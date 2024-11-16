<%@ page language = "java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form - Funcionário</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="formBody">
<!-- Form
    

-->

<div class="bodyContainer">
    <header>
        <div class="headerContainer">
          
          <div class="headerRight">
            <img class="logoLivro" src="image/LogoLivro.png" alt="" />
            <input
              placeholder="Não busque, não funcionará..."
              class="fakeSearch"
              type="text"
            />
          </div>
    
        </div>
      </header>
      
      
      <form method="POST" action="${funcionario.id != null ? 'atualizarFuncionario' : 'adicionarFuncionario' }?idFuncionario=${funcionario.id}">
        
       <div class="backButtonContainer">
        <a href="./funcionarios_home">
            <img class="backButton"  src="image/backImg.png" alt="">
        </a>
       </div>

       <div class="textContainer">
        <h2 class="blackFont">${funcionario.id != null ? "Atualizar" : "Cadastrar" }</h2>
       </div>

       <div class="formContainer">
    
        <div class="inputsContainer">
        
            <div class="nameContainer">
                <label class="name blackFont"> Nome do funcionário: </label>
                <input value="${funcionario.nome}" name="nome" class="inputs blackFont" type="text">
            </div>
        
            <div class="authorContainer">
                <label class="author blackFont"> Cargo do funcionário: </label>
                <input value="${funcionario.cargo}" name="cargo" class="inputs blackFont" type="text" name="" id="">
            </div>
        
            <div class="pagesContainer">
                <label class="pages blackFont"> Idade: </label>
                <input value="${funcionario.idade}" name="idade" class="inputs blackFont" type="number" name="" id="">
            </div>
        
            <button class="sendBtn blackFont" type="submit"> ${funcionario.id != null ? "Atualizar" : "Enviar" } </button>
        </div>
       </div>
    </form>
    
    
    <footer>
        <p>Todos os direitos reservados. Hebert</p>
      </footer>
</div>
</body>
</html>