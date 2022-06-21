const { debug } = require("console");

const PROXY_CONFIG = [{
    context: ['/v1/course'],
    target: 'http://localhost:8080/',
    secure: false,
    logLevel: 'debug'
}];

module.exports = PROXY_CONFIG;
