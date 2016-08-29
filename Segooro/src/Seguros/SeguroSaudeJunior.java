/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguros;

import Extra.Despesas;
import static Seguros.SeguroSaude.getTaxadereembolso;
import java.io.Serializable;

/**
 *
 * @author Diogo,Tomas e Fernando
 */
public class SeguroSaudeJunior extends SeguroSaude implements Serializable
{
    private static final double precoBase = 100;
    
    private static final int maxDespesas =2500;

    public SeguroSaudeJunior(double precoInicial) 
    {
        super(precoInicial);
        setTipo(TipoSeguro.Saude_Junior);
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
    {   //no caso do seguro de saude junior o maximo de despesas e de 2500 ou seja caso ultrapasse
        //esse limite o calculo de reembolso sera efectuado com base no maximo
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
    
    
    
    
    
    
    
    
    
}
