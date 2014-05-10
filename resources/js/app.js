exports.start = function () {
    var router = require('router.js');
    this.router = new router();
    Backbone.history.start({pushState: true});
};
