package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Collections;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	private List<String> token = new ArrayList<String>();
//	private int contentLength = token.size();
	private String content;
	private Map<String,Integer> wordFrequency = new TreeMap<>();
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		nbMedia++;
		this.id += nbMedia;
	}
	
	public Book(String title, String category, float cost, String content) {
		super(title,category,cost);
		this.content = content.toLowerCase();
		this.processContent();
	}
	public Book(String title, String category, float cost, String[] authors, String content) {
		super(title,category,cost);
		this.authors = Arrays.asList(authors);
		this.content = content.toLowerCase();
		this.processContent();
	}
	private List<String> getAuthors() {
		return authors;
	}
	private int getContentLength() {
		return this.wordFrequency.size();
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
	
	public void getDetail() {
    	System.out.println( "ID: " + this.id + " - " + this.getClass().getSimpleName() + " - " + this.getTitle() + " - " 
				+ this.getCategory() + " - " + this.getAuthors() + " - " + "Content length : " + this.getContentLength() 
				+ ": " + this.getCost() + "$" + '\n' + "Token list: " + this.getToken());
    }

	public List<String> getToken() {
		List<String> result = new ArrayList<String>();
		for (Map.Entry <String, Integer> val : this.wordFrequency.entrySet()) {
            result.add(val.getKey() + " : " + val.getValue());
        }
		return result;
	}

	
	private void processContent() {
		String [] arr = content.split("[, ?.@]+");
		for(int i = 0; i < arr.length; i++) {
				this.token.add(arr[i]);
		}
		Collections.sort(this.token);
		for (String i : this.token) {
            Integer j = this.wordFrequency.get(i);
            this.wordFrequency.put(i, (j == null) ? 1 : j + 1);
        }
	}
	
	public String toString() {
		return "ID: " + this.id + " - " + this.getClass().getSimpleName() + " - " + this.getTitle() + " - " 
					+ this.getCategory() + " - " + this.getAuthors() + " - " + "Content length : " + this.getContentLength() 
					+ ": " + this.getCost() + "$" + '\n' + "Token list: " + this.getToken(); 
	}
}
