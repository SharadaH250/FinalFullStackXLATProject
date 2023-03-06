package com.student.mypack.model;

import java.math.BigInteger;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Nonnull
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="classes")
	private String classes;
	
	@Column(name="phonenumber")
	private BigInteger phonenumber;
	
	@Column(name="address")
	private String address;
	
	
	public Student() {
		
	}
	public Student(String firstname, String lastname, String classes, BigInteger phonenumber, String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.classes = classes;
		this.phonenumber = phonenumber;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public BigInteger getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(BigInteger phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
