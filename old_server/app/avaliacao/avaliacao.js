var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

var AvaliacaoSchema   = new Schema({
	dreAluno: { type: String, required: true },								// Dois atributos da
	idDisciplinaPeriodo: { type: Schema.Types.ObjectId, required: true},	//  tabela cursa.
	comentario: { type: String, required: false, trim: true},
	nota: { type: Number, required: true},
	data: { type: Date, default: Date.now },
	dataAlteracao: { type: Date, default: Date.now },
	visivel: { type: Boolean, default: true },

	//TODO Resolver esta confusão de atributos e tags.
	atributos: [{
		idAtributo: { type: Number, ref: 'Atributo'},
		valor: { type: Number, max: 1, min: -1}
	}]		// Array de inteiros com IDs dos atributos
});

module.exports.avaliacao = mongoose.model('Avaliacao', AvaliacaoSchema);
