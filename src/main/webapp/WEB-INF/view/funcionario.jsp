<%@ page language = "java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Visualizar Funcionário</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="bodyView">

	<header>
		<div class="headerContainer">

			<div class="headerRight">
				<img class="logoLivro" src="image/LogoLivro.png" alt="" /> <input
					placeholder="Não busque, não funcionará..." class="fakeSearch"
					type="text" />
			</div>

		</div>
	</header>
	<div class="cardsContainerView">
		<a href="./funcionarios_home"><strong class="blackFont backView">&lt
				Voltar</strong></a>
		<div class="card-content-view">
			<div class="viewCardImg">
				<img class="imgLivroView blackFont" src="image/conta.png"
					alt="Livro" />
			</div>
			<div class="viewCardTexts">
				<h2 class="headerLivroView blackFont">${funcionario.nome }</h2>
				<h3 class="authorLivroView blackFont">${funcionario.cargo }</h3>
				<p class="paginasLivroView blackFont">${funcionario.idade}
					anos</p>
				<div class="btnAdd">
					<a href="funcionarios_form?idFuncionario=${funcionario.id }">
						<button>Editar funcionario</button>
					</a> <a href="deletarFuncionario?idFuncionario=${funcionario.id }">
						<button type="button">Deletar funcionário</button>
					</a>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<p>Todos os direitos reservados. Hebert</p>
	</footer>
</body>
</html>