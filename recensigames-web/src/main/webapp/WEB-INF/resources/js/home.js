var app = angular.module('home', ['ui.router']);
	app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function($stateProvider, $urlRouterProvider, $locationProvider){
		$locationProvider.html5Mode(true);
		$stateProvider
			.state({
				name: 'home',
				url: 'recensigames/',
			})
			.state({
				name: 'login',
				url: 'recensigames/login',
				templateUrl: 'recensigames/views/login.html',
				controller: 'LoginController'
			})
			.state({
				name: 'register',
				url: 'recensigames/register',
				templateUrl: 'recensigames/views/register.html',
				controller: 'RegisterController'
			})
			.state({
				name: 'searchByTitle',
				url: 'recensigames/search/:titoloGioco',
				templateUrl: 'recensigames/views/search.html',
				controller: 'SearchController'
			})
			.state({
				name: 'searchByConsole',
				url: 'recensigames/search/:nomeConsole',
				templateUrl: 'recensigames/views/search.html',
				controller: 'SearchController'
			})
			.state({
				name: 'profile',
				url: 'recensigames/profile',
				templateUrl: 'recensigames/views/profile.html',
				controller: 'ProfileController'
			})
	}])
	app.controller('HomeController', ['$http', '$rootScope', '$state', '$scope', function ($http, $rootScope, $state, $scope){
		var home = this;
		$rootScope.logged = false;
//		$scope.$watch($rootScope.logged, function(value, oldValue){
//			if(!value && oldValue) {
//			      $rootScope.logged = false;
//			      $state.go('login');
//				}
//		    if(value) {
//		    	$state.go('home');
//			      $rootScope.logged = true;
//		    	}
//		}, true);
		
		home.header = "recensigames/views/header.html";
		home.footer = "recensigames/views/footer.html";
	}]);
	app.run(['$rootScope', '$state', function ($rootScope, $state) {
    $rootScope.$on('$stateChangeStart', function (event) {
    	var state = $state.current.url;
        if ($state.current.url.includes('profile') && !$rootScope.logged) {
            event.preventDefault();
            $state.go('/login');
        }
        else if($state.current.url.includes('profile') && rootScope.logged){
            $state.go('home');
        }
    });
}]);