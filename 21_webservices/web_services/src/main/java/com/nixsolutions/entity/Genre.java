package com.nixsolutions.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "genre")
public class Genre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	int id;

	@Column(name = "name")
	String genre;

	public Genre(int id, String genre) {
		this.id = id;
		this.genre = genre;
	}

	public Genre() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return genre;
	}

	public void setName(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
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
		if (!(obj instanceof Genre)) {
			return false;
		}
		Genre other = (Genre) obj;
		if (id != other.id) {
			return false;
		}
		if (genre == null) {
			if (other.genre != null) {
				return false;
			}
		} else if (!genre.equals(other.genre)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + genre + "]";
	}

}
