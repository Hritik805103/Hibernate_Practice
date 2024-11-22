package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the current session without creating a new one
        HttpSession session = req.getSession(false);

        if (session != null) {
            // Remove the user attribute and invalidate the session
            session.removeAttribute("loginUser");
            session.invalidate();
        }

        // Set a logout message (if needed) and redirect to login page
        req.setAttribute("msg", "Logout Successfully");
        resp.sendRedirect("login.jsp");
    }
}
