package br.com.nobrelucas.IMDbAPI.request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class IMDbAPIClient {
	HttpClient client;
	HttpRequest request;
	HttpResponse<String> response;

	public IMDbAPIClient(String apiKey) {
		this.client = HttpClient.newHttpClient();
		this.request = HttpRequest.newBuilder().uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
				.build();
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		};
	}

	public HttpResponse<String> getResponse() {
		return this.response;
	}
}
