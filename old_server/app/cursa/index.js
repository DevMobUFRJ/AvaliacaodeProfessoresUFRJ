var cursa_route = require('./route').cursa_route;
var cursa = require('./cursa').cursa;

cursa_route.use("/", cursa_route);

module.exports.cursa_route = cursa_route;
module.exports.cursa = cursa;
