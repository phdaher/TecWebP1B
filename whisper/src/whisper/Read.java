package whisper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Read
 */
@WebServlet("/read")
public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Read() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderby = request.getParameter("orderby");
		if (!"author".equals(orderby)) {
			orderby = "id";
		}
		DAO dao = new DAO();
		List<Whisper> whispers = dao.getWhispers(orderby);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form action='/whisper/create' method='post'>");
		out.println("<table border='1'><tr><td>Author</td>" +
				 "<td>Content</td><td>Tag</td><td>Add</td></tr>");
		out.println("<tr><td> <input type='text' name='author'/> </td>");
		out.println("<td> <input type='text' name='content'/> </td>");
		out.println("<td> <input type='text' name='tag'/> </td>");
		out.println("<td><input type='submit' value='Add'></td></tr>");
		out.println("</table></form><br/>");
		
		if (orderby == "id") {
			out.println("<a href='/whisper/read?orderby=author'>Order by Author</a>");
		} else {
			out.println("<a href='/whisper/read'>Order by Id</a>");
		}
		out.println("<br/><br/>");
		out.println("<table border='1'><tr><td>ID</td><td>Author</td>" +
		 "<td>Date</td><td>Content</td><td>Tag</td><td>Edit</td><td>Delete</td></tr>");
		for (Whisper whisper : whispers ) {
		 out.println("<tr><td>" + whisper.getId() + "</td>");
		 out.println("<td>" + whisper.getAuthor() + "</td>");
		 out.println("<td>" + whisper.getDate().getTime() + "</td>");
		 out.println("<td>" + whisper.getContent() + "</td>");
		 out.println("<td>" + whisper.getTag() + "</td>");
		 out.println("<td><a href='/whisper/update?id=" + whisper.getId() + "&author=" + whisper.getAuthor() + "&content=" + whisper.getContent() + "&tag=" + whisper.getTag() + "'>Edit</a></td>");
		 out.println("<td><br/><form action='/whisper/delete' method='post'><input type='hidden' name='id' value='" + whisper.getId() + "'/><input type='submit' value='Delete'/></form></td></tr>");
		}
		out.println("</table></body></html>");

		dao.close();
	}

}
