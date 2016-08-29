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
public abstract class SeguroVeiculo extends Seguro implements Serializable
{
    private static final double taxadereducao = 0.03;
    private static final double taxadeagravamento = 0.05;
    
    private Boolean teveacidente = null;

    public SeguroVeiculo(double precoInicial) 
    {
        super(precoInicial);
    }

    @Override
    public String toString() 
    {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double Reembolso() 
    {
        if(getTeveacidente()==null)
            return getPrecoInicial();
        if(getTeveacidente()==false)
        {
            return getPrecoInicial()*getTaxadereducao();
        }
        if(getTeveacidente()==true)
            return getPrecoInicial()*getTaxadeagravamento();
        return 0;
    }


    
        
    /*------------------------------------------get´s e set's----------------------------------------------*/


    /**
     * @return the taxadereducao
     */
    public static double getTaxadereducao() {
        return taxadereducao;
    }

    /**
     * @return the taxadeagravamento
     */
    public static double getTaxadeagravamento() {
        return taxadeagravamento;
    }

    /**
     * @return the teveacidente
     */
    public Boolean getTeveacidente() {
        return teveacidente;
    }

    /**
     * @param teveacidente the teveacidente to set
     */
    public void setTeveacidente(Boolean teveacidente) {
        this.teveacidente = teveacidente;
    }
    
    
    
    
    
    
    
}
