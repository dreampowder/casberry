package models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Order extends Model{
	
	public enum DELIVERYSTATE{
		WAITING,
		DELIVERED
	}
	
	Date createdAt;

	@ManyToMany
	List<Product> products;
	
	@ManyToOne
	Customer customer;
	
	Date deliveryDate;
	
	DELIVERYSTATE state;

	public Order(List<Product> products, Customer customer, Date deliveryDate) {
		super();
		this.createdAt = Calendar.getInstance().getTime();
		this.products = products;
		this.customer = customer;
		this.deliveryDate = deliveryDate;
		this.state = DELIVERYSTATE.WAITING;
	}
	
	
}
