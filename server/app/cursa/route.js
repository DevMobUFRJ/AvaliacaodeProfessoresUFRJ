var cursa_route = require('express').Router({mergeParams: true});
var Cursa = require("./cursa").cursa;

// Rota: http://localhost:8080/api/cursa
cursa_route.route('/')

	// // criar cursa (accessed at POST http://localhost:8080/api/cursa)
	// .post(function(req, res) {
  //
	// 	var cursa = new Cursa();		// create a new instance of the model
	// 	cursa.nome = req.body.nome;  // set dre (comes from the request)
  //
	// 	cursa.save(function(err) {
	// 		if (err)
	// 			res.send(err);
  //
	// 		res.json({ message: 'Cursa criada' });
	// 	});
  //
  //
	// })

	// Ver todos os cursas (accessed at GET http://localhost:8080/api/cursa)
	.get(function(req, res) {
		Cursa.find(function(err, avs) {
			if (err)
				res.send(err);

			res.json(avs);
		});
	});

// on routes that end in /cursa/:id_cursa
// ----------------------------------------------------
// cursa_route.route('/:id_cursa')
//
// 	// consulta cursa pelo id
// 	.get(function(req, res) {
// 		Cursa.findById(req.params.id_cursa, function(err, cursa) {
// 			if (err)
// 				res.send(err);
// 			res.json(cursa);
// 		});
// 	})
//
// 	// update cursa com id
// 	.put(function(req, res) {
// 		Cursa.findById(req.params.id_cursa, function(err, cursa) {
//
// 			if (err)
// 				res.send(err);
//
// 			cursa.nome = req.body.nome;
// 			cursa.save(function(err) {
// 				if (err)
// 					res.send(err);
//
// 				res.json({ message: 'Cursa atualizada!' });
// 			});
//
// 		});
// 	})
// 
// 	// deleta cursa com id
// 	.delete(function(req, res) {
// 		Cursa.remove({
// 			_id: req.params.id_cursa
// 		}, function(err, av) {
// 			if (err)
// 				res.send(err);
//
// 			res.json({ message: 'Successfully deleted' });
// 		});
// 	});


module.exports.cursa_route = cursa_route;
