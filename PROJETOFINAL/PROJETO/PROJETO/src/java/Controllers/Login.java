/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Usuario;
import Models.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
    
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
        for (Cookie cookie :request.getCookies()) {
            if (cookie.getName().equals("usuarioLogado")) {
                int id= Integer.parseInt(cookie.getValue());
                UsuarioModel model =new UsuarioModel();
                Usuario usuario =model.verificaId(id);
                if(model.verficaAdmin(usuario)==true){
                    HttpSession sessao=request.getSession(true);
                    sessao.setAttribute("usuarioLogado", usuario);
                    response.sendRedirect("ListagemVirusAdmin");
                }else{
                    HttpSession sessao=request.getSession(true);
                    sessao.setAttribute("usuarioLogado", usuario);
                    response.sendRedirect("ListagemVirus");
                }
            }
         
     }
        
        request.getRequestDispatcher("WEB-INF/index.html").forward(request, response);
        
        
 }
    
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        UsuarioModel model= new UsuarioModel();
        Usuario usuario = new Usuario(nome, senha);
        if (model.verificaLoga(usuario)!=null) {
            usuario=model.verificaLoga(usuario);
            if(model.verficaAdmin(usuario)==true){
                HttpSession sessao=request.getSession(true);
                sessao.setAttribute("usuarioLogado", usuario);
                if(request.getParameter("manter")==null){
                    response.sendRedirect("ListagemVirusAdmin");
                }else{
                    Cookie cookie= new Cookie("usuarioLogado", String.valueOf(usuario.getId()));
                    cookie.setMaxAge(60*60*24);
                    response.addCookie(cookie);
                    response.sendRedirect("ListagemVirusAdmin");
                }
            }else if(model.verficaAdmin(usuario)==false){
                HttpSession sessao=request.getSession(true);
                sessao.setAttribute("usuarioLogado", usuario);// colocar id do usuario
                if(request.getParameter("manter")==null){
                    response.sendRedirect("ListagemVirus");
                }else {
                    Cookie cookie= new Cookie("usuarioLogado", String.valueOf(usuario.getId()));
                    cookie.setMaxAge(60*60*24);
                    response.addCookie(cookie);
                    response.sendRedirect("ListagemVirus");
                }
            }else{
                request.getRequestDispatcher("WEB-INF/TelaErroLogin.jsp").forward(request, response);
            }
        }else{
                 request.getRequestDispatcher("WEB-INF/TelaErroLogin.jsp").forward(request, response);
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
