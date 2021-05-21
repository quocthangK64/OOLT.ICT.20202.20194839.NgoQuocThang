package hust.soict.globalict.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	public Disc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public Disc(String title) {
		super(title);
	}
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public void getDetail() {
	    System.out.println("ID: " + this.id + " - " + this.getClass().getSimpleName() + " - " + this.getTitle() + " - " 
				+ this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() 
				+ ": " + this.getCost() + "$");
	}
}
