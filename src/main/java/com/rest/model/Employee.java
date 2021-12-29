package com.rest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2897480794834983020L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String empName;
	private Double empSal;
}
