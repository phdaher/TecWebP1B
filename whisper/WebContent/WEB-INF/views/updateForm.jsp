<%@ page language="java" contentType="text/html;
charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<form action='/whisper/updateWhisper' method='post'>
		<table border='1'>
			<tr>
				<td>Id</td>
				<td>Author</td>
				<td>Content</td>
				<td>Tag</td>
				<td>Edit</td>
			</tr>
			<tr>
				<td><input type='number' name='id'
					value='<%=request.getParameter("id")%>' readonly /></td>
				<td><input type='text' name='author'
					value='<%=request.getParameter("author")%>' /></td>
				<td><input type='text' name='content'
					value='<%=request.getParameter("content")%>' /></td>
				<td><input type='text' name='tag'
					value='<%=request.getParameter("tag")%>' /></td>
				<td><input type='submit' value='Save'></td>
			</tr>
		</table>
	</form>
	<br />
</body>
</html>