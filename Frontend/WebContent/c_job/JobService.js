/**
 * 
 */
'use strict';

app.factory('JobService',['$http','$q','$rootScope',function($http,$q,$rootScope){
	
	console.log("JobService..")
	
	var BASE_URL='http://localhost:9092/BankBackend'
		return{
		
		/* GET LIST OF ALL JOBS */
		
fetchAllJobs:function(){
			return $http.get(BASE_URL+'/jobs')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching JobDetails');
						return $q.reject(errResponse);
					}				
	);
},


/* CREATE A JOB */

createJob:function(job){
	console.log('caling create job in jobService')
	return $http.post(BASE_URL+'/job/',job)
	.then(
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while creating Job');
				return $q.reject(errResponse);
			}				
);
},

/* UPDATE A JOB */

updateJob:function(job,id){
	return $http.put(BASE_URL+'/job/'+id,job)
	.then(
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while updating Job');
				return $q.reject(errResponse);
			}				
);
},

/* DELETE A JOB */

deleteJob:function(id){
	return $http.delete(BASE_URL+'/job/'+id)
	.then(
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while deleting Job');
				return $q.reject(errResponse);
			}				
);
},

/* GET SELECTED JOB DETAILS */

getJob: function(id){
	return $http.get(BASE_URL+'/job/'+id)
	.then(                                        //success handler,failure handler
			function(response){
				$rootScope.selectedJob=response.data
				return response.data;
			},
			function(errResponse){
				console.error('Error while getting Job');
				return $q.reject(errResponse);
			}				
);
},

/*APPLY FOR JOB*/

applyForJob: function(id){
	return $http.post(BASE_URL+'/applyForJob/'+id)
	.then(                                        //success handler,failure handler
			function(response){
				$rootScope.selectedJob=response.data
				return response.data;
			},
			function(errResponse){
				console.error('Error while applying Job');
				return $q.reject(errResponse);
			}				
);
},

/*REJECT JOB APPLICATION*/

rejectJobApplication:function(userID,jobID){
	return $http.post(BASE_URL+'/rejectJobApplication/'+userID+'/'+jobID)
		.then(                                        //success handler,failure handler
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while rejecting Job');
				return $q.reject(errResponse);
			}				
);
},

/*CALL FOR INTERVIEW*/

canCallForInterview:function(userID,jobID){
	return $http.post(BASE_URL+'/canCallForInterview/'+userID+'/'+jobID)
	.then(                                        //success handler,failure handler
		function(response){
			return response.data;
		},
		function(errResponse){
			console.error('Error while callingInterview Job');
			return $q.reject(errResponse);
		}				
);
},

/*SELECT USER AFTER INTERVIEW*/

selectUser:function(userID,jobID){
	return $http.put(BASE_URL+'/selectUser/'+userID+'/'+jobID)
	.then(                                        //success handler,failure handler
		function(response){
			return response.data;
		},
		function(errResponse){
			console.error('Error while selecting User Job');
			return $q.reject(errResponse);
		}				
);
},

/* GET MY APPLIED JOBS */

getMyAppliedJobs:function(){
	return $http.get(BASE_URL+'/getMyAppliedJobs/')
	.then(
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while getting MyAppliedJobs');
				return $q.reject(errResponse);
			}				
	);
	},
};  //return
	
}
]
);