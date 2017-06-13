var disciplina_route = require('express').Router({mergeParams: true});
var Disciplina = require("./disciplina").disciplina;

//TODO fix attributes on all routes
disciplina_route.route('/')
	.post(function(req, res) {

		var disciplina = new Disciplina();
        disciplina.codigo = req.body.codigo;
		disciplina.nome = req.body.nome;

		disciplina.save(function(err) {
			if (err)
				res.send(err);
			else {
                res.json({message: 'Disciplina criada'});
            }
		});
	})

	// Ver todas as avaliacoes (accessed at GET http://localhost:8080/api/disciplina)
	.get(function(req, res) {
		Disciplina.find(function(err, lista) {
			if (err)
				res.send(err);
			else {
                res.json(lista);
            }
		});
	});

disciplina_route.route('/:codigo_disciplina')

	// consulta disciplina pelo id
	.get(function(req, res) {
		Disciplina.find({ codigo: req.params.codigo_disciplina }, function(err, disciplina) {
			if (err)
				res.send(err);
			else {
                res.json(disciplina);
            }
		});
	})

	.put(function(req, res) {
		Disciplina.find({ codigo: req.params.codigo_disciplina }, function(err, disciplina) {
			if (err)
				res.send(err);
			else {
                disciplina.nome = req.body.nome;
                disciplina.save(function (err) {
                    if (err)
                        res.send(err);
                    else {
                        res.json({message: 'Disciplina atualizada!'});
                    }
                });
            }
		});
	})

	// deleta disciplina
	.delete(function(req, res) {
		Disciplina.remove({
			codigo: req.params.codigo_disciplina
		}, function(err) {
			if (err)
				res.send(err);
			else
				res.json({ message: 'Successfully deleted' });
		});
	});


module.exports.disciplina_route = disciplina_route;
