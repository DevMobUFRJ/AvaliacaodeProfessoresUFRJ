var aluno_route = require('./route').aluno_route;
var aluno = require('./aluno').aluno;

aluno_route.use("/", aluno_route);

module.exports.aluno_route = aluno_route;
module.exports.aluno = aluno;
