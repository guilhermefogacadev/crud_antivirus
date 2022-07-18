<%-- 
    Document   : AlterarUsuario
    Created on : 08/12/2020, 23:02:34
    Author     : guilh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Antivirus Community </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
        <title>Alterar Antivirus</title>
    </head>
    <body>
       <table class="table table-hover table-dark">
            <thead>
                <tr >
                    <th colspan="3"> Você esta alterando ${virus.nome}:</th>
                    <th colspan="1"><a href="ListagemVirusAdmin" <button style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;">Voltar</button></a></th>
                    
                </tr>
                <form method="post" action="AlteraVirus">
                <div>
                    <td>
                    <label>Nome:</label>
                    <input type="text" name="nome" value="${virus.nome}"/>
                </div>
                </td>
                <div>
                    <td>
                    <label>O antivirus é gratuito?</label>
                    <input type="checkbox" name="tipo" value="Sim"
                           <c:if test ="${virus.tipo}">
                               checked
                           </c:if>
                           />               
                </div>
                </td>
                
                <div>
                    <td>
                    <label>Detalhes:</label>

                    <textarea  cols=100  rows="1" name="detalhes"  maxlength="500" wrap="hard" placeholder="Detalhe sobre o Antivirus" >${virus.detalhes}</textarea>

                </div>
                    <div>
                    <td>
                    <input type="submit" value="Alterar" <button style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;"/>
                </div>
                   </td>
                </td>
                 
                
                
                <c:if test="${virus.id != 0}">
                    <input type="hidden" name="id" value="${virus.id}" />
                </c:if>

                
                   
                   
        </form>
                <c:if test="${param.erro != null}">
                    <script type="text/javascript">
                        window.alert('${param.erro}');
                    </script>
                </c:if>
    </body>
</html>
