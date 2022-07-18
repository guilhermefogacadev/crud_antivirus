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
import java.io.PrintWriter;
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
@WebServlet(name = "DeletaVirus", urlPatterns = {"/DeletaVirus"})
public class DeletaVirus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeletaVirus</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeletaVirus at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
            
              HttpSession sessao=request.getSession(false);
       if(sessao==null || sessao.getAttribute("usuarioLogado")==null){
           
       }else{   
           Usuario logado = (Usuario)sessao.getAttribute("usuarioLogado");
           
        VirusModel model= new VirusModel();
        Virus virus= model.busca(Integer.parseInt(request.getParameter("id")));
        
        request.setAttribute("virus", virus);
        request.setAttribute("usuario",logado);
        request.getRequestDispatcher("WEB-INF/DeletaVirus.jsp").forward(request, response);
        }
            
            /*Virus vi= model.getVirus(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("virus",vi);
            request.getRequestDispatcher("WEB-INF/DeletaVirus.jsp").forward(request, response);
            */
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
            int id= Integer.parseInt(request.getParameter("id"));
            VirusModel model= new VirusModel();
            if(model.remove(id)==true){
                request.getRequestDispatcher("WEB-INF/TelaSucessoAdmin.jsp").forward(request, response);
            }else{
                 request.getRequestDispatcher("WEB-INF/TelaErroAdmin.jsp").forward(request, response);
            }
           
            /*if (model.deletaVirus(id)==true) {
                response.sendRedirect("TelaSucesso");
            }else{
                response.sendRedirect("ListagemVirus");
            }
        
            */
        
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
