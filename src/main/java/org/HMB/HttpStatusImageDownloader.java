package org.HMB;

import org.HMB.exeptions.ExceptionServerCode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    String imageUrl;
    public void downloadStatusImage(int code) throws IOException, InterruptedException {
        String fileName = code + ".jpg";
        Path path = Paths.get(fileName);

        if (!Files.exists(path)) {
            HttpClient httpClient = HttpClient.newHttpClient();

            try {
                imageUrl = new HttpStatusChecker().getStatusImage(code);
                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create(imageUrl))
                        .GET()
                        .build();
                HttpResponse<Path> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofFile(path));
                System.out.println("Picture save in:  " + path.toAbsolutePath());
            } catch (ExceptionServerCode e) {
                System.err.println("HTTP status exception: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("An error occurred while making the HTTP request: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("The HTTP request was interrupted: " + e.getMessage());
            }
        } else {
            System.err.println("Picture already exists: " + path.toAbsolutePath());
        }
    }
}
