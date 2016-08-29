/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguros;

import Extra.CoberturaPassageiros;
import java.io.Serializable;

/**
 *
 * @author Diogo,Tomas e Fernando
 */
public class SeguroCarro extends SeguroVeiculo implements Serializable
{
    private static final int precoBase=250;
    private CoberturaPassageiros coberturaPassageiros;

    public SeguroCarro(CoberturaPassageiros coberturaPassageiros, double precoInicial) 
    {
        super(precoInicial);
        setCoberturaPassageiros(coberturaPassageiros);
        setTipo(TipoSeguro.Carro);
    }

    @Override
    public String toString() 
    {
        return super.toString()+"\nCobertura aos Passageiros: "+getCoberturaPassageiros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrecoInicial(double precoInicial) 
    {
        if(getCoberturaPassageiros()==CoberturaPassageiros.Sim)
            precoInicial+=50;
        else
            super.setPrecoInicial(precoInicial); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
     * @return the precoBase
     */
    public static int getPrecoBase() {
        return precoBase;
    }

    /**
     * @return the coberturaPassageiros
     */
    public CoberturaPassageiros getCoberturaPassageiros() {
        return coberturaPassageiros;
    }

    /**
     * @param coberturaPassageiros the coberturaPassageiros to set
     */
    public void setCoberturaPassageiros(CoberturaPassageiros coberturaPassageiros) {
        this.coberturaPassageiros = coberturaPassageiros;
    }

    /**
     * @return the coberturaPassageiros
     */

    
    
    
    
    
}
