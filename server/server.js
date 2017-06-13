// BASE SETUP
// =============================================================================

// call the packages we need
var express    = require('express');
var bodyParser = require('body-parser');
var app        = express();
var morgan     = require('morgan');

// create our router
var router = express.Router({mergerParams: true});

var port = process.env.OPENSHIFT_NODEJS_PORT || 80;
var server_ip_address = process.env.OPENSHIFT_NODEJS_IP || '127.0.0.1';
var mongourl = process.env.OPENSHIFT_MONGODB_DB_URL || 'mongodb://node:node@localhost:27017/avprof';

// Rotas do Express (Requests HTTP)
var avaliacao_route = require('./app/avaliacao').avaliacao_route;
var disciplinaPeriodo_route = require('./app/disciplinaPeriodo').disciplinaPeriodo_route;
var atributo_route = require('./app/atributo').atributo_route;

var mongoose   = require('mongoose');
mongoose.connect(mongourl); // connect to our database

// configure app
app.use(morgan('dev')); // log requests to the console

// configure body parser
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.set('json spaces', 2);


// ROUTES FOR OUR API
// =============================================================================


// middleware to use for all requests
router.use(function(req, res, next) {
	// do logging
	console.log('Something is happening.');
	next();
});

// ----------------------------------------------------
// on routes that end in /api/avaliacao
router.use("/avaliacao", avaliacao_route);
router.use("/disciplinaPeriodo", disciplinaPeriodo_route);
router.use("/atributo", atributo_route);
router.use("/aluno", aluno_route);
router.use("/disciplina", disciplina_route);
router.use("/docente", docente_route);

// test route to make sure everything is working (accessed at GET http://localhost:8080/api)
router.get('/', function(req, res) {
	res.json({ message: 'hooray! welcome to our api!' });
});


// REGISTER OS -------------------------------
app.use('/api', router);

// START THE SERVER
// =============================================================================
app.listen(port, server_ip_address, function(){
});
