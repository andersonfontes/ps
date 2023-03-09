package contas;

public class Conta {

	// atributos
	protected String cliente;
	protected double saldo;

	public Conta() {
		System.out.println("Agencia 0261");
	}

	// metodos
	protected void exibirSaldo() {
		System.out.println("Saldo: " + saldo);
	}

	void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$ " + valor);
	}

	void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ " + valor);

	}

	void transferir(Conta destino, double valor) {
		// saldo -= valor;
		this.sacar(valor);
		// destino.saldo += valor;
		destino.depositar(valor);
		System.out.println("Transferencia efetuada");
		System.out.println("Origem: " + this.cliente);
		System.out.println("Destino: " + destino.cliente);
		System.out.println("Valor transferido: R$ " + valor);

	}

	double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		return total;
	}
}
