/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguros;

import Extra.Despesas;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Diogo,Tomas e Fernando
 */
public abstract class SeguroSaude extends Seguro implements Serializable
{
    private static final double taxadereembolso=0.3;
    
    public ArrayList<Despesas> DespesasDoTitular;

    public SeguroSaude(double precoInicial) 
    {
        super(precoInicial);
        //criacao de um array de despesas ao criar um seguro de saude
        DespesasDoTitular = new ArrayList<Despesas>();
    }

    @Override
    public String toString()
    {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean adicionarDespesas(String descricao,double valor)
    {
        DespesasDoTitular.add(new Despesas(descricao,valor));
        return true;
    }
    
    
    
    
    /*------------------------------------------get´s e set's----------------------------------------------*/


    /**
     * @return the taxadereembolso
     */
    public static double getTaxadereembolso() {
        return taxadereembolso;
    }

    /**
     * @return the DespesasDoTitular
     */
    public ArrayList<Despesas> getDespesasDoTitular() {
        return DespesasDoTitular;
    }

    /**
     * @param DespesasDoTitular the DespesasDoTitular to set
     */
    public void setDespesasDoTitular(ArrayList<Despesas> DespesasDoTitular) {
        this.DespesasDoTitular = DespesasDoTitular;
    }
    
    
    
    
    
    
    
}
