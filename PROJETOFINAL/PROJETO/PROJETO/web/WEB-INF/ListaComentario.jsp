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
        <title>Antivirus Community </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <table class="table table-hover table-dark">    
            <thead>
        
                <tr >
                    <th colspan="1"> Bem vindo ${usuario.nome},lista de comentarios : ${virus.nome}</th>
                    <th> <a href="ListagemVirus" <button style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;"> Voltar</a></th>
                </tr>
                <form method="post" action="ListaComentario">
                <tr><th scope="col" >Usuario</th>
                <th scope="col" >Comentario</th>
                </tr>
            <c:forEach var="comentario" items="${comentario}">
                <tr>
                    <td>${comentario.usuario.nome}</td>
                    <td>${comentario.comentario}</td>                          
                </tr>   
               
            </c:forEach>
                
                <c:if test="${usuario.id != 0}">
                    <input type="hidden" name="idusuario" value="${usuario.id}" />
                </c:if>
                    
                     <c:if test="${virus.id != 0}">
                    <input type="hidden" name="idvirus" value="${virus.id}" />
                </c:if>
                    
                <td>Comentar:<input type="textarea" name="escrita" ></td>
                <td><input type="submit" value="Enviar" <button style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;"/></button></td>
                
        </form>
        </table>
        <br>

    </body>
</html>