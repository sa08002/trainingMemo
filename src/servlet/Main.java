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

//		ServletContext application = this.getServletContext();
//
//
//		List<TrainingMemo> trainingMemoList =
//				(List<TrainingMemo>) application.getAttribute("trainingMemoList");
//
//		if(trainingMemoList ==null) {
//			trainingMemoList = new ArrayList<>();
//			application.setAttribute("trainingMemoList", trainingMemoList);
//		}

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

		String bench = request.getParameter("bench");
		String deadlift = request.getParameter("deadlift");
		String squat = request.getParameter("squat");

//		ServletContext application = this.getServletContext();
//
//		List<TrainingMemo> trainingMemoList =
//				(List<TrainingMemo>) application.getAttribute("trainingMemoList");


		TrainingMemo trainingMemo = new TrainingMemo(bench, deadlift, squat);

		PostTrainingMemoLogic postTrainingMemoLogic = new PostTrainingMemoLogic();

		postTrainingMemoLogic.execute(trainingMemo);
//
//		application.setAttribute("trainingMemoList", trainingMemoList);

		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		List<TrainingMemo> trainingMemoList = getTrainingMemoLogic.execute();
		request.setAttribute("trainingMemoList", trainingMemoList);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/trainingMemo.jsp");
		dispatcher.forward(request, response);


	}

}
