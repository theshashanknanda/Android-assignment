package com.project.androidassignment.jsonParcing.advanced;

import androidx.annotation.NonNull;

public class Station{
	private String stationCode;
	private String stationName;

	public String getStationCode(){
		return stationCode;
	}

	public String getStationName(){
		return stationName;
	}

	@Override
	public String toString() {
		return "Station{" +
				"stationCode='" + stationCode + '\'' +
				", stationName='" + stationName + '\'' +
				'}';
	}
}
