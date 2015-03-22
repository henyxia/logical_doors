package circuits;

import java.util.Scanner;

public class Sonde extends Composant
{
	private static final long serialVersionUID = 7526470155622776147L;

	private String connector;
	private Composant cmp;

	public Sonde(Composant c, String con)
	{
		connector = con;
		cmp = c;
	}

	public boolean getEtat()
	{
		System.out.println(connector + " de " + cmp.description() + ", true ou false ?");
		Scanner ob = new Scanner(System.in);
		String ret = ob.nextLine();
		if(ret.equals("true"))
			return true;
		else if(ret.equals("false"))
			return false;
		else
			return getEtat();
	}
}
