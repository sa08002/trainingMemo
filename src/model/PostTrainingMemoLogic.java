package model;

import dao.TrainingMemoDAO;

public class PostTrainingMemoLogic {

	public void execute(TrainingMemo trainingMemo) {

		TrainingMemoDAO dao = new TrainingMemoDAO();
		dao.create(trainingMemo);
	}

	public void deleteId(int id) {

		TrainingMemoDAO dao = new TrainingMemoDAO();
		dao.delete(id);
	}

}
