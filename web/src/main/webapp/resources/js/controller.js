'user strict';

var profilerControllers = angular.module("profilerControllers", []);

profilerControllers.controller('UserController', ['$scope', 'UserResource', '$routeParams',
    function ($scope, UserResource, $routeParams) {
        // var someUser = UserResource.get({id: 1});

        $scope.profiles = [
            'ADMIN', 'USER'
        ];

        $scope.user = {
            gender: 'MALE',
            profileType: 'USER'
        };

        $scope.FormElement = {
            FIRST_NAME: {
                name: 'firstName',
                title: 'First Name',
                errMsg1: 'Tell us your first name.'
            },
            LAST_NAME: {
                name: 'lastName',
                title: 'Last Name',
                errMsg1: 'Tell us your last name.'
            },
            EMAIL: {
                name: 'email',
                title: 'Email',
                errMsg1: 'Tell us your email.'
            },
            BIRTH_DATE: {
                name: 'birthDate',
                title: 'Birth Date',
                errMsg1: 'Enter your birth date.'
            }
        };

        $scope.save = function (form) {
            if (form.$invalid) {
                console.log('success');
            } else {
                $scope.user.avatar = encodeURIComponent($scope.resource);
                UserResource.save([], $scope.user);
            }
        };
    }]);
