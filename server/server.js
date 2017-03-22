// BASE SETUP
// =============================================================================

// call the packages we need
var express    = require('express');
var bodyParser = require('body-parser');
var app        = express();
var morgan     = require('morgan');
var port = process.env.OPENSHIFT_NODEJS_PORT || 8080;
var server_ip_address = process.env.OPENSHIFT_NODEJS_IP || '127.0.0.1';
var mongouurl = process.env.OPENSHIFT_MONGODB_DB_URL || 'mongodb://node:node@localhost:27017/avaliacao';

var mongoose   = require('mongoose');
mongoose.connect(mongourl); // connect to our database
var Avaliacao     = require('./app/models/avaliacao');

// configure app
app.use(morgan('dev')); // log requests to the console

// configure body parser
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());


// ROUTES FOR OUR API
// =============================================================================

// create our router
var router = express.Router();

// middleware to use for all requests
router.use(function(req, res, next) {
	// do logging
	console.log('Something is happening.');
	next();
});

// test route to make sure everything is working (accessed at GET http://localhost:8080/api)
router.get('/', function(req, res) {
	res.json({ message: 'hooray! welcome to our api!' });
});

// on routes that end in /avaliacao
// ----------------------------------------------------
router.route('/avaliacao')

	// criar avaliacao (accessed at POST http://localhost:8080/avaliacao)
	.post(function(req, res) {

		var av = new Avaliacao();		// create a new instance of the model
		av.dreAluno = req.body.dreAluno;  // set dre (comes from the request)

		av.save(function(err) {
			if (err)
				res.send(err);

			res.json({ message: 'Avaliacao criada' });
		});


	})

	// Ver todas as avaliacoes (accessed at GET http://localhost:8080/api/avaliacao)
	.get(function(req, res) {
		Avaliacao.find(function(err, avs) {
			if (err)
				res.send(err);

			res.json(avs);
		});
	});

// on routes that end in /avaliacao/:id_avaliacao
// ----------------------------------------------------
router.route('/avaliacao/:id_avaliacao')

	// consulta avaliacao pelo id
	.get(function(req, res) {
		Avaliacao.findById(req.params.id_avaliacao, function(err, av) {
			if (err)
				res.send(err);
			res.json(av);
		});
	})

	// update avaliacao com id
	.put(function(req, res) {
		Avaliacao.findById(req.params.id_avaliacao, function(err, av) {

			if (err)
				res.send(err);

			av.name = req.body.dreAluno;
			av.save(function(err) {
				if (err)
					res.send(err);

				res.json({ message: 'Avaliacao atualizada!' });
			});

		});
	})

	// deleta avaliacao com id
	.delete(function(req, res) {
		Avaliacao.remove({
			_id: req.params.id_avaliacao
		}, function(err, av) {
			if (err)
				res.send(err);

			res.json({ message: 'Successfully deleted' });
		});
	});


// REGISTER OUR ROUTES -------------------------------
app.use('/api', router);

// START THE SERVER
// =============================================================================
app.listen(port);
console.log('Magic happens on port ' + port);
