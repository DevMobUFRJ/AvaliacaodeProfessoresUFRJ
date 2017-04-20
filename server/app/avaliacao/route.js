var avaliacao_route = require('express').Router({mergeParams: true});
var Avaliacao = require("./avaliacao").avaliacao;

// Rota: http://localhost:8080/api/avaliacao
avaliacao_route.route('/')

// criar avaliacao (accessed at POST http://localhost:8080/api/avaliacao)
.post(function(req, res) {

	var av = new Avaliacao();		// create a new instance of the model

	av.dreAluno = req.body.dreAluno;  // set dre (comes from the request)
	av.matProf = req.body.matProf;
	av.comentario = req.body.comentario;
	av.nota = req.body.nota;
  if(req.body.tags) av.tags = req.body.tags.split(',');

	// VALIDAR COMENTÁRIO !!!!!!!!!
	// if (!comentarioValido(av.comentario)) { av.visivel = 0 ;}

	av.save(function(err) {
		if (err){
			res.setHeader("Content-Type", "text/html");
			res.status(400).json({message: err.message});
		} else {
			res.setHeader("Content-Type", "text/html");
			res.status(200).json(av);
		};
	});

})

// Ver todas as avaliacoes (accessed at GET http://localhost:8080/api/avaliacao)
.get(function(req, res) {
	Avaliacao.find(function(err, avs){
		if (err)
		  res.status(400).json({message: err.message});
    else
		  res.status(200).json(avs);
	});
});

// on routes that end in /avaliacao/:id_avaliacao
// ----------------------------------------------------
avaliacao_route.route('/:id_avaliacao')

// consulta avaliacao pelo id
.get(function(req, res) {
	Avaliacao.findById(req.params.id_avaliacao, function(err, av) {
		if (err)
		  res.status(400).json({message: err.message});
    else
		  res.status(200).json({avaliacao: av});
	});
})

// update avaliacao com id
.put(function(req, res) {
	Avaliacao.findById(req.params.id_avaliacao, function(err, av) {
		if (err)
		  res.status(400).json({message: err.message});
    else{
  		av.name = req.body.dreAluno;
  		av.save(function(err) {
  			if (err)
    		  res.status(400).json({message: err.message});
        else
  			  res.status(200).json({ message: 'Avaliacao atualizada!' });
  		});
    }

	});
})

// deleta avaliacao com id
.delete(function(req, res) {
	Avaliacao.remove({
		_id: req.params.id_avaliacao
	}, function(err, av) {
		if (err)
		  res.status(400).json({message: err.message});
    else
		  res.status(200).json({ message: 'Successfully deleted' });
	});
});

avaliacao_route.route("/docente/:matProf_q")
.get(function(req, res){
	Avaliacao.find({matProf: req.params.matProf_q}, function(err, avs){
		if (err)
		  res.status(400).json({message: err.message});
    else
		  res.status(200).json(avs);
	});
});

avaliacao_route.route("/aluno/:dreAluno_q")
.get(function(req, res){
	Avaliacao.find({dreAluno: req.params.dreAluno_q}, function(err, avs){
		if (err)
		  res.status(400).json({message: err.message});
    else
		  res.status(200).json(avs);
	});
});



module.exports.avaliacao_route = avaliacao_route;
