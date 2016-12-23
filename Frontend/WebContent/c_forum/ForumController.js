/**
 * 
 */
'use strict';

app.controller('ForumController', [
		'$scope',
		'ForumService',
		'$location',
		'$rootScope',
		function($scope, ForumService, $location, $rootScope) {
			console.log("ForumController...")
			var self = this; // self is alias name instead directly use this
			self.forum = { // initialization
				forum_id : '',
				forum_title : '',
				creation_date : '',
				info : '',
				user_name : '',
				errorCode:'',
				errorMessage:''
			};
			self.forums = [];
			
			/*GET SELECTED FORUM DETAILS*/

			self.getSelectedForum = getForum

			function getForum(id) {
				console.log("getting forum! " + id)
				ForumService.getForum(id).then(function(d) {
					self.forum = d;
					$location.path('/view_forum');
				}, function(errResponse) {
					console.error('Error while fetching forums');
				});
			};

			/* GET LIST OF ALL FORUMS */

			self.fetchAllForums = function() {
				console.log("getting list of forums")
				ForumService.fetchAllForums()
				.then(function(d) { // these methods are called call back methods
					self.forums = d;
				}, function(errResponse) {
					console.error('Error while fetching Forums');
				});
			};
			self.fetchAllForums();

			/* CREATE A FORUM */

			self.createForum = function(forum) {
				ForumService.createForum(forum).then(self.fetchAllForums,
						function(errResponse) {
							console.error('Error while creating Forums');
						});
			};

			/* UPDATE A FORUM */

			self.updateForum = function(forum) {
				ForumService.updateForum(forum).then(self.fetchAllForums,
						function(errResponse) {
							console.error('Error while updating Forums');
						});
			};

			/* DELETE A FORUM */

			self.deleteForum = function(id) {
				ForumService.deleteForum(id).then(self.fetchAllForums,
						function(errResponse) {
							console.error('Error while deleting Forums');
						});
			};

			/* ON CLICKING SUBMIT BUTTON */

			self.submit = function() {
				/*if (self.forum.forum_id == null) {*/
					console.log('Saving New Forum', self.forum);
					self.forum.user_name = $rootScope.currentUser.user_id
					self.createforum(self.forum);
				//}
				self.reset();
			};
			
			self.reset=function(){
				console.log('resetting the forum',self.forum);
				self.forum={
						forum_id : '',
						forum_title : '',
						creation_date : '',
						info : '',
						user_name : '',
						errorCode:'',
						errorMessage:''
					};
				}


			/* END OF ALL */

		} ]);/**
 * 
 */