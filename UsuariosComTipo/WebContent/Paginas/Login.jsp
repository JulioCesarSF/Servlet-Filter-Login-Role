<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@ include file="includesHead.jsp"%>
</head>
<body>

	<div class="container">

		<%@include file="../menu.jsp"%>

		<div class="row">
			<div class="col-md-12 col-sm-12">
				<div class="page-header">
					<h3>Login</h3>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3 col-sm-3"></div>
			<div class="col-md-6 col-sm-6">
				<form action="Login" method="post">
					<input type="hidden" name="acao" value="entrar">
					<div class="panel panel-primary">
						<div class="panel-heading">Login</div>
						<div class="panel-body">

							<div class="form-group">
								<label for="emailUsuario">Email</label> <input
									type="text" id="emailUsuario" name="DS_EMAIL"
									placeholder="Digite o email do usu�rio"
									class="form-control">
							</div>
							
							<div class="form-group">
								<label for="senhaUsuario">Senha</label> <input
									type="password" id="senhaUsuario" name="DS_PASSWORD"
									placeholder="Digite a senha do usu�rio"
									class="form-control">
							</div>

						</div>
						<div class="panel-footer">
							<div class="form-group">
								<div class="text-right">
									<input type="submit" value="Entrar" class="btn btn-success">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-3 col-sm-3">
				<div class="${tipoMensagem }">
					<c:if test="${not empty tipoMensagem }">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					</c:if>
					<p>${mensagem }</p>
				</div>
			</div>
		</div>


	</div>

	<%@include file="/Paginas/includesHead.jsp"%>
</body>
</html>