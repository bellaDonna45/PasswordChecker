package passcheckpackage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
    
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
            NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        isValidLength(password);
        
        validatePassword(password);
        
        if (!NoSameCharInSequence​(password)) {
            throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
        }
        return true;
    }
    
    public static void validatePassword(String password) throws NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException {
    	if (!hasUpperAlpha(password)) {
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        }
    	if (!hasLowerAlpha(password)) {
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        }
        if (!hasDigit(password)) {
            throw new NoDigitException("The password must contain at least one digit");
        }
        if (!hasSpecialChar(password)) {
            throw new NoSpecialCharacterException("The password must contain at least one special character");
        }
       
    }
    public static boolean isValidLength(String password) throws LengthException{
    	if (password.length() < 6) {
            throw new LengthException("The password must be at least 6 characters long");
        }
    	return true;
    }
    public static boolean hasUpperAlpha(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
    public static boolean hasLowerAlpha(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String password) {
        String specialCharacters = "!@#$%^&*()_+={}:;<>?/";
        for (char c : password.toCharArray()) {
            if (specialCharacters.indexOf(c) != -1) { 
                return true;
            }
        }
        return false;
    }
    public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {

        isValidPassword(password);

        if (password.length() >= 6 && password.length() <= 9) {
            throw new WeakPasswordException("The password is acceptable but weak - it has less than 10 characters.");
        }
        
        return false;
    }
    
 public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
	    ArrayList<String> invalidPasswords = new ArrayList<>();

	    for (String password : passwords) {
	        try {
	            isValidPassword(password);
	        } catch (Exception e) {
	            invalidPasswords.add(password + " " + e.getMessage());
	        }
	    }
	    return invalidPasswords;
	    }


    
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
    	if (!password.equals(passwordConfirm))
    		throw new UnmatchedException();
    }
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }
    public static boolean hasBetweenSixAndNineChars(String password) {
    	if (password.length() >= 6 && password.length() <= 9)
    		return true;
    		else
    			return false;
    }
    
    public static boolean NoSameCharInSequence​(String password)  throws InvalidSequenceException{
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                throw new InvalidSequenceException("You may not have more than two of the same character in sequence");
            }
        }
        return true;
    }
}

class LengthException extends Exception {
    public LengthException(String message) {
        super(message);
    }
}

class NoUpperAlphaException extends Exception {
    public NoUpperAlphaException(String message) {
        super(message);
    }
}

class NoLowerAlphaException extends Exception {
    public NoLowerAlphaException(String message) {
        super(message);
    }
}

class NoDigitException extends Exception {
    public NoDigitException(String message) {
        super(message);
    }
}

class NoSpecialCharacterException extends Exception {
    public NoSpecialCharacterException(String message) {
        super(message);
    }
}

class InvalidSequenceException extends Exception {
    public InvalidSequenceException(String message) {
        super(message);
    }
}

class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

class UnmatchedException extends Exception {
    public UnmatchedException() {
        super("Passwords do not match");
    }
}


