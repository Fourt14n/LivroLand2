<%@ page language = "java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Visualizar Livro</title>
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
		<a href="./home.html"><strong class="blackFont backView">&lt
				Voltar</strong></a>
		<div class="card-content-view">
			<div class="viewCardImg">
				<img class="imgLivroView blackFont" src="image/oNomeVento.jpg"
					alt="Livro" />
			</div>
			<div class="viewCardTexts">
				<h2 class="headerLivroView blackFont">${livro.nome }</h2>
				<h3 class="authorLivroView blackFont">${livro.autor }</h3>
				<p class="paginasLivroView blackFont">${livro.qntdPaginas}
					páginas</p>
				<p class="descLivroView blackFont">${livro.descricao }</p>
				<h1 class="precoLivroView blackFont">${livro.preco }</h1>
				<div class="btnAdd">
					<a href="form?idLivro=${livro.id }">
						<button>Editar livro</button>
					</a> <a href="deletarLivro?idLivro=${livro.id }">
						<button type="button">Deletar livro</button>
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