package model;

import dao.TrainingMemoDAO;

public class PostTrainingMemoLogic {

	public void execute(TrainingMemo trainingMemo) {
		TrainingMemoDAO dao = new TrainingMemoDAO();
		dao.create(trainingMemo);
	}

	public void deleteExecution(int id) {
		TrainingMemoDAO dao = new TrainingMemoDAO();
		dao.deleteExecution(id);
	}

	public void editExecution(TrainingMemo trainingMemo) {
		TrainingMemoDAO dao = new TrainingMemoDAO();
		dao.editExecution(trainingMemo);
	}

}
