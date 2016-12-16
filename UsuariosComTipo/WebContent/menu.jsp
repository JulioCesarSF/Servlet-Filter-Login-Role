<%@ page session="false"%>

<div class="row">
	<ul class="nav nav-tabs">

		<%
			if (request.getSession().getAttribute("nome") == null) {
		%>

		<li role="presentation" class="pull-right"><a href="Login">Entrar</a></li>
		<%
			} else {
		%>
		<li role="presentation" class="pull-right"><a href="Logout">Log
				off</a></li>
		<li role="presentation" class="pull-right"><a href="#">Olá <%=request.getSession().getAttribute("nome")%></a></li>
		<%
			if (request.getSession().getAttribute("tipoUsuario").equals("Admin")) {
		%>

		<c:choose>
			<c:when test="${pagina.equals('usuario') }">
				<li role="presentation"><a href="index.jsp">Home</a></li>
				<li role="presentation" class="active"><a href="Usuario">Usuário</a></li>
				<li role="presentation"><a href="TipoUsuario">TipoUsuário</a></li>
			</c:when>
			<c:when test="${pagina.equals('tipoUsuario') }">
				<li role="presentation"><a href="index.jsp">Home</a></li>
				<li role="presentation"><a href="Usuario">Usuário</a></li>
				<li role="presentation" class="active"><a href="TipoUsuario">TipoUsuário</a></li>
			</c:when>
			<c:when test="${pagina == null }">
				<li role="presentation" class="active"><a href="index.jsp">Home</a></li>
				<li role="presentation"><a href="Usuario">Usuário</a></li>
				<li role="presentation"><a href="TipoUsuario">TipoUsuário</a></li>
			</c:when>
		</c:choose>

		<%
			} //primeiro if dentro do else
				else {
		%>
		<li role="presentation"><a href="index.jsp">Home</a></li>

		<%
			}
			}
		%>


	</ul>
</div>