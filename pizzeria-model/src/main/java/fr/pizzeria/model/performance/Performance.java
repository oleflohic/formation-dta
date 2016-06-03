package fr.pizzeria.model.performance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="performance")
public class Performance {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name="service", length=30)
	private String service;
	
	@Column (name="date", columnDefinition="DATE")
	private Date date;
	
	@Column (name="temps_execution", columnDefinition="INTEGER", nullable=false)
	private Integer tempsExecution;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getTempsExecution() {
		return tempsExecution;
	}
	public void setTempsExecution(Integer tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
}
