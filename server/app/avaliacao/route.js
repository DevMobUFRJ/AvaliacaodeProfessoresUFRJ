var avaliacao_route = require('express').Router({mergeParams: true});
var Avaliacao = require("./avaliacao").avaliacao;

// Rota: http://localhost:8080/api/avaliacao
avaliacao_route.route('/')

	// criar avaliacao (accessed at POST http://localhost:8080/api/avaliacao)
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
avaliacao_route.route('/:id_avaliacao')

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


module.exports.avaliacao_route = avaliacao_route;
