package models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.OnDelete;

import play.Logger;
import play.db.jpa.Model;

@Entity
public class Warehouse extends Model{

	public enum WarehouseType{
		DEPO,
		MAGAZA;
	}
	
	Date createdAt;
	String name;
	String description;
	WarehouseType type;
	
	public Warehouse(String name, String description,WarehouseType type) {
		super();
		this.createdAt = Calendar.getInstance().getTime();
		this.name = name;
		this.description = description;
		this.type = type;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public WarehouseType getType() {
		return type;
	}
	public void setType(WarehouseType type) {
		this.type = type;
	}
	
	@PreRemove
	public void deleteAction(){
		Logger.info("Depoya Kayıtlı ürünler siliniyor..");
		Inventory.delete("wareHouse=?", this);
	}
}
