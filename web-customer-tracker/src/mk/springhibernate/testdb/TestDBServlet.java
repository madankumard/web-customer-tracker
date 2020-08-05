package mk.springhibernate.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// seup connection variables

		String user = "springstudent";
		String password = "springstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";

		// get connection to db
		try {

			PrintWriter out = resp.getWriter();

			out.print("Connecting to database: " + jdbcUrl);
			out.println("<br/>");

			Class.forName(driver);

			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

			out.println("SUCCESS!!");

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
