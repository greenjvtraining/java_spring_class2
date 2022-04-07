package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj00.dao.BoardDAO;
import prj00.vo.BoardVO;

@WebServlet("/list")
public class GetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardDAO dao = new BoardDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getList Controller..............ing...");
		List<BoardVO> list = new ArrayList<>();
		
		try {
			list = dao.getList();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("board/list.jsp").forward(request, response);
	}


}
