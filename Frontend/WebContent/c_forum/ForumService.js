/**
 * 
 */
/**
 * 
 */
'use strict';

app.factory('ForumService',['$http','$q','$rootScope',function($http,$q,$rootScope){
	
	console.log("ForumService..")
	
	var BASE_URL='http://localhost:9092/BankBackend'
		return{
		
		/* GET LIST OF ALL FORUMS */
		
fetchAllForums:function(){
	        console.log("calling fetchAllForums")
			return $http.get(BASE_URL+'/forums')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching ForumDetails');
						return $q.reject(errResponse);
					}				
	);
},


/* CREATE A FORUM */

createForum:function(forum){
	return $http.post(BASE_URL+'/forum/',forum)
	.then(
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while creating Forum');
				return $q.reject(errResponse);
			}				
);
},

/* UPDATE A FORUM */

updateForum:function(forum,id){
	return $http.put(BASE_URL+'/forum/'+id,forum)
	.then(
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while updating Forum');
				return $q.reject(errResponse);
			}				
);
},

/* DELETE A FORUM */

deleteForum:function(id){
	return $http.delete(BASE_URL+'/forum/'+id)
	.then(
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while deleting Forum');
				return $q.reject(errResponse);
			}				
);
},

/* GET SELECTED FORUM DETAILS */

getForum: function(id){
	return $http.get(BASE_URL+'/forum/'+id)
	.then(                                        //success handler,failure handler
			function(response){
				$rootScope.selectedForum=response.data
				return response.data;
			},
			function(errResponse){
				console.error('Error while getting Forum');
				return $q.reject(errResponse);
			}				
);
},


};  //return
	
}
]
);