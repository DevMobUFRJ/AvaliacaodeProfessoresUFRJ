var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

//TODO change attributes
var DisciplinaSchema   = new Schema({
	_id: Number,
	nome: String,
});

module.exports.disciplina = mongoose.model('Disciplina', DisciplinaSchema);
