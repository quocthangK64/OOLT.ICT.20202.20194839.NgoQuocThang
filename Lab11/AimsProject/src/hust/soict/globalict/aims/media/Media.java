package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.utils.MediaComparatorByCostTitle;
import hust.soict.globalict.aims.utils.MediaComparatorByTitleCost;

public abstract class Media implements Comparable<Media>{
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbMedia = 0;
	protected LocalDate dateAdded;
	public static ArrayList<Media> itemsAvailble = new ArrayList<Media>();
	public Media() {
	}
	public Media (Media root) {
		super();
		this.id = root.id;
		this.title = root.title;
		this.category = root.category;
		this.cost = 0;
		this.dateAdded = root.dateAdded;		
	}
	public Media(String title, String category, float cost) {
		super();
		nbMedia++;
		this.id = nbMedia;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
	}
	public Media(String title) {
		super();
		nbMedia++;
		this.id = nbMedia;
		this.title = title;
		this.dateAdded = LocalDate.now();
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public static int getNbMedia() {
		return nbMedia;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void getDetail() {
    	System.out.println(this.getId() + " " + this.getTitle() + "    " 
          + this.getCategory() + "       "
          + this.getCost() + "    " + this.getDateAdded());
    }
	public void setFree() {
		this.cost = 0f;
	}
    public boolean search(String title) {
    	StringTokenizer str = new StringTokenizer(title);
    	String [] s = this.getTitle().split(" ");
    	while(str.hasMoreTokens()) {
    		String save = str.nextToken();
    		for(int i = 0;i < s.length;i++) {
    			if(s[i].compareToIgnoreCase(save)==0) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    @Override
    public boolean equals(Object obj) throws NullPointerException{
    		try {
    			Media m = (Media) obj;
    			return (this.title.equals(m.getTitle()) && this.cost == m.getCost());
    		} 
    		catch (NullPointerException e) {
    			throw new NullPointerException("Obj is null");
    		}
    		catch (ClassCastException e){
    			throw new ClassCastException("Wrong class type casting (Media)");
    		}
    }
    @Override
    public int compareTo(Media o) {
    	if(this.title.compareToIgnoreCase(o.getTitle())!=0) {
    		return this.title.compareToIgnoreCase(o.getTitle());
    	}else {
    		return this.category.compareToIgnoreCase(o.getCategory());
    	}
    }
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
    		new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
    		new MediaComparatorByCostTitle();
    
}
