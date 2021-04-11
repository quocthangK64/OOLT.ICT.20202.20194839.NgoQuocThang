package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    //Question in part 5. Create Constructor method
    //Answer: Yes. JAVA allow us to do this. It's called overloading method
    // 2 constructor are different from variables (title and category)
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
    
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,cost);
		this.director = director;
	}
    
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,cost);
		this.director = director;
		this.length = length;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
    	return this.getId() + " " + this.getTitle() + "    " 
          + this.getCategory() + "       " + this.getDirector() 
          + "       " + this.getLength() + "        " 
          + this.getCost() + "    " + this.getDateAdded();
    }

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}