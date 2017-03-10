angular.module('home')
	.controller('HeaderController', ['$http', '$rootScope', '$state', function($http, $rootScope, $state){
		'use strict';
		var header = this;
		header.consolesNintendo = [];
		header.consolesMicrosoft = [];
		header.logged = $rootScope.logged;
		
		header.validate = function() {
			header.gameTitles = [];
			header.game = [];
			var search = header.search;
			var getGames = $http.get('http://localhost:8080/recensigames/search/getGamesByTitle?titoloGioco=' + search)
			getGames.then(function(result) {
			    header.game = result.data;
			    angular.forEach(header.game, function(value, key){
			    	header.gameTitles.push(value.titolo);
			    });
			});
		};
		header.getConsolesByProductor = function(){
			var getSonyConsoles = $http.get('http://localhost:8080/recensigames/search/getConsolesByProductor?nomeProduttore=' + 'Sony');
			getSonyConsoles.then(function(result){
				header.consolesSony = result.data;
			})
			var getNintendoConsoles = $http.get('http://localhost:8080/recensigames/search/getConsolesByProductor?nomeProduttore=' + 'Nintendo');
			getNintendoConsoles.then(function(result){
				header.consolesNintendo = result.data;
			})
			var getMicrosoftConsoles = $http.get('http://localhost:8080/recensigames/search/getConsolesByProductor?nomeProduttore=' + 'Microsoft');
			getMicrosoftConsoles.then(function(result){
				header.consolesMicrosoft = result.data;
			})
		};
		header.getConsolesByProductor();
		
		header.logout = function(){
			$rootScope.logged = false;
			$state.go("home");
		}
	}]);