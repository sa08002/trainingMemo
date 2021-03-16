package model;

import java.util.List;

public class PostTrainingMemoLogic {

	public void execute (TrainingMemo trainingMemo, List<TrainingMemo> trainingMemoList) {
		trainingMemoList.add(0, trainingMemo);
	}

}
