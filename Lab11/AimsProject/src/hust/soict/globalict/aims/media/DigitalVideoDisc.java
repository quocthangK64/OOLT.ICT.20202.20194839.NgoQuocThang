package hust.soict.globalict.aims.media;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
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
	// ----------Lab07------------
	@Override
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			JOptionPane.showMessageDialog(null, "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR : DVD length is non-positive");
		}
	}
	@Override
	public String toString() {
		return "ID: " + this.id + " - " + this.getClass().getSimpleName() + " - " + this.getTitle() + " - " 
				+ this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() 
				+ ": " + this.getCost() + "$";
	}
}