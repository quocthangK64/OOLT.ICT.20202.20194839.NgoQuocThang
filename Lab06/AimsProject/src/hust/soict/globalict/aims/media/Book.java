package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	private List<String> token = new ArrayList<String>();
	private int contentLength = token.size();
	private int[] frequency = new int[1000];
	private String content;
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
	}
	public Book(String title, String category, float cost, String[] authors, String content) {
		super(title,category,cost);
		this.authors = Arrays.asList(authors);
		this.content = content.toLowerCase();
	}
	private List<String> getAuthors() {
		return authors;
	}
	private int getContentLength() {
		return this.takeContentLength(this.content);
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
	public String getDetail() {
    	return this.getId() + " " + this.getTitle() + "    " 
          + this.getCategory() + "       " + this.getContentLength() + 
          "        " + this.getCost() + "        " + this.getAuthors()
          +"    " + this.getDateAdded() + "    " + this.getToken()+"     " +this.getFrequency();
    }
	public int takeContentLength(String content) {
		int result;
		String [] arr = content.split("[, ?.@]+");
		for(int i = 0; i < arr.length; i++) {
			if(this.token.contains(arr[i])==false) {
				this.token.add(arr[i]);
			}
		}
		result = this.token.size();
		return result;
	}

	public List<String> getToken() {
		this.takeContentLength(this.content);
		Collections.sort(this.token);
		return this.token;
	}

	public List<String> getFrequency() {
		Arrays.fill(this.frequency, 0);
		String [] arr = this.content.split("[, ?.@]+");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < this.token.size(); j++ ) {
				if(arr[i].equalsIgnoreCase(this.token.get(j))) {
					this.frequency[j]++;
				}
			}
		}
		String strArray[] = new String[this.token.size()];
        for (int i = 0; i < this.token.size(); i++)
            strArray[i] = String.valueOf(frequency[i]);
        List<String> list = new ArrayList<String>();
        list = Arrays.asList(strArray);
		return list;
	}
	
}