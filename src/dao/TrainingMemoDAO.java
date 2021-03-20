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

	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/trainingMemo";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<TrainingMemo> findAll() {
		List<TrainingMemo> empTrainingMemo = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT BENCH, DEADLIFT, SQUAT FROM TRAININGMEMO ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String bench = rs.getString("BENCH");
				String deadlift = rs.getString("DEADLIFT");
				String squat = rs.getString("SQUAT");

				TrainingMemo triningMemo = new TrainingMemo(bench, deadlift,squat);
				empTrainingMemo.add(triningMemo);

			}
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
		}
		return empTrainingMemo;
	}

	public boolean create(TrainingMemo trainingMemo) {

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO TRAININGMEMO(BENCH, DEADLIFT, SQUAT) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, trainingMemo.getBench());
			pStmt.setString(2, trainingMemo.getDeadlift());
			pStmt.setString(3, trainingMemo.getSquat());

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
