var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

var AvaliacaoSchema   = new Schema({
	id: Number,
	matProf: Number,
	dreAluno: Number
});

module.exports = mongoose.model('Avaliacao', AvaliacaoSchema);
