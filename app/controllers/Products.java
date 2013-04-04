package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Product;
import play.mvc.Controller;

public class Products extends Controller{

	public static void index(String searchquery){
		List<Product> allProducts = new ArrayList<Product>();
		if(searchquery==null || searchquery.isEmpty())
			 allProducts = Product.find("order by name asc").fetch();
		else
			allProducts = Product.find("lower(name) like ? order by name asc", "%"+searchquery.toLowerCase()+"%").fetch();
		render(allProducts,searchquery);
	}
	
	public static void delete(){
		index("");
	}
	
}
