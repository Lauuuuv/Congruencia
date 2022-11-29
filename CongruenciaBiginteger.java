import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Congruencia {

	public static <BigInteger> void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigInteger comparacion = new BigInteger("-1");
		BigInteger valorA;
		BigInteger valorB = null;
		BigInteger valorModulo = null;

		int opción= -1;
		while(opción!=0) {

			String mensaje= JOptionPane.showInputDialog("MENÚ\n"
					+ "1.Ingresar datos \n"
					+ "0.Salir."  + "\n");
			try {
				opción=Integer.parseInt(mensaje);

				switch (opción) {

				case 1: 

					valorA = new BigInteger(JOptionPane.showInputDialog("Ingrese el valor de a."));
					if (valorA.compareTo(comparacion) > 0) {
						valorB = new BigInteger(JOptionPane.showInputDialog("Ingrese el valor de b."));
						if (valorB.compareTo(comparacion) > 0) {
							valorModulo = new BigInteger(JOptionPane.showInputDialog("Ingrese el valor del módulo."));
							while (valorModulo.compareTo(comparacion) < 0 ) {
								valorModulo = new BigInteger(JOptionPane.showInputDialog("Ingrese un valor positivo para el módulo."));
							}
						}
					}
					else {
						mostrarInformacionError("ERROR");
					}
					
				    BigInteger residuo2 = valorB.mod(valorModulo);
					BigInteger residuo1 = valorA.mod(valorModulo);
					BigInteger resta = new BigInteger(valorA.subtract(valorB).toString());
					
					if (resta.mod(valorModulo).compareTo(BigInteger.ZERO) > 0 ) {
						mostrarMensaje("La diferencia entre a y b NO da como resultado un múltiplo del módulo  " + valorModulo + "\n");
					} else {
						mostrarMensaje("La diferencia entre a y b da como resultado un múltiplo del módulo  " + valorModulo + "\n");
					}
					if (residuo1 == residuo2) {
						mostrarMensaje("Los números ingresados son congruentes con el módulo ingresado" + "\n");

					} else {
						mostrarMensaje("Los números ingresados" +
								"" +
								"" +
								" NO son congruentes con el módulo ingresado" + "\n");

					}
					
					break;

				case 0: 

					mostrarMensaje("Vuelva pronto");
					break;

				default: mostrarInformacionError("ERROR, ingrese una opción válida.");
				break;
				}

			}catch(Exception e) {
				mostrarMensaje("ERROR, ingrese una opción válida.");
			}
		}
	
	}

	public static void mostrarMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public static void mostrarInformacionError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error" , JOptionPane.ERROR_MESSAGE);
	}
	
}
