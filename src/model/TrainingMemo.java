package model;

public class TrainingMemo {

	private int id;
	private String bench;
	private String deadlift;
	private String squat;
	private String day;

	public TrainingMemo() {

	}

	public TrainingMemo(int id, String bench, String deadlift, String squat, String day) {
		this.id = id;
		this.bench = bench;
		this.deadlift = deadlift;
		this.squat = squat;
		this.day = day;
	}

	public TrainingMemo(String bench, String deadlift, String squat, String day) {
		this.bench = bench;
		this.deadlift = deadlift;
		this.squat = squat;
		this.day = day;
	}

	public TrainingMemo(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setBench(String bench) {
		this.bench = bench;
	}

	public void setDeadlift(String deadlift) {
		this.deadlift = deadlift;
	}

	public void setSquat(String squat) {
		this.squat = squat;
	}

	public void setDay(String day) {
		this.day = day;
	}



}
