/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg3;
import java.util.Calendar;

/**
 *
 * @author MiguelAngel
 */
public class DeAhorros extends Cuenta{
    java.util.Scanner lectura = new java.util.Scanner(System.in);
    
    private Fecha fechaVen = new Fecha(28, 04, 2020);
    private double porcenIntMen;
    
    public DeAhorros(String nC, double s){
        super(nC, s);
        System.out.print("\tIngrese el porcentaje de interes mensual pactado:");
        this.porcenIntMen = lectura.nextDouble();
        
    }
    
    @Override
    public void consultarDatos() {
        System.out.println("\n        TITULAR:\t"+this.nombreCliente);
        System.out.println("        TIPO DE CUENTA:\tCuenta de Ahorros");
        System.out.println("        NUMERO DE CUENTA:\t"+this.noCuenta);
        System.out.println("        SALDO:\t"+this.saldo);
        System.out.print("        FECHA DE VENCIMIENTO:\t"+this.fechaVen.getDia()+"/"+this.fechaVen.getMes()+"/"+this.fechaVen.getYear());
        System.out.print("\n        PORCENTAJE DE INTERES MENSUAL:\t"+this.porcenIntMen*100);
        System.out.println("%\n");
    }
    @Override
    public void Depositar (int cantidad){
        super.Depositar(cantidad);
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DATE);
        if(dia == 1){
            this.saldo+= (this.saldo*this.porcenIntMen);
            System.out.println("\tSU INTERES MENSUAL SE HA TRANSFERIDO A SU SALDO POR UN VALOR DE "+ (this.saldo*this.porcenIntMen));
            System.out.println("\tSALDO ACTUAL: "+this.saldo);
        }
        
        
    }
    @Override
    public void Retirar (int cantidad){
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DATE);
        if(this.saldo >= cantidad && dia == fechaVen.getDia()){
            this.saldo-=cantidad;
            System.out.println("\tTRANSACCION EXITOSA");
            System.out.println("\tSALDO ACTUAL: "+this.saldo);
        }else{
            if(this.saldo < cantidad){
                System.out.println("FONDOS INSUFICIENTES");
            }
            if(dia != fechaVen.getDia()){
                System.out.print("SOLO LOS DIAS "+fechaVen.getDia());
                System.out.println(" DE CADA MES PODRA REALIZAR RETIROS");
            }
            
        }  
    } 
}
