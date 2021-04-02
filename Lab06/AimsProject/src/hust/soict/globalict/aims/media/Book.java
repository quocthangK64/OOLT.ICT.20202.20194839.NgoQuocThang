package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	private List<String> getAuthors() {
		return authors;
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Author has already been in the list.");
		}else {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			
		}else {
			System.out.println("Author has not been in the list.");
		}
	}
}
