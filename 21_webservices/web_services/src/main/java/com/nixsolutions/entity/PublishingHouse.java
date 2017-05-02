package com.nixsolutions.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "publishing_house")
public class PublishingHouse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publishing_house_id")
	private int houseId;

	@Column(name = "house")
	private String house;

	public PublishingHouse(int houseId, String house) {
		this.houseId = houseId;
		this.house = house;
	}

	public PublishingHouse() {

	}

	public int getId() {
		return houseId;
	}

	public void setId(int houseId) {
		this.houseId = houseId;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + houseId;
		result = prime * result + ((house == null) ? 0 : house.hashCode());
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
		if (!(obj instanceof PublishingHouse)) {
			return false;
		}
		PublishingHouse other = (PublishingHouse) obj;
		if (houseId != other.houseId) {
			return false;
		}
		if (house == null) {
			if (other.house != null) {
				return false;
			}
		} else if (!house.equals(other.house)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Publishing_house [id=" + houseId + ", house=" + house + "]";
	}

}
