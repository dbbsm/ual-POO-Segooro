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
public class SeguroMota extends SeguroVeiculo implements Serializable
{
    private static final int precoBase = 150;

    
    public SeguroMota(double precoInicial) 
    {
        super(precoInicial);
        setTipo(TipoSeguro.Mota);
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
     * @return the precoBase
     */
    public static int getPrecoBase() {
        return precoBase;
    }


    
    


    
    
    
    
    
    
}
