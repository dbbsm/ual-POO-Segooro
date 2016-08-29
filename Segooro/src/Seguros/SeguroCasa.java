/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguros;

import java.io.Serializable;

/**
 *
 * @author Diogo,Tomas e Fernando
 */
public class SeguroCasa extends Seguro implements Serializable
{
    private double recheio;
    private static final int maxRecheio = 10000;
    private static final double taxadereembolso = 0.5;
  

    public SeguroCasa(double recheio, double precoInicial) 
    {
        super(precoInicial);
        this.recheio = recheio;
        setTipo(TipoSeguro.Casa);
    }

    @Override
    public String toString() 
    {
        return super.toString()+"\nRecheio da Casa: "+getRecheio(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double ValorApagar() 
    {
        return super.ValorApagar(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public double Reembolso() 
    {
        if(getRecheio()<=getMaxRecheio())
            return getRecheio()*getTaxadereembolso();
        else
            return getMaxRecheio()*getTaxadereembolso();
    }
    
    
    
    
    
    /*------------------------------------------get´s e set's----------------------------------------------*/


    /**
     * @return the recheio
     */
    public double getRecheio() {
        return recheio;
    }

    /**
     * @param recheio the recheio to set
     */
    public void setRecheio(double recheio) {
        this.recheio = recheio;
    }

    /**
     * @return the maxRecheio
     */
    public static int getMaxRecheio() {
        return maxRecheio;
    }

    /**
     * @return the taxadereembolso
     */
    public static double getTaxadereembolso() {
        return taxadereembolso;
    }
    
    
    
    
    
}
