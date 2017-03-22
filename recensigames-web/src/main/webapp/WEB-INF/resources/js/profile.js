angular.module('home')
	.controller('ProfileController', ['$http', '$rootScope', function($http, $rootScope){
		'use strict';
		var profile = this;
		profile.getContribution = function(){
			profile.walkthroughs = [];
			profile.reviews = [];
			profile.domande = [];
			profile.risposte = [];
			
			var getPartialReviesByUser = $http.get('http://localhost:8080/recensigames/profile/getPartialReviewsByUser?username=' + $rootScope.user.username);
			getPartialReviesByUser.then(function(result) {
				angular.forEach(result.data, function(value, key){
					if(value.tipologia === ("Walkthrough")){
				    	profile.walkthroughs.push(value);
				    	} else if(value.tipologia === ("Recensione")){
				    		profile.reviews.push(value);
				    	}
				});
			});
			var getQuestionsByUser = $http.get('http://localhost:8080/recensigames/profile/getQuestionsByUser?username=' + $rootScope.user.username);
			getQuestionsByUser.then(function(result) {
			    profile.domande = result.data;
			});
			var getAnswersByUser = $http.get('http://localhost:8080/recensigames/profile/getAnswersByUser?username=' + $rootScope.user.username);
			getAnswersByUser.then(function(result) {
				profile.risposte = result.data;
			});
		};
		profile.getContribution();
	}]);