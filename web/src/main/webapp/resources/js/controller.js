'user strict';

var profilerControllers = angular.module("profilerControllers", []);

var initUserDefaultData = function ($scope) {
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
};

profilerControllers.controller('CreateUserController', ['$scope', 'UserResource',
    function ($scope, UserResource) {

        initUserDefaultData($scope);

        $scope.save = function (form) {
            if (form.$invalid) {
                console.log('error');
            } else {
                $scope.user.avatar = $scope.resource;
                UserResource.save([], $scope.user);
            }
        };
    }]);

profilerControllers.controller('EditUserController', ['$scope', 'UserResource', '$routeParams',
    function ($scope, UserResource, $routeParams) {

        initUserDefaultData($scope);

        $scope.user = UserResource.get({id: $routeParams.id}, function () {
            $scope.user.birthDate = new Date($scope.user.birthDate);
            $scope.avatar = [$scope.user.avatar];
            $scope.resource = $scope.user.avatar;
        });

        $scope.save = function (form) {
            if (form.$invalid) {
                console.log('error');
            } else {
                $scope.user.avatar = $scope.resource;
                $scope.user.$update(null, function () {
                    $scope.user.birthDate = new Date($scope.user.birthDate);
                });
                // $scope.user.$remove({id: $routeParams.id});
            }
        };
    }]);
