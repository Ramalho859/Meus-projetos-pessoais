package Api;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
public class ApideCep {
    public static void main(String[] args) throws Exception {// não entendi
        // Cria servidor na porta 8080
        //http://localhost:8080/cep/07060000 colocar isso no navegador
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        System.out.println("Servidor rodando em http://localhost:8080");

        // Rota /cep
        server.createContext("/cep", new CepHandler());
        server.setExecutor(null); // padrão
        server.start();
    }

    // Classe que trata requisições em /cep
    static class CepHandler implements HttpHandler {//não entendi isso
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            // Ex: /cep/01001000
            String[] parts = path.split("/");
            if (parts.length < 3) {
                sendResponse(exchange, "CEP não informado", 400);
                return;
            }

            String cep = parts[2];

            try {
                // Consulta ViaCEP
                URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)
                );
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();

                // Retorna JSON pro navegador
                sendResponse(exchange, sb.toString(), 200);

            } catch (Exception e) {
                sendResponse(exchange, "Erro ao consultar CEP coloque um outro cep", 500);
            }
        }

        private void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(statusCode, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
