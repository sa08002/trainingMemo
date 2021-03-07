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

			String sql = "SELECT BENCH, DEADLIFT, SQUAT FROM TRAININGMEMO";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Double bench = rs.getDouble("BENCH");
				Double deadlift = rs.getDouble("DEADLIFT");
				Double squat = rs.getDouble("SQUAT");

				TrainingMemo triningMemo = new TrainingMemo(bench, deadlift,squat);
				empTrainingMemo.add(triningMemo);

			}
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
		}
		return empTrainingMemo;
	}
}
