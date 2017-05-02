package com.nixsolutions.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "rate")
public class Rate implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rate_id")
	private int id;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	private Book book;

	@NotNull
	@Column(name = "rate")
	private int rate;

	public Rate(int id, Book book, int rate) {
		super();
		this.id = id;
		this.book = book;
		this.rate = rate;
	}

	public Rate() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + id;
		result = prime * result + rate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Rate)) {
			return false;
		}
		Rate other = (Rate) obj;
		if (book == null) {
			if (other.book != null) {
				return false;
			}
		} else if (!book.equals(other.book)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (rate != other.rate) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", book=" + book + ", rate=" + rate + "]";
	}

}
