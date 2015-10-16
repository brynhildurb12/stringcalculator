 package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}

		else if(text.startsWith("//")){
			return sum(splitNumbersDifferentDelimiter(text));
		}
		
		else if((text.contains("\n"))||(text.contains(","))){
			return sum(splitNumbersMoreDelimiters(text));
		}

		else
			return 1;
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
		    total += toInt(number);
		}
		return total;
    }
	
	private static String[] splitNumbersMoreDelimiters(String numbers){
	    return numbers.split(",|\\n");
	} 

	private static String[] splitNumbersDifferentDelimiter(String text){
	    	Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			m.matches();	
			String delimiter = m.group(1);
			String numbers = m.group(2);
	    return numbers.split(delimiter);
	}   
}