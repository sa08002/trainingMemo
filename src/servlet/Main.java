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
		case "new_confirm":
			new_confirm(request, response);
			break;
		case "delete_confirm":
			delete_confirm(request, response, state[1]);
			break;
		}
	}

	private void new_confirm(HttpServletRequest request,
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

	private void delete_confirm(HttpServletRequest request,
			HttpServletResponse response, String id) throws ServletException, IOException {

		int intId = Integer.parseInt(id);

		PostTrainingMemoLogic postTrainingMemoLogic = new PostTrainingMemoLogic();
		postTrainingMemoLogic.deleteId(intId);

		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		List<TrainingMemo> trainingMemoList = getTrainingMemoLogic.execute();
		request.setAttribute("trainingMemoList", trainingMemoList);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/trainingMemo.jsp");
		dispatcher.forward(request, response);
	}

}
