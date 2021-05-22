package hust.soict.globalict.aims.media;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	public ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	
	public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, String category, String director, float cost) {
		super(title,category,cost);
		this.director = director;
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
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			for(int i = 0; i < tracks.size(); i++) {
				try {
					tracks.get(i).play();
				}catch(PlayerException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	public void getDetail() {
		super.getDetail();
		for(int i = 0; i < tracks.size(); i++) {
			System.out.println("		Track: " + tracks.get(i).getTitle());
			System.out.println("		Length: " + tracks.get(i).getLength());
		}
	}
}
