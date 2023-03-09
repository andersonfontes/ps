package poo;

public class Fusca {

	public static void main(String[] args) {

		Carro fusca = new Carro();
		fusca.ano=1960;
		fusca.cor="azul";
		System.out.println(" ccarro: fusca");
		System.out.println("ano = "+fusca.ano);
		System.out.println("cor = "+fusca.cor);
		fusca.ligar();
		fusca.acelerar();
		fusca.desligar();
	}

}
