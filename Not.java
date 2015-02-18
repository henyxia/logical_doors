public class Not extends Porte
{	
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
			return !in.getEtat();
	}

	public String description()
	{
		return getId() + " in: " + (in == null ? "Non connecté" : in.getId());
	}
}
