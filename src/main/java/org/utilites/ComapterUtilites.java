package org.utilites;

import java.util.Comparator;

public class ComapterUtilites implements Comparator  {

	public int compare(Object o1, Object o2) {
		Integer s1 = (Integer) o1;
		Integer s2 = (Integer) o2;
		if(s1 > s2) {
			return 1;
		}
		else if(s1 < s2) {
			return -1;
		}else {
			return 0;
		}
		
	}

}
