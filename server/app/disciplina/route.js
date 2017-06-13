var disciplina_route = require('express').Router({mergeParams: true});
var Disciplina = require("./disciplina").disciplina;

//TODO fix attributes on all routes 
// Rota: http://localhost:8080/api/disciplina
disciplina_route.route('/')

	// criar disciplina (accessed at POST http://localhost:8080/api/disciplina)
	.post(function(req, res) {

		var disciplina = new Disciplina();		// create a new instance of the model
		disciplina.nome = req.body.nome;  // set dre (comes from the request)

		disciplina.save(function(err) {
			if (err)
				res.send(err);

			res.json({ message: 'Disciplina criada' });
		});


	})

	// Ver todas as avaliacoes (accessed at GET http://localhost:8080/api/disciplina)
	.get(function(req, res) {
		Disciplina.find(function(err, avs) {
			if (err)
				res.send(err);

			res.json(avs);
		});
	});

// on routes that end in /disciplina/:id_disciplina
// ----------------------------------------------------
disciplina_route.route('/:id_disciplina')

	// consulta disciplina pelo id
	.get(function(req, res) {
		Disciplina.findById(req.params.id_disciplina, function(err, disciplina) {
			if (err)
				res.send(err);
			res.json(disciplina);
		});
	})

	// update disciplina com id
	.put(function(req, res) {
		Disciplina.findById(req.params.id_disciplina, function(err, disciplina) {

			if (err)
				res.send(err);

			disciplina.nome = req.body.nome;
			disciplina.save(function(err) {
				if (err)
					res.send(err);

				res.json({ message: 'Disciplina atualizada!' });
			});

		});
	})

	// deleta disciplina com id
	.delete(function(req, res) {
		Disciplina.remove({
			_id: req.params.id_disciplina
		}, function(err, av) {
			if (err)
				res.send(err);

			res.json({ message: 'Successfully deleted' });
		});
	});


module.exports.disciplina_route = disciplina_route;
