stefanini.controller('mutanteController', ['$scope','$http','mutanteService','util',function($scope,$http,
		mutanteService,util){
	
	$scope.mutante = {};
	
	$scope.mutante = function () {
		mutanteService.getMutante(util.getUri()).success(function(data, status, headers, config) {
			$scope.mutante = data;
		}).error(function(data, status, headers, config) {
			//$scope.messages = data.message;
	    });
	};
}]);