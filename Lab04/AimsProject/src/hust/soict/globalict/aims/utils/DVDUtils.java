package hust.soict.globalict.aims.utils;
import java.util.Arrays;
import java.util.Comparator;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
public class DVDUtils {
	
	public static int compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(dvd1.getCost() > dvd2.getCost()) {
			return 1;
		}
		else if(dvd1.getCost() < dvd2.getCost()) {
			return -1;
		}
		else return 0;
	}
	
    public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.getTitle().compareToIgnoreCase(dvd2.getTitle());
	}
    
    public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
    	int number=0;
    	for (number = 0; dvdList[number] != null; number++);
    	Arrays.sort(dvdList,0,number, new Comparator<DigitalVideoDisc>() {
    		public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    			int compareByCost = DVDUtils.compareByCost(dvd1, dvd2);
    			if(compareByCost==0) {
    				return compareByTitle(dvd1,dvd2);
    			}
    			return -compareByCost(dvd1,dvd2);
    		}
    	});
		return dvdList;
	}
    
    public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
    	int number=0;
    	for (number = 0; dvdList[number] != null; number++);
    	Arrays.sort(dvdList,0,number, new Comparator<DigitalVideoDisc>() {
    		public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    			int compareByTitle = DVDUtils.compareByTitle(dvd1, dvd2);
    			if(compareByTitle==0) {
    				return -compareByCost(dvd1,dvd2);
    			}
    			return compareByTitle(dvd1,dvd2);
    		}
    	});
		return dvdList;
	}	
}