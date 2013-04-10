package models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import play.db.jpa.Model;

@Entity
public class Inventory extends Model{
	
	Date createdAt;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Dispatch dispatch;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Product product;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	Warehouse wareHouse;

	public Inventory(Product product, Warehouse wareHouse,Dispatch dispatch) {
		super();
		this.createdAt = Calendar.getInstance().getTime();
		this.product = product;
		this.wareHouse = wareHouse;
		this.dispatch = dispatch;
	}
	
}
