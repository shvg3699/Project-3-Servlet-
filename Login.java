import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class Login extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 

    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String e=request.getParameter("userEmail"); 
    String p=request.getParameter("userPass");  
 
        // TODO code application logic here
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/employee1","root","");
            
            if(con!=null)
            {
            System.out.println("Connected");
                PreparedStatement ps=con.prepareStatement("select * from reg1 where email=? & password=?");
                ps.setString(1,e);
                ps.setString(2,p);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    System.out.println("Id      :   "+rs.getString(1));
                    System.out.println("Name    :   "+rs.getString(2));
                    System.out.println("Design  :   "+rs.getString(3));
                    System.out.println("Salary  :   "+rs.getString(4));
                }
                
            }
            else
                System.out.println("Not Connected");
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
    }

}