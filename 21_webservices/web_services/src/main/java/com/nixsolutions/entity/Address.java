package com.nixsolutions.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "address")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;

	@NotNull
	@Column(name = "region")
	private String region;

	@NotNull
	@Column(name = "city")
	private String city;

	@NotNull
	@Column(name = "street")
	private String street;

	@NotNull
	@Column(name = "building")
	private String building;

	@Column(name = "flat")
	private int flat;

	@Column(name = "postal_code")
	private int postalCode;

	public Address() {

	}

	public Address(int id, String region, String city, String street, String building, int flat, int postalCode) {
		this.id = id;
		this.region = region;
		this.building = building;
		this.city = city;
		this.flat = flat;
		this.postalCode = postalCode;
		this.street = street;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getFlat() {
		return flat;
	}

	public void setFlat(int flat) {
		this.flat = flat;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + flat;
		result = prime * result + id;
		result = prime * result + postalCode;
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		if (building == null) {
			if (other.building != null) {
				return false;
			}
		} else if (!building.equals(other.building)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (flat != other.flat) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (postalCode != other.postalCode) {
			return false;
		}
		if (region == null) {
			if (other.region != null) {
				return false;
			}
		} else if (!region.equals(other.region)) {
			return false;
		}
		if (street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!street.equals(other.street)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", region=" + region + ", city=" + city + ", street=" + street + ", building="
				+ building + ", flat=" + flat + ", postalCode=" + postalCode + "]";
	}

}
