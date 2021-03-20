package model;

import java.util.List;

import dao.TrainingMemoDAO;

public class GetTrainingMemoLogic {

	public List<TrainingMemo> execute() {

		TrainingMemoDAO dao = new TrainingMemoDAO();
		List<TrainingMemo> trainingMemo = dao.findAll();
		return trainingMemo;

	}

}
