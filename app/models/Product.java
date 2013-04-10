package models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Product extends Model{
	
	Date createdAt;
	String name;
	String code;
	Double price;
	
	public Product(String name, String code, Double price) {
		super();
		this.createdAt = Calendar.getInstance().getTime();
		this.name = name;
		this.code = code;
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
