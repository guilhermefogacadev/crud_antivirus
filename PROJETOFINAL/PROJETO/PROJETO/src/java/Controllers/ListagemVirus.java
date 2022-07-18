/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Entidades.Usuario;
import Entidades.Virus;
import Models.VirusModel;
import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
@WebServlet(name = "ListagemVirus", urlPatterns = {"/ListagemVirus"})
public class ListagemVirus extends HttpServlet {

    
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession sessao=request.getSession(false);
       if(sessao==null || sessao.getAttribute("usuarioLogado")==null){
           
       }else{   
           Usuario logado = (Usuario)sessao.getAttribute("usuarioLogado");
           
           VirusModel model= new VirusModel();
           ArrayList<Virus> virus= model.listaVirus();

        
           request.setAttribute("virus", virus);
           request.setAttribute("usuario",logado);
           request.getRequestDispatcher("WEB-INF/ListagemVirus.jsp").forward(request, response);
        }
      
        
       
            
    }

   
}
