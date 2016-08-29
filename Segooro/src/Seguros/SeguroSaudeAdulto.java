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
public class SeguroSaudeAdulto extends SeguroSaude implements Serializable
{
    private static final double precoBase = 150;

    public SeguroSaudeAdulto(double precoInicial) 
    {
        super(precoInicial);
        setTipo(TipoSeguro.Saude_Adulto);
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
    {   //no caso do seguro de saude adulto nao existe limite para as despesas de saude ou seja 
        //deduzimos que o reembolso seria feito a partir da totalidade das despesas apresentadas
        double total=0;
        for(Despesas d: getDespesasDoTitular())
        {
             total= total+d.getValor();
        }
        
        return total*getTaxadereembolso();
    }

     /*------------------------------------------get´s e set's----------------------------------------------*/

    /**
     * @return the precoBase
     */
    public static double getPrecoBase() {
        return precoBase;
    }


    
    
    

    
}
