package hust.soict.globalict.garbage;
import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		String s = "" ;
		Random r = new Random(123) ;
		long startTime = System.currentTimeMillis() ;
		for(int i = 0 ;i < 65536 ;i++) {
			s += r.nextInt();
		}
		System.out.println(System.currentTimeMillis() - startTime);
		
		StringBuffer ouputString = new StringBuffer("") ;
		r = new Random(123) ;
		startTime = System.currentTimeMillis() ;
		for(int i = 0 ;i < 65536; i++) {
			ouputString.append(r.nextInt()) ;
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
