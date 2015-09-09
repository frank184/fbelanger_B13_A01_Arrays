package fbelanger_B13_A01_Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Timetable
{
	private final File TIMETABLE_FILE = new File("Timetable.txt");
	private Week week;
	
	public Timetable()
	{
		try
		{
			Scanner r = new Scanner(TIMETABLE_FILE);
			week = new Week();
			for (int i = 0; i <= 4; i++)
			{
				for (int j = 0; j <= 9; j++)
				{
					Day day = new Day(r.next());
					if (week.getDay(i) == null)
						week.setDay(i, day);
					int h = Integer.parseInt(r.next());
					String courseNumber = r.next();
					String roomNumber = "";
					if (!courseNumber.equals("FREE"))
						roomNumber = r.next();
					Hour hour = new Hour(h, courseNumber, roomNumber);
					day.setHour(j, hour);
					week.getDay(i).setHour(j, hour);
				}
			}
			r.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Timetable app = new Timetable();
		app.run();
	}
	
	private void run()
	{
		Scanner prompt = new Scanner(System.in);
		String userInput = new String();
		
		// main application loop
		while(!userInput.equals("exit"))
		{
			System.out.println();
			System.out.println("Timetable");
			System.out.println("1. Read timetable");
			System.out.println("2. Update timetable");
			System.out.println("3. List timetable");
			
			System.out.print("Enter option: ");
			userInput = prompt.nextLine();
			
			if (userInput.equals("exit"));
				// do nothing loop will handle
			
			else if (userInput.equals("2"))
				updateTimeTable(prompt);
			
			else if (userInput.equals("3"))
				listTimeTable();
			
			else if (userInput.equals("1"))
				readTimeTable(prompt);
			else
				System.out.println("Not an option");
		}
		prompt.close();
	}
	
	private void readTimeTable(Scanner prompt)
	{
		Hour hour = selectTime(prompt);
		System.out.println(hour);
	}
	
	private void updateTimeTable(Scanner prompt)
	{
		Hour hour = selectTime(prompt);
		System.out.println(hour);
		System.out.printf("%-5s%s", "courseNumber","RoomNumber");
		System.out.printf("%-5s%s", hour.getCourseNumber(), hour.getRoomNumber());
		System.out.println("1. edit course | 2. edit room");
	}
	
	private Hour selectTime(Scanner prompt)
	{
		System.out.print("\nEnter a week day: ");
		int weekday = Day.convertNameOrFullNameToDay(prompt.nextLine().split(" ")[0]);
		Day day = week.getDay(weekday);
		System.out.println(weekday);
		
		System.out.print("Enter a time of the day: ");
		int time = Hour.convertTimeToIndex(prompt.nextLine().split(" ")[0]);
		System.out.println(time);
		Hour hour = day.getHour(time);
		System.out.println(hour);
		System.out.println(week.getDay(0).getHour(0));
		return hour;
	}
	
	public String timeToString(int weekday, int time)
	{
		Day day = week.getDay(weekday);
		Hour hour = day.getHour(time);
		return day + " " + hour;
	}
	
	public String timeToString(Day day, Hour hour)
	{
		return day + " " + hour;
	}
	
	private void listTimeTable()
	{
		for (int i = 0; i <= 4; i++)
		{
			for (int j = 0; j <= 9; j++)
			{
				System.out.println(week.getDay(i).getHour(j));
			}
		}
	}
}
