var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

var AvaliacaoSchema   = new Schema({
	_id: Number,
	dreAluno: String,
	matProf: String,
	comentario: String,
	nota: Number,
	data: { type: Date, default: Date.now },
	visivel: Boolean,
	tags: [{ type: Number, ref: 'Tag'}]

});

module.exports.avaliacao = mongoose.model('Avaliacao', AvaliacaoSchema);
