'user strict';

var profilerControllers = angular.module("profilerControllers", ['angularFileUpload']);

function fileUploader($scope, FileUploader) {
    var uploader = $scope.uploader = new FileUploader({
        queueLimit: 1
    });

    uploader.filters.push({
        name: 'imageFilter',
        fn: function (item, options) {
            var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
            return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
        }
    });

    uploader.onAfterAddingFile = function (fileItem) {
        var reader = new FileReader();
        reader.onload = onLoadFile;
        reader.readAsDataURL(fileItem._file);

        function onLoadFile(event) {
            $scope.user.avatar = event.target.result;
        }
    };
}

//function UserController($scope, FileUploader) {
//    $scope.user = {gender: 'MALE'};
//
//    $scope.FormElement = {
//        FIRST_NAME: {
//            name: 'firstName',
//            title: 'First Name',
//            errMsg1: 'Tell us your first name.'
//        },
//        LAST_NAME: {
//            name: 'lastName',
//            title: 'Last Name',
//            errMsg1: 'Tell us your last name.'
//        },
//        EMAIL: {
//            name: 'email',
//            title: 'Email',
//            errMsg1: 'Tell us your email.'
//        },
//        BIRTH_DATE: {
//            name: 'birthDate',
//            title: 'Birth Date',
//            errMsg1: 'Enter your birth date.'
//        }
//    };
//    
//    var uploader = $scope.uploader = new FileUploader({
//        queueLimit : 1
//    });
//    
//    uploader.filters.push({
//        name: 'imageFilter',
//        fn: function (item, options) {
//            var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
//            return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
//        }
//    });
//
//    uploader.onAfterAddingFile = function (fileItem) {
//        $scope.user.avatar = fileItem;
//    };
//
////    fileUploader($scope, FileUploader);
//    
//    $scope.save = function (form, user) {
//        if (form.$invalid) {
////            form.$setPristine();
////            form.$setUntouched();
//            console.log(user);
//        }
//    };
//}

profilerControllers.controller('UserController', ['$scope', 'FileUploader',
    function ($scope, FileUploader) {
        $scope.user = {gender: 'MALE', avatar: ''};
//        $scope.files = [];
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

//        var uploader = $scope.uploader = new FileUploader({
////            url: "",
////            queueLimit: 1
//        });
//
//        uploader.filters.push({
//            name: 'imageFilter',
//            fn: function (item, options) {
//                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
//                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
//            }
//        });

//        uploader.onAfterAddingFile = function (fileItem) {
////            uploader.clearQueue();
//            var reader = new FileReader();
//            reader.onload = onLoadFile;
//            reader.readAsDataURL(fileItem._file);
//            $scope.file =fileItem._file;
//            function onLoadFile(event) {
//                $scope.user.avatar = event.target.result;
//            }
//        };

//    fileUploader($scope, FileUploader);

        $scope.save = function (form, user) {
            if (form.$invalid) {
//            form.$setPristine();
//            form.$setUntouched();
                console.log(user);
            } else {
                function onLoadFile(event) {
                    $scope.user.avatar = event.target.result;
                }

                var reader = new FileReader();
                reader.onload = onLoadFile;
                reader.readAsDataURL($scope.files[0]);
                console.log('success');
            }
        };
    }]);



//profilerControllers.controller('FileUploader', ['$scope', 'FileUploader', FileUploaderController]);