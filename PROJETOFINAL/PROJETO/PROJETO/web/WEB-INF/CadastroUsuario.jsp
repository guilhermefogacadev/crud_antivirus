<%-- 
    Document   : CadastroUsuario
    Created on : 02/12/2020, 23:31:43
    Author     : guilh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuário</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    </head>
    <body>
        <br>
            <div class="row justify-content-md-center" style ="background-color: white">
                <div class="card" style="width: 25rem;">
                    <img src="user.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <form method="post" action="CadastroUsuario">
                            <h4>Para se cadastrar, preencha os seguintes campos.</h4>
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">User</label>
                                <input  type="text"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="nome" value-="${usuario.nome}">
                                
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" name="senha" value-="${usuario.senha}">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Password Again</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" name="csenha" value-="${usuario.csenha}">
                                <c:if test="${usuario.senha == usuario.csenha }"> 
                                </c:if>
                            </div>
                            
                            <button type="submit" class="btn btn-primary">Cadastrar</button>
                            <a href="index.html" <button type="submit" class="btn btn-primary"> Voltar</button></a>
                            
                        </form>
                    </div>
                    
                </div>
            </div>

        </div>
    </div>
        
        
   
       
</html>
