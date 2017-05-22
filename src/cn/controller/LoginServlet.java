package cn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
		
        user = userdao.searchUserByUsername(username);
        
        if( user!=null )
		{
			if (password.equals(user.getPassword())) 
			{
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				int a =userdao.searchUseridByUsername(username);
				int b = 0;
				System.out.print(a);
				session.setAttribute("userid", a);
				session.setAttribute("action", b);
				session.setAttribute("username",username);
				Limit c = limitdao.SearchRoleById(a);
				int d = c.getAction();
				session.setAttribute("action", d);
				request.getRequestDispatcher("jspp/loginin.jsp").forward(request, response);
				
			}
			else
			{
				System.out.println("用户密码错误");
				request.setAttribute("error", "fail");
			    request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
			}
		}
	
        else{
			System.out.println("用户不存在");
		    request.setAttribute("error", "fail");
		    request.getRequestDispatcher("jspp/login.jsp").forward(request, response);
		}   
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
