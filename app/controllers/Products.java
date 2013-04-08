package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Product;
import play.Logger;
import play.mvc.Controller;

public class Products extends Controller{

	public static void index(){
		render();
	}
	
	public static void getProducts(){
		List<Product> products = Product.findAll();
		renderJSON(products);
	}
	
	public static void getProductNames(){
		List<String> products = Product.find("select p.name from Product as p order by p.name").fetch();
		renderJSON(products);
	}
	
	public static void getProductFromQuery(String query){
		String[]elements = query.split(" ");
		Logger.info(query);
		Product p = null;
		if(elements.length>0){
		p = Product.find("byCode", elements[0]).first();
		}
		renderJSON(p);
	}
}
