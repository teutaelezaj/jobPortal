package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.dao.PostDAO;
import com.entity.Jobs;
import com.entity.Posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/add_post")
public class AddSocialMediaServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String name = req.getParameter("name");
			String postDesc = req.getParameter("postDesc");
			
			Posts u = new Posts();
			u.setName(name);
			u.setPostDesc(postDesc);
			
			HttpSession session = req.getSession();
			
			PostDAO dao = new PostDAO(DBConnect.getConn());
			boolean p=dao.addPosts(u);
			if(p) {
				session.setAttribute("succMsg", "Post created successfully!");
				resp.sendRedirect("add_post.jsp");
			} else {
				session.setAttribute("succMsg", "Something went wrong");
				resp.sendRedirect("add_post.jsp");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	

}
