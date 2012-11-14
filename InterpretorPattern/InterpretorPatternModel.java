package InterpretorPattern;

import java.io.*;
import java.util.List;


public class InterpretorPatternModel
{
	public static void main(String[] args)
	{
		Interpretor interpretor = new Interpretor();

		System.out.println("Input format as mm-dd-yyyy or dd-yyyy-mm or something else");

		//Console read method
		Console console = System.console();

		String input = console.readLine();

		System.out.println("Cycle of 5th sun will end at " + interpretor.interpret(input));
	}
}


class Interpretor
{
	String product;

	public Interpretor()
	{
		this.product = new String();
	}

	public String interpret(String string)
	{
		String[] tokens = string.split("-");
		this.product = "";

		for (String token : tokens)
		{
			if (token.equals("dd"))
			{
				this.product = this.product + Calendar.get_day();
			}
			if (token.equals("mm"))
			{
				this.product = this.product + Calendar.get_month();
			}
			if (token.equals("yyyy"))
			{
				this.product = this.product + Calendar.get_year();
			}
			else
			{
				System.out.println("Wrong format input!!!");
			}

			this.product = this.product + "-";
		}

		this.product = this.product.substring(0 , 10);

		return this.product;
	}
}


class Calendar
{
	public static String get_day()
	{
		return "21";
	}

	public static String get_month()
	{
		return "12";
	}

	public static String get_year()
	{
		return "2012";
	}
}