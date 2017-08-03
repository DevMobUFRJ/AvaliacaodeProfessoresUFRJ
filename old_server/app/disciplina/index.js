var disciplina_route = require('./route').disciplina_route;
var disciplina = require('./disciplina').disciplina;

disciplina_route.use("/", disciplina_route);

module.exports.disciplina_route = disciplina_route;
module.exports.disciplina = disciplina;
