'use strict'

var webServices = angular.module('webServices', ['ngResource']);

webServices.factory('UserResource', ['$resource', '$location',
    function ($resource, $location) {
        var errorHandler = function () {
            $location.path('/error')
        };
        return $resource('http://localhost:8080/profiler/rest/user/:id', null,
            {
                'get': {method: 'GET', interceptor: {responseError: errorHandler}},
                'save': { method: 'POST', interceptor: {responseError: errorHandler}},
                'update': { method: 'PUT', interceptor: {responseError: errorHandler}}
            });
    }]);