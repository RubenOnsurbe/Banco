package banco;

public class CuentaVivienda extends Cuenta {
	
	public CuentaVivienda() {
		super( );
		this.setCliente(null);
		this.setComisionMensual(0);
		this.setInteresMensual(0.2);
		this.setTipoCuenta("CV");
	}
	
}
