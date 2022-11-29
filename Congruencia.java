import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Congruencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		encontrarCongruencias();

	}

	public static void encontrarCongruencias() {

		int opción= -1;
		while(opción!=0) {

			String mensaje= JOptionPane.showInputDialog("MENÚ\n"
					+ "1.Ingresar datos \n"
					+ "0.Salir."  + "\n");
			try {
				opción=Integer.parseInt(mensaje);

				switch (opción) {

				case 1: 

					validarCongruencia();

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


	public static int validarCongruencia() {

		int a = 0;
		int b = 0;
		int c = 0;
		int calcularCongruencia = 0;

		a = leerDatoEntero("Ingrese el valor de a.");
		if (a > 0) {
			b = leerDatoEntero("Ingrese el valor de b.");
			if (b > 0) {
				c = leerDatoEntero("Ingrese el valor del módulo (c).");
				while (c < 0) {
					c = leerDatoEntero("Opción inválida, ingrese un valor positivo para el módulo.");
				}
			}
		}
		else {
			mostrarInformacionError("ERROR");
		}
		int residuo2 = b % c;
		int residuo1 = a % c;
		int resta = a - b;

		if (resta % c == 0) {
			mostrarMensaje("La diferencia entre a y b da como resultado un múltiplo del módulo  " + c + "\n");
		} else {
			mostrarMensaje("La diferencia entre a y b NO da como resultado un múltiplo del módulo  " + c + "\n");
		}
		if (residuo1 == residuo2) {
			mostrarMensaje("Los números ingresados son congruentes con el módulo ingresado" + "\n");

		} else {
			mostrarMensaje("Los números ingresados NO son congruentes con el módulo ingresado" + "\n");

		}
		return calcularCongruencia;
	}


	public static int leerDatoEntero(String mensaje) {
		int dato =0;
		boolean condicion = false;
		while(condicion == false) {
			try {
				String aux = JOptionPane.showInputDialog(mensaje);
				dato = Integer.parseInt(aux);	
				condicion= true; 
			}
			catch (Exception e) {
				condicion = false;
			}
		}
		return dato;
	}

	public static int obtenerDato(String mensaje) {
		return Integer.parseInt(JOptionPane.showInputDialog(null, mensaje, "Obtención de información", 3));
	}

	public String leerDatoString(String mensaje) {
		String respuesta = JOptionPane.showInputDialog(mensaje);
		return respuesta;
	}

	public static void mostrarMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public static void mostrarInformacionError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error" , JOptionPane.ERROR_MESSAGE);

	}

}
