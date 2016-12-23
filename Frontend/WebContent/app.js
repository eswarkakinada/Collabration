var app=angular.module('myApp',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	
	.when('/',{
		templateUrl:'c_home/home.html',
		controller:'HomeController'
	})
	
	.when('/home',{
		templateUrl:'c_home/home.html',
		controller:'HomeController'
	})
	
	.when('/manageUser',{
		templateUrl:'c_admin/manage_users.html',
		controller:'AdminController'
	})
	
	.when('/about',{
		templateUrl:'c_about/AboutUs.html',
	})
	
	.when('/contact',{
		templateUrl:'c_about/ContactUs.html',
	})

	.when('/login',{
		templateUrl:'c_user/login.html',
		controller:'UserController'
	})
	
	.when('/register',{
		templateUrl:'c_user/register.html',
		controller:'UserController'
		
	})
	
	/*
	 * EVENT
	 */
		
	.when('/my_event',{
		templateUrl:'c_event/my_event.html',
		controller:'EventController'
	})
	
	.when('/create_event',{
		templateUrl:'c_event/create_event.html',
		controller:'EventController'
	})
	
	.when('/list_event',{
		templateUrl:'c_event/list_event.html',
		controller:'EventController'
	})
	
	.when('/view_event',{
		templateUrl:'c_event/view_event.html',
		controller:'EventController'
	})
	
	
	
	/**
	 * BLOG
	**/
	
	.when('/my_blog',{
		templateUrl:'c_blog/my_blog.html',
		controller:'BlogController'
	})
	
	.when('/create_blog',{
		templateUrl:'c_blog/create_blog.html',
		controller:'BlogController'
	})
	
	.when('/list_blog',{
		templateUrl:'c_blog/list_blog.html',
		controller:'BlogController'
	})
	
	.when('/view_blog',{
		templateUrl:'c_blog/view_blog.html',
		controller:'BlogController'
	})
	
	/**
	 * FRIEND RELATED MAPPING
	 **/
	
	.when('/list_friend',{
		templateUrl:'c_friend/list_friend.html',
		controller:'FriendController'
	})
	
	.when('/view_friend',{
		templateUrl:'c_friend/view_friend.html',
		controller:'FriendController'
	})
	
	/**
	 * FORUM RELATED MAPPING 
	 **/
	
	.when('/create_forum',{
		templateUrl:'c_forum/create_forum.html',
		controller:'ForumController'
	})
	
	.when('/list_forum',{
		templateUrl:'c_forum/list_forum.html',
		controller:'ForumController'
	})
	
	.when('/view_forum',{
		templateUrl:'c_forum/view_forum.html',
		controller:'ForumController'
	})
	
	.when('/my_forum',{
		templateUrl:'c_forum/my_forum.html',
		controller:'ForumController'
	})
	
	/**
	 * JOB RELATED MAPPING
	 **/
	
	.when('/create_job',{
		templateUrl:'c_job/create_job.html',
		controller:'JobController'
	})
	
	.when('/list_job',{
		templateUrl:'c_job/list_job.html',
		controller:'JobController'
	})
	
	.when('/view_job',{
		templateUrl:'c_job/view_job.html',
		controller:'JobController'
	})
	
	.when('/my_job',{
		templateUrl:'c_job/my_job.html',
		controller:'JobController'
	})
	
	.otherwise({redirectTo: '/'});

});

/*app.run(function($rootScope,$location,$cookieStore,$http){
	$rootScope.$on('$locationChangeStart',function(event,next,current){
		var unRestrictedPage=$.inArray($location.path(),['/login','/register','/list_friend','/list_event','/list_job','/list_forum'])==0;
	var loggedIn=$rootScope.currentUser.user_id;
	console.log("loggedIn:" + loggedIn)
	if(unRestrictedPage && !loggedIn){
		console.log("Navigating to login page")
		$location.path('/login');
	}
	});
	
	//keep user logged in after page refresh
	$rootScope.currentUser=$cookieStore.get('currentUser')||{};
	if($rootScope.currentUser){
	$http.defaults.headers.common['Authorization']	='Basic'+ $rootScope.currentUser;
	}
	});*/