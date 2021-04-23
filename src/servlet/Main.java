package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetTrainingMemoLogic;
import model.PostTrainingMemoLogic;
import model.TrainingMemo;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		List<TrainingMemo> trainingMemoList = getTrainingMemoLogic.execute();

		request.setAttribute("trainingMemoList", trainingMemoList);


		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/trainingMemo.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String param = request.getParameter("state");
		String[] state = param.split(",");

		switch (state[0]) {
		case "newConfirm":
			newConfirm(request, response);
			break;
		case "deletConfirmation":
			deleteConfirmation(request, response, state[1]);
			break;
		case "deleteExecution":
			deleteExecution(request, response, state[1]);
			break;
		}
	}

	private void newConfirm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bench = request.getParameter("bench");
		String deadlift = request.getParameter("deadlift");
		String squat = request.getParameter("squat");
		String day = request.getParameter("day");


		TrainingMemo trainingMemo = new TrainingMemo(bench, deadlift, squat, day);

		PostTrainingMemoLogic postTrainingMemoLogic = new PostTrainingMemoLogic();

		postTrainingMemoLogic.execute(trainingMemo);

		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		List<TrainingMemo> trainingMemoList = getTrainingMemoLogic.execute();
		request.setAttribute("trainingMemoList", trainingMemoList);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/trainingMemo.jsp");
		dispatcher.forward(request, response);
	}

//	削除確認の処理
	private void deleteConfirmation(HttpServletRequest request,
			HttpServletResponse response, String id) throws ServletException, IOException {

		int intId = Integer.parseInt(id);

		TrainingMemo trainingMemo = new TrainingMemo();
		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		trainingMemo = getTrainingMemoLogic.delete_confirmation(intId);

		request.setAttribute("trainingMemo", trainingMemo);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/deleteConfirmation.jsp");
		dispatcher.forward(request, response);
	}


//	削除実行処理
	private void deleteExecution(HttpServletRequest request,
			HttpServletResponse response, String id) throws ServletException, IOException {

		int intId = Integer.parseInt(id);

		PostTrainingMemoLogic postTrainingMemoLogic = new PostTrainingMemoLogic();
		postTrainingMemoLogic.delete_execution(intId);

		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		List<TrainingMemo> trainingMemoList = getTrainingMemoLogic.execute();
		request.setAttribute("trainingMemoList", trainingMemoList);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/deleteSuccess.jsp");
		dispatcher.forward(request, response);
	}

}
