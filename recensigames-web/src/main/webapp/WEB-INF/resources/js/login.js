angular.module('home')
	.controller('LoginController', ['$http', '$rootScope', '$state' ,function($http, $rootScope, $state){
		var login = this;

		login.login = function(){
			login.user = {
					username : "",
					password : ""
			};
			var getLogin = $http.get('http://localhost:8080/recensigames/login/getUserByUsernameAndPassword?username=' + login.username + "&password=" + login.password);
			getLogin.then(function(result) {
				login.user = result.data;
				
				if(!!login.user.username && !!login.user.password){
					$rootScope.user = login.user;
					$rootScope.logged = true;
					$state.go('home');
				}
			});
		}
	}]);