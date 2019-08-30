/**
 * 
 */
stefanini.service('dueloService', ['$http', 
                                function($http){
	
	this.getResultados = function(uri){
		return $http.get(uri + '/duelar');
	};
	
}])