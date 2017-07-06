var atributo_route = require('express').Router({mergeParams: true});
var Atributo = require("./atributo").atributo;

// Rota: http://localhost:8080/api/atributo
atributo_route.route('/')

	// // criar atributo (accessed at POST http://localhost:8080/api/atributo)
	// .post(function(req, res) {
  //
	// 	var atributo = new Atributo();		// create a new instance of the model
	// 	atributo.nome = req.body.nome;  // set dre (comes from the request)
  //
	// 	atributo.save(function(err) {
	// 		if (err)
	// 			res.send(err);
  //
	// 		res.json({ message: 'Atributo criada' });
	// 	});
  //
  //
	// })

	// Ver todos os atributos (accessed at GET http://localhost:8080/api/atributo)
	.get(function(req, res) {
		Atributo.find(function(err, avs) {
			if (err)
				res.send(err);

			res.json(avs);
		});
	});

// on routes that end in /atributo/:id_atributo
// ----------------------------------------------------
// atributo_route.route('/:id_atributo')
//
// 	// consulta atributo pelo id
// 	.get(function(req, res) {
// 		Atributo.findById(req.params.id_atributo, function(err, atributo) {
// 			if (err)
// 				res.send(err);
// 			res.json(atributo);
// 		});
// 	})
//
// 	// update atributo com id
// 	.put(function(req, res) {
// 		Atributo.findById(req.params.id_atributo, function(err, atributo) {
//
// 			if (err)
// 				res.send(err);
//
// 			atributo.nome = req.body.nome;
// 			atributo.save(function(err) {
// 				if (err)
// 					res.send(err);
//
// 				res.json({ message: 'Atributo atualizada!' });
// 			});
//
// 		});
// 	})
// 
// 	// deleta atributo com id
// 	.delete(function(req, res) {
// 		Atributo.remove({
// 			_id: req.params.id_atributo
// 		}, function(err, av) {
// 			if (err)
// 				res.send(err);
//
// 			res.json({ message: 'Successfully deleted' });
// 		});
// 	});


module.exports.atributo_route = atributo_route;
