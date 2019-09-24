<%@ page language="java" contentType="text/html;
charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<%@ page import="java.util.*,mvc.model.*"%>

<form action='/whisper/addWhisper' method='post'>
	<table border='1'>
		<tr>
			<td>Author</td>
			<td>Content</td>
			<td>Tag</td>
			<td>Add</td>
		</tr>
		<tr>
			<td><input type='text' name='author' /></td>
			<td><input type='text' name='content' /></td>
			<td><input type='text' name='tag' /></td>
			<td><input type='submit' value='Add'></td>
		</tr>
	</table>
</form>
<br />

<table border='1'>
	<tr>
		<td>ID</td>
		<td>Author</td>
		<td>Date</td>
		<td>Content</td>
		<td>Tag</td>
		<td>Edit</td>
		<td>Delete</td>
	</tr>
	<%
		WhispersDAO dao = new WhispersDAO();
		List<Whisper> whispers = dao.getWhispers("id");
		for (Whisper whisper : whispers) {
	%>
	<tr>
		<td><%=whisper.getId()%></td>
		<td><%=whisper.getAuthor()%></td>
		<td><%=whisper.getDate().getTime()%></td>
		<td><%=whisper.getContent()%></td>
		<td><%=whisper.getTag()%></td>
		<td><a
			href=<%="/whisper/updateForm?id=" + whisper.getId() + "&author=" + whisper.getAuthor() + "&content="
						+ whisper.getContent() + "&tag=" + whisper.getTag()%>>Edit</a></td>

		<td><br />
			<form action='/whisper/deleteWhisper' method='post'>
				<input type='hidden' name='id' value='<%=whisper.getId()%>' /><input
					type='submit' value='Delete' />
			</form></td>
	</tr>
	<%
		}
	%>
</table>
</html>