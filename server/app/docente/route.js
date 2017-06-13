var docente_route = require('express').Router({mergeParams: true});
var Docente = require("./docente").docente;

//TODO fix attributes on all routes
// Rota: http://localhost:8080/api/docente
docente_route.route('/')

	// criar docente (accessed at POST http://localhost:8080/api/docente)
	.post(function(req, res) {

		var docente = new Docente();
		docente.matricula = req.body.matricula;
		docente.nome = req.body.nome;

		docente.save(function(err) {
			if (err)
				res.send(err);

			res.json({ message: 'Docente criada' });
		});
	})

	// Ver todos os docentes (accessed at GET http://localhost:8080/api/docente)
	.get(function(req, res) {
		Docente.find(function(err, avs) {
			if (err)
				res.send(err);

			res.json(avs);
		});
	});

// on routes that end in /docente/:id_docente
// ----------------------------------------------------
docente_route.route('/:mat_docente')

	// consulta docente pelo id
	.get(function(req, res) {
		Docente.find({matricula: req.params.mat_docente}, function(err, docente) {
			if (err)
				res.send(err);
			else
				res.json(docente);
		});
	})

	// update docente com id
	.put(function(req, res) {
		Docente.find({matricula: req.params.mat_docente}, function(err, docente) {

			if (err)
				res.send(err);
			else {
                docente.nome = req.body.nome;
                docente.save(function (err) {
                    if (err)
                        res.send(err);
					else
                    	res.json({message: 'Docente atualizada!'});
                });
            }
		});
	})

	// deleta docente com id
	.delete(function(req, res) {
		Docente.remove({matricula: req.params.mat_docente}, function(err, av) {
			if (err)
				res.send(err);

			res.json({ message: 'Successfully deleted' });
		});
	});


module.exports.docente_route = docente_route;
