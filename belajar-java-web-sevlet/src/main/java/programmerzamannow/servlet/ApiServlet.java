package programmerzamannow.servlet;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import programmerzamannow.servlet.model.SayHelloRequest;
import programmerzamannow.servlet.util.JsonUtil;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/api/say-hello")
public class ApiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SayHelloRequest sayHelloRequest = JsonUtil.getObjectMapper().readValue(req.getReader(), SayHelloRequest.class);

            String sayHello = "Hello " + sayHelloRequest.getFirstName() + " " + sayHelloRequest.getLastName();

            Map<String, String> response = Map.of(
                    "data", sayHello
            );
            String jsonResponse = JsonUtil.getObjectMapper().writeValueAsString(response);
            resp.setStatus(200);
            resp.setHeader("Content-Type", "application/json");
            resp.getWriter().println(jsonResponse);
        } catch (UnrecognizedPropertyException e) {
            Map<String, String> response = Map.of(
                    "status", "fail",
                    "message", "nama property tidak valid"
            );
            resp.setStatus(402);
            resp.setHeader("Content-Type", "application/json");
            resp.getWriter().println(JsonUtil.getObjectMapper().writeValueAsString(response))   ;
        }
    }
}
