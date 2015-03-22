package circuits;

public class Not extends Porte
{
	private static final long serialVersionUID = 7526471155522776147L;
	protected Composant in;
	
	public void setIn(Composant comp)
	{
		in = comp;	
	}

	public Composant getIn()
	{
		return in;
	}

	public boolean getEtat() throws NonConnecteException
	{
		if(in == null)
			throw new NonConnecteException();
		else
			return !in.getEtat();
	}

	public String description()
	{
		return getId() + " in: " + (in == null ? "Non connecté" : in.getId());
	}
}
