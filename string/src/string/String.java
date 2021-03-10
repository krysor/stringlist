package string;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of characters.
 * 
 *  @immutable
 */
public class String {

	/**
	 * @invar | characters != null
	 * @representationObject
	 */
	private final char[] characters;
	
	/**
	 * @inspects | this
	 * @basic
	 */
	public char[] toCharArray() {
		return characters.clone();
	}
	
	/**
	 * @inspects | this
	 * @post | result == toCharArray().length
	 */
	public int length() { return characters.length; }
	
	/**
	 * @inspects | this
	 * @pre | 0 <= index && index < length()
	 * @post | result == toCharArray()[index]
	 */
	public char charAt(int index) {
		return characters[index];
	}
	
	private String(char[] characters) {
		this.characters = characters;
	}
	
	//alternatief:
//	public String(char[] characters) {
//		this.characters = characters.clone();
//	}
	
	/**
	 * 
	 * @post | result != null
	 * @post | Arrays.equals(result.toCharArray(), new char[] {c}) 
	 */
	public static String valueOf(char c) {
		return new String(new char[] {c});
	}
	
	/**
	 * @pre | other != null
	 * 
	 * @inspects | this, other
	 * 
	 * @post | result != null
	 * @post | result.length() == this.length() + other.length()
	 * @post | Arrays.equals(result.toCharArray(), 0, this.length(), 
	 * 		 | 				 this.toCharArray(), 0, this.length())
	 * @post | Arrays.equals(result.toCharArray(), this.length(), result.length(), 
	 * 		 | 				 other.toCharArray(), 0, other.length())
	 */
	public String concat(String other) {
		char[] newCharacters = new char[length() + other.length()];
		System.arraycopy(this.characters, 0, newCharacters, 0, length());
		System.arraycopy(other.characters, 0, newCharacters, length(), other.length());
		return new String(newCharacters);
	}
}
