package banco;

public class CuentaCorriente extends Cuenta{
	
	public CuentaCorriente() {
		super( );
		this.setCliente(null);
		this.setComisionMensual(0.6);
		this.setInteresMensual(0.1);
		this.setTipoCuenta("CC");
	}
}
