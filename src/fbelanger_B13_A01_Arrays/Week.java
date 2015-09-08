package fbelanger_B13_A01_Arrays;

import java.util.Arrays;

/**
 * <p>Represents a School Week. Contains an array of Day class.</p>
 */
public class Week
{
	private Day[] days;
	
	/**
	 * Instantiates a Week by setting the array of Day class.
	 * @param days
	 */
	public Week(Day...days)
	{
		if (days.length == 5)
		{
			this.days = days;
		}
		else
			try
			{
				throw new WeekException(days.length);
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
		
	}
	
	/**
	 * Returns whether two Weeks are identical.
	 * @param obj
	 * @return identical
	 */
	public boolean equals(Object obj)
	{
		try
		{
			return Arrays.equals(((Week)obj).days, this.days);
		}
		catch (ClassCastException e)
		{
			return false;
		}
	}
	
	/**
	 * Getter for a Day in a Week.
	 * @param weekday
	 * @return
	 */
	public Day getDay(int weekday)
	{
		return days[weekday];
	}
	
	/**
	 * Setter for a Day in a Week.
	 * @param weekday
	 * @param day
	 */
	public void setDay(int weekday, Day day)
	{
		days[weekday] = day;
	}
	
	/**
	 * Getter for the Days array in a Week.
	 * @return
	 */
	public Day[] getDays()
	{
		return days;
	}
	
	/**
	 * Setter for the Days array in a Week.
	 * @param days
	 */
	public void setDays(Day[] days)
	{
		if (days.length == 5)
		{
			this.days = days;
		}
		else
			try
			{
				throw new WeekException(days.length);
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	/**
	 * <p>A private class for Week class Exceptions.<p>
	 */
	@SuppressWarnings("serial")
	protected static class WeekException extends Exception
	{
		WeekException(int dayLength)
		{
			super(buildMessage(dayLength));
		}
		
		public static String buildMessage(int dayLength)
		{
			String s = new String();
			if (dayLength < 5)  s = ": " + dayLength + " is too few days";
			if (dayLength > 5) s =  ": " + dayLength + " is too many days";
			return "Invalid Week" + s;
		}
	}
}
