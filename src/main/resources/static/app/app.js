(function(angular) {
    angular.module("random-number.controllers", []);
    angular.module("random-number.services", []);
    angular.module("random-number", ["ngResource", "random-number.controllers", "random-number.services"]);
}(angular));