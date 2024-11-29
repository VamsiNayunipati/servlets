package innovator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@WebServlet("/Main")
public class Main extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head><title>Response</title></head>");
        out.println("<body style='font-family: Arial, sans-serif; text-align: center;'>");

        if ((firstName == null || firstName.isEmpty()) && (lastName == null || lastName.isEmpty()))
        {
            out.println("<h1>Error</h1>");
            out.println("<p style='color: red;'>First Name and Last Name are required! Please enter First and Last Name to proceed.</p>");
        }
        else if (firstName == null || firstName.isEmpty())
        {
            out.println("<h1>Error</h1>");
            out.println("<p style='color: red;'>First Name is required! Please enter First Name to proceed</p>");
        }
        else if (lastName == null || lastName.isEmpty())
        {
            out.println("<h1>Error</h1>");
            out.println("<p style='color: red;'>Last Name is required! Please enter Last Name to proceed.</p>");
        }
        else if (gender == null)
        {
            out.println("<h1>Error</h1>");
            out.println("<p style='color: red;'>Please select a gender!</p>");
        }
        else
        {
            String salutation = "Thank you ";
            if (gender.equals("Male"))
            {
                salutation += "Mr. ";
            }
            else if (gender.equals("Female"))
            {
                salutation += "Ms. ";
            }

            salutation += firstName + " " + lastName + ".";

            out.println("<h1>Welcome to my shop</h1>");
            out.println("<p>" + salutation + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
