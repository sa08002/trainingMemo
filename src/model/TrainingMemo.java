package model;

public class TrainingMemo {

	private double bench;
	private double deadlift;
	private double squat;

	public TrainingMemo(double bench, double deadlift, double squat) {
		this.bench = bench;
		this.deadlift = deadlift;
		this.squat = squat;
	}

	public double getBench() {
		return bench;
	}

	public double getDeadlift() {
		return deadlift;
	}

	public double getSquat() {
		return squat;
	}



}
