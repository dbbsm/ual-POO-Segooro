/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;
import Clientes.*;
import Seguros.*;

/**
 *
 * @author Diogo,Tomas e Fernando
 */
public class Main 
{
    public static void main(String[] args)
    {
        Titular t1 = new Titular("tomas","rua",15,Sexo.Masculino);
        
        t1.criarSeguroVida("qualquer coisa","irma", 120);
        t1.criarSeguroSaude(100);
        t1.criarSeguroCasa(5000, 500);
        t1.criarSeguroCarro(CoberturaPassageiros.Sim, 300);
        t1.criarSeguroMota(200);
        
        //tentativa de criar outro seguro de vida e de casa
        
        if(t1.criarSeguroVida("Fernando","Filho", 700)==false)
            System.out.println("Nao pode criar outro seguro de Vida pois ja tem um!");
        if(t1.criarSeguroCasa(7000, 800)==false)
            System.out.println("Nao pode criar outro seguro de Casa pois ja tem um!");
        if(t1.adicionarDespesas(3, null, 600)==false)
            System.out.println("Nao adicionou a despesa porque nao e um seguro de saude");
        
        if(t1.adicionarDespesas(2, null, 100)==true)
            System.out.println("adicionou despesa ao seguro de saude");
        //aciona o seguro de saude junior e retorna o rembolso do respectivo seguro
        t1.AcionarSeguro(2);
        //aciona o seguro da casa e remove-o
        t1.AcionarSeguro(3);
        
        //acrescenta mais despesas ao seguro de saude e aciona o e ele devolve o 
        //reembolso sobre o valor total das despesas apresentadas
        t1.adicionarDespesas(2, null, 300);
        t1.AcionarSeguro(2);
        
        //listar todos os seguros do titular
        t1.ListarSeguros();
        
    }
    
}
