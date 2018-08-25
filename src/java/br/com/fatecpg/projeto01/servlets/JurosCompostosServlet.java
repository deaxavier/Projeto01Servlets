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
 * @author deaxa *

 */
@WebServlet(name = "JurosCompostosServlet", urlPatterns = {"/juroscomposto.html"})
public class JurosCompostosServlet extends HttpServlet {

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
            out.println("<title>JurosCompostos</title>");            
            out.println("</head>");
            out.println("<body>");            
            out.println("<h1>Calculadora de Juros</h1>");
            out.println("<h3>Cálculo de Juros Compostos</h3>");
            out.println("<form method='get'>");
            out.println("Taxa de juros (%): <input type=\"text\" name=\"i\"/>");
            out.println("Período (em meses): <input type=\"number\" name=\"n\" max='12'/>" );
            out.println("Capital (em Reais): <input type=\"text\" name=\"C\"/>");
            out.println("<input type=\"submit\" value=\"Calcular\"/>");
            out.println("</form>");
            if(request.getParameter("C") != null){
                try{
                    double i = Double.parseDouble(request.getParameter("i"));
                    double n = Double.parseDouble(request.getParameter("n"));
                    double C = Double.parseDouble(request.getParameter("C"));
                    for(int v=1; v<=n; v++){
                    out.println("<h2>Montate do mês "+v+": R$"+(C*(Math.pow((1+(i/100)),v)))+"</h2>");}
                    
                    }catch(Exception ex){
                    out.println("Não é valido");
                }
            }
            out.println("<h3><a href='juroscomposto.html'>Calcular Juros Compostos</a></h3>");
            out.println("<h3><a href='jurossimples.html'>Calcular Juros Simples</a></h3>");
            out.println("<h3><a href='index.html'>Volta</a></h3>");
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
