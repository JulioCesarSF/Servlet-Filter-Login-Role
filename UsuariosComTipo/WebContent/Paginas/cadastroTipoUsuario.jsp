<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Tipo de Usuário</title>
<%@ include file="includesHead.jsp"%>
</head>
<body>

	<div class="container">

		<%@include file="../menu.jsp"%>

		<div class="row">
			<div class="col-md-12 col-sm-12">
				<div class="page-header">
					<h3>Cadastro de Tipo de Usuário</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-sm-3"></div>
			<div class="col-md-6 col-sm-6">
				<form action="TipoUsuario" method="post">
					<input type="hidden" name="acao" value="cadastrar">
					<div class="panel panel-primary">
						<div class="panel-heading">Cadastrar Tipo de Usuário</div>
						<div class="panel-body">

							<div class="form-group">
								<label for="nomeTipo">Nome do Tipo de Usuário</label> <input
									type="text" id="nomeTipo" name="NM_TIPO_USUARIO"
									placeholder="Digite o nome do tipo de usuário"
									class="form-control">
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
					<h4>Lista de Tipos de Usuário</h4>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 col-sm-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>CD_TIPO_USUARIO</th>
							<th>NM_TIPO</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${lista }">
							<tr>
								<td>${item.id }</td>
								<td>${item.nome }</td>
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