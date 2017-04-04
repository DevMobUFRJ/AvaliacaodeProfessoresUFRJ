var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

var AvaliacaoSchema   = new Schema({
	dreAluno: { type: String, required: true },
	matProf: { type: String, required: true} ,
	comentario: { type: String, required: false, trim: true},
	nota: { type: Number, required: true} ,
	data: { type: Date, default: Date.now },
	visivel: { type: Boolean, default: true },
	tags: [{ type: Number, ref: 'Tag', default: undefined }]
});

module.exports.avaliacao = mongoose.model('Avaliacao', AvaliacaoSchema);
