var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

var CursaSchema   = new Schema({
    dreAluno: { type: String, required: true },
    idDisciplinaPeriodo: { type: Schema.Types.ObjectId, required: true}
});

module.exports.cursa = mongoose.model('Cursa', CursaSchema);
