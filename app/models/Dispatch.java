package models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Dispatch extends Model{
	
	Date createdAt;
	
	String description;
	
	public Dispatch(String description){
		this.createdAt = Calendar.getInstance().getTime();
		this.description = description;
	}

}
