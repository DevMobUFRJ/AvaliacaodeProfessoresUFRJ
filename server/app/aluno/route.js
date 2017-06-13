var aluno_route = require('express').Router({mergeParams: true});
var Aluno = require("./aluno").aluno;

// Rota: http://localhost:8080/api/aluno
aluno_route.route('/')

	// criar aluno (accessed at POST http://localhost:8080/api/aluno)
	.post(function(req, res) {

		var aluno = new Aluno();		// create a new instance of the model
		aluno.dre = req.body.dre;
		aluno.nome = req.body.nome;  // set dre (comes from the request)

		aluno.save(function(err) {
			if (err)
				res.send(err);

			res.json({ message: 'Aluno criada' });
		});
	})

	// Ver todas as avaliacoes (accessed at GET http://localhost:8080/api/aluno)
	.get(function(req, res) {
		Aluno.find(function(err, avs) {
			if (err)
				res.send(err);

			res.json(avs);
		});
	});

// on routes that end in /aluno/:dre
// ----------------------------------------------------
aluno_route.route('/:dre')

	// consulta aluno pelo id
	.get(function(req, res) {
		Aluno.findById(req.params.dre, function(err, aluno) {
			if (err)
				res.send(err);
			res.json(aluno);
		});
	})

	// deleta aluno com id
	.delete(function(req, res) {
		Aluno.remove({
			_id: req.params.dre
		}, function(err, av) {
			if (err)
				res.send(err);

			res.json({ message: 'Successfully deleted' });
		});
	});


module.exports.aluno_route = aluno_route;
