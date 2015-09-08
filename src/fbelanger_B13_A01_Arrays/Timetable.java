package fbelanger_B13_A01_Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Timetable
{
	private final File TIMETABLE_FILE = new File("Timetable.txt");
	private Week week;
	
	public Timetable()
	{		
		try
		{
			Week week;
			Day[] days;
			Hour[] hours;
			
			Scanner r = new Scanner(TIMETABLE_FILE);
			while (r.hasNextLine())
			{
				
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
			System.out.println("Timetable");
			System.out.println("1 - Read timetable");
			System.out.println("2 - Update timetable");
			
			System.out.print("Enter option: ");
			userInput = prompt.nextLine();
			
			if (userInput.equals("1"))
				readTimeTable(prompt);
			
			else if (userInput.equals("2"))
				updateTimeTable(prompt);
			
			else if (userInput.equals("exit"))
				System.out.println();
			
			else
				System.out.println("Not an option");
		}
		prompt.close();
	}
	
	private void readTimeTable(Scanner prompt)
	{
		Hour result = selectTime(prompt);
		System.out.println(result);
	}
	
	private void updateTimeTable(Scanner prompt)
	{
		selectTime(prompt);
		
	}
	
	private Hour selectTime(Scanner prompt)
	{
		System.out.println();
		System.out.print("Enter a week day: ");
		
		System.out.print("Enter a time of the day: ");
		
		
		return null;
	}
}
