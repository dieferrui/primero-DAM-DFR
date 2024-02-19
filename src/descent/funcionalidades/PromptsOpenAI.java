package descent.funcionalidades;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PromptsOpenAI {

    public static String solicitarPromptDiego(String apiKey, String prompt) throws Exception {

        String endpoint = "https://api.openai.com/v1/completions";
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

    public static String solicitarPrompt(String apiKey, String prompt) throws Exception {

        String apiUrl = "https://api.openai.com/v1/completions"; // URL del endpoint de completions

        // Parámetros de la solicitud
        Map<Object, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("prompt", "Dime hola");
        requestBody.put("max_tokens", 200);

        // Configuración de la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .header("OpenAI-Beta", "assistants=v1")
                .POST(HttpRequest.BodyPublishers.ofString(mapToJson(requestBody)))
                .build();

        // Envío de la solicitud y obtención de la respuesta
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Respuesta del servidor:");
            System.out.println(response.body());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Método para convertir un mapa a JSON (puedes usar una biblioteca JSON real en tu proyecto)
    private static String mapToJson(Map<Object, Object> map) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":\"");
            json.append(entry.getValue()).append("\",");
        }
        json.setCharAt(json.length() - 1, '}');
        return json.toString();
    }

}
