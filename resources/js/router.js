module.exports = Backbone.Router.extend({
    routes: {
        '': 'index'
    },
    index: function () {
        console.log('index route');
    }
});
