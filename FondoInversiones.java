package banco;

public class FondoInversiones extends Cuenta {
	
	public FondoInversiones() {
		super( );
		this.setCliente(null);
		this.setComisionMensual(0.6);
		this.setInteresMensual(0.34);
		this.setTipoCuenta("FI");
	}
	
}
