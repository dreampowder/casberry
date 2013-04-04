package models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Inventory extends Model{
	
	Date createdAt;
	
	@ManyToOne
	Product product;
	
	@ManyToOne
	Warehouse wareHouse;

	public Inventory(Product product, Warehouse wareHouse) {
		super();
		this.createdAt = Calendar.getInstance().getTime();
		this.product = product;
		this.wareHouse = wareHouse;
	}
	
	

}
