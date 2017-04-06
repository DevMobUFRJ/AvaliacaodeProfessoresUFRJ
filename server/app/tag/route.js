var tag_route = require('express').Router({mergeParams: true});
var Tag = require("./tag").tag;

// Rota: http://localhost:8080/api/tag
tag_route.route('/')

	// criar tag (accessed at POST http://localhost:8080/api/tag)
	.post(function(req, res) {

		var tag = new Tag();		// create a new instance of the model
		tag.nome = req.body.nome;  // set dre (comes from the request)

		tag.save(function(err) {
			if (err)
				res.send(err);

			res.json({ message: 'Tag criada' });
		});


	})

	// Ver todas as avaliacoes (accessed at GET http://localhost:8080/api/tag)
	.get(function(req, res) {
		Tag.find(function(err, avs) {
			if (err)
				res.send(err);

			res.json(avs);
		});
	});

// on routes that end in /tag/:id_tag
// ----------------------------------------------------
tag_route.route('/:id_tag')

	// consulta tag pelo id
	.get(function(req, res) {
		Tag.findById(req.params.id_tag, function(err, tag) {
			if (err)
				res.send(err);
			res.json(tag);
		});
	})

	// update tag com id
	.put(function(req, res) {
		Tag.findById(req.params.id_tag, function(err, tag) {

			if (err)
				res.send(err);

			tag.nome = req.body.nome;
			tag.save(function(err) {
				if (err)
					res.send(err);

				res.json({ message: 'Tag atualizada!' });
			});

		});
	})

	// deleta tag com id
	.delete(function(req, res) {
		Tag.remove({
			_id: req.params.id_tag
		}, function(err, av) {
			if (err)
				res.send(err);

			res.json({ message: 'Successfully deleted' });
		});
	});


module.exports.tag_route = tag_route;
