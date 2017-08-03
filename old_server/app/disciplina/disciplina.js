var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

//TODO change attributes
var DisciplinaSchema   = new Schema({
	_id: { type: Schema.Types.ObjectId, default: new mongoose.Types.ObjectId },
	codigo: { type: String, required: true},
	nome: String
});

module.exports.disciplina = mongoose.model('Disciplina', DisciplinaSchema);
