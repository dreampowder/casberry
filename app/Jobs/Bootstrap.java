package Jobs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import models.Product;

import org.apache.commons.io.FileUtils;

import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job{

	@Override
	public void doJob() throws Exception {
		super.doJob();
		rebuildProducts();
	}
	
	private void rebuildProducts(){
		Logger.info("Ürün tanımları yükleniyor");
    	File file = new File("public/cilekproducts.csv");
    	List<String> lines = null;
		try {
			lines = FileUtils.readLines(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	for(String s:lines){
    		String[] params = s.split(",");
    		if(params.length==3){
    			String code = params[0];
    			String name = params[1];
    			Double price = Double.parseDouble(params[2]);
    			Product pTest = Product.find("byCode", code).first();
    			if(pTest==null){
    				pTest = new Product(name, code, price);
    			}else{
    				pTest.setName(name);
    				pTest.setPrice(price);
    			}
    			pTest.save();
    		}
    	}
    	Logger.info("Ürün tanımları yüklendi");
	}
}
