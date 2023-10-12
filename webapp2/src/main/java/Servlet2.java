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
    urlPatterns = "/servlet2",
    initParams = {
        @WebInitParam(name="initparam2",value = "Chandrayaan - 3")
    }
)
public class Servlet2 extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        // System.out.println("***SERVLET-2***");
        ServletContext context2 = req.getServletContext();
        String name = context2.getInitParameter("name");
        System.out.println("CONTEXT: " + name);
        context2.setInitParameter("Age", "22");
        System.out.println(context2.getInitParameter("Age"));

        ServletConfig config2 = getServletConfig();
        String initparam2 = config2.getInitParameter("initparam2");
        System.out.println("CONFIG: " + initparam2);


        PrintWriter out=resp.getWriter();
        out.println("<h3>SERVLET-2</h3>");
        // out.println("<b>CONTEXT: </b>"+name);
        out.println("<br><b>CONFIG: </b>"+initparam2);
    }
}
