(function() {
	var app = angular.module('store', []);

	var employees = [ {
		name : 'Rupesh Raut',
		age : 36,
		show : true
	}, {
		name : 'kirti Raut',
		age : 28,
		show : false
	}, ]

	app.controller('StoreCtrl', function() {
		this.employeeList = employees;
	});
})();