var avaliacao_route = require('./route').avaliacao_route;
var avaliacao = require('./avaliacao').avaliacao;

avaliacao_route.use("/", avaliacao_route);

module.exports.avaliacao_route = avaliacao_route;
module.exports.avaliacao = avaliacao;
