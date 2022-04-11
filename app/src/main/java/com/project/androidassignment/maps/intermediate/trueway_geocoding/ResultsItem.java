package com.project.androidassignment.maps.intermediate.trueway_geocoding;

import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("area")
	private String area;

	@SerializedName("country")
	private String country;

	@SerializedName("address")
	private String address;

	@SerializedName("street")
	private String street;

	@SerializedName("locality")
	private String locality;

	@SerializedName("location")
	private Location location;

	@SerializedName("region")
	private String region;

	@SerializedName("type")
	private String type;

	@SerializedName("location_type")
	private String locationType;

	public void setArea(String area){
		this.area = area;
	}

	public String getArea(){
		return area;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setLocality(String locality){
		this.locality = locality;
	}

	public String getLocality(){
		return locality;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getRegion(){
		return region;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	public String getLocationType(){
		return locationType;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"area = '" + area + '\'' + 
			",country = '" + country + '\'' + 
			",address = '" + address + '\'' + 
			",street = '" + street + '\'' + 
			",locality = '" + locality + '\'' + 
			",location = '" + location + '\'' + 
			",region = '" + region + '\'' + 
			",type = '" + type + '\'' + 
			",location_type = '" + locationType + '\'' + 
			"}";
		}
}