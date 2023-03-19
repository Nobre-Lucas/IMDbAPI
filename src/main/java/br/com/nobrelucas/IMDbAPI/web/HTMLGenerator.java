package br.com.nobrelucas.IMDbAPI.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.nobrelucas.IMDbAPI.model.Movie;

public class HTMLGenerator {

	PrintWriter writer;

	public HTMLGenerator(PrintWriter writer) {
		this.writer = writer;
	}

	public void generate(List<Movie> movies) throws IOException {
		writer.append("<h1>Top 250 Movies!</h1>");
		for (Movie movie : movies) {
			writer.append("<h2>" + movie.getFullTitle() + "</h2>");
			writer.append("<img src=" + movie.getImage() + ">");
		}
	}

}
