package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.ApplyDAO;
import com.entity.Apply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet("/apply_job")
public class ApplyJobServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			
			String name = req.getParameter("name");
			String school = req.getParameter("school");
			String experience = req.getParameter("experience");
			String reason = req.getParameter("reason");
			
			Apply a = new Apply();
			a.setName(name);
			a.setSchool(school);
			a.setExperience(experience);
			a.setReason(reason);
			
			HttpSession session = req.getSession();
			
			ApplyDAO dao = new ApplyDAO(DBConnect.getConn());
			boolean f=dao.applyUser(a);
			if(f) {
				session.setAttribute("succMsg", "Applied successfully! A recruiter will be in contact soon.");
				resp.sendRedirect("apply_job.jsp");
			} else {
				session.setAttribute("succMsg", "Something went wrong");
				resp.sendRedirect("apply_job.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}