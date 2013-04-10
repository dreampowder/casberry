package controllers;

import java.util.List;

import com.google.gson.Gson;

import models.Dispatch;
import models.Inventory;
import models.Product;
import models.Warehouse;
import play.Logger;
import play.mvc.Controller;
import viewModels.DispatchViewModel;

public class Inventories extends Controller{
	
	public static void index(){
		render();
	}
	
	public static void getInventories(){
		List<Inventory> inventories = Inventory.findAll();
		renderJSON(inventories);
	}
	
	public static void addInventory(){
		render();
	}
	
	public static void saveDispatch(String dispatchData){		
		Gson gson = new Gson();
		DispatchViewModel dvm = gson.fromJson(dispatchData, DispatchViewModel.class);
		Logger.info("data=%s", dvm.getProducts().toString());
		Dispatch dispatch = new Dispatch(dvm.getCode()).save();
		Warehouse wareHouse = Warehouse.findById(Long.parseLong(dvm.getWarehouse()));
		for(Product p:dvm.getProducts()){
			p=Product.findById(p.getId());
			new Inventory(p, wareHouse, dispatch).save();
		}
		renderText("İrsaliye başarı ile kaydedildi!");
	}
}
