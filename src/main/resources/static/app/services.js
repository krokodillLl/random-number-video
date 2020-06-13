(function (angular) {
    var RandomNumberFactory = function ($resource) {
        return $resource('random/:action/:id',
            {id: "@id"},
            {
              add: {
                  method: "POST",
                  params: {
                      action: 'add'
                  }
              },
                update: {
                  method: "PUT",
                    params: {
                      action: 'update'
                    }
                },
                remove: {
                  method: "DELETE",
                    params: {
                      action: 'delete'
                    }
                }
            });
    };
    RandomNumberFactory.$inject = ['$resource'];
    angular.module("random-number.services").factory("RandomNumber", RandomNumberFactory);


}(angular));