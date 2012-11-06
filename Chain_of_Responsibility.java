package COR;
//COR - Chain Of Responsibility


/*
This is a model of three handler classes - Mouse, Wolve and Monkey.
Mouse handles the "cheese" request.
Monkey handles the "banana" request.
Wolve handles the "meet" request.
If there is given none from the valid requests, chain ends with alert of unsuccess.
*/


//This class is a model of client class

public class Chain_of_Responsibility
{
	public void main(String[] args)
	{
		//Create the Chain of Responsibility

		Handler chain = build_chain();

		//Trying to handle the request (valid are cheese, meet or banana)

		chain.handle_request(args[1]);
	}

	private Handler build_chain()
	{
		//Creating the chain

		Handler monkey = new Monkey();
		Handler wolve = new Wolve();
		Handler mouse = new Mouse();

		//First nide is Monkey, then Wolve and then Mouse

		monkey.set_next_handler(wolve);
		wolve.set_next_handler(mouse);

		//Returning the first node in the chain

		return monkey;
	}
}


//Abstract class for handlers

abstract class Handler
{
	Handler next_handler;

	public void set_next_handler(Handler next_handler)	
	{
		//Setting next handler in the chain

		this.next_handler = next_handler;
	}

	public abstract void handle_request(String request);
}


//Mouse, a handler class

class Mouse extends Handler
{
	public void handle_request(String request)
	{
		//Trying to handle the request

		if (request == "cheese")
		{
			//Succesful try

			System.out.println("Mouse handles cheese!");
		}
		else
		{
			//Cannot handle request

			System.out.println("Mouse in unable to handle cheese" +  request + "!");

			if (next_handler != null)
			{
				//Sending request to the next handler

				next_handler.handle_request(request);
			}
			else
			{
				//If there is no handlers left, alert about crash

				System.out.println("Chain ends without success!");
			}
		}
	}
}


//Wolve, a handler class

class Wolve extends Handler
{
	public void handle_request(String request)
	{
		//Trying to handle the request

		if (request == "meet")
		{
			//Succesful try

			System.out.println("Wolve handles meet!");
		}
		else
		{
			//Cannot handle request

			System.out.println("Wolve in unable to handle cheese" +  request + "!");

			if (next_handler != null)
			{
				//Sending request to the next handler

				next_handler.handle_request(request);
			}
			else
			{
				//If there is no handlers left, alert about crash

				System.out.println("Chain ends without success!");
			}
		}
	}
}


//Monkey, a handler class

class Monkey extends Handler
{
	public void handle_request(String request)
	{
		//Trying to handle the request

		if (request == "banana")
		{
			//Succesful try

			System.out.println("Monkey handles banana!");
		}
		else
		{
			//Cannot handle request

			System.out.println("Monkey in unable to handle" +  request + "!");

			if (next_handler != null)
			{
				//Sending request to the next handler

				next_handler.handle_request(request);
			}
			else
			{
				//If there is no handlers left, alert about crash

				System.out.println("Chain ends without success!");
			}
		}
	}
}