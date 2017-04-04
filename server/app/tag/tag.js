var mongoose     = require('mongoose');
var Schema       = mongoose.Schema;

var TagSchema   = new Schema({
	_id: Number,
	nome: String,
});

module.exports.tag = mongoose.model('Tag', TagSchema);
