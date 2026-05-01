package vinix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaApplication.class, args);
	}
	
/*
 static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog("****Selecione uma operação****" +
		
				"\n|   Opção 1 - criar conta" +
				"\n|   Opção 2 - Depositar" +
				"\n|   Opção 3 - Sacar" +
				"\n|   Opção 4 - Transferir" + 
				"\n|   Opção 5 - Listar" + 
				"\n|   Opção 6 - Sair"));

		switch (operacao) {
		case 1:
			criarConta();
			break;

		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Tchau, obrigado!!!");
			System.exit(0);

		default:
			JOptionPane.showMessageDialog(null, "Opção invalida");
			operacoes();
			break;
		}

	}

	public static void criarConta() {

		User p = new User(null, null, null);
		
		p.setName(JOptionPane.showInputDialog("Nome: "));
		
		p.setCpf(JOptionPane.showInputDialog("CPF: "));
		
		p.setEmail(JOptionPane.showInputDialog("Email: "));

		Conta conta = new Conta(p);
		contasBancarias.add(conta);

		JOptionPane.showMessageDialog(null,"sua conta foi criada com sucesso");
		operacoes();
	}

	private static Conta encontraConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta: "));

		Conta conta = encontraConta(numeroConta);

		if (conta != null) {
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor depositar: "));
			conta.getDepositar(valorDeposito);
		} else {
			JOptionPane.showMessageDialog(null, "Conta não encontrada !!!");
		}
		operacoes();
	}

	public static void sacar() {
		
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog(" Digite a conta que deseja sacar: "));

		Conta conta = encontraConta(numeroConta);

		if (conta != null) {
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog(" Digite o valor que deseja sacar: "));
			conta.getSacar(valorSaque);
		} else {
			JOptionPane.showMessageDialog(null, " Conta nâo encontrada !!!");
		}
		operacoes();
	}

	public static void transferir() {
		int envia = Integer.parseInt(JOptionPane.showInputDialog(" Conta que ira transferir: "));

		Conta contaEnvia = encontraConta(envia);

		if (contaEnvia != null) {
			int recebe = Integer.parseInt(JOptionPane.showInputDialog(" Conta que ira receber: "));

			Conta contaRecebe = encontraConta(recebe);
			if (contaRecebe != null) {
				Double valor = Double.parseDouble(JOptionPane.showInputDialog(" Qual valor da transferência: "));

				contaEnvia.getTransferir(valor, contaRecebe);
			} else {
				JOptionPane.showMessageDialog(null, " Conta não encontrada: ");
			}
		} else {
			JOptionPane.showMessageDialog(null, " Conta não encontrada: ");
		}
		operacoes();

	}

	public static void listar() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				JOptionPane.showMessageDialog(null, conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, " Não há contas cadastradas !!! ");
		}
		operacoes();
	} 
 */

}
