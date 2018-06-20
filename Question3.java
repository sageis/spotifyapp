private static int changePossibilities (int amount, int[] denoms ){
		return changePossibilitiesHelper (amount, denoms, 0, ""); 
}

private static int changePossibilitiesHelper (int amount, int[] denoms, int index, String output){
		if (amount == 0) return 1; 

		int ways = 0; 
		for (int i=index; i<denoms.length; i++) {
			if (denoms[i] <= amount) {
				ways += changePossibilitiesHelper(amount-denoms[i], denoms, i, output + denoms[i] + " ");
			}
		}
		return ways; 
}
