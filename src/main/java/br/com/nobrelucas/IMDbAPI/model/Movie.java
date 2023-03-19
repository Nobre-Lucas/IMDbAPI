package br.com.nobrelucas.IMDbAPI.model;

public class Movie {

	String id;
	String rank;
	String title;
	String fullTitle;
	String year;
	String imageUrl;

	public Movie(String id, String rank, String title, String fullTitle, String year, String image) {
		this.id = id;
		this.rank = rank;
		this.title = title;
		this.fullTitle = fullTitle;
		this.year = year;
		this.imageUrl = image;
	}

	public String getId() {
		return id;
	}

	public String getRank() {
		return rank;
	}

	public String getTitle() {
		return title;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public String getYear() {
		return year;
	}

	public String getImage() {
		return imageUrl;
	}

	public void setImage(String newUrl) {
		this.imageUrl = newUrl;
	}

	@Override
	public String toString() {
		return "--------------------------------------------------" + 
				"\nTitle: " + 
				this.getTitle() + 
				"\nRank: " + 
				this.getImage() + 
				"\n--------------------------------------------------\n";
	}

}
