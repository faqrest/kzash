package com.nixsolutions.entity;

import java.io.Serializable;
import java.sql.Date;

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

@Entity(name = "orders")
public class Orders implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orders_id")
	private int ordersId;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@Column(name = "order_date")
	private Date orderDate;

	@NotNull
	@Column(name = "expected_return_date")
	private Date expectedReturnDate;

	@Column(name = "actual_return_date")
	private Date actualReturnDate;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_type_id")
	private OrderType type;

	@Column(name = "comment")
	private String comment;

	public Orders(int ordersId, Book book, User user, Date orderDate, Date expectedReturnDate, Date actualReturnDate,
			OrderType type, String comment) {
		super();
		this.ordersId = ordersId;
		this.book = book;
		this.user = user;
		this.orderDate = orderDate;
		this.expectedReturnDate = expectedReturnDate;
		this.actualReturnDate = actualReturnDate;
		this.type = type;
		this.comment = comment;
	}

	public Orders() {

	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Date getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualReturnDate == null) ? 0 : actualReturnDate.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((expectedReturnDate == null) ? 0 : expectedReturnDate.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ordersId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (!(obj instanceof Orders)) {
			return false;
		}
		Orders other = (Orders) obj;
		if (actualReturnDate == null) {
			if (other.actualReturnDate != null) {
				return false;
			}
		} else if (!actualReturnDate.equals(other.actualReturnDate)) {
			return false;
		}
		if (book == null) {
			if (other.book != null) {
				return false;
			}
		} else if (!book.equals(other.book)) {
			return false;
		}
		if (comment == null) {
			if (other.comment != null) {
				return false;
			}
		} else if (!comment.equals(other.comment)) {
			return false;
		}
		if (expectedReturnDate == null) {
			if (other.expectedReturnDate != null) {
				return false;
			}
		} else if (!expectedReturnDate.equals(other.expectedReturnDate)) {
			return false;
		}
		if (orderDate == null) {
			if (other.orderDate != null) {
				return false;
			}
		} else if (!orderDate.equals(other.orderDate)) {
			return false;
		}
		if (ordersId != other.ordersId) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", book=" + book + ", user=" + user + ", orderDate=" + orderDate
				+ ", expectedReturnDate=" + expectedReturnDate + ", actualReturnDate=" + actualReturnDate + ", type="
				+ type + ", comment=" + comment + "]";
	}

}
