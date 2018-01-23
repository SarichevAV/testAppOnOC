import com.sun.jmx.snmp.Enumerated;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class RequestExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String title = "HTTP Request Example";
        String contentType = "<!DOCTYPE html>\n";

        writer.println(contentType + "<html>\n" +
                "<head><title>" + title + "</title></head>" +
                "<body>" +
                "<h1> HTTP Servlet Request Example </h1>");
        Enumeration headers = req.getHeaderNames();

        while (headers.hasMoreElements()) {
            String paramentrName = (String) headers.nextElement();
            String value = req.getHeader(paramentrName);
            writer.println("<h3>" + paramentrName + ": " + value + "</h3>\n");
        }
        writer.println("</body>\n" + "</html>");
    }
}
