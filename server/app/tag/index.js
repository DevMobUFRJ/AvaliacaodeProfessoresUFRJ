var tag_route = require('./route').tag_route;
var tag = require('./tag').tag;

tag_route.use("/", tag_route);

module.exports.tag_route = tag_route;
module.exports.tag = tag;
