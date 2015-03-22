package circuits;

public class Vanne extends Composant
{
	private static final long serialVersionUID = 7526471155622776149L;
	protected Composant in;
	
	public void setIn(Composant comp)
	{	
		in = comp;	
	}

	public boolean getEtat() throws NonConnecteException
	{
		if(in == null)
			throw new NonConnecteException();
		else
			return in.getEtat();
	}

	public String description()
	{
		return getId() + " in: " + in.getId();
	}
}
