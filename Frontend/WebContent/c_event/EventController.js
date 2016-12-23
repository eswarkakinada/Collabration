/**
 * 
 */
'use strict';

app.controller('EventController', [
		'$scope',
		'EventService',
		'$location',
		'$rootScope',
		function($scope, EventService, $location, $rootScope) {
			console.log("EventController...")
			var self = this; // self is alias name instead directly use this
			self.event = { // initialization
				event_id : '',
				event_title : '',
				creation_date : '',
				info : '',
				user_name : '',
				errorCode:'',
				errorMessage:''
			};
			self.events = [];
			
			/*GET SELECTED EVENT DETAILS*/

			self.getSelectedEvent = getEvent

			function getEvent(id) {
				console.log("getting event! " + id)
				EventService.getEvent(id).then(function(d) {
					self.event = d;
					$location.path('/view_event');
				}, function(errResponse) {
					console.error('Error while fetching events');
				});
			};

			/* GET LIST OF ALL EVENTS */

			self.fetchAllEvents = function() {
				console.log("getting list of events")
				EventService.fetchAllEvents()
				.then(function(d) { // these methods are called call back methods
					self.events = d;
				}, function(errResponse) {
					console.error('Error while fetching Events');
				});
			};
			self.fetchAllEvents();

			/* CREATE A EVENT */

			self.createEvent = function(event) {
				EventService.createEvent(event).then(self.fetchAllEvents,
						function(errResponse) {
							console.error('Error while creating Events');
						});
			};

			/* UPDATE A EVENT */

			self.updateEvent = function(event) {
				EventService.updateEvent(event).then(self.fetchAllEvents,
						function(errResponse) {
							console.error('Error while updating Events');
						});
			};

			/* DELETE A EVENT */

			self.deleteEvent = function(id) {
				EventService.deleteEvent(id).then(self.fetchAllEvents,
						function(errResponse) {
							console.error('Error while deleting Events');
						});
			};

			/* ON CLICKING SUBMIT BUTTON */

			self.submit = function() {
				if (self.event.event_id == null) {
					console.log('Saving New Event', self.event);
					self.event.user_name = $rootScope.currentUser.user_id
					self.createevent(self.event);
				}
				self.reset();
			};
			
			self.reset=function(){
				console.log('resetting the blog',self.event);
				self.event={
						event_id : '',
						event_title : '',
						creation_date : '',
						info : '',
						user_name : '',
						errorCode:'',
						errorMessage:''
					};
				}


			/* END OF ALL */

		} ]);