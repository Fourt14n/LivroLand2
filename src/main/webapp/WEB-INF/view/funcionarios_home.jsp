<%@ page language = "java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Funcion�rios</title>
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
            placeholder="N�o busque, n�o funcionar�..."
            class="fakeSearch"
            type="text"
          />
        </div>

      </div>
    </header>

    <main>

      <div class="presentationContainer">
        <div class="presentation">
          <div class="presentationImg">
            <img
              class="presentationImg"
              src="image/logoLampda.png"
              alt=""
            />
          </div>

          <div class="presentationText">
            <h1>LivroLand 2</h1>
            <p>Gerencie de forma otimizada seus funcion�rios.</p>
          </div>
        </div>
      </div>

      
      <div class="btnAdd">
        <a href="./funcionario_form">
          <button>Adicionar funcion�rio</button>
        </a>
      </div>

      <div class="cardsContainer">
      <!--  For  -->
      <!--  vai ser equivalente a um arraylist de livros que vem pro front
      ArrayList(Livro) livros
       -->
       
            <c:forEach items="${funcionarios}" var="funcionario">
        <a class="card-livro" href="funcioniario?idFuncionario=${funcionario.id}">
          <div class="card-content">
            <img class="imgLivro" src="image/oNomeVento.jpg" alt="Livro" />
            <h2 class="headerLivro">${funcionario.nome}</h2> <!--  Livro.getNome() -->
            <h3 class="authorLivro">${funcionario.autor}</h3>
            <p class="paginasLivro">${funcionario.qntdPaginas}</p>
            <p class="descLivro">
              ${funcionario.descricao}
            </p>
            <h1 class="precoLivro">${funcionario.preco}</h1>
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
