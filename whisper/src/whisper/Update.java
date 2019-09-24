package whisper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<form action='/whisper/update' method='post'>");
		out.println("<table border='1'><tr><td>Id</td><td>Author</td>" +
				 "<td>Content</td><td>Tag</td><td>Edit</td></tr>");
		out.println("<tr><td> <input type='number' name='id' value='" + request.getParameter("id")+"' readonly /> </td>");
		out.println("<td> <input type='text' name='author' value='"+ request.getParameter("author")+"' /> </td>");
		out.println("<td> <input type='text' name='content' value='"+ request.getParameter("content")+"' /> </td>");
		out.println("<td> <input type='text' name='tag' value='"+ request.getParameter("tag")+"' /> </td>");
		out.println("<td><input type='submit' value='Save'></td></tr>");
		out.println("</table></form><br/>");
		
		 // out.println("<html><body>");
		 // out.println("<h1>Edit Whisper:" + request.getParameter("id") + "</h1>");
		 // out.println("<form action='/whisper/update' method='post'>");
		 // out.println("Id: <input type='number' name='id'><br>");
		 // out.println("Author: <input type='text' name='author'><br>");
		 // out.println("Content: <input type='text' name='content'><br>");
		 // out.println("Tag: <input type='text' name='tag'><br>");
		 // out.println("<input type='submit' value='Save'>");
		 // out.println("</form>");
		 out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		Whisper whisper = new Whisper();
		whisper.setId(Integer.valueOf(request.getParameter("id")));
		whisper.setAuthor(request.getParameter("author"));
		whisper.setContent(request.getParameter("content"));
		whisper.setTag(request.getParameter("tag"));
		dao.updateWhisper(whisper);
		dao.close();
		response.sendRedirect("/whisper/read");
	}

}
