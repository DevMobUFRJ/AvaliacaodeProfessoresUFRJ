var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

var AtributoSchema   = new Schema({
	_id: Number,
	nome: String,
});

module.exports.atributo = mongoose.model('Atributo', AtributoSchema);
