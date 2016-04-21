/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg3;
import java.util.*;

/**
 *
 * @author MiguelAngel
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("************ BANCO DE COLOMBIA ************");
        System.out.println("*******************************************");
        ArrayList<Cuenta> listaGeneral = new ArrayList<>();
        Cuenta cuentaDePruebaA, cuentaDePruebaC;
        int respuesta;
        String nombreTitular;
        int saldo, noCuenta, cantidad;
        do {            
            System.out.println("\n\t OPCIONES");
            System.out.println("\n\t1) CREAR CUENTA.");
            System.out.println("\t2) CONSULTAR DATOS DE SU CUENTA.");
            System.out.println("\t3) DEPOSITAR DINERO");
            System.out.println("\t4) RETIRAR DINERO");
            System.out.print("\n\tSeleccione una opcion: ");
            respuesta = lectura.nextInt();
            switch(respuesta){
                case 1:
                    System.out.println("*******************************************");
                    System.out.println("************* CREAR SU CUENTA *************");
                    System.out.println("*******************************************");
                    System.out.println("\n\t¿QUE TIPO DE CUENTA DESEA?");
                    System.out.println("\t1) CUENTA DE AHORROS.");
                    System.out.println("\t2) CUENTA DE CHEQUES.");
                    System.out.print("\n\tSeleccione una opcion: ");
                    respuesta = lectura.nextInt();
                    switch (respuesta){
                        case 1:
                            System.out.print("\n\tIngrese el nombre del titular:");
                            nombreTitular = lectura.next();
                            System.out.print("\tIngrese el saldo inicial: ");
                            saldo = lectura.nextInt();
                            cuentaDePruebaA = new DeAhorros(nombreTitular, saldo);
                            listaGeneral.add(cuentaDePruebaA);
                            break;
                        case 2:
                            System.out.print("\n\tIngrese el nombre del titular:");
                            nombreTitular = lectura.next();
                            System.out.print("\tIngrese el saldo inicial: ");
                            saldo = lectura.nextInt();
                            cuentaDePruebaC = new DeCheques(nombreTitular, saldo);
                            listaGeneral.add(cuentaDePruebaC);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("*******************************************");
                    System.out.println("************* CONSULTAR DATOS *************");
                    System.out.println("*******************************************");
                    System.out.println("\n\t PARAMETROS DE BUSQUEDA");
                    System.out.println("\t1) NUMERO DE CUENTA");
                    System.out.println("\t2) NOMBRE DEL TITULAR");
                    System.out.print("\n\tSeleccione una opcion: ");
                    respuesta = lectura.nextInt();
                    switch (respuesta){
                        case 1:
                            System.out.print("\n\tIngrese el Numero de la Cuenta:");
                            noCuenta = lectura.nextInt();
                            for (Cuenta cuenta : listaGeneral) {
                                if (cuenta.noCuenta == noCuenta){
                                    cuenta.consultarDatos();
                                }
                            }
                            break;
                        case 2:
                            System.out.print("\n\tIngrese el Nombre del Titular:");
                            nombreTitular = lectura.next(); 
                            for (Cuenta cuenta : listaGeneral) {
                                if (cuenta.nombreCliente.equals(nombreTitular)){
                                    cuenta.consultarDatos();
                                }
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("********************************************");
                    System.out.println("************* DEPOSITAR DINERO *************");
                    System.out.println("********************************************");
                    System.out.print("\n\tIngrese el Numero de la Cuenta en la cual desea hacer el deposito:");
                    noCuenta = lectura.nextInt();
                    for (Cuenta cuenta : listaGeneral) {
                        if (cuenta.noCuenta == noCuenta){
                            System.out.print("\n\tIngrese la cantidad a depositar:");
                            cantidad = lectura.nextInt();
                            cuenta.Depositar(cantidad);
                        }
                    }
                    break;
                case 4:
                    System.out.println("********************************************");
                    System.out.println("************** RETIRAR DINERO **************");
                    System.out.println("********************************************");
                    System.out.print("\n\tIngrese el Numero de la Cuenta en la cual desea hacer el retiro:");
                    noCuenta = lectura.nextInt();
                    for (Cuenta cuenta : listaGeneral) {
                        if (cuenta.noCuenta == noCuenta){
                            System.out.print("\n\tIngrese la cantidad a retirar:");
                            cantidad = lectura.nextInt();
                            cuenta.Retirar(cantidad);
                        }
                    }
                    break;
            }
        } while (respuesta == 1 || respuesta == 2);
    }
}
