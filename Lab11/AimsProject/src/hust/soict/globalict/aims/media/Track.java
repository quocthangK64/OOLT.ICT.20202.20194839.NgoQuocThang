package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable, Comparable<Track> {
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
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
			}else {
				throw new PlayerException("Error: Track length is non-positive");
			}
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track t = (Track) obj;
			return (this.title.equals(t.getTitle()) && this.length == t.getLength());
		}else {
			return false;
		}
	}
	@Override
	public int compareTo(Track o) {
		return this.title.compareToIgnoreCase(o.getTitle());
	}
}
