package ex1;

public class UserMainCode {

	static int checkCharacters(String s) {
		if (s == null) {
			return -1;
		}
		if ("".equals(s)) {
			return 1;
		}
		// comparison is case sensitive
		return s.charAt(0) == s.charAt(s.length() - 1) ? 1 : -1;
	}

}
