package org.HMB;

import org.HMB.exeptions.ExceptionServerCode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.HMB.configuretion.constants.URL_CAT;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws IOException, InterruptedException {
        String url;
        url = URL_CAT + code + ".jpg";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

            HttpResponse<Void> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.discarding());
            if (response.statusCode() != 404) {
                return url;
            } else {
                throw new ExceptionServerCode("not found picture for code: " + code);
            }
    }

}
