private static String sortByString(String s, String t) {
		HashMap <Character, String> organizer = new HashMap <Character,String>();
		String returnVal = "";

		//Assuming that casing does not matter 
		s = s.toLowerCase();
		t = t.toLowerCase();

		//Iterate over S string and map substrings by character
		for (int i = 0; i < s.length(); i++){
			char ch=s.charAt(i);

			String prev = organizer.get(ch);
			if (prev != null){
				organizer.put(ch,prev+ch);
			} else {
				organizer.put(ch,""+ch);
			}
		}

		//put substrings in order according to T string
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);

			// if there are letters in s have that are not in t they will not be outputted because they are not in t alphabet
			if (organizer.containsKey(ch)) {
				returnVal += organizer.get(ch);
			}
		}

		return returnVal; 
	}
