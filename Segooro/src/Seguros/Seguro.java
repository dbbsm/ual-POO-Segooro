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
public abstract class Seguro implements Serializable 
{
    private double precoInicial;
    private int seguroID;
    private static int ultimoseguroID=0;
    private static final double taxacancelamento = 0.2;
    private TipoSeguro tipo;
    
    public abstract double Reembolso();
    
    
    public Seguro(double precoInicial) 
    {
        this.precoInicial = precoInicial;
        ultimoseguroID++;
        setSeguroID(getUltimoseguroID());
    }
    //metodo para digitar no ecra o seguro e os seus atributos
    public String toString()
    {
        return "\nSeguro nº: "+getSeguroID()+"\nTipo de Seguro: "+getTipo()+
                "\nCusto: "+getPrecoInicial();
    }
    //metodo que retorna o valor a pagar ao criar o seguro
    public double ValorApagar()
    {
        return getPrecoInicial();
    }
    
    public double Cancelamento()
    {
        return getPrecoInicial()*getTaxacancelamento();
    }
    

    
    
    
/*------------------------------------------get´s e set's----------------------------------------------*/


    /**
     * @return the ultimoseguroID
     */
    public static int getUltimoseguroID() {
        return ultimoseguroID;
    }

    /**
     * @param aUltimoseguroID the ultimoseguroID to set
     */
    public static void setUltimoseguroID(int aUltimoseguroID) {
        ultimoseguroID = aUltimoseguroID;
    }


    /**
     * @return the precoInicial
     */
    public double getPrecoInicial() {
        return precoInicial;
    }

    /**
     * @param precoInicial the precoInicial to set
     */
    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }

    /**
     * @return the seguroID
     */
    public int getSeguroID() {
        return seguroID;
    }

    /**
     * @param seguroID the seguroID to set
     */
    public void setSeguroID(int seguroID) {
        this.seguroID = seguroID;
    }

    /**
     * @return the tipo
     */
    public TipoSeguro getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoSeguro tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the taxacancelamento
     */
    public static double getTaxacancelamento() {
        return taxacancelamento;
    }
    
    
    
}
