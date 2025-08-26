/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Calculadora.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
@WebServlet(name = "CalculadoraProcesso", urlPatterns = {"/CalculadoraProcesso"})
public class CalculadoraProcesso extends HttpServlet {

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
        
        
        String numero1 = request.getParameter("n1");
        String numero2 = request.getParameter("n2");
        
        String operacao = request.getParameter("operacao");
        
        double n1 = 0,n2 = 0;
        String simbolo = "";
        String error = null;
        double resultado = 0;
        
        try{
            
            n1 = Double.parseDouble(numero1);
            n2 = Double.parseDouble(numero2);
            
            if(operacao == null){
                System.out.println("Error por favor insira uma operacao");
                
            }else{
                switch (operacao) {
                    case "soma":
                        resultado =  n1 + n2;
                        simbolo = "+";
                        break;
                     case "subtracao":
                        resultado =  n1 - n2;
                        simbolo = "-";
                        break;
                    case "multiplicacao":
                        resultado =  n1 * n2;
                        simbolo = "*";
                        break;
                    case "divisao":
                        resultado =  n1 / n2;
                        simbolo = "/"; 
                        break;
                        
                        
                    default:
                        System.err.println("Operacao invalida");
                }
            }
            
            
        } catch (NumberFormatException e) {
            error = "Os valores informados para os números não são válidos.";
        }try (PrintWriter out = response.getWriter()){
            if (error != null) {
                out.println("<p class='error'>" + error + "</p>");
            } else {
                out.println("<p class='result'>" + numero1 + " " + simbolo + " " + numero2 + " = <strong>" + resultado + "</strong></p>");
            }
            
            out.println("<a href='index.html'>Calcular Novamente</a>");
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
