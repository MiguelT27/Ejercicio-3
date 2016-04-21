/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg3;


/**
 * 
 *
 * @author MiguelAngel
 */
public abstract class Cuenta {
    java.util.Scanner lectura = new java.util.Scanner(System.in);
    protected int noCuenta = 800;               //Profesor lo unico que no logre conseguir fue que cada vez que creara un objeto el Numero de cuenta fuera aumentando de uno en uno. Por lo tanto a todas las cuentas les asigna el mismo numero de cuenta.
    protected String nombreCliente;
    protected double saldo;
    public Cuenta(String nC, double s){
        noCuenta+=1;
        nombreCliente = nC;
        saldo = s;
    }
    public abstract void consultarDatos ();
    public void Depositar (int cantidad){
        this.saldo+=cantidad;
        System.out.println("\tTRANSACCION EXITOSA");
        System.out.println("\tSALDO ACTUAL: "+this.saldo);
    }
    public void Retirar (int cantidad){
        if(this.saldo < cantidad){
            System.out.println("FONDOS INSUFICIENTES");
        }else{
            this.saldo-=cantidad;
            System.out.println("\tTRANSACCION EXITOSA");
            System.out.println("\tSALDO ACTUAL: "+this.saldo);
        }  
    } 
}
