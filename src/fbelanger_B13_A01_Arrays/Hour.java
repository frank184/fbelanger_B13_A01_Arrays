package fbelanger_B13_A01_Arrays;

/**
 * <p>Represents the Hour in a given School Day in a given School Week. An hour may have an hour, a course number and a room number.</p>
 */
public class Hour
{
	//Hours of a day
	public static final int EIGHT 		 = 0;
	public static final int NINE  		 = 1;
	public static final int TEN   		 = 2;
	public static final int ELEVEN 	 = 3;
	public static final int TWELEVE 	 = 4;
	public static final int THIRTEEN  = 5, ONE 	= 5;
	public static final int FOURTEEN  = 6, TWO 	= 6;
	public static final int FIFTEEN   = 7, THREE = 7;
	public static final int SIXTEEN	 = 8, FOUR  = 8;
	public static final int SEVENTEEN = 9, FIVE  = 9;
	
	private String courseNumber;
	private String roomNumber;
	private int hour;
	
	/**
	 * Instantiates an Hour and sets hour.
	 * @param hour
	 * @throws HourException 
	 */
	public Hour(int hour)
	{
		if (hour > 7 && hour < 17)
		{
			this.hour = hour;
			this.courseNumber = "FREE";
			this.roomNumber = "";
		}
		else
			try
			{
				throw new HourException(hour);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	/**
	 * Instantiates an Hour, sets hour and courseNumber.
	 * @param hour
	 * @param courseNumber
	 * @throws HourException
	 */
	public Hour(int hour, String courseNumber)
	{
		if (hour > 7 && hour < 17)
		{
			this.hour = hour;
			this.courseNumber = courseNumber;
			this.roomNumber = "";
		}
		else
			try
			{
				throw new HourException(hour);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	/**
	 * Instantiates an Hour, sets hour, courseNumber and roomNumber.
	 * @param hour
	 * @param courseNumber
	 * @param roomNumber
	 * @throws HourException
	 */
	public Hour(int hour, String courseNumber, String roomNumber)
	{
		if (hour > 7 && hour < 17)
		{
			this.hour = hour;
			this.courseNumber = courseNumber;
			this.roomNumber = roomNumber;
		}
		else
			try
			{
				throw new HourException(hour);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	/**
	 * Returns whether two Hours are identical.
	 * @param obj
	 * @return identical
	 */
	public boolean equals(Object obj)
	{
		try
		{
			return ((Hour)obj).hour == this.hour
					&& ((Hour)obj).courseNumber.equals(this.courseNumber)
					&& ((Hour)obj).roomNumber.equals(this.roomNumber);
		}
		catch (ClassCastException e)
		{
			return false;
		}
	}
	
	/**
	 * Returns a String representation of an Hour.
	 * @return
	 */
	public String toString()
	{
		return hour + " " + courseNumber + " " + roomNumber;
	}
	
	/**
	 * Getter for the Integer representation of Hour.
	 * @return hour
	 */
	public int getHour()
	{
		return hour;
	}
	
	/**
	 * Setter for the Integer representation of Hour.
	 * @param hour
	 */
	public void setHour(int hour)
	{
		if (hour > 7 && hour < 17)
		{
			this.hour = hour;
		}
		else
			try
			{
				throw new HourException(hour);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
	}

	/**
	 * Getter for the courseNumber of a given Hour.
	 * @return
	 */
	public String getCourseNumber()
	{
		return courseNumber;
	}

	/**
	 * Setter for the courseNumber of a given Hour.
	 * @param courseNumber
	 */
	public void setCourseNumber(String courseNumber)
	{
		this.courseNumber = courseNumber;
	}

	/**
	 * Getter for the roomNumber of a given Hour.
	 * @return
	 */
	public String getRoomNumber()
	{
		return roomNumber;
	}

	/**
	 * Setter for the roomNumber of a given Hour.
	 * @param roomNumber
	 */
	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	/**
	 * <p>A private class for Hour class Exceptions.<p>
	 */
	@SuppressWarnings("serial")
	protected static class HourException extends Exception
	{
		HourException(int hour)
		{
			super(buildMessage(hour));
			for(int i = 0; i < 9; i++);
			System.exit(-1);
		}
		
		public static String buildMessage(int hour)
		{
			String s = new String();
			if (hour < 8)  s = ": " + hour + " is too early";
			if (hour > 17) s = ": " + hour + " is too late";
			return "Invalid Hour" + s;
		}
	}
}
