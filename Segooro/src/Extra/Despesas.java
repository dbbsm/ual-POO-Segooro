/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;

import java.io.Serializable;

/**
 *
 * @author Diogo,Tomas e Fernando
 */
public class Despesas implements Serializable
{
    private String Descricao;
    private double valor;

    //para criar uma nova despesa de saude
    public Despesas(String Descricao, double valor) 
    {
        this.Descricao = Descricao;
        this.valor = valor;
    }

    //metodo para escrever a despesa no ecra
    @Override
    public String toString() 
    {
        return "Descricao: "+getDescricao()+"\nValor: "+getValor()+"\n\n"; //To change body of generated methods, choose Tools | Templates.
    }
    


    
    /*------------------------------------------get´s e set's----------------------------------------------*/

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
    
}
