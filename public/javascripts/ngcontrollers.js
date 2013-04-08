'use strict';

var myApp = angular.module('casberryApp',['ui.bootstrap']);

function ProductListCtrl($scope,$http){
	$http.get('/product/getProducts').success(function(data){
		$scope.products = data;	
	});
	$scope.orderProp = 'name';
};

function InventoryListCtrl($scope,$http){
	$http.get('/inventory/getInventories').success(function(data){
		$scope.inventories = data;	
	});
	$scope.orderProp = 'name';
	
	$http.get('/warehouse/getWarehouses').success(function(data){
		$scope.warehouses = data;	
	});
	
	$scope.checkOption = function(value){

	};
}

function AddInventoryCtrl($scope,$http){

		$http.get('/warehouse/getWarehouses').success(function(data){
		$scope.warehouses = data;	
	});
	
		$http.get('/product/getProducts').success(function(data){
		$scope.products = data;	
	});

	$scope.addProduct=function(){
	if($scope.typeAhead!=null){
		$http.get('/product/getProductFromQuery?query='+$scope.typeAhead).success(function(data){
			$scope.dispatchProducts.push(data);
		});
		}
	}
	
	$scope.removeFromDispatch = function(index){
		$scope.dispatchProducts.splice(index,1);
	};
	
	$scope.saveDispatch = function(productArray,warehouseId,dispatchCode){
		console.log(productArray);
		var dispatchProducts = new Object();
		dispatchProducts.products = productArray;
		dispatchProducts.code = dispatchCode;
		dispatchProducts.warehouse=warehouseId;
		$http.post('/inventory?dispatchData='+JSON.stringify(dispatchProducts)).success(function(data){
			console.log(data);
		});	
	};
}
