import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RomanToInteger {
	public int romanToInt(String s) {
		int solution = 0;
		List<Integer> numarray = new ArrayList<Integer>();
		List<String> list = Arrays.asList(s.split(""));
		Iterator<String> it = list.iterator();		
		while(it.hasNext()) {
			switch(it.next()) {
				case "I":
					numarray.add(1);
					continue;
				case "V":
					numarray.add(5);
					continue;
				case "X":
					numarray.add(10);
					continue;
				case "L":
					numarray.add(50);
					continue;
				case "C":
					numarray.add(100);
					continue;
				case "D":
					numarray.add(500);
					continue;
				case "M":
					numarray.add(1000);
					continue;
			}
		}		
 		ListIterator<Integer> numit = numarray.listIterator();
 		while(numit.hasNext()) {
 			int temp = numit.next();
 			solution += temp;
 			if(temp == 5 || temp == 10) {
 				if(numit.previousIndex()-1 != -1) {
 					if(numarray.get(numit.previousIndex()-1) == 1) {
 						solution -= 2;
 					}
 				}
 			}
 			else if(temp == 50 || temp == 100) {
 				if(numit.previousIndex()-1 != -1) {
 					if(numarray.get(numit.previousIndex()-1) == 10) {
 						solution -= 20;
 					}
 				}
 			}
 			else if(temp == 500 || temp == 1000) {
 				if(numit.previousIndex()-1 != -1) {
 					if(numarray.get(numit.previousIndex()-1) == 100) {
 						solution -= 200;
 					}
 				}
 			}
 			
 		}
		return solution;
    }
	public static void main(String args[]) {
		String s = "MCXVII";
		RomanToInteger obj = new RomanToInteger();
		int solution = obj.romanToInt(s);
		System.out.println(solution);
	}
}
