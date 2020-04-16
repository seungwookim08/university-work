package part1;

// This class implements Comparable Interface.
public class LetterWord implements Comparable<LetterWord>{
	
	// LetterWord contains String which is read from Scanner and frequency.
	private String word;
	private int frequency;
	
	/**
	 * Parameterized constructor which takes String and set frequency to 1 (since the word exists)
	 * @param s	Word only contains letters.
	 */
	public LetterWord(String s){
		word = s;
		frequency = 1;
	}
	
	/**
	 * When this method is called, frequency is incremented. 
	 */
	public void incrementFrequency(){
		frequency++;
	}

	/**
	 * equals method will be used if they are the same word
	 * @param lw	Comparing two LetterWord
	 * @return	if the word is the same regardless of upper case or lower case.
	 */
	public boolean equals(LetterWord lw){
		return this.word.equalsIgnoreCase(lw.word);
	}

	// getters (note that no setter is needed for word and frequency is incrementing automatically whenever it has the same word.
	public String getWord() {
		return word;
	}

	public int getFrequency() {
		return frequency;
	}

	@Override
	/**
	 * LetterWord is compared based on alphabetic order of word. 
	 * @param lw	Comparing two LetterWord
	 * @return 	1 is return if parameterized LetterWord comes lexicographically first. if it's the same, return 0, else return -1. 
	 */
	public int compareTo(LetterWord lw) {
		if (this.word.compareTo(lw.word)>0)
			return 1;
		if (this.word.compareTo(lw.word)==0)
			return 0;
		return -1;
	}
	
	
	
}
