var cursa_route = require('express').Router({mergeParams: true});
var Cursa = require("./cursa").cursa;

cursa_route.route('/')
	.post(function(req, res) {

		var cursa = new Cursa();
		cursa.dreAluno = req.body.dreAluno;
		cursa.nome = req.body.nome;

		cursa.save(function(err) {
			if (err)
				res.send(err);
            else {
                res.json({message: 'Sucesso'});
            }
		});
	})

	// Ver todos alunos-disciplina
 	.get(function(req, res) {
		Cursa.find(function(err, lista) {
			if (err)
				res.send(err);
            else {
                res.json(lista);
            }
		});
	});

/**
 * Consultar matérias cursadas pelo DRE Aluno
 */
cursa_route.route('/aluno/:dre_aluno')
	.get(function(req, res) {
		Cursa.find({dreAluno: req.params.dre_aluno}, function(err, cursa) {
			if (err)
				res.send(err);
			else {
                res.json(cursa);
            }
		});
	});

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
