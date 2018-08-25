/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.projeto01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author deaxa
 */
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/jurossimples.html"})
public class JurosSimplesServlet extends HttpServlet {

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
            out.println("<title>JurosSimples</title>");            
            out.println("</head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
            out.println("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap-theme.css\" type=\"text/css\"/>");
            out.println("<body>");      
            out.println("<h1>Calculadora de Juros</h1>");
            out.println("<div class=\"container\" align=\"center\"> \n");            
            out.println("<h2>Cálculo de Juros Simples</h2>");
            out.println("<div class = 'col-xs-12 col-sm-12 col-md-3 col-lg-3' align='center'> ");
            out.println("<form method='get'>");
            out.println(" <div class=form>");
            out.println("<div class=\"form-row align-items-center\">");
            out.println("Taxa de juros: <input type=\"text\" name=\"i\"/><br>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("Período (em meses): <input type=\"text\" name=\"n\"/><br>");
            out.println("Capital (em Reais): <input type=\"text\" name=\"C\"/><br>");
            out.println("<input type=\"submit\" value=\"Calcular\"/>");
            out.println("</form>");
            if(request.getParameter("C") != null){
                try{
                    double i = Double.parseDouble(request.getParameter("i"));
                    double n = Double.parseDouble(request.getParameter("n"));
                    double C = Double.parseDouble(request.getParameter("C"));
                    out.println("<h2>Juros do período de "+ n +" meses: R$: "+(C*i*n)+"</h2>");
                }catch(Exception ex){
                    out.println("Não é valido");
                }
            }
            out.println("<h3><a href='juroscomposto.html'>Calcular Juros Compostos</a></h3>");
            out.println("<h3><a href='index.html'>Voltar</a></h3>");
            out.println("</div>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
