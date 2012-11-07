package CommandPattern;

import java.io.*;
import java.util.*;


//CommandPatternModel class models the usage of Command Patterns

public class CommandPatternModel
{
	public static void main(String[] args)
	{
		Invoker invoker = new Invoker();
		RunCommand run = new RunCommand();
		DriveCommand drive = new DriveCommand();

		//Some introduction to type
		System.out.println("Type run for run operation.");
		System.out.println("Type drive for drive operation.");
		System.out.println("Type undo to undo last operations.");
		System.out.println("Type close to close program.");

		//Console read method
		Console console = System.console();

		while (true)
		{
			//Read users input
			String choice = console.readLine();

			if (choice.equalsIgnoreCase("run"))
			{
				//If input is "run"
				//Set run command to invoker

				invoker.set_command(run);
				invoker.invoke();
			}
			else if(choice.equalsIgnoreCase("drive"))
			{
				//If input is "drive"
				//Set drive command to invoker

				invoker.set_command(drive);
				invoker.invoke();
			}
			else if(choice.equalsIgnoreCase("undo"))
			{
				//If input is "undo"
				//Undo the last operation

				invoker.get_history();
			}
			else if(choice.equalsIgnoreCase("close"))
			{
				//If input is "close"
				//Terminate program

				break;
			}
		}
	}
}


//Class Invoker, it incapsulates the reciever's code from Client, CommandPatternModel

class Invoker
{
	//command keeps the command which will handle execution
	private Command command;

	//history contains stack of last operations
	private Stack<Command> history;

	//Constructor to initializa history
	public Invoker()
	{
		this.history = new Stack();
	}

	//set_command sets the command class that handles the execution
	public void set_command(Command command)
	{
		this.command = command;
	}

	//invoke lets the command to execute
	public void invoke()
	{
		this.history.push(this.command);
		this.command.execute();
	}

	//executing last operation in history
	public void get_history()
	{
		if (!this.history.empty())
		{
			//If stack is not empty

			this.command = this.history.pop();
			this.command.execute();
		}
		else
		{
			//If stack is empty

			System.out.println("NOTE: Stack of Undo operations is empty!");
		}
	}
}


//This interface is the Command which handles the execution of operation
//and incopsulates it from Invoker

interface Command
{
	public void execute();
}


//RunCommand, handles the run operation and incopsulates reciever Run class

class RunCommand implements Command
{
	//This command stands for Run reciever
	private Run run;

	//Constructor to initialize run
	public RunCommand()
	{
		this.run = new Run();
	}

	//Transmit the execution to the reciever
	@Override
	public void execute()
	{
		this.run.so_run();
	}
}


//DriveCommand, handles the drive operation and incopsulates reciever Drive class

class DriveCommand implements Command
{
	//This command stands for Drive reciever
	private Drive drive;

	//Constructor to initialize drive
	public DriveCommand()
	{
		this.drive = new Drive();
	}
	
	//Transmit the execution to the reciever
	@Override
	public void execute()
	{
		this.drive.so_drive();
	}
}


//class Run, the reciever and main executor of run operation

class Run
{
	public void so_run()
	{
		System.out.println("RUN!!");
	}
}


//class Drive, the reciever and main executor of drive operation

class Drive
{
	public void so_drive()
	{
		System.out.println("DRIVE!!");
	}
}