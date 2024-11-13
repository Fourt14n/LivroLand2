<%@ page language = "java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form - Livro</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="formBody">
<!-- Form
    

-->

<div class="bodyContainer">
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
    
        </div>
      </header>
      
      
      <form method="POST" action="${livro.id != null ? 'atualizarLivro' : 'adicionarLivro' }?idLivro=${livro.id}">
        
       <div class="backButtonContainer">
        <a href="./home">
            <img class="backButton"  src="image/backImg.png" alt="">
        </a>
       </div>

       <div class="textContainer">
        <h2 class="blackFont">${livro.id != null ? "Atualizar" : "Cadastrar" }</h2>
       </div>

       <div class="formContainer">
    
        <div class="inputsContainer">
        
            <div class="nameContainer">
                <label class="name blackFont"> Nome do livro: </label>
                <input value="${livro.nome}" name="nome" class="inputs blackFont" type="text">
            </div>
        
            <div class="authorContainer">
                <label class="author blackFont"> Nome do autor: </label>
                <input value="${livro.autor}" name="autor" class="inputs blackFont" type="text" name="" id="">
            </div>
        
            <div class="pagesContainer">
                <label class="pages blackFont"> Quantidade de páginas: </label>
                <input value="${livro.qntdPaginas}" name="qntdPaginas" class="inputs blackFont" type="number" name="" id="">
            </div>
        
            <div class="priceContainer">
                <label class="price blackFont"> Preço: </label>
                <input value="${livro.preco}" name="preco" step="0.01" class="inputs blackFont" type="number" name="" id="">
            </div>
            <div class="imgContainer">
                <label class="image blackFont"> Foto do livro: </label>
                <input class="inputs blackFont" type="file">
            </div>
            <div class="descContainer">
                <label class="desc blackFont" for=""> Descrição do livro: </label>
                <textarea name="descricao" rows="7" maxlength="240" class="descTxtArea blackFont" placeholder="Uma breve descrição do livro" name="" id="">${livro.descricao}</textarea>
            </div>
        

        
            <button class="sendBtn blackFont" type="submit"> ${livro.id != null ? "Atualizar" : "Enviar" } </button>
        </div>
       </div>
    </form>
    
    
    <footer>
        <p>Todos os direitos reservados. Hebert</p>
      </footer>
</div>
</body>
</html>