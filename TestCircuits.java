public class TestCircuits
{
	private static void printIds(Composant[] cps)
	{
		for(int i=0; i<cps.length; i++)
		{
			System.out.println(cps[i].getId());
		}
	}

	private static void descCps(Composant[] cps)
	{
		for(int i=0; i<cps.length; i++)
		{
			System.out.println(cps[i].description());
		}
	}


	public static void main(String[] args)
	{
		//Construction
		Composant []composants;
		composants = new Composant[7];
		composants[0] = new Interrupteur();
		composants[1] = (Interrupteur) new Interrupteur();
		composants[2] = (Interrupteur) new Interrupteur();
		composants[3] = (Or) new Or();
		composants[4] = (Not) new Not();
		composants[5] = (And) new And();
		composants[6] = new Vanne();

		//Connexions
		((Vanne)composants[6]).setIn(composants[5]);
		((And)composants[5]).setIn1(composants[3]);
		((And)composants[5]).setIn2(composants[4]);
		((Or)composants[3]).setIn1(composants[0]);
		((Or)composants[3]).setIn2(composants[1]);
		((Not)composants[4]).setIn(composants[2]);

		//Affichage
		System.out.println("Liste des composants");
		printIds(composants);
		System.out.println("Description des composants");
		descCps(composants);
		System.out.println("Au revoir!");
	}
}
