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
public class SeguroVida extends Seguro implements Serializable
{
    //nome do familiar que recebe o dinheiro em caso do titular do seguro morrer
    private String nomeDoFamiliar; 
    //grau de parentesco do familiar que recebe o dinheiro em relacao ao titular
    private String grauParentesco;
    private static final double taxadereembolso= 0.15;

    public SeguroVida(String nomeDoFamiliar, String grauParentesco, double precoInicial) 
    {
        super(precoInicial);
        this.nomeDoFamiliar = nomeDoFamiliar;
        this.grauParentesco = grauParentesco;
        
        setTipo(TipoSeguro.Vida);
    }

    @Override
    public String toString() 
    {
        return super.toString()+"\nNome do Familiar: "+getNomeDoFamiliar()+
                "\nGrau de Parentesco: "+getGrauParentesco(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double ValorApagar() 
    {
        return super.ValorApagar(); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public double Reembolso() 
    {
        return getPrecoInicial()+getPrecoInicial()*getTaxadereembolso();
    }
    
    
       
    /*------------------------------------------get´s e set's----------------------------------------------*/

    /**
     * @return the taxadereembolso
     */
    public static double getTaxadereembolso() {
        return taxadereembolso;
    }
    

    /**
     * @return the nomeDoFamiliar
     */
    public String getNomeDoFamiliar() {
        return nomeDoFamiliar;
    }

    /**
     * @param nomeDoFamiliar the nomeDoFamiliar to set
     */
    public void setNomeDoFamiliar(String nomeDoFamiliar) {
        this.nomeDoFamiliar = nomeDoFamiliar;
    }

    /**
     * @return the grauParentesco
     */
    public String getGrauParentesco() {
        return grauParentesco;
    }

    /**
     * @param grauParentesco the grauParentesco to set
     */
    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
    
}
