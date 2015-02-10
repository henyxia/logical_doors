public class Vanne extends Composant
{	
	protected Composant in;
	
	public void setIn(Composant comp)
	{	
		in = comp;	
	}

	public String description()
	{
		return getId() + " in: " + in.getId();
	}
}
