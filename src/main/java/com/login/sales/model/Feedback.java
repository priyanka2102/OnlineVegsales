package com.login.sales.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="feedback")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Feedback implements Serializable{
	private static final long serialversionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="comment", length=50)
	private String comment;
	
	@Column(name="rating", length=5)
	private int rating;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="cust_id")
	@JsonIgnore
	private Customer customer;
    
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Feedback() {
		
	}
	
	public Feedback(int id, String comment, int rating) {
		super();
		this.id = id;
		this.comment = comment;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComments(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", comment=" + comment + ", rating=" + rating + ", customer=" + customer + "]";
	}
}

