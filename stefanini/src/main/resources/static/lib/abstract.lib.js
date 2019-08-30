/**
	Abstract for construction commom in user case
*/
stefanini.controller('abstractController', ['$scope', '$state', 
    function($scope, $state) {
      
	  $scope.initial = function(){
	    $state.go('/', {});
	  };
	  
	  $scope.herois = function(){
	    $state.go('herois', {});
	  };
	  
	  $scope.duelar = function(){
		$state.go('duelar',{});  
	  };
	  
	  $scope.mutante = function(){
		  $state.go('mutante',{});  
	  };
	  
}]).directive('menu', function() {
  return {
  	restrict: 'E',
    templateUrl: 'template/menu.html'
  };
});