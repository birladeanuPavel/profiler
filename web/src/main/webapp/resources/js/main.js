'user strict';

var profilerApp = angular.module('profilerApp', ['ngRoute', 'profilerControllers', 'profilerDirectives', 'webServices']);

profilerApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
                when('/createUser', {
                    templateUrl: 'resources/routes/user_form.jspf',
                    controller: 'CreateUserController'
                }).
                when('/editUser/:id', {
                    templateUrl: 'resources/routes/user_form.jspf',
                    controller: 'EditUserController'
                }).
                otherwise({
                    redirectTo: '/'
                });
    }
]);