public class TestCircuits
{
	private static void traceEtats(Composant[] cps)
	{
		for(int i=0; i<cps.length; i++)
		{
			System.out.println(cps[i].traceEtat());
		}
	}

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
		composants[1] = new Interrupteur();
		composants[2] = new Interrupteur();
		composants[3] = new Or();
		composants[4] = new Not();
		composants[5] = new And();
		composants[6] = new Vanne();

		//Connexions
		((Vanne)composants[6]).setIn(composants[5]);
		((And)composants[5]).setIn1(composants[3]);
		((And)composants[5]).setIn2(composants[4]);
		((Or)composants[3]).setIn1(composants[0]);
		((Or)composants[3]).setIn2(composants[1]);
		((Not)composants[4]).setIn(composants[2]);
		//((Not)composants[4]).setIn(new LazyProbe(composants[2], "in"));
		Circuit circuit = new Circuit("my cool circuit", composants);

		//Affichage
		System.out.println("Part list");
		printIds(composants);
		System.out.println("\nPart description");
		descCps(composants);
		System.out.println("\nState list");
		traceEtats(composants);
		System.out.println("\nCircuit description");
		circuit.description();
		System.out.println("\nBood bye!");
	}
}
