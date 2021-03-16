package model;

public class TrainingMemo {

	private String bench;
	private String deadlift;
	private String squat;

	public TrainingMemo(String bench, String deadlift, String squat) {
		this.bench = bench;
		this.deadlift = deadlift;
		this.squat = squat;
	}

	public String getBench() {
		return bench;
	}

	public String getDeadlift() {
		return deadlift;
	}

	public String getSquat() {
		return squat;
	}

}
