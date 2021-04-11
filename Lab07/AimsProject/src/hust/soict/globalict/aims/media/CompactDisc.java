package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public CompactDisc(String title) {
		super(title);
	}
	
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track t) {
		if(tracks.contains(t)) {
			System.out.println("The input track is already in the list of tracks.");
		}else {
			tracks.add(t);
		}
	}
	public void removeTrack(Track t) {
		if(tracks.contains(t)) {
			tracks.remove(t);
		}else {
			System.out.println("The input track had not been in the list of tracks.");
		}
	}
	public int getLength() {
		int cdlength = 0;
		for(int i = 0; i < tracks.size(); i++ ) {
			cdlength += tracks.get(i).getLength();
		}
		return cdlength;
	}
	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for(int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
		}
	}
}
