<%-- 
    Document   : ListagemVirus
    Created on : 02/12/2020, 23:34:26
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link type="text/css" rel="stylesheet" href="css.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
        
        
        <title>Vírus Cadastrados</title>
        
        
    </head>
    <body >
        
        <table class="table table-hover table-dark">
            <thead>
            
                <tr >
                    <th > Seja bem vindo admin ${usuario.nome}: </th>
                    <th colspan="2"><a href="CadastroVirus" <button type="submit" style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;"> Novo Antivirus</a></th>
                    <th colspan="2"><a href="Logout" <button type="submit" style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;"> Logout</a></th>
                </tr>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Gratuito</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Deletar</th>
              
                    
                </tr>
            </thead>
            <c:forEach var="virus" items="${virus}">
            <tbody>
                <tr>
                    <td>${virus.nome}</td>
                    <td><input type="checkbox"
                        <c:if test ="${virus.tipo}">
                            checked
                        </c:if>
                        /></td>
                       <td><a href="AlteraVirus?id=${virus.id}" <button style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;"> Editar Antivírus</button></a></td>
                       <td><a href="DeletaVirus?id=${virus.id}" <button style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;"> Deletar Vírus</button></a></td>
                    
                    
                </tr>
                <tr>

            </tbody>
            </c:forEach>
        </table>
                
    </body>
</html>
