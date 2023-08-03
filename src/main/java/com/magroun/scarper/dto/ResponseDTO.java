package com.magroun.scarper.dto;

public class ResponseDTO {
    private String price;
    private String name;
    private String category;
    private String city;


    public ResponseDTO() {
    }

    public ResponseDTO(String price, String name, String category, String city) {
        this.price = price;
        this.name = name;
        this.category = category;
        this.city = city;
    }

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
