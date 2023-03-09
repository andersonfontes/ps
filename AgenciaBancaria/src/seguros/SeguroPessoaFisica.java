package seguros;

import contas.Conta;

public class SeguroPessoaFisica extends Conta{

	public static void main(String[] args) {
		SeguroPessoaFisica cc3 = new SeguroPessoaFisica();
		cc3.cliente = "Robson Xablau";
		cc3.saldo = 123432;
		System.out.println("Cliente: " + cc3.cliente);
		cc3.exibirSaldo();
		System.out.println("-----------------");

	}
}
