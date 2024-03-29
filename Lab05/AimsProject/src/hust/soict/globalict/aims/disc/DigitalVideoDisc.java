package hust.soict.globalict.aims.disc;
import java.time.LocalDate;
import java.util.StringTokenizer;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private LocalDate dateAdded;
    private static int nbDigitalVideoDiscs = 0;
    private String id = "DVD";
    //Question in part 5. Create Constructor method
    //Answer: Yes. JAVA allow us to do this. It's called overloading method
    // 2 constructor are different from variables (title and category)
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id += nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id += nbDigitalVideoDiscs;
	}
    
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id += nbDigitalVideoDiscs;
	}
    
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id += nbDigitalVideoDiscs;
	}

	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}
	public String getId() {
		return id;
	}

	// temporarily add a setter for Test
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getDetail() {
    	return this.getId() + " " + this.getTitle() + "    " 
          + this.getCategory() + "       " + this.getDirector() 
          + "       " + this.getLength() + "        " 
          + this.getCost() + "    " + this.getDateAdded();
    }
    
    // -----------Lab05------------ //
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
    
}