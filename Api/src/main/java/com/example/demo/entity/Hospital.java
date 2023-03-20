package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
	@Transactional
	@Table(name="hospitals")
	public class Hospital{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="add_id")
	private Long Id;
	private String name;
	private String address;
	private Long phone_number;
	private String diagnosis;
	public Hospital(Long id, String name, String address, Long phone_number, String diagnosis) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.diagnosis = diagnosis;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
}
