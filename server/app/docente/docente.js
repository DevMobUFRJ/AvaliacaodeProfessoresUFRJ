var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

//TODO change attributes
var DocenteSchema   = new Schema({
	matricula: { type: String, required: true },
	nome: { type: String },
});

module.exports.docente = mongoose.model('Docente', DocenteSchema);
