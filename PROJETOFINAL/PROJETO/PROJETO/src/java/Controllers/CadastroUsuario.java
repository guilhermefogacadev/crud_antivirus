/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Usuario;
import Models.UsuarioModel;
import Models.VirusModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
@WebServlet(name = "CadastroUsuario", urlPatterns = {"/CadastroUsuario"})
public class CadastroUsuario extends HttpServlet {

    
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("WEB-INF/CadastroUsuario.jsp").forward(request, response);
        
        //No get retorna a página, no post faz o cadastro. Agora sim
        
      
 }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nome= request.getParameter("nome");
            String senha= request.getParameter("senha");
            String csenha= request.getParameter("csenha");
            
           //Para criar um usuario pra eu passar na model para fazer a comparação se ja existe ou nao , preciso de um id pq e um dos atributos
           //de onde tiro esse id para colocar ali ? invento um aleatorio?
            
            Usuario usu = new Usuario(nome, senha, csenha);
            
            UsuarioModel model= new UsuarioModel();
            if(model.verificaCadastra(usu)==true){
                request.getRequestDispatcher("WEB-INF/TelaSucessoCadastro.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/TelaErro.jsp").forward(request, response);
            }
          ;
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
