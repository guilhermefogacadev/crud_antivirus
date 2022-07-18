<%-- 
    Document   : DeletaVirus
    Created on : 08/12/2020, 22:39:37
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
        <title>Deleta AntiVirus</title>
    </head>
    <body>
        <table class="table table-hover table-dark">
            <thead>
                <tr >
                    <th colspan="4"> Deletar Antivirus</th>
                </tr>
                <tr>
                    <th  colspan="4"scope="col">Nome</th>
                </tr>
            </thead>
        <form method="post" action="DeletaVirus">
            <div>
                <tr>
                    <td> Deseja deletar : ${virus.nome}</td>
                    <td><input type="submit" value="Deletar" <button style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;"/></button></td>
                    <td><a href="ListagemVirusAdmin" <button style="background: gray; border-radius: 6px; padding: 11px; cursor: pointer; color: #fff; border: none; font-size: 12px;">Voltar </button></a></td>
                </tr>
            </div>
                <c:if test="${virus.id != 0}">
                    <input type="hidden" name="id" value="${virus.id}" />
                </c:if>
    </body>
        </table>
</html>
