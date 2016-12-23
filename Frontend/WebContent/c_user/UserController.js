/**
 * 
 */
'use strict';

app.controller('UserController', [
		'$scope',
		'UserService',
		'$location',
		'$rootScope',
		function($scope, UserService, $location, $rootScope) {
			console.log("UserController...")
			var self = this;
			self.user = {
				userid : '',
				username : '',
				password : '',
				contact : '',
				
				email : '',
				role : '',
				
				errorMessage : ''
			};
			self.users = [];

			self.fetchAllUsers = function() {
				UserService.fetchAllUsers().then(function(d) {
					self.users = d;
				}, function(errResponse) {
					console.error('Error while fetching Users');
				});
			};
			self.fetchAllUsers();

			/* CREATE USER */
			self.createUser = function(user) {
				UserService.createUser(user)
				.then(self.fetchAllUsers,
						function(errResponse) {
							console.error('Error while creating User...');
						});
			};

			/* UPDATE USER */
			self.updateUser = function(user, id) {
				UserService.updateUser(user, id)
				.then(self.fetchAllUsers,
						function(errResponse) {
							console.error('Error while updating User...');
						});
			};

			/* AUTHENTICATION OF USER */
			self.authenticate = function(user) {
				UserService.authenticate(user)
				.then(function(d) {
					self.user = d;
					if ($rootScope.currentUser) {
						$location.path('/');
					}
				}, function(errResponse) {
					console.error('Error while authenticate User...');
				});
			};

			/* DELETE USER */
			self.deleteUser = function(id) {
				UserService.deleteUser(id)
				.then(self.fetchAllUsers,
						function(errResponse) {
							console.error('Error while deleting User');
						});
			};

			self.login = function() {
				{
					console.log('login validation????', self.user);
					self.authenticate(self.user);
				}
			};
			
			self.edit = function(id) {
				console.log('id to be edited', id);
				for (var i = 0; i < self.users.length; i++) {
					if (self.users[i].id == id) {
						self.user = angular.copy(self.users[i]);
						break;
					}
				}
			};
			
			self.remove = function(id) {
				console.log('id to be deleted', id);
				if (self.user.id == id) {
					self.reset();
				}
				self.deleteUser(id);
			};
			
			self.logout=function(){
				console.log('Logging out');
				UserService.logout()
				.then(function() {
					if ($rootScope.currentUser='') {
						
						alert("You have successfully logged out!")
					}},
						/*$rootScope.currentUser={}
						$cookieStore.remove('currentUser');*/
						
						/*$location.path("/")*/
						function(errResponse) {
					console.error('Error while logging out');
				});
				
				self.submit = function() {
						console.log('Saving New user', self.user);
						self.createUser(self.user);
					
				self.reset();
				};
				
				
				self.reset=function(){
					console.log('reset user',self.user);
					self.user={
							userid : '',
							username : '',
							password : '',
							contact : '',
							email : '',
							role : '',
							
							errorMessage : ''
						};
				     $scope.myForm.$setPristine(); // reset Form
				};

	
			/* END OF ALL */
};
	
		} ]);