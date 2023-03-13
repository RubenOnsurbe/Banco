package banco;

import java.util.Arrays;
import java.util.Scanner;

import libro.Libro;

public class banco {
	static Cliente[] clientes = new Cliente[0];
	static Cuenta[] cuentas = new Cuenta[0];
	public static void main(String[] args) {
		int opc=-1;
		while (opc!=0) {
			opc=mostrarMenu(opc);
			switch(opc) {
				case 1-> {
					clientes=crearCliente();
				}
				case 2-> {
					cuentas=crearCuenta();
				}
				case 3-> {
					mostrarCuentasClientes();
				}
				case 4-> {
					cuentas=IngresarDinero();
				}
				case 5-> {
					cuentas=SacarDinero();
				}
				case 6-> {
					consultaSaldo();
				}
				case 7-> {
					revision();
				}
				case 8-> {
					cuentas=cambiarComision();
				}
				case 0-> {
					return;
				}
				default ->{
					System.out.println("ERROR: Introduzca un numero en el rango del 0-8");
				}
			}
		}
		
	}
	static int mostrarMenu(int opc) {
	Scanner sc = new Scanner(System.in);
	System.out.println("\n-Bienvenido a su Banco-\n"
			+ "1. Nuevo Cliente\n"
			+ "2. Nueva Cuenta\n"
			+ "3. Listar clientes y cuentas\n"
			+ "4. Ingresar Dinero\n"
			+ "5. Sacar Dinero\n"
			+ "6. Consultar Saldo\n"
			+ "7. Revision mensual\n"
			+ "8. Cambiar comision mensual\n"
			+ "0. Salir");
	opc=sc.nextInt();
	return opc;
	}
	static Cliente[] crearCliente() {
			Scanner sc = new Scanner(System.in);
			int c=0;
			String n="", a="", d="", di="", t="";
			boolean sal=false;
			clientes=Arrays.copyOf(clientes, clientes.length+1);
			clientes[clientes.length-1] = new Cliente();
			System.out.println("Nombre: ");
			n=sc.nextLine();
			clientes[clientes.length-1].setNombre(n);
			System.out.println("Apellidos: ");
			a=sc.nextLine();
			clientes[clientes.length-1].setApellidos(a);
			while(sal==false) {
				c=0;
				System.out.println("DNI: ");
				d=sc.nextLine();
				for(int i=0; i<clientes.length;i++) {
					if(clientes[i].getDNI().equals(d)) {
						c++;
					}
				}
				if(c==1) {
					System.out.println("Este DNI ya se ha introducido.");
				}else {
					sal=true;
				}
			}
			
			clientes[clientes.length-1].setDNI(d);
			System.out.println("Direccion: ");
			di=sc.nextLine();
			clientes[clientes.length-1].setDireccion(di);
			System.out.println("Telefono: ");
			t=sc.nextLine();
			clientes[clientes.length-1].setTelefono(t);
			System.out.println("Cliente añadido");
			return clientes;
	}
	static Cuenta[] crearCuenta() {
		if(clientes.length<1) {
			System.out.println("No puedes crear una cuenta sin tener clientes.");
		}else {
			cuentas=Arrays.copyOf(cuentas, cuentas.length+1);
			Scanner sc = new Scanner(System.in);
			String dni_c="",dni2_c="";
			int opc=0;
			boolean dni_v=false;
			System.out.println("-TIPO DE CUENTA-"
					+ "\n1: Cuenta Corriente (CC)"
					+ "\n2: Cuenta Vivienda (CV)"
					+ "\n3: Fondo Inversiones (FI)");
			while (opc<1||opc>3) {
				opc=sc.nextInt();
				switch (opc) {
					case 1 ->{
						int opc1=0;
						int cliente1 = 0 , cliente2 = 0;
						cuentas[cuentas.length-1] = new CuentaCorriente();
						System.out.println("DNI de la persona:");
						dni_c=sc.next();				
						for (int i=0; i<clientes.length; i++) {
							if(clientes[i].getDNI().equals(dni_c)) {
								System.out.println("DNI valido.");
								cliente1=i;
							}
						}
						System.out.println("Quieres otra persona en la cuenta?"
								+ "\n1: Si"
								+ "\n2: No");
						opc1=sc.nextInt();
						if(opc1==1) {
							boolean sal=false;
							while (sal==false) {
								System.out.println("DNI de la persona:");
								dni2_c=sc.next();
								if(clientes[cliente1].getDNI().equals(dni2_c)){
									System.out.println("No puedes meter a la misma persona");
								}else {
									sal=true;
								}
							}
							for (int i=0; i<clientes.length; i++) {
								if(clientes[i].getDNI().equals(dni2_c)) {
									cliente2=i;
								}
							}
							cuentas[cuentas.length-1].setCliente(new Cliente[] {clientes[cliente1],clientes[cliente2]});
						}else {
							cuentas[cuentas.length-1].setCliente(new Cliente[] {clientes[cliente1]});
						}
					}
					case 2 ->{
						int opc2=0;
						int cliente1 = 0 , cliente2 = 0;
						cuentas[cuentas.length-1] = new CuentaVivienda();
						System.out.println("DNI de la persona:");
						dni_c=sc.next();				
						for (int i=0; i<clientes.length; i++) {
							if(clientes[i].getDNI().equals(dni_c)) {
								cliente1=i;
							}
						}
						System.out.println("Quieres otra persona en la cuenta?"
								+ "\n1: Si"
								+ "\n2: No");
						opc2=sc.nextInt();
						if(opc2==1) {
							boolean sal=false;
							while (sal==false) {
								System.out.println("DNI de la persona:");
								dni2_c=sc.next();
								if(clientes[cliente1].getDNI().equals(dni2_c)){
									System.out.println("No puedes meter a la misma persona");
								}else {
									sal=true;
								}
							}
							for (int i=0; i<clientes.length; i++) {
								if(clientes[i].getDNI().equals(dni2_c)) {
									System.out.println("DNI valido.");
									cliente2=i;
								}
							}
							
							cuentas[cuentas.length-1].setCliente(new Cliente[] {clientes[cliente1],clientes[cliente2]});
						}else {
							cuentas[cuentas.length-1].setCliente(new Cliente[] {clientes[cliente1]});
						}
						
						
					}
					case 3 ->{
						System.out.println("DNI de la persona:");
						dni_c=sc.next();
						int opc3=0;
						int cliente1 = 0 , cliente2 = 0;
						cuentas[cuentas.length-1] = new FondoInversiones();
						for (int i=0; i<clientes.length; i++) {
							if(clientes[i].getDNI().equals(dni_c)) {
								cliente1=i;
							}
						}
						System.out.println("Quieres otra persona en la cuenta?"
								+ "\n1: Si"
								+ "\n2: No");
						opc3=sc.nextInt();
						if(opc3==1) {
							boolean sal=false;
							while (sal==false) {
								System.out.println("DNI de la persona:");
								dni2_c=sc.next();
								if(clientes[cliente1].getDNI().equals(dni2_c)){
									System.out.println("No puedes meter a la misma persona PEDRO");
								}else {
									sal=true;
								}
							}
							for (int i=0; i<clientes.length; i++) {
								if(clientes[i].getDNI().equals(dni2_c)) {
									System.out.println("DNI valido.");
									cliente2=i;
								}
							}
							
							cuentas[cuentas.length-1].setCliente(new Cliente[] {clientes[cliente1],clientes[cliente2]});
						}else {
							cuentas[cuentas.length-1].setCliente(new Cliente[] {clientes[cliente1]});
						}
						
						
					}
				}
				System.out.println("COD de cuenta: "+cuentas[cuentas.length-1].getNum_cuenta());
				System.out.println("Saldo de la cuenta: "+cuentas[cuentas.length-1].getSaldo());
				System.out.println("Cuenta creada");
		}
		
		}
		
		return cuentas;
	
		
	}
	static void mostrarCuentasClientes() {
		if(clientes.length<1) {
			System.out.println("No te puedo enseñar clientes ya que no hay ninguno");
		}else {
			System.out.println("\n_________________________________________________________________\nClientes:");
			for (int i=0; i<clientes.length;i++) {
				System.out.println(clientes[i].toString());
			}
		}
		if(cuentas.length<1) {
			System.out.println("No te puedo enseñar las cuentas ya que no hay ninguna creada");
		}else {
			System.out.println("\n_________________________________________________________________\nCuentas:");
			for (int i=0; i<cuentas.length;i++) {
				System.out.println(cuentas[i].toString());
			}
		}
		
		System.out.println("\n_________________________________________________________________");
	}
	private static Cuenta[] IngresarDinero() {
		if(cuentas.length<1) {
			System.out.println("No puedes ingresar dinero ya que no hay ninuna cuenta creada");
		}else {
			Scanner sc = new Scanner(System.in);
			boolean nc_v=false;
			long nc_c=0;
			double saldo_c=0;
			int pos=0,c=0;
			boolean sal=false,sal2=false;
			while (sal==false) {
				System.out.println("Numero de cuenta: ");
				nc_c=sc.nextLong();
				for(int i=0; i<cuentas.length;i++) {
					if(cuentas[i].getNum_cuenta()==nc_c) {
						sal=true;
					}else{
						c++;
					}
				}
				if(c==cuentas.length+1) {
					System.out.println("Numero de cuenta mal introducido");
				}
			}
			while(sal2==false) {
				System.out.println("Cuanto dinero quieres ingresar:");
				saldo_c=sc.nextDouble();
				if(saldo_c<=0){
					System.out.println("No puedes ingresar un numero negativo de dinero");
				}else {
					sal2=true;
				}
			}
			
			for (int i=0; i<cuentas.length; i++) {
				if(cuentas[i].getNum_cuenta()==nc_c) {
					cuentas[i].setSaldo(cuentas[i].getSaldo()+saldo_c);
					pos=i;
				}
			}
			System.out.println("Nuevo saldo de la cuenta: "+nc_c+" es de: "+cuentas[pos].getSaldo()+"€");
		}
		return cuentas;
	}
	private static Cuenta[] SacarDinero() {
		if(cuentas.length<1) {
			System.out.println("No puedes sacar dinero ya que no hay ninuna cuenta creada");
		}else {
			Scanner sc = new Scanner(System.in);
			boolean nc_v=false;
			long nc_c=0;
			double saldo_c=0, sald_a=0;
			int pos=0,c=0;
			boolean sal=false,sal2=false;
			while (sal==false) {
				System.out.println("Numero de cuenta: ");
				nc_c=sc.nextLong();
				for(int i=0; i<cuentas.length;i++) {
					if(cuentas[i].getNum_cuenta()==nc_c) {
						sal=true;
					}else{
						c++;
					}
				}
				if(c==cuentas.length+1) {
					System.out.println("Numero de cuenta mal introducido");
				}
			}
			while(sal2==false) {
				System.out.println("Cuanto dinero quieres sacar:");
				saldo_c=sc.nextDouble();
				if(saldo_c<=0){
					System.out.println("No puedes sacar un numero negativo o 0 de dinero");
				}else {
					sal2=true;
				}
			}
			for (int i=0; i<cuentas.length; i++) {
				if(cuentas[i].getNum_cuenta()==nc_c) {
					if(cuentas[i].getTipoCuenta().equals("CV")) {
						System.out.println("No se puede sacar dinero de esta cuenta");
					}else if(cuentas[i].getTipoCuenta().equals("CC")){
						if(cuentas[i].getSaldo()>=0){
							sald_a=cuentas[i].getSaldo();
							double sald_t=sald_a-saldo_c;
							if(sald_t<0) {
								System.out.println("No puedes sacar tanto dinero ya que tu cuenta no se puede quedar en negativo");
							}else {
								cuentas[i].setSaldo(cuentas[i].getSaldo()-saldo_c);
								System.out.println("Nuevo saldo de la cuenta: "+nc_c+" es de: "+cuentas[i].getSaldo()+"€");
							}
						}else {
							System.out.println("No ha sido posible ya que su cuenta no puede tener saldo negativo");
						}
					}else if(cuentas[i].getTipoCuenta().equals("FI")) {
						if(cuentas[i].getSaldo()>=(-500)) {
							sald_a=cuentas[i].getSaldo();
							double sald_t=sald_a-saldo_c;
							if(sald_t<(-500)) {
								System.out.println("No sacar tanto dinero ya que tu cuenta no se puede tener un saldo en negativo mayor que 500");
							}else {
								cuentas[i].setSaldo(cuentas[i].getSaldo()-saldo_c);
								System.out.println("Nuevo saldo de la cuenta: "+nc_c+" es de: "+cuentas[i].getSaldo()+"€");
							}
						}else {
							System.out.println("No ha sido posible ya que su cuenta ya que no puede tener menos de 500€ en negativo");
						}
					}
				}
			}
		}
		return cuentas;
	}
	private static void consultaSaldo() {
		if(cuentas.length<1) {
			System.out.println("No te puedo enseñar el saldo de ninguna cuenta ya que no hay ninguna creada");
		}else {
			Scanner sc = new Scanner(System.in);
			long nc_c=0,c=0;
			boolean sal=false;
			while (sal==false) {
				System.out.println("Numero de cuenta: ");
				nc_c=sc.nextLong();
				for(int i=0; i<cuentas.length;i++) {
					if(cuentas[i].getNum_cuenta()==nc_c) {
						sal=true;
					}else{
						c++;
					}
				}
				if(c==cuentas.length+1) {
					System.out.println("Numero de cuenta mal introducido");
				}
			}
			for (int i=0; i<cuentas.length; i++) {
				if(cuentas[i].getNum_cuenta()==nc_c) {
					System.out.println("El saldo de la cuenta:"+nc_c+" es de:"+cuentas[i].getSaldo());
				}
			}
		}
	}
	private static void revision() {
		if(cuentas.length<1) {
			System.out.println("No puedes hacer la revision de ninguna cuenta ya que no hay ninguna creada");
		}else {
			Scanner sc = new Scanner(System.in);
			long nc_c=0,c=0;
			boolean sal=false;
			while (sal==false) {
				System.out.println("Numero de cuenta: ");
				nc_c=sc.nextLong();
				for(int i=0; i<cuentas.length;i++) {
					if(cuentas[i].getNum_cuenta()==nc_c) {
						sal=true;
					}else{
						c++;
					}
				}
				if(c==cuentas.length+1) {
					System.out.println("Numero de cuenta mal introducido");
				}
			}
			for (int i=0; i<cuentas.length; i++) {
				if(cuentas[i].getNum_cuenta()==nc_c) {
					if((cuentas[i].revisionSaldo()<(-500))&&cuentas[i].getTipoCuenta().equals("FI")) {
						cuentas[i].setSaldo(-500);
						System.out.println("La revision mensual es de: "+cuentas[i].getSaldo());
					}else if((cuentas[i].revisionSaldo()<0)&&cuentas[i].getTipoCuenta().equals("CC")) {
						cuentas[i].setSaldo(0);
						System.out.println("La revision mensual es de: "+cuentas[i].getSaldo());
					}
				}			
			}
		}
	}
		
	private static Cuenta[] cambiarComision() {
		
		if(cuentas.length<1) {
			System.out.println("No puedes cambiar la comision de nunguna cuenta ya que no hay ninguna creada");
		}else {
			Scanner sc = new Scanner(System.in);
			long nc_c=0, cm_c=-1;
			int pos=0,c=0;
			boolean sal=false;
			while (sal==false) {
				System.out.println("Numero de cuenta: ");
				nc_c=sc.nextLong();
				for(int i=0; i<cuentas.length;i++) {
					if(cuentas[i].getNum_cuenta()==nc_c) {
						sal=true;
					}else{
						c++;
					}
				}
				if(c==cuentas.length+1) {
					System.out.println("Numero de cuenta mal introducido");
				}
			}
			while(cm_c<0) {
				System.out.println("Nueva comision Mensual: ");
				cm_c=sc.nextLong();
				if(cm_c<0) {
					System.out.println("No puedes poner una comision mensual menor que 0");
				}
			}
			for (int i=0; i<cuentas.length; i++) {
				if(cuentas[i].getNum_cuenta()==nc_c) {
					cuentas[i].setComisionMensual(cm_c);
					pos=i;
				}
			}
			System.out.println("La nueva comision mensual de la cuenta: "+nc_c+" es de: "+cuentas[pos].getComisionMensual()+".");
		}
		return cuentas;
	}

}
