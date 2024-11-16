<%@ page language = "java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
      <link rel="stylesheet" href="./css/style.css" />
 
  </head>
  <body>
    <!-- Card -->

    <header>
      <div class="headerContainer">
        
        <div class="headerRight">
          <a href="./home">
          	<img class="logoLivro" src="image/LogoLivro.png" alt="" />
          </a>
          <input
            placeholder="Não busque, não funcionará..."
            class="fakeSearch"
            type="text"
          />
        </div>
        
        <div class="funcionariosContainer">
        	<a href="./funcionarios_home">
        		<button type="button">Funcionários</button>
        	</a>
        </div>

      </div>
    </header>

    <main>

      <div class="presentationContainer">
        <div class="presentation">
          <div class="presentationImg">
            <img
              class="presentationImg"
              src="image/presentationImg.png"
              alt=""
            />
          </div>

          <div class="presentationText">
            <h1>Os melhores livros</h1>
            <p>Explore histórias e descubra novos mundos.</p>
          </div>
        </div>
      </div>

      
      <div class="btnAdd">
        <a href="./form">
          <button>Adicionar livro</button>
        </a>
      </div>

      <div class="cardsContainer">
      <!--  For  -->
      <!--  vai ser equivalente a um arraylist de livros que vem pro front
      ArrayList(Livro) livros
       -->
       
            <c:forEach items="${livros}" var="livro">
        <a class="card-livro" href="livro?idLivro=${livro.id}">
          <div class="card-content">
            <img class="imgLivro" src="image/oNomeVento.jpg" alt="Livro" />
            <h2 class="headerLivro">${livro.nome}</h2> <!--  Livro.getNome() -->
            <h3 class="authorLivro">${livro.autor}</h3>
            <p class="paginasLivro">${livro.qntdPaginas} páginas</p>
            <p class="descLivro">
              ${livro.descricao}
            </p>
            <h1 class="precoLivro">R$ ${livro.preco}</h1>
          </div>
        </a>
        </c:forEach>
	
<!-- Final do for  -->
    
      </div>
    </main>

    <footer>
      <p>Todos os direitos reservados. Hebert</p>
    </footer>
  </body>
</html>
