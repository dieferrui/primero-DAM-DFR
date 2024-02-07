package Descent.Funcionalidades;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PromptsOpenAI {

    public static String solicitarPrompt(String apiKey, String prompt) throws Exception {
        
        String endpoint = "https://api.openai.com/v1/engines/davinci-codex/completions";
        URL url = new URL(endpoint);
        HttpURLConnection connection = null;
    
        try {

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setDoOutput(true);
    
            // Construir el cuerpo del prompt
            String generatePrompt = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 100}";
    
            try (OutputStream outputStream = connection.getOutputStream()) {

                byte[] input = generatePrompt.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);

            }
    
            // Leer la respuesta del modelo
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                
                StringBuilder respuesta = new StringBuilder();
                String linea;
    
                while ((linea = reader.readLine()) != null) {

                    respuesta.append(linea);

                }
    
                return respuesta.toString();

            }

        } finally {

            if (connection != null) {

                connection.disconnect();

            }
        }
    }     
}
