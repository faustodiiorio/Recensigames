angular.module('home')
	.controller('SearchController', ['$stateParams', '$http', function ($stateParams, $http){
		var search = this;
		search.searchParam = "";
		search.byTitle = false;
		search.byConsole = false;
		if($stateParams.hasOwnProperty('titoloGioco')){
			search.searchParam = $stateParams.titoloGioco;
			search.byTitle = true;
			search.byConsole = false;
		} else if($stateParams.hasOwnProperty('nomeConsole')){
			search.searchParam = $stateParams.nomeConsole;
			search.byConsole = true;
			search.byTitle = false;
		}
		
		search.validate = function() {
			search.game = [];
			var getGames = $http.get('http://localhost:8080/recensigames/search/getGamesByTitle?titoloGioco=' + search.searchParam)
			getGames.then(function(result) {
			    search.game = result.data;
			});
		};
		search.advancedSearch = function(){
			search.isHidden = !search.isHidden;
		}
		search.gameByTitleAndVersion = [];
		var getGameByTitleAndVersion = $http.get('http://localhost:8080/recensigames/search/getGameByTitleAndConsole?titoloGioco=' + search.searchParam + "&nomeConsole=" );
		getGameByTitleAndVersion.then(function(result){
			search.gameByTitleAndVersion = result.data;
		});
//		search.url = "";
//		search.populateUrl = function(){
//			if($location.path().contains("byConsole")){
//				search.url = "console";
//			} else if($location.path().contains("byTitle")){
//				search.url = "title";
//			}
//		}
//		search.populateUrl();
}]);