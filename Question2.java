//Returns a string repeated reps number of times
private static String duplicateString(String s, int reps) {
  String returnString = "";
  for (int i = 0; i < reps; i++){
    returnString += s;
  }
  return returnString; 
}

//Given the last index of an int value string, returns the start index of int
private static int getIntStartIndex(String s, int tail){
  for (int i=tail-1; i >= 0; i--){
    if (!Character.isDigit(s.charAt(i))){
      return i+1; 
    }
  }
  return 0; 
}

private static String decodeString(String s) {
		int SENTINEL = -1; 
		int strbracket = SENTINEL;
		int endbracket = SENTINEL;
		int bracketbal = 0; 

		for (int i = 0; i<s.length(); i++){

			if (s.charAt(i) == '[') {
				if (strbracket == SENTINEL) strbracket = i; 
				bracketbal++; 
			}

			if (s.charAt(i) == ']'&& strbracket != SENTINEL) {
				bracketbal--;
				if (bracketbal == 0) {
					endbracket = i;

					int repsstrt = getIntStartIndex(s,strbracket);
					int reps = Integer.parseInt(s.substring(repsstrt,strbracket));

					return s.substring(0,repsstrt) + 
					duplicateString(decodeString(s.substring(strbracket+1,endbracket)), reps) + 
					decodeString(s.substring(endbracket+1,s.length()));

				} 
			}
		}

		if (bracketbal > 0) {
			System.out.println("ERROR: Improper Format. Missing ']' ! ");
		} else if (bracketbal < 0) {
			System.out.println("ERROR: Improper Format. Missing '[' ! ");
		}
		return s;
}
