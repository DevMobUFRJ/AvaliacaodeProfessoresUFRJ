var atributo_route = require('./route').atributo_route;
var atributo = require('./atributo').atributo;

atributo_route.use("/", atributo_route);

module.exports.atributo_route = atributo_route;
module.exports.atributo = atributo;
