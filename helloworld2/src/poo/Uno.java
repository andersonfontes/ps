package poo;

public class Uno {

	public static void main(String[] args) {
		Carro uno = new Carro(2000, "prata");

		System.out.println(" ccarro: uno");
		System.out.println("ano = " + uno.ano);
		System.out.println("cor = " + uno.cor);
		uno.ligar();
		uno.acelerar();
		uno.desligar();
	}

}
