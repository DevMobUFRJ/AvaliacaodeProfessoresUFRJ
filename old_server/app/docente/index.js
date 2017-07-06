var docente_route = require('./route').docente_route;
var docente = require('./docente').docente;

docente_route.use("/", docente_route);

module.exports.docente_route = docente_route;
module.exports.docente = docente;
