package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

class DVDWrapper{ 
	   DigitalVideoDisc disc; 
	   DVDWrapper(DigitalVideoDisc disc){
		   this.disc = disc;
       } 
} 

public class TestingPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		DVDWrapper dw1 = new DVDWrapper(jungleDVD); 
        DVDWrapper dw2 = new DVDWrapper(cinderellaDVD); 
		swap(dw1, dw2);
		System.out.println("jungle dvd title: " + dw1.disc.getTitle());
		System.out.println("cinderella dvd title: " + dw2.disc.getTitle());
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	// rewrite a swap() method
	public static void swap(DVDWrapper dw1, DVDWrapper dw2) {
    	DigitalVideoDisc tmp = dw1.disc;
    	dw1.disc = dw2.disc;
    	dw2.disc = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
