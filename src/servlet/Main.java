package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();

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
		case "details":
			details(request, response, state[1]);
			break;
		case "edit":
			edit(request, response, state[1]);
			break;
		case "editConfirmation":
			editConfirmation(request, response, state[1]);
			break;
		case "editExecution":
			editExecution(request, response, session);
			break;
		}
	}


//	投稿処理
	private void newConfirm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bench = request.getParameter("bench");
		String deadlift = request.getParameter("deadlift");
		String squat = request.getParameter("squat");
		String day = request.getParameter("day");
		String text = request.getParameter("text");


		TrainingMemo trainingMemo = new TrainingMemo(bench, deadlift, squat, day, text);

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
		postTrainingMemoLogic.deleteExecution(intId);

		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		List<TrainingMemo> trainingMemoList = getTrainingMemoLogic.execute();
		request.setAttribute("trainingMemoList", trainingMemoList);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/deleteSuccess.jsp");
		dispatcher.forward(request, response);
	}


//	詳細確認
	private void details(HttpServletRequest request,
			HttpServletResponse response, String id) throws ServletException, IOException {

		int intId = Integer.parseInt(id);

		TrainingMemo trainingMemo = new TrainingMemo();
		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		trainingMemo = getTrainingMemoLogic.details(intId);

		request.setAttribute("trainingMemo", trainingMemo);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/details.jsp");
		dispatcher.forward(request, response);
	}


//	編集処理
	private void edit(HttpServletRequest request,
			HttpServletResponse response, String id) throws ServletException, IOException {

		int intId = Integer.parseInt(id);

		TrainingMemo trainingMemo = new TrainingMemo();
		GetTrainingMemoLogic getTrainingMemoLogic = new GetTrainingMemoLogic();
		trainingMemo = getTrainingMemoLogic.details(intId);

		request.setAttribute("trainingMemo", trainingMemo);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/edit.jsp");
		dispatcher.forward(request, response);
	}

//	編集確認
	private void editConfirmation(HttpServletRequest request,
			HttpServletResponse response, String id) throws ServletException, IOException {

		int intId = Integer.parseInt(id);

		String bench = request.getParameter("bench");
		String deadlift = request.getParameter("deadlift");
		String squat = request.getParameter("squat");
		String day = request.getParameter("day");
		String text = request.getParameter("text");

		TrainingMemo trainingMemo = new TrainingMemo(intId, bench, deadlift, squat, day, text);

		HttpSession session = request.getSession();
		session.setAttribute("trainingMemo", trainingMemo);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/editConfirmation.jsp");
		dispatcher.forward(request, response);
	}

//	編集実行処理
	private void editExecution(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		TrainingMemo trainingMemo = (TrainingMemo) session.getAttribute("trainingMemo");

		PostTrainingMemoLogic postTrainingMemoLogic = new PostTrainingMemoLogic();
		postTrainingMemoLogic.editExecution(trainingMemo);

		session.removeAttribute("trainingMemo");

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/editSuccess.jsp");
		dispatcher.forward(request, response);
	}

}
