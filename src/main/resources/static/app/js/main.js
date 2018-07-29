var app = angular.module("zavrsni", [ "ngRoute" ]);

app.controller("ctrl", function($scope) {
	
});

app.controller("UcesniciCtrl", function($scope, $http, $location) {

	var baseUrl = "/api/ucesnici";
	var baseUrlT = "/api/takmicenja";

	$scope.ucesnici = [];
	$scope.takmicenja = [];

	$scope.noviUcesnik = {};
	
	$scope.noviUcesnik.naziv = "";
	$scope.noviUcesnik.mesto = "";
	$scope.noviUcesnik.kontakt = "";
	$scope.noviUcesnik.odigranoSusreta = "";
	$scope.noviUcesnik.brojBodova ="";
	$scope.noviUcesnik.takmicenjeId = "";
	$scope.noviUcesnik.takmicenjeNaziv ="";
	
	$scope.noviUcesnik.id ="";
	
	$scope.pPretrage = {};
	$scope.pPretrage.naziv = "";
	$scope.pPretrage.takmicenjeId = '';

	$scope.pageNum = 0;
	$scope.totalPages = 1;
	
	$scope.prikazi = false;
	
	
	var getUcesnici = function() {

		var config = {
			params : {}
		};

		if ($scope.pPretrage.naziv != "") {
			config.params.naziv = $scope.pPretrage.naziv;
		}
		if ($scope.pPretrage.takmicenjeId != "") {
			config.params.takmicenjeId = $scope.pPretrage.takmicenjeId;
		}

		config.params.pageNum = $scope.pageNum;

		$http.get(baseUrl, config).then(function success(res) {
			$scope.ucesnici = res.data;
			$scope.totalPages = res.headers("totalPages");
		}, function error() {
			alert("Neuspela pretraga.");
		});
	}
	$scope.pretraga = function(){
		$scope.pageNum = 0;
		$scope.prikazi = true;
		getUcesnici();
		
	}
	getUcesnici();

	var getTakmicenja = function() {
		$http.get(baseUrlT).then(function success(res) {
			$scope.takmicenja = res.data;
		}, function error(res) {
			alert("Something went wrong");
		});
	}

	getTakmicenja();

	$scope.dodaj = function() {
		$http.post(baseUrl, $scope.noviUcesnik).then(function success() {
			getUcesnici();
			$scope.noviUcesnik.naziv = "";
			$scope.noviUcesnik.mesto = "";
			$scope.noviUcesnik.kontakt = "";
			$scope.noviUcesnik.odigranoSusreta = "";
			$scope.noviUcesnik.brojBodova ="";
			$scope.noviUcesnik.takmicenjeId = "";
			$scope.noviUcesnik.takmicenjeNaziv ="";
			
		}, function error() {
			alert("Could not create.")
		});
	}

	
	$scope.delete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getUcesnici();
			},
			function error(){
				alert("Could not delete the activity.");
			}
		);
	}
	$scope.goToEdit = function(id){
		$location.path("/ucesnici/edit/" + id);
	}
	$scope.goToDodaj = function(){
		$location.path("/ucesnici/dodajRezultat/"+ $scope.pPretrage.takmicenjeId);
	}
	$scope.go = function(direction) {
		$scope.pageNum = $scope.pageNum + direction;
		getUcesnici();
	}
});
app.controller("editUcesnikCtrl", function($scope, $routeParams, $http, $location){
	
	// console.log($routeParams);
	var uId = $routeParams.uId;
	var baseUrl = "/api/ucesnici";
	
	$scope.noviUcesnik = {};
	
	$scope.noviUcesnik.naziv = "";
	$scope.noviUcesnik.mesto = "";
	$scope.noviUcesnik.kontakt = "";
	$scope.noviUcesnik.odigranoSusreta = "";
	$scope.noviUcesnik.brojBodova ="";
	$scope.noviUcesnik.takmicenjeId = "";
	$scope.noviUcesnik.takmicenjeNaziv ="";
	
	$scope.noviUcesnik.id ="";

	
	var getUcesnik = function(){
		
		$http.get(baseUrl + "/" + uId).then(
			function success(res){
				$scope.noviUcesnik = res.data;
			},
			function error(res){
				console.log("Something went wrong!");
			}	
		);
	}
	
	getUcesnik();
	
	$scope.edit = function(){
		$http.put(baseUrl + "/" + uId, $scope.noviUcesnik).then(
			function success(res){
			
				$location.path("/ucesnici");
			},
			function error(res){
				alert("Something went wrong");
			}
		);
	}
	$scope.nazad = function(){
		$location.path("/ucesnici");
	}
	
});

app.controller("addRezultatCtrl", function($scope, $routeParams, $http, $location){
	
	var uId = $routeParams.uId;
	var baseUrl = "/api/takmicenja";
	$scope.noviUcesnik1 = {};
	$scope.noviUcesnik2 = {};
	
	$scope.noviUcesnik1.naziv = "";
	$scope.noviUcesnik1.id ="";	
	$scope.noviUcesnik2.naziv = "";
	$scope.noviUcesnik2.id ="";
	
	$scope.ucesnici = [];
	
	$scope.rezultat ={};
	$scope.rezultat.prvoname ="Pobeda prvog ucesnika"
	$scope.rezultat.drugoname ="Pobeda drugog ucesnika"
	$scope.rezultat.trecename ="Nereseno"
	$scope.rezultat.zvanicno ="";
	var getUcesnici = function() {

		$http.get(baseUrl +"/" +uId +"/ucesnici").then(function success(res) {
			$scope.ucesnici = res.data;
			
		}, function error() {
			alert("Neuspela pretraga.");
		});
	}
	getUcesnici();
	
	$scope.rezultatUtakmice = {};
	$scope.rezultatUtakmice.idPrvog = "";
	$scope.rezultatUtakmice.idDrugog = "";
	$scope.rezultatUtakmice.zvanicno = "";
	
	
	var izmeni = function() {

		var config = {
			params : {}
		};
		
		config.params.idPrvog = $scope.rezultatUtakmice.idPrvog;
		config.params.idDrugog = $scope.rezultatUtakmice.idDrugog;
		config.params.zvanicno = $scope.rezultat.zvanicno;

		$http.get(baseUrl +"/" +uId, config).then(function success(res) {
			$scope.ucesnici = res.data;
	
		}, function error() {
			alert("Neuspela pretraga.");
		});
	}
	$scope.nazad = function(){
		$location.path("/ucesnici");
	}
	
});

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/app/html/partial/home.html',
		controller : 'ctrl'
	}).when('/ucesnici', {
		templateUrl : '/app/html/partial/ucesnici.html'
	}).when('/ucesnici/edit/:uId', {
		templateUrl : '/app/html/partial/edit-ucesnik.html'
	}).when('/ucesnici/dodajRezultat/:uId', {
		templateUrl : '/app/html/partial/add-rezultat.html'
	}).when('/prevoznici', {
		templateUrl : '/app/html/partial/prevoznici.html'
	}).otherwise({
		redirectTo : '/'
	});
} ]);