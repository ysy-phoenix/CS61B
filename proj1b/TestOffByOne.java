import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    /*Uncomment this class once you've created your CharacterComparator
      interface and OffByOne class. **/
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('z', 'y'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('A', 'B'));

        assertFalse(offByOne.equalChars('x', 'x'));
        assertFalse(offByOne.equalChars('s', 'z'));
        assertFalse(offByOne.equalChars('）', '#'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('B', 'Z'));
    }

}
