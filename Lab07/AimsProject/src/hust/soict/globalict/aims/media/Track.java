package hust.soict.globalict.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public Track(String title) {
		this.title = title;
	}
	public Track(int length) {
		this.length = length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	@Override
	public void play() {
		if(this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
			}else {
				System.out.println("Cannot play this track: "+ this.getTitle() + " because this has the length 0 or less");
			}
	}
}
