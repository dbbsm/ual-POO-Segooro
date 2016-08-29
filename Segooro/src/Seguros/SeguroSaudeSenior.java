/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguros;

import Extra.Despesas;
import java.io.Serializable;

/**
 *
 * @author Diogo,Tomas e Fernando
 */
public class SeguroSaudeSenior extends SeguroSaude implements Serializable
{
    private static final double precoBase=150;
    
    private static final int maxDespesas=5000;

    public SeguroSaudeSenior(double precoInicial) 
    {
        super(precoInicial);
        setTipo(TipoSeguro.Saude_Senior);
    }

    @Override
    public String toString() 
    {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double ValorApagar() 
    {
        return super.ValorApagar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double Reembolso() 
    {   //no caso do seguro de saude o senior o limite aumenta para o dobro mas o calculo e feito 
        //com o mesmo principio alterando o maximo das despesas
        double total=0;
        for(Despesas d: getDespesasDoTitular())
        {
             total= total+d.getValor();
        }
        
        if(total<=maxDespesas)
        {
            return total*getTaxadereembolso();
        }
        
        else
            return maxDespesas*getTaxadereembolso();
    }
    
    
    
    
    
    
    
    

    
    /*------------------------------------------get´s e set's----------------------------------------------*/

    /**
     * @return the precoBase
     */
    public static double getPrecoBase() {
        return precoBase;
    }
    
    
    
}
