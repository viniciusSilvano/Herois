/**
 * 
 */
stefanini.service('dueloService', ['$http', 
                                function($http){
	
	this.getPersonagem = function(uri){
		return $http.get(uri + '/duelar');
	};
	
}])