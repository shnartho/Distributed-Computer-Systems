﻿using System;
					
public class Program
{
	public static void Main()
	{
		Console.WriteLine("Hello World");
		Console.WriteLine("My name is Nayem");
		
		string inputName = Console.ReadLine();
		Console.ForegroundColor = ConsoleColor.Red;
		Console.WriteLine("+---------------------------------+");
		Console.WriteLine("| Your name is {0}", inputName);
		Console.WriteLine("+---------------------------------+");
		Console.Clear();
			
	}
}