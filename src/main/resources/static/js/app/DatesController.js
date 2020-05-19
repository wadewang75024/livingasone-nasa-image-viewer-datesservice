'use strict'

var module = angular.module('datesservice.controllers', []);
module.controller
("DatesController", 
	[ "$scope", "DatesService",
		function($scope, DatesService) {			
			DatesService.getDates().then(function(value) 
			{
				console.log(value.data);
				$scope.allDates= value.data;
			}, function(reason) 
			{
				console.log("error occured");
			}, function(value) 
			{
				console.log("no callback");
			}
			);

			$scope.displayDates = function() {				
				DatesService.getDates().then(function(value) {
					console.log("works");
					$scope.allDates= value.data;							
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				}
				);
			}
					
		}
	]
);