/**
 * 
 */
stefanini.controller('dueloController', ['$scope','$http','dueloService','util',function($scope,$http,
		dueloService,util){
	$scope.duelar = function () {
		dueloService.getResultados(util.getUri()).sucess(function(data, status, headers, config) {
			$scope.duelos = data;
		}).error(function(data, status, headers, config) {
			$scope.messages = data.message;
	    });
	};
}]);