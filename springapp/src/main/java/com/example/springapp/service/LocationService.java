package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Location;

public interface LocationService {

	public List<Location> getLocation();

	public void setLocation(Location l);

	public void editLocation(Location l);

	public void deleteLocation(int id);
}
