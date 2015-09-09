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
		loadFile(TIMETABLE_FILE);
	}
	
	public void loadFile(File file)
	{
		try
		{
			Scanner r = new Scanner(file);
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
	
	/**
	 * main
	 * @param args
	 */
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
			System.out.println("\nTimetable");
			System.out.println("1. Read timetable");
			System.out.println("2. Update timetable");
			System.out.println("3. List timetable");
			
			System.out.print("Enter option: ");
			userInput = prompt.next();
			
			if (userInput.equals("exit"));
				// do nothing loop will handle
			
			else if (userInput.equals("1"))
				readTimeTable(prompt);
			
			else if (userInput.equals("2"))
				updateTimeTable(prompt);
			
			else if (userInput.equals("3"))
				listTimeTable();
			
			else
				System.out.println("Not an option");
		}
		prompt.close();
	}
	
	private void readTimeTable(Scanner prompt)
	{
		Day day = selectDay(prompt);
		Hour hour = selectHour(day, prompt);
		System.out.println(day + " " + hour);
	}
	
	private void updateTimeTable(Scanner prompt)
	{
		Day day = selectDay(prompt);
		Hour hour = selectHour(day, prompt);
		System.out.println(day + " " + hour);
	}
	
	private Day selectDay(Scanner prompt)
	{
		System.out.print("\nEnter a week day: ");
		String userInput = prompt.next();
		int weekday = Day.convertNameOrFullNameToDay(userInput);
		return week.getDay(weekday);
	}
	
	private Hour selectHour(Day day, Scanner prompt)
	{
		System.out.print("Enter a time of the day: ");
		String userInput = prompt.next();
		int time = Hour.convertTimeToIndex(userInput);
		return day.getHour(time);
	}
	
	private void listTimeTable()
	{
		System.out.println();
		for (int i = 0; i <= 4; i++)
		{
			for (int j = 0; j <= 9; j++)
			{
				System.out.println(week.getDay(i) + " " + week.getDay(i).getHour(j));
			}
		}
	}
}
