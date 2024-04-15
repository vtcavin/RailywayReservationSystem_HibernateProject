package com.Railway.dao;

import java.util.List;

import com.Railway.entity.Train;
import com.Railway.entity.User;

public interface TrainDao {
	
	//Train
    Train createTrain(Train train);
    
    Train getTrainById(String trainId);
    void updateTrain(Train train);
    List<Train> getAllTrains();
    void deleteTrain(String trainId);


}
