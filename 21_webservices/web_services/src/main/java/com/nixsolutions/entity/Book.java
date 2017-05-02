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

@Entity(name = "book")
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int id;

	@NotNull
	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private Author author;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "publishing_house_id")
	private PublishingHouse house;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "genre_id")
	private Genre genre;

	@Column(name = "avarage_rate", columnDefinition = "int default 0")
	private Double avarageRate;

	@NotNull
	@Column(name = "total_count")
	private int totalCount;

	@NotNull
	@Column(name = "current_count")
	private int currentCount;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "place_id", nullable = false)
	private Place place;

	@Column(name = "description")
	private String description;

	@Column(name = "read_count")
	private int readCount;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id")
	private Language language;

	public Book(int id, String name, Author author, PublishingHouse house, Genre genre, double avarageRate,
			int totalCount, int currentCount, Place place, String description, int readCount, Language language) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.house = house;
		this.genre = genre;
		this.avarageRate = avarageRate;
		this.totalCount = totalCount;
		this.currentCount = currentCount;
		this.place = place;
		this.description = description;
		this.readCount = readCount;
		this.language = language;
	}

	public Book() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public PublishingHouse getHouse() {
		return house;
	}

	public void setHouse(PublishingHouse house) {
		this.house = house;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public double getAvarageRate() {
		return avarageRate;
	}

	public void setAvarageRate(double avarageRate) {
		this.avarageRate = avarageRate;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		long temp;
		temp = Double.doubleToLongBits(avarageRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + currentCount;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + readCount;
		result = prime * result + totalCount;
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
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (Double.doubleToLongBits(avarageRate) != Double.doubleToLongBits(other.avarageRate)) {
			return false;
		}
		if (currentCount != other.currentCount) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (genre == null) {
			if (other.genre != null) {
				return false;
			}
		} else if (!genre.equals(other.genre)) {
			return false;
		}
		if (house == null) {
			if (other.house != null) {
				return false;
			}
		} else if (!house.equals(other.house)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (language == null) {
			if (other.language != null) {
				return false;
			}
		} else if (!language.equals(other.language)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (place == null) {
			if (other.place != null) {
				return false;
			}
		} else if (!place.equals(other.place)) {
			return false;
		}
		if (readCount != other.readCount) {
			return false;
		}
		if (totalCount != other.totalCount) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", house=" + house + ", genre=" + genre
				+ ", avarageRate=" + avarageRate + ", totalCount=" + totalCount + ", currentCount=" + currentCount
				+ ", place=" + place + ", description=" + description + ", readCount=" + readCount + ", language="
				+ language + "]";
	}

}
