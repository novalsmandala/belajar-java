package programmerzamannow.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/session/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        HttpSession session = req.getSession(true);
        session.setAttribute("username", username);

        if (username == null) {
            resp.getWriter().println("Login Failed");
        } else {
            resp.getWriter().println("Login success : " + username);
            resp.getWriter().println("Redirect in 5 seconds");
            try {
                Thread.sleep(5000L);
                resp.sendRedirect("/session/get");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
