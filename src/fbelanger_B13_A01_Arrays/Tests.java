package fbelanger_B13_A01_Arrays;

public class Tests
{
	public static void main(String[] args)
	{
		Tests runTests = new Tests();
		runTests.run();
	}
	
	private void run()
	{
		// Tests Invalid Hour Exception
		testInvalidHour();
		
		// Test Invalid Day Exception
		testInvalidDay();
		
		// Test Invalid Week Exception
		testInvalidWeek();
	}
	
	private void testInvalidHour()
	{
		Hour early = new Hour(7);
		Hour late = new Hour(18);
	}
	
	private void testInvalidDay()
	{
		Hour[] tooFew = new Hour[9];
		Hour[] tooMany = new Hour[11];
		Day day = new Day(Day.MONDAY,tooFew);
		Day day2 = new Day(Day.MONDAY,tooMany);
	}
	
	private void testInvalidWeek()
	{
		Day[] tooFew = new Day[4];
		Day[] tooMany = new Day[6];
		Week week = new Week(tooFew);
		Week week2 = new Week(tooMany);
	}
	
}


