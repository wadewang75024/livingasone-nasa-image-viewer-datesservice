'use strict'

var datesserviceApp = angular.module('nasa.datesservice', 
		[ 'ui.bootstrap', 
		  'datesservice.controllers',
		  'datesservice.services' ]);

datesserviceApp.constant("CONSTANTS", {
	getDates : "/api/v1/dates"
});