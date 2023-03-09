package poo;

public class Cessna {

	public static void main(String[] args) {
		Aviao cessna = new Aviao();
		cessna.ano=2022;
		cessna.cor="branco";
		cessna.envergadura=11;
		System.out.println(" aviao: Cessna");
		System.out.println("cor = "+ cessna.cor);
		System.out.println("ano ="+ cessna.ano);
		System.out.println("envergadura: "+cessna.envergadura + "m");
		cessna.acelerar();

	}

}
