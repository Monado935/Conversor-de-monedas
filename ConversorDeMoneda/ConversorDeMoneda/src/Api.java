import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    static Conversor convertir(String monedaBase, String monedaObjetivo, Double montoAConvertir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/044d221be780eae2af2499df/pair/"+monedaBase+"/"+monedaObjetivo+"/"+montoAConvertir);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(),Conversor.class);
    }
}
