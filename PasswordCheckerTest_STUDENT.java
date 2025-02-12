package passcheckpackage;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
            PasswordCheckerUtility.isValidPassword("abc");
            fail("Expected LengthException for password too short");
        } catch (LengthException e) {
            assertTrue("Password too short", true);
        } catch (Exception e) {
            fail("Unexpected exception type: " + e);
        }
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
            PasswordCheckerUtility.isValidPassword("abcdef1!");
            fail("Expected NoUpperAlphaException");
        } catch (NoUpperAlphaException e) {
            assertTrue("No uppercase character", true);
        } catch (Exception e) {
            fail("Unexpected exception type: " + e);
        }
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
            PasswordCheckerUtility.isValidPassword("ABCDEFG1!");
            fail("Expected NoLowerAlphaException");
        } catch (NoLowerAlphaException e) {
            assertTrue("No lowercase character", true);
        } catch (Exception e) {
            fail("Unexpected exception type: " + e);
        }
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
            PasswordCheckerUtility.isWeakPassword("Abcc1!");
            fail("Expected WeakPasswordException");
        } catch (WeakPasswordException e) {
            assertTrue("Weak password", true);
        } catch (Exception e) {
            fail("Unexpected exception type: " + e);
        }	
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
            PasswordCheckerUtility.isValidPassword("Aaabbb1!");
            fail("Expected InvalidSequenceException");
        } catch (InvalidSequenceException e) {
            assertTrue("Invalid sequence", true);
        } catch (Exception e) {
            fail("Unexpected exception type: " + e);
        }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
            PasswordCheckerUtility.isValidPassword("Abcdefg!");
            fail("Expected NoDigitException");
        } catch (NoDigitException e) {
            assertTrue("No digit", true);
        } catch (Exception e) {
            fail("Unexpected exception type: " + e);
        }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		 try {
	            assertTrue(PasswordCheckerUtility.isValidPassword("Abcdef1!"));
	        } catch (Exception e) {
	            fail("Unexpected exception: " + e);
	        }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwords = new ArrayList<>(Arrays.asList("abc", "abcdef1", "ABCDEF1!", "Abcdefg", "Aaabbb1!"));
        ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords(passwords);
        assertEquals(5, results.size());
	}
	
}

