package info.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="EMP_TBL",schema="BMS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
	@Id
	private Long eno;
	private String name;
	private Double salary;
	
	
	
		public Long getEno() {
		return eno;
	}
	public void setEno(Long eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	


}
