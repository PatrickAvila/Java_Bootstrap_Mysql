<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Questionário Covid-19</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/checkout/">

    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="https://ufop.br/sites/default/files/slide_-_1177x432_px_-_coronaaaaa_1.png" alt="" width="500" height="200">
    <p class="lead">Ajudaremos você a saber qual a probabilidade de ter Covid-19(CoronaVirus).</p>
  </div>
	
		<% 
		String nome = (String) request.getAttribute("nome"); 
		String end = (String) request.getAttribute("Endereco"); 
		String email = (String) request.getAttribute("Email"); 
		int resultado = (Integer) request.getAttribute("Resultado");
		%>
		
		<form class="needs-validation" novalidate >
			<h3 class="mb-3">Resultado da Pesquisa</h3>
			<hr class="mb-4">
          <div class=" mb-3">
            <label for="firstName">Nome: <%=nome %></label>
          </div>
          
         <div class="mb-3">
          <label for="address">Endereço: <%=end %></label>
        </div>

        <div class="mb-3">
          <label for="email">Email: <%=email %> </label>
        </div>
        
                <div class="mb-3">
          <label for="email">Resultado: <%=resultado %></label>
        </div>
			</form>
			<hr class="mb-4">
			<a href="index.html" style="text-decoration:none"><button class="btn btn-primary btn-lg btn-block" type="submit">Voltar</button></a>
  </div>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2020 Developed by Patrick Costa and Allan Fonseca</p>
  </footer>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
        <script src="form-validation.js"></script></body>

</html>