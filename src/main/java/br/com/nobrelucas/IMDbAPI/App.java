package br.com.nobrelucas.IMDbAPI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.nobrelucas.IMDbAPI.parse.ParsedJson;
import br.com.nobrelucas.IMDbAPI.request.IMDbAPIClient;
import br.com.nobrelucas.IMDbAPI.web.HTMLGenerator;

public class App {
	public static void main(String[] args) {
		
		String apiKey = System.getenv("API_KEY");

		IMDbAPIClient apiClient = new IMDbAPIClient(apiKey);
		String responseBody = apiClient.getResponse().body();

		ParsedJson json = new ParsedJson(responseBody);

		try {
			FileWriter file = new FileWriter("./top250.html");
			PrintWriter writer = new PrintWriter(file);
			HTMLGenerator generator = new HTMLGenerator(writer);

			generator.generate(json.parse());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
