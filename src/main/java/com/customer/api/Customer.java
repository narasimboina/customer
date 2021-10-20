package com.customer.api;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Customer {

	private @Id @GeneratedValue Long id;
	private String name;

	Customer() {}

	Customer(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Customer))
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(this.id, customer.id) && Objects.equals(this.name, customer.name)
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + this.id + ", name= " + this.name + "}";
	}
}