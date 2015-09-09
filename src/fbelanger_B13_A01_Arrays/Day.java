package fbelanger_B13_A01_Arrays;

import java.util.Arrays;

/**
 * <p>Represents a school Day in a given School Week. Contains an array of Hour class.</p>
 */
public class Day
{
	// Days in a week
	public static final int MONDAY    = 0;
	public static final int TUESDAY   = 1;
	public static final int WEDNESDAY = 2;
	public static final int THURSDAY  = 3;
	public static final int FRIDAY    = 4;
	
	// DAY_NAMES array
	private static final String[] DAY_NAMES = {
			"M", "TU", "W", "TH", "F"
	};
	
	// DAY_FULL_NAMES array
	private static final String[] DAY_FULL_NAMES = {
			"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
	};
	
	// Hour array
	private Hour[] hours;
	private int day;
	
	/**
	 * Instantiates a Day by setting the day and the array of Hour class.
	 * @param hours
	 */
	public Day(int day)
	{
		if (day >= 0 && day <= 4)
		{
			this.day = day;
			this.hours = new Hour[10];
		}
		else
			try
			{
				throw new DayException(day, hours.length);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	/**
	 * Instantiates a Day by setting the day and the array of Hour class.
	 * @param hours
	 */
	public Day(int day, Hour...hours)
	{
		if (hours.length == 10 && day > 0 && day < 5)
		{
			this.day = day;
			this.hours = hours;
		}
		else
			try
			{
				throw new DayException(day, hours.length);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	public Day(String dayName)
	{
		this.day = convertDayNameToDay(dayName);
		this.hours = new Hour[50];
	}
	
	public Day(String dayName, Hour...hours)
	{
		if (hours.length == 10 && day > 0 && day < 5)
		{
			this.day = convertDayNameToDay(dayName);
			this.hours = hours;
		}
		else
			try
			{
				throw new DayException(day, hours.length);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	/**
	 * Method for returning the Integer value of a dayName.
	 * @param dayName
	 * @return
	 */
	public static int convertDayNameToDay(String dayName)
	{
		dayName = dayName.trim().toUpperCase();
		switch(dayName)
		{
		case "M":
			return Day.MONDAY;
		case "TU":
			return Day.TUESDAY;
		case "W":
			return Day.WEDNESDAY;
		case "TH":
			return Day.THURSDAY;
		case "F":
			return Day.FRIDAY;
		default:
			try
			{
				throw new DayNameFormatException(dayName);
			}
			catch (DayNameFormatException e)
			{
				e.printStackTrace();
			}
			return -1;
		}
	}
	
	/**
	 * Method for returning the Integer value of a dayFullName.
	 * @param dayName
	 * @return
	 */
	public static int convertDayFullNameToDay(String dayFullName)
	{
		dayFullName = dayFullName.trim().toLowerCase().substring(0, 1).toUpperCase();
		switch(dayFullName)
		{
		case "Monday":
			return Day.MONDAY;
		case "Tuesday":
			return Day.TUESDAY;
		case "Wednesday":
			return Day.WEDNESDAY;
		case "Thurday":
			return Day.THURSDAY;
		case "Friday":
			return Day.FRIDAY;
		default:
			try
			{
				throw new DayNameFormatException(dayFullName);
			}
			catch (DayNameFormatException e)
			{
				e.printStackTrace();
			}
			return -1;
		}
	}
	
	/**
	 * Method for returning the Integer value of a dayFullName.
	 * @param dayName
	 * @return
	 */
	public static int convertNameOrFullNameToDay(String day)
	{
		day = day.trim().toLowerCase().substring(0, 1).toUpperCase();
		if (day.length() == 2)
			day = day.substring(1, 2).toUpperCase();
		
		switch(day)
		{
		case "M":
			return Day.MONDAY;
		case "TU":
			return Day.TUESDAY;
		case "W":
			return Day.WEDNESDAY;
		case "TH":
			return Day.THURSDAY;
		case "F":
			return Day.FRIDAY;
		case "Monday":
			return Day.MONDAY;
		case "Tuesday":
			return Day.TUESDAY;
		case "Wednesday":
			return Day.WEDNESDAY;
		case "Thurday":
			return Day.THURSDAY;
		case "Friday":
			return Day.FRIDAY;
		default:
			try
			{
				throw new DayNameFormatException(day);
			}
			catch (DayNameFormatException e)
			{
				e.printStackTrace();
			}
			return -1;
		}
	}
	
	/**
	 * Returns whether two Days are identical.
	 * @param obj
	 * @return identical
	 */
	public boolean equals(Object obj)
	{
		try
		{
			return Arrays.equals(((Day)obj).hours, this.hours);
		}
		catch (ClassCastException e)
		{
			return false;
		}
	}
	
	/**
	 * Returns a String representation of a Day.
	 * @return dayName
	 */
	public String toString()
	{
		return DAY_NAMES[day];
	}
	
	/**
	 * Getter for the day Integer.
	 * @return day
	 */
	public int getDay()
	{
		return day;
	}
	
	/**
	 * Getter for a Day's name.
	 * @return dayNames[day]
	 */
	public String getDayName()
	{
		return DAY_NAMES[day];
	}
	
	/**
	 * Getter for a Day's full name.
	 * @return dayFullNames[day]
	 */
	public String getDayFullName()
	{
		return DAY_FULL_NAMES[day];
	}
	
	/**
	 * Setter for the day Integer.
	 * @param day
	 */
	public void setDay(int day)
	{
		if (day > 0 && day < 5)
		{
			this.day = day;
		}
		else
			try
			{
				throw new DayException(day, hours.length);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	/**
	 * Setter for the day Integer.
	 * @param day
	 */
	public void setDay(String day)
	{
		this.day = convertDayNameToDay(day);
	}

	/**
	 * Getter for an Hour in a Day.
	 * @param time
	 * @return
	 */
	public Hour getHour(int time)
	{
		return hours[time];
	}

	/**
	 * Setter for an Hour in a Day.
	 * @param time
	 * @param hour
	 */
	public void setHour(int time, Hour hour)
	{
		hours[time] = hour;
	}
	
	/**
	 * Getter for the Hours array in a Day.
	 * @return hours
	 */
	public Hour[] getHours()
	{
		return hours;
	}
	
	/**
	 * Setter for the Hours array in a Day.
	 * @param hours
	 */
	public void setHours(Hour[] hours)
	{
		if (hours.length == 10)
		{
			this.hours = hours;
		}
		else
			try
			{
				throw new DayException(day, hours.length);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	/**
	 * <p>A private class for Day class Exceptions.<p>
	 */
	@SuppressWarnings("serial")
	protected static class DayException extends Exception
	{
		DayException(int day, int hoursLength)
		{
			super(buildMessage(day, hoursLength));
		}
		
		public static String buildMessage(int day, int hoursLength)
		{
			String s = new String();
			if (day < 0 || day > 4) s = ": " + day + " is not a valid day of the week";
			if (hoursLength < 10)  s = ": " + hoursLength + " is too few hours";
			if (hoursLength > 10) s =  ": " + hoursLength + " is too many hours";
			return "Invalid Day" + s;
		}
	}
	
	/**
	 * <p>A private class for DayName Format Exceptions.<p>
	 */
	@SuppressWarnings("serial")
	protected static class DayNameFormatException extends Exception
	{
		DayNameFormatException(String dayName)
		{
			super(buildMessage(dayName));
		}
		
		public static String buildMessage(String dayName)
		{
			return "Invalid DayName" + ": " + dayName + " is an invalid dayName";
			
		}
	}
}
