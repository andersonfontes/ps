package contas;

public class PessoaFisica {

	public static void main(String[] args) {
		Conta cc1=new Conta();
		cc1.cliente="ANderson fontes";
		cc1.saldo=1200000;
		System.out.println("Cliente: " + cc1.cliente);
		cc1.exibirSaldo();
		cc1.sacar(1000);
		cc1.exibirSaldo();
		System.out.println("-----------------");
		Conta cc2=new Conta();
		cc2.cliente="maria silva";
		cc2.saldo=345;
		System.out.println("Cliente: " + cc2.cliente);
		cc2.exibirSaldo();
		cc2.depositar(2000);
		cc2.exibirSaldo();
		System.out.println("-----------------");
		
		cc1.transferir(cc2, 6666);
		
		System.out.println("-------------------");
		
		
		System.out.println("Cliente: " + cc1.cliente);
		cc1.exibirSaldo();		
		System.out.println("-----------------");		
		
		
		System.out.println("Cliente: " + cc2.cliente);
		cc2.exibirSaldo();		
		System.out.println("-----------------");
		System.out.println("Relatorio");
		Conta gerente = new Conta();
		double relatorio = gerente.soma(cc1.saldo,cc2.saldo);
		System.out.println("saldo total nas contas = " + relatorio);
		
	}
	




}
