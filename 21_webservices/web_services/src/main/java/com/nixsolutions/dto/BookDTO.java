package com.nixsolutions.dto;

import com.nixsolutions.entity.Author;
import com.nixsolutions.entity.Genre;
import com.nixsolutions.entity.Language;
import com.nixsolutions.entity.Place;
import com.nixsolutions.entity.PublishingHouse;

public class BookDTO {
	private int id;
	private String name;
	private Author author;
	private PublishingHouse house;
	private Genre genre;
	private Double avarageRate;
	private int totalCount;
	private int currentCount;
	private Place place;
	private String description;
	private int readCount;
	private Language language;

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
}
