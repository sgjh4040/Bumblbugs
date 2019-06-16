package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;
import DAO.MemberDAO;



/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO memberDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    
    public void init() throws ServletException{
    	
    	memberDAO = new MemberDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action= "+action);
		
		if (action == null || action.equals("/listMembers.do")) {
			ArrayList<UserBean> membersList = memberDAO.listMember();
			request.setAttribute("membersList", membersList);
			nextPage = "../Admin/listMembers.jsp";
		}else if(action.equals("/addMember.do")) {
			
		}else if(action.equals("/modMemberForm.do")) {
			String u_idx = request.getParameter("u_idx");
			UserBean memInfo = memberDAO.getMember(u_idx);
			request.setAttribute("memInfo", memInfo);
			nextPage = "../Admin/modMemberForm.jsp";
		}else if(action.equals("/modMember.do")) {
			String u_nm = request.getParameter("u_nm");
			String u_email = request.getParameter("u_email");
			String u_pwd = request.getParameter("u_pwd");
			String u_loc = request.getParameter("u_loc");
			String u_intro = request.getParameter("u_intro");
			String u_idx = request.getParameter("u_idx");
			System.out.println(u_nm);
			System.out.println(u_email);
			System.out.println(u_pwd);
			
			UserBean userbean = new UserBean();
			userbean.setU_idx(Integer.parseInt(u_idx));
			userbean.setU_nm(u_nm);
			userbean.setU_email(u_email);
			userbean.setU_pwd(u_pwd);
			userbean.setU_loc(u_loc);
			userbean.setU_intro(u_intro);
			memberDAO.modMember(userbean);
			request.setAttribute("msg", "modified");
			nextPage="/member/listMembers.do";
		}else if(action.equals("/delMember.do")){
			String u_idx = request.getParameter("u_idx");
			memberDAO.delMember(u_idx);
			request.setAttribute("msg", "delted");
			nextPage = "/member/listMembers.do";
			
		}else {
			ArrayList<UserBean> membersList = memberDAO.listMember();
			request.setAttribute("membersList", membersList);
			nextPage = "../Admin/listMembers.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
		
	}

}
