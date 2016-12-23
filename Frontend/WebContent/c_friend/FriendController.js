/**
 * 
 */
'use strict'

app.controller('FriendController',['UserService','$scope','FriendService','$location','$rootScope',
                                   function($http,$q,$rootScope,FriendService,UserService){
	console.log("FriendController....")
	var self=this;
	self.friend={ // initialization
			id : '',
			friend_id : '',
			friend_name:'',
			user_id : '',
			request_status : '',
			isOnline : '',
			errorCode:'',
			errorMessage:''
		};
	self.friends=[];
	
	self.user = {
			id : '',
			name : '',
			password : '',
			mobile : '',
			address : '',
			email : '',
			role : '',
			errorMessage : ''
		};
		self.users = [];

/*SENDING FRIEND REQUEST*/		
self.sendFriendRequest=sendFriendRequest

function sendFriendRequest(friendID)
{
console.log("sendFriendRequest:" + friendID)
FriendService.sendFriendRequest(friendID)
.then(
function(d){
	self.friend=d;
	alert("Friend request sent")
},function(errResponse){
	console.error('Error while sending Friend requests');
	
});
};

/*GET MY FRIENDS LIST*/
self.getMyFriends=function(){
	console.log("gettingMyFriends")
	FriendService.getMyFriends()
	.then(
	function(d){
		self.friends=d;
		console.log("Got the friends list")
	},function(errResponse){
		console.error('Error while fetching Friend');
		
	});
	};
	
self.updateFriendRequest=function(friend,id){
	FriendService.updateFriendRequest(friend,id)
	.then(
	self.fetchAllFriends,
	function(errResponse){
		console.error('Error while updating Friend');
	}
	);
};

self.deleteFriend=function(id){
	FriendService.deleteFriend(id)
	.then(
	self.fetchAllFriends,
	function(errResponse){
		console.error('Error while deleting Friend');
	}
	);
};

self.fetchAllUsers=function(){
	UserService.fetchAllUsers()
	.then(function(d){
		self.users=d;
	},function(errResponse){
		console.error('Error while fetching Users');
	}
	);
};

self.fetchAllUsers();
self.getMyFriends();

	/* END OF ALL */

} ]);