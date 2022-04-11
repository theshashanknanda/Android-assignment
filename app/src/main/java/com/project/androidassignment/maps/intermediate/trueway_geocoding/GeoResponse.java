package com.project.androidassignment.maps.intermediate.trueway_geocoding;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeoResponse{

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"GeoResponse{" + 
			"results = '" + results + '\'' + 
			"}";
		}
}