package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Pagination;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String condition = request.getParameter("condition");//"writer"|"title"|"content"
		String keyword = request.getParameter("keyword");//"사용자가 입력한 키워드값"
		
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		BoardServiceImpl bService = new BoardServiceImpl();
		int searchCount = bService.selsctSearchCount(map);//현재 검색결과에 맞는 게시글 총 개수
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		PageInfo pi = Pagination.getPageInfo(searchCount,currentPage,10,5);
		
		System.out.println(pi);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
