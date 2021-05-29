package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TrainingMemo;

public class TrainingMemoDAO {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/trainingMemo";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<TrainingMemo> findAll() {
		List<TrainingMemo> trainingMemoList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT ID, BENCH, DEADLIFT, SQUAT, DAY FROM TRAININGMEMO ORDER BY DAY DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				int intId = Integer.parseInt(id);
				String bench = rs.getString("BENCH");
				String deadlift = rs.getString("DEADLIFT");
				String squat = rs.getString("SQUAT");
				String day = rs.getString("DAY");

				TrainingMemo trainingMemo = new TrainingMemo(intId, bench, deadlift,squat, day);
				trainingMemoList.add(trainingMemo);

			}
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
		}
		return trainingMemoList;
	}

	public boolean create(TrainingMemo trainingMemo) {

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO TRAININGMEMO(BENCH, DEADLIFT, SQUAT, DAY, TEXT) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, trainingMemo.getBench());
			pStmt.setString(2, trainingMemo.getDeadlift());
			pStmt.setString(3, trainingMemo.getSquat());
			pStmt.setString(4, trainingMemo.getDay());
			pStmt.setString(5, trainingMemo.getText());

			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public TrainingMemo deleteConfirmation(int intId) {

		TrainingMemo trainingMemo = new TrainingMemo();

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT ID, BENCH, DEADLIFT, SQUAT, DAY FROM TRAININGMEMO WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, intId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				String bench = rs.getString("BENCH");
				String deadlift = rs.getString("DEADLIFT");
				String squat = rs.getString("SQUAT");
				String day = rs.getString("DAY");

				trainingMemo.setId(intId);
				trainingMemo.setBench(bench);
				trainingMemo.setDeadlift(deadlift);
				trainingMemo.setSquat(squat);
				trainingMemo.setDay(day);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return trainingMemo;

	}

	public boolean deleteExecution(int intId) {

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "DELETE FROM TRAININGMEMO WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, intId);

			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}


	public TrainingMemo details(int intId) {

		TrainingMemo trainingMemo = new TrainingMemo();

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT ID, BENCH, DEADLIFT, SQUAT, DAY, TEXT FROM TRAININGMEMO WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, intId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				String bench = rs.getString("BENCH");
				String deadlift = rs.getString("DEADLIFT");
				String squat = rs.getString("SQUAT");
				String day = rs.getString("DAY");
				String text = rs.getString("TEXT");

				trainingMemo.setId(intId);
				trainingMemo.setBench(bench);
				trainingMemo.setDeadlift(deadlift);
				trainingMemo.setSquat(squat);
				trainingMemo.setDay(day);
				trainingMemo.setText(text);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return trainingMemo;

	}

	public boolean editExecution(TrainingMemo trainingMemo) {

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "UPDATE TRAININGMEMO  SET BENCH=?, DEADLIFT=?, SQUAT=?, DAY=?, TEXT=? WHERE ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, trainingMemo.getBench());
			pStmt.setString(2, trainingMemo.getDeadlift());
			pStmt.setString(3, trainingMemo.getSquat());
			pStmt.setString(4, trainingMemo.getDay());
			pStmt.setString(5, trainingMemo.getText());
			pStmt.setInt(6, trainingMemo.getId());

			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
