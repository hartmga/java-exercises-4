package ex2;

/*
 2.	Create two String reference variables. Then create two String literals with the same value - "cat" -  
and assign them to the reference variables. Try using the "==" operator to verify that they are pointing
to the same String object. Now say new String("cat") and assign that to the first reference variable.
Try verifying again with "==". Now try creating a reference variable of type StringBuilder or StringBuffer.
Give this the value of "cat" – then call append() method on this object, modifying the value.
Notice there is no append() method on a String object, since it is immutable. 
 */

public class Main {

	public static void main(String[] args) {
		String s1, s2;
		s1 = "cat";
		s2 = "cat";
		System.out.println(s1 == s2); // returns true because both point to the same place in the string pool
		s1 = new String("cat");
		System.out.println(s1 == s2); // s1 was assigned with new, so it no longer has the same reference

		StringBuilder sb = new StringBuilder(s1);
		sb.append(s2);
		System.out.println(sb);

	}

}
