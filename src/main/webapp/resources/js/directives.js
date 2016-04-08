'user strict';

var profilerDirectives = angular.module("profilerDirectives", []);

profilerDirectives.directive('formInputGroup', function () {
    return {
        restrict: 'E',
        scope: {
            element: '=element',
            form: '=form',
            model: '=model'
        },
        templateUrl: 'resources/templates/form-input-group.jspf'
    };
});

profilerDirectives.directive('ngThumb', ['$window', function ($window) {
        var helper = {
            support: !!($window.FileReader && $window.CanvasRenderingContext2D),
            isFile: function (item) {
                return angular.isObject(item) && item instanceof $window.File;
            },
            isImage: function (file) {
                var type = '|' + file.type.slice(file.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        };

        return {
            restrict: 'A',
            template: '<canvas/>',
            link: function (scope, element, attributes) {
                if (!helper.support)
                    return;

                var params = scope.$eval(attributes.ngThumb);

                if (!helper.isFile(params.file))
                    return;
                if (!helper.isImage(params.file))
                    return;

                var canvas = element.find('canvas');
                var reader = new FileReader();

                reader.onload = onLoadFile;
                reader.readAsDataURL(params.file);

                function onLoadFile(event) {
                    var img = new Image();
                    img.onload = onLoadImage;
                    img.src = event.target.result;
                }

                function onLoadImage() {
                    var width = params.width || this.width / this.height * params.height;
                    var height = params.height || this.height / this.width * params.width;
                    canvas.attr({width: width, height: height});
                    canvas[0].getContext('2d').drawImage(this, 0, 0, width, height);
                }

            }
        };
    }]);

profilerDirectives.directive('fileModel', function () {
    return {
        require: 'ngModel',
        link: function (scope, el, attrs, ngModel) {
            el.bind('change', function () {
                scope.$apply(function () {
                    function onLoadFile(event) {
                        scope.$apply(function () {
                            scope.resource = event.target.result;
                        });
                    };
                    var reader = new FileReader();
                    reader.onload = onLoadFile;
                    reader.readAsDataURL(el[0].files[0]);

                    ngModel.$setViewValue(el[0].files);
                    ngModel.$render();
                });
            });
        }
    };
});