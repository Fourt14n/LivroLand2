
# LivroLand2

Um sistema web simples onde é possível cadastrar livros e funcionários, desenvolvido como atividade acadêmica visando aprender sobre desenvolvimento java web com o modelo MVC.



## Instalação

Para fazer a instalação do projeto e testá-lo, é preciso:

- Instalar o [Tomcat 9.0](https://tomcat.apache.org/download-90.cgi)
- Instalar dentro do eclipse marketplace o [Web Developer Tools](https://marketplace.eclipse.org/content/eclipse-enterprise-java-and-web-developer-tools)
- Adicionar dentro da view de server no eclipse o servidor Apache tomcat 9.0
- Rodar a seguinte query dentro do MySql Workbench:
    
```sql
CREATE DATABASE livraria;
USE livraria;
CREATE TABLE livros(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    preco DOUBLE,
    descricao VARCHAR(240),
    autor VARCHAR(100),
    qntdPaginas INT
    
);
CREATE TABLE funcionarios(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    cargo VARCHAR(100),
    idade INT
);

```
- Clonar o repositório com o seguinte comando no terminal:
```
git clone https://github.com/Fourt14n/LivroLand2.git
```
- E então rodar o arquivo como um servidor, clicando com o botão direito no arquivo -> Run as -> Run on server

## Aprendizados

Aprendi sobre o modelo MVC:
- Como é estruturado
- Sobre como acontece a comunicação interna da aplicação
- Importância de um modelo de separação e organização em projetos maiores

Aprendi também sobre variáveis específicas de um ambiente, precisei clonar o repositório em um notebook diferente e acabei sem querer esbarrando com diferentes versões do Tomcat.

Também aprendi sobre a importância dos logs de erros em um servidor, repetidamente eu precisei ler e entender erros no log para conseguir resolver meus bugs e dos colegas que eu ajudei na resolução de erros.

Tive uma pequena demonstração do funcionamento do protocolo HTTP e com as portas específicas para diferentes aplicações que se comunicam entre si, como a conexão com a porta 3306 usando JDBC para se conectar ao banco de dados.




