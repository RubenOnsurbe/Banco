package banco;

public class Cuenta {
	
	private long num_cuenta;
	private Cliente[] cliente= new Cliente[2];
	private double saldo, interesMensual, comisionMensual;
	private String tipoCuenta;
	
	
	Cuenta(){
		this.setNum_cuenta((long)(Math.random() * (9999999999L - 1000000000L + 1)));
		this.setSaldo(0);
		
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getInteresMensual() {
		return interesMensual;
	}

	public void setInteresMensual(double interesMensual) {
		this.interesMensual = interesMensual;
	}

	public double getComisionMensual() {
		return comisionMensual;
	}

	public void setComisionMensual(double comisionMensual) {
		this.comisionMensual = comisionMensual;
	}

	public long getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(long num_cuenta) {
		this.num_cuenta = num_cuenta;
	}

	public Cliente[] getCliente() {
		return cliente;
	}

	public void setCliente(Cliente[] cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double revisionSaldo() {
		return this.saldo=(this.saldo+((this.interesMensual*saldo)/100)-this.comisionMensual);
	}
	public String toString() {
		if (cliente.length<2) {
			return "_________________________________________________________________\nNumero de cuenta: "+getNum_cuenta()+"\nCliente 1:\n"+getCliente()[0].getNombre()+"\n_________________________________________________________________\nSaldo: "+getSaldo()+"€\nTipo de cuenta: "+getTipoCuenta()+"\nComision de cuenta: "+getComisionMensual()+"\nInteres de cuenta: "+getInteresMensual()+"%\n_________________________________________________________________";
		}else {
			return "_________________________________________________________________\nNumero de cuenta: "+getNum_cuenta()+"\nCliente 1:\n"+getCliente()[0].getNombre()+"\nCliente 2:\n"+getCliente()[1].getNombre()+"\n_________________________________________________________________\nSaldo: "+getSaldo()+"€\nTipo de cuenta: "+getTipoCuenta()+"\nComision de cuenta: "+getComisionMensual()+"\nInteres de cuenta: "+getInteresMensual()+"%\n_________________________________________________________________";
		}
	}
	
}
