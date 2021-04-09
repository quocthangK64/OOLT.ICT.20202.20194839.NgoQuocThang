package hust.soict.globalict.test.utils;
import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.MediaUtils;


public class DVDTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA","aaaa","aaaa",1,5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB","bbbb","bbbb",2,5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC","cccc","cccc",3,5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD","dddd","dddd",4,7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE","eeee","eeee",5,3.3f);
		
		System.out.println(MediaUtils.compareByCost(dvd1,dvd2));
		System.out.println(MediaUtils.compareByTitle(dvd5,dvd3));
		
		ArrayList<Media> arrayList = new ArrayList<Media>(Arrays.asList(new Media[] {
				dvd1,dvd2,dvd3,dvd4,dvd5}));
		ArrayList<Media> sorted = MediaUtils.sortByCost(arrayList);
		System.out.println("sort by cost: ");
		System.out.println("ID   Title   Category   Director   Length   Cost   Date_added");
		for(int i = 0; i < sorted.size(); i++) {
			System.out.println(sorted.get(i).getDetail());
		}
		sorted = MediaUtils.sortByTitle(sorted);
		System.out.println("sort bt title: ");
		System.out.println("ID   Title   Category   Director   Length   Cost   Date_added");
		for(int i = 0; i < sorted.size(); i++) {
			System.out.println(sorted.get(i).getDetail());
		}
	}
}