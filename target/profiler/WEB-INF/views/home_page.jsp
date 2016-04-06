<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="profilerApp">
    <head>
        <title>Profiler</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">

        <!--bootstrap-->
        <link href="<c:url value="/resources/plugins/bootstrap/css/bootstrap.css" />" rel="stylesheet">
        <!--ui bootstrap-->
        <link href="<c:url value="/resources/plugins/angular-ui-bootstrap/ui-bootstrap-csp.css" />" rel="stylesheet">
        <!--mine-->
        <link href="<c:url value="/resources/stylesheets/home_page.css" />" rel="stylesheet">

    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="/profiler">Profiler</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <!--<li class="active"><a href="/profiler">Home <span class="sr-only">(current)</span></a></li>-->
                        <li><a href="/profiler/#/createUser">Edit profile</a></li>
<!--                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>-->
                    </ul>
<!--                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Link</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                    </ul>-->
                </div>
            </div>
        </nav>
       
        <div ng-view></div>

        <!--jquery-->
        <script src="<c:url value="/resources/plugins/jquery/jquery-2.2.1.js" />"></script>
        <!--bootstrap-->
        <script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.js" />"></script>
        <!--angular-->
        <script src="<c:url value="/resources/plugins/angularjs/angular.min.js" />"></script>
        <script src="<c:url value="/resources/plugins/angularjs/angular-resource.min.js" />"></script>
        <script src="<c:url value="/resources/plugins/angularjs/angular-route.min.js" />"></script>
        <!--angular ui-->
        <script src="<c:url value="/resources/plugins/angular-ui-bootstrap/ui-bootstrap.js" />"></script>
        <script src="<c:url value="/resources/plugins/angular-ui-bootstrap/ui-bootstrap-tpls.js" />"></script>
        <!--angular file upload-->
        <script src="<c:url value="/resources/plugins/angular-file-upload/angular-file-upload.js" />"></script>
        <!--mine-->
        <script src="<c:url value="/resources/js/controller.js" />"></script>
        <script src="<c:url value="/resources/js/directives.js" />"></script>
        <script src="<c:url value="/resources/js/main.js" />"></script>

    </body>
</html>
