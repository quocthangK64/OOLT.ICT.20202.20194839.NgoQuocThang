package hust.soict.globalict.aims.utils;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	
	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		if(o1.getTitle().compareToIgnoreCase(o2.getTitle())!=0) {
			return o1.getTitle().compareToIgnoreCase(o2.getTitle());
		}else {
			if(o1.getCost() > o2.getCost()) {
				return -1;
			}
			else if(o1.getCost() < o2.getCost()) {
				return 1;
			}else 
				return 0;
		}
	}
	
}
