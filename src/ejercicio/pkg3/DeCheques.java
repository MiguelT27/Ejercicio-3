/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg3;


/**
 *
 * @author MiguelAngel
 */
public class DeCheques extends Cuenta{
    
    private double ComUsoChe;
    private double ComEmiCheSalIns;
    
    public DeCheques(String nC, double s) {
        super(nC, s);
        this.ComUsoChe = 1;
        this.ComEmiCheSalIns = 2;
    }
   
    @Override
    public void consultarDatos() {
        System.out.println("\n        TITULAR:\t"+this.nombreCliente);
        System.out.println("        TIPO DE CUENTA:\tCuenta de Cheques");
        System.out.println("        NUMERO DE CUENTA:\t"+this.noCuenta);
        System.out.println("        SALDO:\t"+this.saldo);
        System.out.println("        COMISION USO CHEQUERA:\t"+this.ComUsoChe);
        System.out.println("        COMISION EMISION CHEQUE CON SALDO INSUFICIENTE:\t"+this.ComEmiCheSalIns);
    } 
    
    @Override
    public void Retirar (int cantidad){
        super.Retirar(cantidad);
        System.out.print("\t¿CUANTOS CHEQUES A UTILIZADO ESTE MES?");
        int noChequesUtilizados = lectura.nextInt();
        
        if(noChequesUtilizados > 0){
            this.saldo-= (this.ComUsoChe*noChequesUtilizados);
            System.out.println("\tSE HA DESCONTADO $ "+(this.ComUsoChe*noChequesUtilizados)+" POR LOS CHEQUES UTILIZADOS EN ESTE MES.");
        }
        System.out.println("\tSE HA ENCONTRADO QUE TODOS LOS CHEQUES EMITIDOS HAN SIDO CON SALDO INSUFICIENTE.");
        this.saldo-= (this.ComEmiCheSalIns* noChequesUtilizados);
        System.out.println("\tSE HA DESCONTADO $ "+(this.ComEmiCheSalIns*noChequesUtilizados)+" POR LOS CHEQUES EMITIDOS SIN SALDO SUFICIENTE EN ESTE MES.");
        System.out.println("\tSU SALDO ACTUAL: $ "+this.saldo);
        
        
    }
}
