package hust.soict.globalict.aims.utils;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import hust.soict.globalict.aims.media.Media;
public class MediaUtils {
	
	public static int compareByCost(Media m1, Media m2) {
		if(m1.getCost() > m2.getCost()) {
			return 1;
		}
		else if(m1.getCost() < m2.getCost()) {
			return -1;
		}
		else return 0;
	}
	
    public static int compareByTitle(Media m1, Media m2) {
		return m1.getTitle().compareToIgnoreCase(m2.getTitle());
	}
    
    public static ArrayList<Media> sortByCost(ArrayList<Media> dvdList) {
    	Collections.sort(dvdList, new Comparator<Media>() {
    		public int compare(Media m1, Media m2) {
    			int compareByCost = MediaUtils.compareByCost(m1, m2);
    			if(compareByCost==0) {
    				return compareByTitle(m1,m2);
    			}
    			return -compareByCost(m1,m2);
    		}
    	});
		return dvdList;
	}
    
    public static ArrayList<Media> sortByTitle(ArrayList<Media> dvdList) {
    	Collections.sort(dvdList, new Comparator<Media>() {
    		public int compare(Media m1, Media m2) {
    			int compareByTitle = MediaUtils.compareByTitle(m1, m2);
    			if(compareByTitle==0) {
    				return -compareByCost(m1,m2);
    			}
    			return compareByTitle(m1,m2);
    		}
    	});
		return dvdList;
	}
}