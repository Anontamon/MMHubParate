
angular.module('login', []).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.
        when('/login', {
            templateUrl: 'loginform.jsp', 
            controller: loginFormCtrl
        }).
        when('/home', {
            templateUrl: 'home.jsp', 
            controller: homeCtrl
        }).
        when('/home/cat',{
        
        }).
        otherwise({
            redirectTo: '/login'
        });
    }]);