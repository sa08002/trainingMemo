package model;

public class TrainingMemo {

	private String bench;
	private String deadlift;
	private String squat;
	private String day;

	public TrainingMemo(String bench, String deadlift, String squat, String day) {
		this.bench = bench;
		this.deadlift = deadlift;
		this.squat = squat;
		this.day = day;
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

	public String getDay() {
		return day;
	}

}
