var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

//TODO check attributes
var AlunoSchema   = new Schema({
	dre: { type: String, required: true },
	nome: { type: String },
});

module.exports.aluno = mongoose.model('Aluno', AlunoSchema);
