package MementoPattern;


//MementoPatternModel class introduces usage of Memento Pattern

public class MementoPatternModel
{
	public static void main(String[] args)
	{
		//Settings is our Originator class
		Settings mysettings = new Settings(10 , 3 , 80);

		//Settings Manager is our Caretaker class
		SettingsManager settingsmanager = new SettingsManager();

		//Printing first, default settings
		System.out.println("Settings are :");
		System.out.println(mysettings);

		//Saving them in memento,
		//save process is incapsulated with settingsmanager
		//and our Settings-nested private class Memento
		System.out.println("Saving settings...");
		settingsmanager.save(mysettings);

		//Changing brightness
		System.out.println("Changing screen brightness to 70");
		mysettings.set_screen_brightness(70);

		//Printing new settings
		System.out.println("New settings are :");
		System.out.println(mysettings);

		//Restoring old one
		System.out.println("Restoring old settings...");
		settingsmanager.restore(mysettings);

		//Printing restored settings
		System.out.println("Settings restored :");
		System.out.println(mysettings);
	}
}

//Settings is our Originator class

class Settings
{
	//Settings class models screen settings
	private int color_id;
	private int screensaver_id;
	private int screen_brightness;

	public Settings(int color_id , int screensaver_id , int screen_brightness)
	{
		//Constructor

		this.color_id  = color_id;
		this.screensaver_id = screensaver_id;
		this.screen_brightness = screen_brightness;
	}

	public void set_color_id(int color_id)
	{
		this.color_id  = color_id;
	}

	public void set_screensaver_id(int screensaver_id)
	{
		this.screensaver_id = screensaver_id;
	}

	public void set_screen_brightness(int screen_brightness)
	{
		this.screen_brightness = screen_brightness;
	}

	public String toString()
	{
		//This method is used by println system output method to print settings
		return "Settings are: Color ID - " + color_id + " , ScreenSaver Id - " + screensaver_id + " , Screen Brightness - " + screen_brightness + ".";
	}

	public Memento save_settings()
	{
		//Saving settings, returning a Memento object
		//This method waould be used by SystemSettings class,
		//Who have not access to nested private Memento class
		return new Memento(this.color_id , this.screensaver_id , this.screen_brightness);
	}

	public void restore_settings(Object saved_state)
	{
		//Restoring settings
		//This method waould be used by SystemSettings class,
		//Who have not access to nested private Memento class

		//saved_state Object is passed by SystemSettings class
		//We bring type of saved_state to Memento
		//And get data from it
		Memento memento = (Memento)saved_state;
		this.color_id = memento.memento_color_id;
		this.screensaver_id = memento.memento_screensaver_id;
		this.screen_brightness = memento.memento_screen_brightness;
	}

	private class Memento
	{
		//Here saved data from Settings class is stored
		private int memento_color_id;
		private int memento_screensaver_id;
		private int memento_screen_brightness;

		public Memento(int color_id , int screensaver_id , int screen_brightness)
		{
			//Constructor

			memento_color_id = color_id;
			memento_screensaver_id = screensaver_id;
			memento_screen_brightness = screen_brightness;
		}
	}
}

//SettingsManager, our Caretaker class

class SettingsManager
{
	//SettingsManager does not recognize Memento class,
	//So we create saved_state of Object type,
	//Which in real is Memento of Settings
	Object saved_state;

	public void save(Settings settings)
	{
		//getting data from Settings via Memento object

		saved_state = settings.save_settings();
	}

	public void restore(Settings settings)
	{
		//Restoring data in Settings object
		//Parcing an saved_state Object to it
		//Which will be converted to Memento in restore_settings method
		settings.restore_settings(saved_state);
	}
}