/**
 * 
 */
'use strict';

app.controller('BlogController', [
		'$scope',
		'BlogService',
		'$location',
		'$rootScope',
		function($scope, BlogService, $location, $rootScope) {
			console.log("BlogController...")
			var self = this; // self is alias name instead directly use this
			self.blog = { // initialization
				blog_id : '',
				blog_title : '',
				creation_date : '',
				status : '',
				description : '',
				user_name : '',
				errorCode:'',
				errorMessage:''
			};
			self.blogs = [];
			
			/*GET SELECTED BLOG DETAILS*/

			self.getSelectedBlog = getBlog

			function getBlog(id) {
				console.log("getting blog in Controller! " + id)
				BlogService.getBlog(id).then(function(d) {
					self.blog = d;
					$location.path('/view_blog');
				}, function(errResponse) {
					console.error('Error while fetching blogs');
				});
			};

			/* GET LIST OF ALL BLOGS */

			self.fetchAllBlogs = function() {
				BlogService.fetchAllBlogs().then(function(d) { // these methods
																// are called
																// call back
																// methods
					self.blogs = d;
				}, function(errResponse) {
					console.error('Error while fetching Blogs');
				});
			};
			self.fetchAllBlogs();

			/* CREATE A BLOG */

			self.createBlog = function(blog) {
				BlogService.createBlog(blog).then(self.fetchAllBlogs,
						function(errResponse) {
							console.error('Error while creating Blogs');
						});
			};

			/* UPDATE A BLOG */

			self.updateBlog = function(blog) {
				BlogService.updateBlog(blog).then(self.fetchAllBlogs,
						function(errResponse) {
							console.error('Error while updating Blogs');
						});
			};

			/* DELETE A BLOG */

			self.deleteBlog = function(id) {
				BlogService.deleteBlog(id).then(self.fetchAllBlogs,
						function(errResponse) {
							console.error('Error while deleting Blogs');
						});
			};

			/* ON CLICKING SUBMIT BUTTON */

			self.submit = function() {
				if (self.blog.blog_id == null) {
					console.log('Saving New Blog', self.blog);
					self.blog.user_name = $rootScope.currentUser.user_id
					self.createblog(self.blog);
				}
				self.reset();
			};
			
			self.reset=function(){
				console.log('resetting the blog',self.blog);
				self.blog={
						blog_id : '',
						blog_title : '',
						creation_date : '',
						status : '',
						description : '',
						user_name : '',
						errorCode:'',
						errorMessage:''
					};
				}


			/* END OF ALL */

		} ]);