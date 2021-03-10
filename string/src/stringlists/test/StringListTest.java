package stringlists.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stringlists.StringList;

class StringListTest {

	@Test
	void test() {
		String[] myStrings = {"Hello", "Bye"};
		StringList myStringList = new StringList(myStrings);
		
		myStrings[0] = null;
		
		assertThrows(NullPointerException.class, () -> 
					 myStringList.getConcatenation());
	}

}
