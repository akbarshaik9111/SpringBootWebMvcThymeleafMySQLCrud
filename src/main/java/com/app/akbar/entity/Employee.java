package com.app.akbar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "emptab")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private Integer empId;
	
	@Column(name = "ename")
	private String empName;
	
	@Column(name="egen")
	private String empGen;
	
	@Column(name = "esal")
	private Double empSal;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="edoj")
	private Date empDoj;
	
	@Column(name = "eha")
	private Double empHa;
	
	@Column(name = "etra")
	private Double empTra;
	
	@Column(name = "edept")
	private String empDept;
	
	@Column(name="eaddr")
	private String empAddr;

}
