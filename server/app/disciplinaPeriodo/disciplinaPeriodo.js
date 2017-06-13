var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

var DisciplinaPeriodoSchema   = new Schema({
	id: Number,
	periodo: { type: String, required: true, maxlength: 6}, //6 characteres, ex: "2017.1"
	matDocente: { type: String, required: true, ref: "Docente"},
	codDisciplina: { type: String, required: true, ref: "Disciplina" }
});

module.exports.disciplinaPeriodo = mongoose.model('DisciplinaPeriodo', DisciplinaPeriodoSchema);
