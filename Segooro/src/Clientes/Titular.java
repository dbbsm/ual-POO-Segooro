/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import Extra.CoberturaPassageiros;
import Seguros.*;
import Seguros.SeguroSaudeAdulto;
import Seguros.SeguroSaudeJunior;
import Seguros.SeguroSaudeSenior;
import Seguros.SeguroVida;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Diogo, Tomas e Fernando
 */
public class Titular implements Serializable
{
    private String nome;
    private String morada;
    private int idade;
    private Sexo sexo;
    private int IDtitular;
    private static int ultimoID=0;
    
    private boolean temSeguroVida;
    private boolean temSeguroCasa;
    private ArrayList<Seguro> SegurosDoTitular;
    private ArrayList<Seguro> SegurosCancelados;
    
    private static final int maxIDADEjunior = 16;
    private static final int maxIDADEadulto = 59;
    private static final int minIDADEadulto = 17;
    private static final int maxIDADEsenior = 80;
    private static final int minIDADEsenior = 60;
   

    public Titular(String nome, String morada, int idade, Sexo sexo) 
    {
        this.nome = nome;
        this.morada = morada;
        this.idade = idade;
        setSexo(sexo);
        ultimoID++;
        setIDtitular(getUltimoID());
        //inicia a variavel tem seguro de vida e de casa como false pois ainda nao foi adicionado
        //nenhum seguro
        setTemSeguroVida(false);
        setTemSeguroCasa(false);
        //cria o array de seguros de titular ao criar um titular novo
        SegurosDoTitular = new ArrayList<Seguro>();
        SegurosCancelados = new ArrayList<Seguro>();
                
    }
    
    //metodo para escrever no ecra os atributos do titular
    public String toString()
    {
        return "Titular nº: "+getIDtitular()+"\nNome: "+getNome()+"\nMorada: "+getMorada()+
                "\nIdade: "+getIdade()+"\nSexo: "+getSexo();
    }
    
    //metodo para acionar um seguro 
    public String AcionarSeguro(int seguroID)
    {
        //percorre os elementos do array e verifica se o id introduzido existe no array
        for(Seguro s : SegurosDoTitular)
        {   //se o o id existir no array retorna o reembolso do seguro
            if (seguroID == s.getSeguroID())
            {   //caso o seguro a ser accionado seja da casa este tem de ser eliminado
                if(s instanceof SeguroCasa)
                {
                    
                    SegurosDoTitular.remove(s);
                    setTemSeguroCasa(false);
                    SegurosCancelados.add(s);
                    return "Ao acionar este seguro da Casa, este vai ser eliminado e"
                            + " o seu reembolso e de: "+s.Reembolso();
                    
                }
                if(s instanceof SeguroVida)
                {
                    
                    SegurosDoTitular.remove(s);
                    setTemSeguroVida(false);
                    SegurosCancelados.add(s);
                    return "Ao acionar este seguro de Vida, este vai ser eliminado e"
                            + " o seu reembolso e de: "+s.Reembolso();
                }
                if(s instanceof SeguroVeiculo)
                {
                    SeguroVeiculo sv = (SeguroVeiculo) s;
                    sv.setTeveacidente(true);
                    SegurosDoTitular.remove(s);
                    SegurosCancelados.add(s);
                    return "Ao acionar este seguro de Vida, este vai ser eliminado e"
                            + " o seu reembolso e de: "+s.Reembolso();
                    
                }
                else
                    return "Ao acionar este seguro o seu reembolso e de: "+s.Reembolso();
                
             
            }
        }
        return "";
    }
    
    public double cancelarSeguro(int seguroID)
    {
        for(Seguro s : SegurosDoTitular)
        {
            if(seguroID==s.getSeguroID())
            {
                if( s instanceof SeguroVida)
                    setTemSeguroVida(false);
                if( s instanceof SeguroCasa)
                    setTemSeguroCasa(false);
                
                SegurosDoTitular.remove(s);
                SegurosCancelados.add(s);
                return s.Cancelamento();
            }
        }
        return 0;
    }
    
    //metodo para listar o titular e os respectivos seguros
    public String ListarSeguros()
    {
        String T ="";
        T+=this.toString();
        T+="\n---------Seguros---------";
        for (Seguro s : SegurosDoTitular)
        {
            T+="\n"+s.toString();
        }
        return T;
    }
    
    //metodo para para criar um seguro de vida
    public boolean criarSeguroVida(String familiar,String grau, double custo)
    {   //verifica se o titular ja tem um seguro de vida
        if(isTemSeguroVida()==false)
        {   //caso nao tenha adiciona um novo seguro de vida com os parametros introduzidos
            //e indica a variavel tem seguro de vida como true para o caso de tentar introduzir um novo
            SegurosDoTitular.add(new SeguroVida(familiar, grau, custo));
            setTemSeguroVida(true);
            return true;
        }
        //caso ja tenha um seguro de vida retorna false e nao adiciona
        else
            return false;
    }
    
    //metodo para criar um seguro de saude
    public boolean criarSeguroSaude(double precoInicial)
    {   //verifica que tipo de seguro de saude deve ser criado consoante a idade do titular
        if(getIdade()<=getMaxIDADEjunior())
        {
            SegurosDoTitular.add(new SeguroSaudeJunior(precoInicial));
            return true;
        }
        
        if(getIdade()>=getMinIDADEadulto() && getIdade()<=getMaxIDADEadulto())
        {
            SegurosDoTitular.add(new SeguroSaudeAdulto(precoInicial));
            return true;
        }
        
        if(getIdade()>=getMinIDADEsenior() && getIdade()<=getMaxIDADEsenior())
        {
            SegurosDoTitular.add(new SeguroSaudeSenior(precoInicial));
            return true;
        }
        else 
            return false;
    }
    
    //metodo para criar um seguro da casa
    public boolean criarSeguroCasa(double recheio, double precoInicial)
    {   //verifica se o titular ja tem um seguro de casa
        if(isTemSeguroCasa()==false)
        {   //se nao tiver cria um e adiciona
            SegurosDoTitular.add(new SeguroCasa(recheio,precoInicial));
            setTemSeguroCasa(true);
            return true;
        }
        
        else
            return false;
        
    }
    
    //metodo para criar um seguro do carro
    public boolean criarSeguroCarro(CoberturaPassageiros cobertura, double precoInicial)
    {
        SegurosDoTitular.add(new SeguroCarro(cobertura, precoInicial));
        return true;
    }
    
    //metodo para criar um seguro da mota
    public boolean criarSeguroMota(double precoInicial)
    {
        SegurosDoTitular.add(new SeguroMota(precoInicial));
        return true;
    }
    
    //metodo para adicionar despesas ao seguro de saude
    public boolean adicionarDespesas(int idseguro, String Descricao, double valor)
    {
        //percorre todos os seguros do array de seguros do titular
        for(Seguro s: SegurosDoTitular)
        {
            //verifica se o id do seguro inserido existe no array de seguros do titular
            if(idseguro == s.getSeguroID())
            {
                //verifica se o seguro que tem o ID inserido é da classe seguro de saude adulto,
                //jovem ou senior
                if(s instanceof SeguroSaudeAdulto || s instanceof SeguroSaudeJunior || 
                        s instanceof SeguroSaudeSenior)
                {
                    //caso se verifique adiciona as despesas e retorna true
                    SeguroSaude ob = (SeguroSaude) s;
                    ob.adicionarDespesas(Descricao,valor);
                    return true;
                }
                return false;
            }
        }
      return false;  
    }
    
    
    /*------------------------------------------get´s e set's----------------------------------------------*/

    /**
     * @return the ultimoID
     */
    public static int getUltimoID() {
        return ultimoID;
    }

    /**
     * @param aUltimoID the ultimoID to set
     */
    public static void setUltimoID(int aUltimoID) {
        ultimoID = aUltimoID;
    }
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the IDtitular
     */
    public int getIDtitular() {
        return IDtitular;
    }

    /**
     * @param IDtitular the IDtitular to set
     */
    public void setIDtitular(int IDtitular) {
        this.IDtitular = IDtitular;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the SegurosDoTitular
     */
    public ArrayList<Seguro> getSegurosDoTitular() {
        return SegurosDoTitular;
    }

    /**
     * @param SegurosDoTitular the SegurosDoTitular to set
     */
    public void setSegurosDoTitular(ArrayList<Seguro> SegurosDoTitular) {
        this.SegurosDoTitular = SegurosDoTitular;
    }

    /**
     * @return the temSeguroVida
     */
    public boolean isTemSeguroVida() {
        return temSeguroVida;
    }

    /**
     * @param temSeguroVida the temSeguroVida to set
     */
    public void setTemSeguroVida(boolean temSeguroVida) {
        this.temSeguroVida = temSeguroVida;
    }

    /**
     * @return the temSeguroCasa
     */
    public boolean isTemSeguroCasa() {
        return temSeguroCasa;
    }

    /**
     * @param temSeguroCasa the temSeguroCasa to set
     */
    public void setTemSeguroCasa(boolean temSeguroCasa) {
        this.temSeguroCasa = temSeguroCasa;
    }

    /**
     * @return the maxIDADEjunior
     */
    public static int getMaxIDADEjunior() {
        return maxIDADEjunior;
    }

    /**
     * @return the maxIDADEadulto
     */
    public static int getMaxIDADEadulto() {
        return maxIDADEadulto;
    }

    /**
     * @return the minIDADEadulto
     */
    public static int getMinIDADEadulto() {
        return minIDADEadulto;
    }

    /**
     * @return the maxIDADEsenior
     */
    public static int getMaxIDADEsenior() {
        return maxIDADEsenior;
    }

    /**
     * @return the minIDADEsenior
     */
    public static int getMinIDADEsenior() {
        return minIDADEsenior;
    }

    /**
     * @return the SegurosCancelados
     */
    public ArrayList<Seguro> getSegurosCancelados() {
        return SegurosCancelados;
    }

    /**
     * @param SegurosCancelados the SegurosCancelados to set
     */
    public void setSegurosCancelados(ArrayList<Seguro> SegurosCancelados) {
        this.SegurosCancelados = SegurosCancelados;
    }
    
    
    
}
