package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="username")
	String name;
	@Column(name="dish")
	String dish;
	@Column(name="address")
	String address;
	@Column(name="password")
	String password;
	
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
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", dish=" + dish + ", address=" + address + ", password=" + password + "]";
	}
	
}
