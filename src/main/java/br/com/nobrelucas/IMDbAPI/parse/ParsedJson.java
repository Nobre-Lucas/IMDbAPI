package br.com.nobrelucas.IMDbAPI.parse;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.nobrelucas.IMDbAPI.model.Movie;

public class ParsedJson {

	Gson gson;
	JsonObject jsonObject;

	public ParsedJson(String responseBody) {
		this.gson = new Gson();
		this.jsonObject = gson.fromJson(responseBody, JsonObject.class);
	}

	public List<Movie> parse() {
		List<Movie> moviesList = new ArrayList<>();
		JsonArray itemsArray = jsonObject.getAsJsonArray("items");
//		for (int i = 0; i < itemsArray.size(); i++) {
//			JsonObject Item = itemsArray.get(i).getAsJsonObject();
//			String id = Item.get("id").getAsString();
//			String rank = Item.get("rank").getAsString();
//			String title = Item.get("title").getAsString();
//			String fullTitle = Item.get("fullTitle").getAsString();
//			String year = Item.get("year").getAsString();
//			String image = Item.get("image").getAsString();
//			Movie movie = new Movie(id, rank, title, fullTitle, year, image);
//			moviesList.add(movie);
//		}
		
		for (JsonElement jsonElement : itemsArray) {
			JsonObject Item = jsonElement.getAsJsonObject();
			String id = Item.get("id").getAsString();
			String rank = Item.get("rank").getAsString();
			String title = Item.get("title").getAsString();
			String fullTitle = Item.get("fullTitle").getAsString();
			String year = Item.get("year").getAsString();
			String image = Item.get("image").getAsString();
			Movie movie = new Movie(id, rank, title, fullTitle, year, image);
			moviesList.add(movie);
		}
		return moviesList;
	}

}
