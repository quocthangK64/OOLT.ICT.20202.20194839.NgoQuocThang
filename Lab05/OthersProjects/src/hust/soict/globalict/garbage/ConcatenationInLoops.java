package hust.soict.globalict.garbage;
import java.util.Random;
public class ConcatenationInLoops {
	public static void main(String[] args) {
		//not using StringBuffer
		String str = "" ;
		Random random = new Random(123) ;
		long startTime = System.currentTimeMillis() ;
		for(int i = 0 ;i < 10000 ;i++) {
			str += random.nextInt();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
//		System.out.println(str);
		
		// using StringBuffer
		StringBuffer outputString = new StringBuffer("") ;
		random = new Random(100) ;
		startTime = System.currentTimeMillis() ;
		for(int i = 0 ;i < 10000; i++) {
			outputString.append(random.nextInt()) ;
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
//		System.out.println(outputString);
	}
}
