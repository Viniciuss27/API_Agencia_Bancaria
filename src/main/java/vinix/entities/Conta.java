package vinix.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroConta;

    private Double saldo;
    
    private String cpf;

    @OneToOne
    private User user;

    public Conta() {}

    public Conta(Integer numeroConta, String cpf, Double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cpf = cpf;
    }

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void getSacar(Double valor) {
		if(valor > getSaldo()) {
		setSaldo(getSaldo() - valor);
		}else {
			System.out.println("valor indisponivel para saque");
		}
	}
	
	public void getDepositar(Double valor) {
		if(valor > 0) {
		setSaldo(getSaldo() - valor);
	    }else { 
	    	System.out.println("só pode depositar valor acima de R$ 0,0");
	    }
	}
	
	public void getTransferir(Double valor, Conta conta) {
		if(valor > 0 && conta.saldo >= valor) {
			setSaldo(getSaldo() - valor);
			conta.saldo = conta.getSaldo() + valor;
		}else {
			System.out.println("não pode transferir");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numeroConta, other.numeroConta);
	}
}
