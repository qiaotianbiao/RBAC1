package cn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dao.RoleDao;
import cn.dao.RoleImpl;
import cn.dao.UserDao;
import cn.dao.UserImpl;
import cn.entity.Limit;
import cn.entity.User;
@WebServlet("/ClickServlet2")
public class ClickServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public ClickServlet2() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = null;
		UserDao userdao = new UserImpl();
		Limit limit = null;
		RoleDao limitdao = new RoleImpl();
		
		
		
		HttpSession session = request.getSession();
		int b =(Integer) session.getAttribute("userid");
		Limit c = limitdao.SearchRoleById(b);
		int d = c.getAction();
		session.setAttribute("action", d);
		
		
		//request.getRequestDispatcher("jspp/loginin.jsp").forward(request, response);
		if(d==1||d==3)
		request.getRequestDispatcher("jspp/has.jsp").forward(request, response);
		else
			request.getRequestDispatcher("jspp/hasnot.jsp").forward(request, response);
	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
 
}

