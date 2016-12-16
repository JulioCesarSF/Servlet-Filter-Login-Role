<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>
<%@ include file="includesHead.jsp"%>
</head>
<body>

	<div class="container">

		<%@include file="../menu.jsp"%>

		<div class="row">
			<div class="col-md-12 col-sm-12">
				<div class="page-header">
					<h3>Cadastro de Usuário</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-sm-3"></div>
			<div class="col-md-6 col-sm-6">
				<form action="Usuario" method="post">
					<input type="hidden" name="acao" value="cadastrar">
					<div class="panel panel-primary">
						<div class="panel-heading">Cadastrar Usuário</div>
						<div class="panel-body">

							<div class="form-group">
								<label for="nomeTipo">Nome</label> <input type="text"
									id="nomeTipo" name="NM_USUARIO"
									placeholder="Digite o nome do usuário" class="form-control">
							</div>

							<div class="form-group">
								<label for="email">Email</label> <input type="text" id="email"
									name="DS_EMAIL" placeholder="Digite o email do usuário"
									class="form-control">
							</div>

							<div class="form-group">
								<label for="senha">Senha</label> <input type="password"
									id="senha" name="DS_PASSWORD"
									placeholder="Digite a senha do usuário" class="form-control">
							</div>

							<div class="form-group">
								<label for="tipos">Tipo de Usuário</label> <select
									name="CD_TIPO_USUARIO" id="tipos" class="form-control">
									<c:forEach var="item" items="${tipos }">
										<option value="${item.id }">${item.nome }</option>
									</c:forEach>
								</select>
							</div>

						</div>
						<div class="panel-footer">
							<div class="form-group">
								<div class="text-right">
									<input type="submit" value="Salvar" class="btn btn-success">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-3 col-sm-3">
				<div class="${tipoMensagem }">
					<c:if test="${not empty tipoMensagem }"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></c:if>
					<p>${mensagem }</p>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 col-sm-12">
				<div class="page-header">
					<h4>Lista de Usuário</h4>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 col-sm-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>CD_USUARIO</th>
							<th>NM_NOME</th>
							<th>DS_EMAIL</th>
							<th>DS_PASSWORD</th>
							<th>CD_TIPO_USUARIO</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${lista }">
							<tr>
								<td>${item.id }</td>
								<td>${item.nome }</td>
								<td>${item.email }</td>
								<td>${item.senha }</td>
								<td>${item.tipo }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%@include file="/Paginas/includesHead.jsp" %>
</body>
</html>