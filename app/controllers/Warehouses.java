package controllers;

import java.util.List;

import models.Warehouse;
import models.Warehouse.WarehouseType;
import play.Logger;
import play.mvc.Controller;

public class Warehouses extends Controller{
	
    public static void index(){
    	List<Warehouse> warehouses = Warehouse.findAll();
    	render(warehouses);
    }

	public static void addWareHouse(String name,String description, String type){
		Logger.info("Gelen Parametreler: %s %s %s", name,description,type);
		WarehouseType wtype = WarehouseType.MAGAZA;
		if(type.equalsIgnoreCase("depo"))
			wtype = WarehouseType.DEPO;
		 new Warehouse(name, description, wtype).save();
		index();
	}
	
	public static void delete(Long id){
		Warehouse wh = Warehouse.findById(id);
		wh.delete();
		index();
	}
	
	public static void getWarehouses(){
		List<Warehouse> warehouses = Warehouse.findAll();
		renderJSON(warehouses);
	}
}
