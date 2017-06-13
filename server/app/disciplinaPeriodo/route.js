var disciplinaPeriodo_route = require('express').Router({mergeParams: true});
var DisciplinaPeriodo = require("./disciplinaPeriodo").disciplinaPeriodo;

// Rota: http://localhost:8080/api/disciplinaPeriodo
disciplinaPeriodo_route.route('/')

	// criar disciplinaPeriodo (accessed at POST http://localhost:8080/api/disciplinaPeriodo)
	.post(function(req, res) {

		var disciplinaPeriodo = new DisciplinaPeriodo();		// create a new instance of the model
		disciplinaPeriodo.id = req.body.id;  // set dre (comes from the request)
		disciplinaPeriodo.periodo = req.body.periodo;
		disciplinaPeriodo.matDocente = req.body.matDocente;
		disciplinaPeriodo.codDisciplina = req.body.codDisciplina;

		disciplinaPeriodo.save(function(err) {
			if (err)
				res.send(err);

			res.json({ message: 'DisciplinaPeriodo criada' });
		});


	})

	// Ver todas as avaliacoes (accessed at GET http://localhost:8080/api/disciplinaPeriodo)
	.get(function(req, res) {
		DisciplinaPeriodo.find(function(err, avs) {
			if (err)
				res.send(err);

			res.json(avs);
		});
	});

// on routes that end in /disciplinaPeriodo/:id_disciplinaPeriodo
// ----------------------------------------------------
disciplinaPeriodo_route.route('/:id')

  //TODO trocar findById 
	// consulta disciplinaPeriodo pelo id
	.get(function(req, res) {
		DisciplinaPeriodo.findById(req.params.id, function(err, disciplinaPeriodo) {
			if (err)
				res.send(err);
			res.json(disciplinaPeriodo);
		});
	})

	// deleta disciplinaPeriodo com id
	.delete(function(req, res) {
		DisciplinaPeriodo.remove({
			_id: req.params.id
		}, function(err, av) {
			if (err)
				res.send(err);

			res.json({ message: 'Successfully deleted' });
		});
	});


module.exports.disciplinaPeriodo_route = disciplinaPeriodo_route;
