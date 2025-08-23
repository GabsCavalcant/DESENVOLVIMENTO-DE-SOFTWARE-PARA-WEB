package primeiroformulario.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para processamento dos dados do formulário.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet(name = "ProcessaDadosClienteServlet", urlPatterns = {"/processaDadosCliente"})
public class ProcessaDadosClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
         * Precisamos manter de forma consistente o mesmo encoding em todas as camadas da
         * aplicação, evitando assim problemas com caracteres acentuados. Aqui informamos
         * que a requisição está chegando codificada em UTF-8.
         */
        request.setCharacterEncoding("UTF-8");

        /*
         * Obtém os dados do request. O método getParameter de request obtém um
         * parâmetro enviado pelo formulário que acessou o Servlet.
         *
         * O parâmetro tem SEMPRE o mesmo nome configurado na propriedade "name" do
         * componente do formulário.
         */
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String CPF = request.getParameter("cpf");
        String dataNascimento = request.getParameter("dataNasc");
        String sexo = request.getParameter("sexo");
        String observacoes = request.getParameter("observacoes");
        String email = request.getParameter("email");
        //Endereço
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        
        // Outras Informações
        String temFilhosParam = request.getParameter("temFilhos"); // Parâmetro do checkbox
        String possuiFilhos = "Não";
        if (temFilhosParam != null && temFilhosParam.equals("sim")) {
            possuiFilhos = "Sim";
        }
        
        
// --- EXIBIÇÃO DOS DADOS NO CONSOLE ---
        System.out.println("-----------------------------------------");
        System.out.println("DADOS DO CLIENTE RECEBIDOS (SAÍDA CONSOLE)");
        System.out.println("-----------------------------------------");
        
        System.out.println("Nome Completo: " + nome + " " + sobrenome);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + CPF);
        System.out.println("Data de Nascimento: " + dataNascimento);

        // Lógica corrigida para evitar o erro NullPointerException
        if (sexo != null && sexo.equals("M")) {
            System.out.println("Sexo: Masculino");
        } else if (sexo != null && sexo.equals("F")) {
            System.out.println("Sexo: Feminino");
        } else {
            System.out.println("Sexo: Não informado");
        }
        
        System.out.println("\n--- Endereço ---");
        System.out.println("CEP: " + cep);
        System.out.println("Logradouro: " + logradouro + ", Nº " + numero);
        System.out.println("Complemento: " + complemento);
        System.out.println("Cidade/Estado: " + cidade + " / " + estado);
        
        System.out.println("\n--- Outras Informações ---");
        System.out.println("Possui Filhos: " + possuiFilhos);
        System.out.println("Observacoes: " + observacoes);
        System.out.println("-----------------------------------------");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ProcessaDadosClienteServlet";
    }

}
