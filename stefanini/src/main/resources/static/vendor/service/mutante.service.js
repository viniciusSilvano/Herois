stefanini.service('mutanteService', ['$http', 
                                function($http){
	
	this.getMutante = function(uri){
		return $http.get(uri + '/mutante');
	};
	
}])