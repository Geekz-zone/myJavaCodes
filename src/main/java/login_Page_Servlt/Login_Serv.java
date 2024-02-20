package login_Page_Servlt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/VerifyLogin")
public class Login_Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Login_Serv() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("mail");
		String pass = request.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login_Db","root","9691977312@Ka");
			Statement stmnt = con.createStatement();
			ResultSet result = stmnt.executeQuery("select * from Login where Email = '"+email+"' and Password = '"+pass+"' ");
			
			if(result.next()) {
				System.out.println("Welcome");
			}else {
				System.out.println("Invalid email/password");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}




}
