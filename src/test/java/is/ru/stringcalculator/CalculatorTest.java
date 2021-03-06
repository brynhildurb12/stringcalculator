package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
    
    @Test
    public void testMultipleNumbersMoreDelimiters(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
    
    @Test
    public void testNegativeNumber(){
    	try{
    		Calculator.add("-1,2");
    		//fail("Exception expected.");
    	}
    	catch(RuntimeException ex){
    		assertEquals("Negatives are not allowed: -1", ex.getMessage());
    	}
    }

    @Test
    public void testMultipleNegativeNumber(){
    	try{
    		Calculator.add("2,-4,3,-5");
    		//fail("Exception expected.");
    	}
    	catch(RuntimeException ex){
    		assertEquals("Negatives are not allowed: -4,-5", ex.getMessage());
    	}
    }

    @Test
    public void testNumbersBiggerThan1000NotAllowed(){
    	assertEquals(2, Calculator.add("1001,2"));
    }
/*
    @Test
    public void testDelimiterOfAnyLength(){
    	assertEquals(3, Calculator.add("//***\n1***2"));
    }*/
   
}