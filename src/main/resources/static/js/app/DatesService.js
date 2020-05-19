'use strict'

angular.module('datesservice.services', []).factory('DatesService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};			
			service.getDates = function() {
				return $http.get(CONSTANTS.getDates);
			}
			return service;
		} 
		]
);