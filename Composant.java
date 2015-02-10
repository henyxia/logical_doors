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
}
