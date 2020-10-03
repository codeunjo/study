package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServelt2
 */
@WebServlet("/input2")
public class InputServelt2 extends HttpServlet {

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServelt2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	request.setCharacterEncoding("utf-8");
	Enumeration en = request.getParameterNames();
	while (en.hasMoreElements()) {
		String name = (String)en.nextElement();
		String[] values = request.getParameterValues(name);
		for(String value : values) {
			System.out.println("name="+name + " , value="+value);
		}
		
		
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
