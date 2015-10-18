 package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("-")){

			noNegativeNumbersAllowed(text);
			return 0;
		}

		else if(text.startsWith("//")){

			/*Matcher m = Pattern.compile("//((.)|(\\[.+\\]))\n(.*)").matcher(text);
			m.matches();
			//String delimiter = m.group(1);
			String anyLengthDelimiter = m.group(2);
			if(!anyLengthDelimiter.isEmpty()){
				String numbersWithLongDelimiter = m.group(4);
				return sum(numbersWithLongDelimiter.split(anyLengthDelimiter));
			}	*/
			return sum(splitNumbersDifferentDelimiter(text));
		}
		
		else if((text.contains("\n"))||(text.contains(","))){
			return sum(splitNumbersMoreDelimiters(text));
		}

		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) > 1000){
        		number = "0";
        	}
		    total += toInt(number);
		}
		return total;
	}	

	private static String[] splitNumbersMoreDelimiters(String numbers){
	    return numbers.split(",|\\n");
	} 

	private static String[] splitNumbersDifferentDelimiter(String text){
	    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
	    //Matcher m = Pattern.compile("//((.)|(\\[.+\\]))\n(.*)").matcher(text);
		m.matches();	
		String delimiter = m.group(1);
		String numbers = m.group(2);
	    return numbers.split(delimiter);
	}  

	private static void noNegativeNumbersAllowed(String text) throws RuntimeException{
	 	String[] allnumbers = splitNumbers(text); 	
		List<String> negativenumbers = new ArrayList<>();
		for(String number : allnumbers){
			if(toInt(number) < 0){
				negativenumbers.add(number);
			}
		}
		String listofnegatives = String.join(",", negativenumbers);
		throw new RuntimeException("Negatives are not allowed: " + listofnegatives);
	} 

}