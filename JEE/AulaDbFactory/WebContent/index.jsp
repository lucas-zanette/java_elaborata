<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="aula.BdFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Teste</h1>
	<%
	
		Connection con = BdFactory.getInstance().getConnection();
	    		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into pessoa (nome, endereco, email) values (?, ?, ?)");
			ps.setString(1, "Ademundo");
			ps.setString(2, "Rua do Ade");
			ps.setString(3, "ade@alslsls.com arg1");
			
			ps.execute();
			
			ps.close();
			con.close();		
		} catch  (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	%>
</body>
</html>