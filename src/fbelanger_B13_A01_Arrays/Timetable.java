package fbelanger_B13_A01_Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Timetable
{
	boolean updated = false;
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
	
	public void saveFile(File file)
	{
		if (updated)
		{
			updated = false;
			String content = "";
			for (int i = 0; i <= 4; i++)
			{
				for (int j = 0; j <= 9; j++)
				{
					content += week.getDay(i) + " " + week.getDay(i).getHour(j) + "\n";
				}
			}
			try
			{
				FileWriter w = new FileWriter(file);
				w.write(content);
				w.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
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
			System.out.println();
			System.out.println("Timetable");
			System.out.println("1. Read timetable");
			System.out.println("2. Update timetable");
			System.out.println("3. List timetable");
			System.out.print("Enter option: ");
			
			userInput = prompt.next();
			if (userInput.equals("exit"))
			{
				saveFile(TIMETABLE_FILE);
			}
			
			else if (userInput.equals("1"))
				readTimeTable(prompt);
			
			else if (userInput.equals("2"))
				updateTimeTable(prompt);
			
			else if (userInput.equals("3"))
				listTimeTable();
			
			else
				System.out.println("Invalid option");
		}
		prompt.close();
	}
	
	private void readTimeTable(Scanner prompt)
	{
		int weekday = selectDayIndex(prompt);
		Day day = week.getDay(weekday);
		
		int time = selectHourIndex(prompt);
		Hour hour = day.getHour(time);
		
		System.out.printf("\n%s %s\n", day, hour);
	}
	
	private void updateTimeTable(Scanner prompt)
	{
		int weekday = selectDayIndex(prompt);
		Day day = week.getDay(weekday);
		
		int time = selectHourIndex(prompt);
		Hour hour = day.getHour(time);
		
		System.out.println("\n1. " + hour.getCourseNumber());
		System.out.println("2. " + hour.getRoomNumber());
		System.out.print("Enter option: ");
		
		String userInput = prompt.next();
		if (userInput.equals("exit"))
			return;
		else if (userInput.equals("1"))
		{
			updated = true;
			System.out.print(hour.getCourseNumber() + ": ");
			userInput = prompt.next();
			hour.setCourseNumber(userInput);
			week.getDay(weekday).setHour(time, hour);
			saveFile(TIMETABLE_FILE);
		}
		else if (userInput.equals("2"))
		{
			updated = true;
			System.out.print(hour.getRoomNumber() + ": ");
			userInput = prompt.next();
			hour.setRoomNumber(userInput);
			week.getDay(weekday).setHour(time, hour);
			saveFile(TIMETABLE_FILE);
		}
		else
			System.out.println("Invalid option");
	}
	
	private int selectDayIndex(Scanner prompt)
	{
		System.out.print("\nEnter a week day: ");
		String userInput = prompt.next();
		return Day.convertNameOrFullNameToDay(userInput);
	}
	
	
	private int selectHourIndex(Scanner prompt)
	{
		System.out.print("Enter a time of the day: ");
		String userInput = prompt.next();
		return Hour.convertTimeToIndex(userInput);
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
