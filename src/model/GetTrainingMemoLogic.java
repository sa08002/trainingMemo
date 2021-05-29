package model;

import java.util.List;

import dao.TrainingMemoDAO;

public class GetTrainingMemoLogic {

	public List<TrainingMemo> execute() {

		TrainingMemoDAO dao = new TrainingMemoDAO();
		List<TrainingMemo> trainingMemoList = dao.findAll();
		return trainingMemoList;

	}

	public TrainingMemo delete_confirmation(int id) {

		TrainingMemoDAO dao = new TrainingMemoDAO();
		TrainingMemo trainingMemo = dao.deleteConfirmation(id);
		return trainingMemo;

	}

	public TrainingMemo details(int id) {

		TrainingMemoDAO dao = new TrainingMemoDAO();
		TrainingMemo trainingMemo = dao.details(id);
		return trainingMemo;

	}

}
