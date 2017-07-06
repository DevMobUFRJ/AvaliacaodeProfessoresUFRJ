var disciplinaPeriodo_route = require('./route').disciplinaPeriodo_route;
var disciplinaPeriodo = require('./disciplinaPeriodo').disciplinaPeriodo;

disciplinaPeriodo_route.use("/", disciplinaPeriodo_route);

module.exports.disciplinaPeriodo_route = disciplinaPeriodo_route;
module.exports.disciplinaPeriodo = disciplinaPeriodo;
