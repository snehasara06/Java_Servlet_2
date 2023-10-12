import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
    urlPatterns = "/servlet1",
    initParams = {
        @WebInitParam(name="initparam1",value = "Vikram Lander")
    }
)
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        System.out.println("***SERVLET-1***");
        ServletContext context1 = req.getServletContext();
        String name = context1.getInitParameter("name");
        System.out.println("CONTEXT: " + name);

        ServletConfig config1 = getServletConfig();
        String initparam1 = config1.getInitParameter("initparam1");
        System.out.println("CONFIG: " + initparam1);


        PrintWriter out=resp.getWriter();
        out.println("<h3>SERVLET-1</h3>");
        out.println("<b> CONTEXT: </b>"+name);
        out.println("<br><b> CONFIG: </b>"+initparam1);
    }
}
