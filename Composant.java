public abstract class Composant
{	
	public String getId()
	{	
		return super.toString(); // class@numero renvoye par Object	
	}

	public String description()
	{
		return getId();
	}

	public abstract boolean getEtat() throws NonConnecteException;

	public String traceEtat()
	{
			try
			{
				return getId() + (getEtat() ? " On" : " Off");
			}
			catch(NonConnecteException ex)
			{
				return getId() + " Un des composants n'est pas connecté";
			}
	}
}
