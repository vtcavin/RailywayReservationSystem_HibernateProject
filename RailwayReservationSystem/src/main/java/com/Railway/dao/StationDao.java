package com.Railway.dao;

import java.util.List;


import com.Railway.entity.Station;

public interface StationDao {
	
	
	
	//Station
	Station createStation(Station station);
	Station getStationById(String stationId);
    void updateStation(Station station);
    List<Station> getAllStations();
    void deleteStation(String stationId);





}
   

    
    

