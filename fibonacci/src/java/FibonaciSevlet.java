
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author gabri
 */
@WebServlet(name = "FibonaciSevlet", urlPatterns = {"/fibonacci"})
public class FibonaciSevlet extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = fibonacci(8);
        System.out.println(a);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        
        

    }
    private int fibonacci(int numero) {

        int ant = 0;
        int atual = 1;

        for (int i = 1; i <= numero; i++) {

            int prox = ant + atual;

           

            ant = atual;
            atual = prox;

        }
        
        return atual;

    

    }
    
    
}
