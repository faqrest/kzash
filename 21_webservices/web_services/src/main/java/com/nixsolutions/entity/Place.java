package com.nixsolutions.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "place")
public class Place implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_id")
	private int placeId;

	@NotNull
	@Column(name = "shelf_code")
	private String shelfCode;

	public Place(int placeId, String shelfCode) {
		this.placeId = placeId;
		this.shelfCode = shelfCode;
	}

	public Place() {

	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getShelfCode() {
		return shelfCode;
	}

	public void setShelfCode(String shelfCode) {
		this.shelfCode = shelfCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + placeId;
		result = prime * result + ((shelfCode == null) ? 0 : shelfCode.hashCode());
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
		if (!(obj instanceof Place)) {
			return false;
		}
		Place other = (Place) obj;
		if (placeId != other.placeId) {
			return false;
		}
		if (shelfCode == null) {
			if (other.shelfCode != null) {
				return false;
			}
		} else if (!shelfCode.equals(other.shelfCode)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", shelfCode=" + shelfCode + "]";
	}

}
