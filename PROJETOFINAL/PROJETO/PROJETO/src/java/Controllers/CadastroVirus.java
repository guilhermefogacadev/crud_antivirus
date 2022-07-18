/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Virus;
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
@WebServlet(name = "CadastroVirus", urlPatterns = {"/CadastroVirus"})
public class CadastroVirus extends HttpServlet {

    
    

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
           request.getRequestDispatcher("WEB-INF/CadastroVirus.jsp").forward(request, response);
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
            String nome= request.getParameter("nome");
            String tipo= request.getParameter("tipo");
            String detalhes= request.getParameter("detalhes");
            
            Virus v= new Virus("Sim".equals(tipo), nome, detalhes);
            VirusModel model = new VirusModel();
            if(model.verificaVirus(v)==true){
                request.getRequestDispatcher("WEB-INF/TelaSucessoAdmin.jsp").forward(request, response);
            }
            request.getRequestDispatcher("WEB-INF/TelaErroAdmin.jsp").forward(request, response);
            
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
