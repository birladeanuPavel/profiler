'use strict'

var webServices = angular.module('webServices', ['ngResource']);

webServices.factory('UserResource', ['$resource',
    function ($resource) {
        return $resource('http://localhost:8080/profiler/rest/user/:id');
    }]);