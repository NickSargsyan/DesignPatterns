package StatePattern;


//StatePatternModel show usage of State Pattern

public class StatePatternModel
{
	public static void main(String[] args)
	{
		//Creating context class
		FroskaTheCat froska = new FroskaTheCat("Angry");

		//Changing emotion of cat, it will change it's behavior

		froska.voice();

		froska.set_emotion("Surprised");

		froska.voice();

		froska.set_emotion("Kind");

		froska.voice();
	}
}


//Mood interface describes mood states

interface Mood
{
	public void voice();
}


//Angry cat, implements Mood

class Angry implements Mood
{
	@Override
	public void voice()
	{
		System.out.println("FSSSSSS!!!!!!");
	}
}


//Surprised cat, implements Mood

class Surprised implements Mood
{
	@Override
	public void voice()
	{
		System.out.println("Myau??");
	}
}


//Kind cat, implements Mood

class Kind implements Mood
{
	@Override
	public void voice()
	{
		System.out.println("Mr-Mr-Mr-Mr...");
	}
}


//FroskaTheCat, out context class

class FroskaTheCat
{
	//Mood for it's mood

	Mood mood;

	//String for emotion

	String emotion;

	public FroskaTheCat(String emotion)
	{
		//Constructor

		this.emotion = emotion;

		//Setting mood according to emotion

		this.set_mood();
	}

	public void set_emotion(String emotion)
	{
		//Setting new emotion and mood according it

		this.emotion = emotion;

		this.set_mood();
	}

	private void set_mood()
	{
		//Setting mood according to emotion

		if (this.emotion.equals("Angry"))
		{
			Angry engry = new Angry();

			mood = engry;
		} 
		else if (this.emotion.equals("Surprised"))
		{
			Surprised surprised = new Surprised();

			mood = surprised;
		}
		else if (this.emotion.equals("Kind"))
		{
			Kind kind = new Kind();

			mood = kind;
		}
	}

	public void voice()
	{
		//Give voice
		//According to the emotion of cat, it will give different voices,
		//because different mood objects will respond on voice method request

		mood.voice();
	}
}