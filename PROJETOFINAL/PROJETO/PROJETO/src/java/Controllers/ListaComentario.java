/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Comentario;
import Entidades.Usuario;
import Entidades.Virus;
import Models.ComentarioModel;
import Models.UsuarioModel;
import Models.VirusModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListaComentario", urlPatterns = {"/ListaComentario"})
public class ListaComentario extends HttpServlet {

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

            HttpSession sessao = request.getSession(false);
        
            Usuario logado = (Usuario) sessao.getAttribute("usuarioLogado");

            VirusModel model = new VirusModel();
            ArrayList comentario = model.buscaComentario(Integer.parseInt(request.getParameter("id")));
            Virus virus = model.busca(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("virus", virus);
            request.setAttribute("comentario", comentario);
            request.setAttribute("usuario", logado);
            request.getRequestDispatcher("WEB-INF/ListaComentario.jsp").forward(request, response);
        

    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ComentarioModel model = new ComentarioModel();
        UsuarioModel modelu = new UsuarioModel();
        VirusModel modelv = new VirusModel();
        Usuario usuario = modelu.verificaId(Integer.parseInt(request.getParameter("idusuario")));
        Virus virus = modelv.busca(Integer.parseInt(request.getParameter("idvirus")));
        Comentario comentario = new Comentario(usuario, virus, request.getParameter("escrita"));
        if (model.Cadastrar(comentario) == true) {
            request.getRequestDispatcher("WEB-INF/TelaSucesso.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/TelaErro.jsp").forward(request, response);
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

}
