/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.gui;


import java.awt.CardLayout;
import java.util.ArrayList;
import Clientes.*;
import Extra.*;
import Seguros.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Diogo
 */
public class MainWindow extends javax.swing.JFrame 
{
    private Segooros emp;
    private Seguro s;
    private Titular T;
    private AccionarSeguro accionarSeguro;
    private CancelarSeguro cancelarSeguro;
    private FormCasa formCasa;
    private FormSaude formSaude;
    private FormTitular formTitular;
    private FormVeiculo formVeiculo;
    private FormVida formVida;
    private ListarTitulares listarTitulares;
    private SegurosDoTitular segurosDoTitular;
    private AdicionarDespesas adicionarDespesas;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        initData();
    }
    
    private void initData() 
    {
        try
        {
            Titular t;
            Seguro S;
                        
            // TODO add your handling code here:
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("segooro emp.dat"));
            emp = (Segooros) ois.readObject();
            ois.close();
            
            BufferedReader fIn  = new BufferedReader(new FileReader("Variaveis Static.dat"));
            String line = fIn.readLine();
            String arr[] = line.split(",");
            Titular.setUltimoID(Integer.parseInt(arr[0]));
            Seguro.setUltimoseguroID(Integer.parseInt(arr[1]));
            fIn.close();
            
            formTitular = new FormTitular(emp);
            jPanel1.add(formTitular, "formTitular");
            listarTitulares = new ListarTitulares(emp);
            jPanel1.add(listarTitulares, "listarTitulares");
            segurosDoTitular = new SegurosDoTitular(emp);
            jPanel1.add(segurosDoTitular, "segurosTitular");
            formVida = new FormVida(emp);
            jPanel1.add(formVida, "formVida");
            formSaude = new FormSaude(emp);
            jPanel1.add(formSaude, "formSaude");
            formCasa= new FormCasa(emp);
            jPanel1.add(formCasa, "formCasa");
            formVeiculo = new FormVeiculo(emp);
            jPanel1.add(formVeiculo, "formVeiculo");
            cancelarSeguro = new CancelarSeguro(emp);
            jPanel1.add(cancelarSeguro,"cancelarSeguro");
            accionarSeguro = new AccionarSeguro(emp);
            jPanel1.add(accionarSeguro, "accionarSeguro");
            adicionarDespesas = new AdicionarDespesas(emp);
            jPanel1.add(adicionarDespesas, "adicionarDespesas");
            
            /*Necessario se usarmos o botao importar
            accionarSeguro.SetSegooros(emp);
            adicionarDespesas.SetSegooros(emp);
            cancelarSeguro.SetSegooros(emp);
            formCasa.SetSegooros(emp);
            formSaude.SetSegooros(emp);
            formTitular.SetSegooros(emp);
            formVeiculo.SetSegooros(emp);
            formVida.SetSegooros(emp);
            listarTitulares.SetSegooros(emp);
            segurosDoTitular.SetSegooros(emp);*/
            
            JOptionPane.showMessageDialog(null,"A informacao foi carregada com sucesso.");
            
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, e+" : O ficheiro nao foi encontrado, sera "
                    + "inicializado tudo do inicio.");
            emp = new Segooros();
        
            formTitular = new FormTitular(emp);
            jPanel1.add(formTitular, "formTitular");
            listarTitulares = new ListarTitulares(emp);
            jPanel1.add(listarTitulares, "listarTitulares");
            segurosDoTitular = new SegurosDoTitular(emp);
            jPanel1.add(segurosDoTitular, "segurosTitular");
            formVida = new FormVida(emp);
            jPanel1.add(formVida, "formVida");
            formSaude = new FormSaude(emp);
            jPanel1.add(formSaude, "formSaude");
            formCasa= new FormCasa(emp);
            jPanel1.add(formCasa, "formCasa");
            formVeiculo = new FormVeiculo(emp);
            jPanel1.add(formVeiculo, "formVeiculo");
            cancelarSeguro = new CancelarSeguro(emp);
            jPanel1.add(cancelarSeguro,"cancelarSeguro");
            accionarSeguro = new AccionarSeguro(emp);
            jPanel1.add(accionarSeguro, "accionarSeguro");
            adicionarDespesas = new AdicionarDespesas(emp);
            jPanel1.add(adicionarDespesas, "adicionarDespesas");
        }
        catch(IOException e)
        {
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex +" : A classe nao "
                    + "foi possivel importar pois nao foi encontrada.");
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem7 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Segooros");

        jLabel2.setText("Projecto Realizado por:");

        jLabel3.setText("Diogo Machado nº 20140915");

        jLabel4.setText("Fernando Gonçalves nº 20130320");

        jLabel5.setText("Tomás Alecrim nº 20130584");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, "card2");

        jMenu1.setText("File");

        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");

        jMenuItem4.setText("Criar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Listar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Procurar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Seguros");

        jMenu4.setText("Criar");

        jMenuItem8.setText("Seguro de Vida");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Seguro de Saude");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Seguro do Veiculo");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem11.setText("Seguro da Casa");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenu3.add(jMenu4);

        jMenuItem12.setText("Cancelar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem13.setText("Accionar");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem14.setText("Adicionar Despesas");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "formTitular");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "listarTitulares");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "segurosTitular");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "formVida");
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "formSaude");
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "formVeiculo");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "formCasa");
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        //cancelar seguro
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "cancelarSeguro");
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        //Accionar Seguro
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "accionarSeguro");
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        //Adicionar Despesas
        ((CardLayout)jPanel1.getLayout()).show(jPanel1, "adicionarDespesas");
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        //guardar ficheiros
        try
        {
            //ficheiro Generico

            // TODO add your handling code here:
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("segooro emp.dat"));
            oos.writeObject(emp);
            oos.writeObject(s);
            oos.writeObject(T);
            oos.flush();
            oos.close();
            //Guardar as variaveis static como UltimoIDTitular e UltimoIDSeguro
            BufferedWriter fOut3 = new BufferedWriter(new FileWriter("Variaveis Static.dat"));
            fOut3.write(Titular.getUltimoID()+","+Seguro.getUltimoseguroID());
            fOut3.flush();
            fOut3.close();

            //escrever as despesas
            BufferedWriter fOut2 = new BufferedWriter(new FileWriter("Despesas de seguros de saude.txt"));
            for(Titular T : emp)
            {
                for(Seguro s : T.getSegurosDoTitular())
                {
                    if(s instanceof SeguroSaudeAdulto || s instanceof SeguroSaudeSenior ||
                        s instanceof SeguroSaudeJunior)
                    {
                        SeguroSaude ss = (SeguroSaude) s;
                        fOut2.write(ss.getSeguroID()+","+ss.getTipo()+","+ss.getPrecoInicial());
                        for(Despesas d : ss.getDespesasDoTitular())
                        {
                            fOut2.write(d.getDescricao()+","+d.getValor());
                            fOut2.newLine();
                        }
                    }
                }
            }
            if(fOut2 !=null)
            {
               fOut2.flush();
               fOut2.close(); 
            }
               

            //escrever os seguros cancelados de cada Titular
            BufferedWriter fOut = new BufferedWriter(new FileWriter("Seguros Cancelados.txt"));
            for(Titular T : emp)
            {
                
                if(T.getSegurosCancelados()!=null)
                {
                    fOut.write(T.getIDtitular()+","+T.getNome()+","+T.getIdade()+","+T.getMorada()+","+T.getSexo());
                    fOut.newLine();

                    for(Seguro s : T.getSegurosCancelados())
                    {
                        if(s instanceof SeguroVida)
                        {
                            SeguroVida sv = (SeguroVida) s;
                            fOut.write(sv.getSeguroID()+","+sv.getTipo()+","+sv.getPrecoInicial()+","
                                +sv.getNomeDoFamiliar()+","+sv.getGrauParentesco());
                        }
                        if(s instanceof SeguroSaudeAdulto || s instanceof SeguroSaudeSenior ||
                            s instanceof SeguroSaudeJunior)
                        {
                            SeguroSaude ss = (SeguroSaude) s;
                            fOut.write(ss.getSeguroID()+","+ss.getTipo()+","+ss.getPrecoInicial());
                            for(Despesas d : ss.getDespesasDoTitular())
                            {
                                fOut.write(d.getDescricao()+","+d.getValor());
                                fOut.newLine();
                            }
                        }
                        if(s instanceof SeguroCasa)
                        {
                            SeguroCasa sc = (SeguroCasa) s;
                            fOut.write(sc.getSeguroID()+","+sc.getTipo()+","+sc.getPrecoInicial()+","+sc.getRecheio());

                        }
                        if(s instanceof SeguroVeiculo)
                        {
                            if(s instanceof SeguroCarro)
                            {
                                SeguroCarro sc = (SeguroCarro) s;
                                fOut.write(sc.getSeguroID()+","+sc.getTipo()+","+sc.getPrecoInicial()
                                    +","+sc.getCoberturaPassageiros()+","+sc.getTeveacidente());
                            }
                            if(s instanceof SeguroMota)
                            {
                                SeguroMota sm = (SeguroMota) s;
                                fOut.write(sm.getSeguroID()+","+sm.getTipo()+","+sm.getPrecoInicial()
                                    +","+sm.getTeveacidente());
                            }
                        }
                    }
                }
            }
            if(fOut !=null)
                fOut.close();

            //escrever os seguros existentes de cada titular
            BufferedWriter fOut1 = new BufferedWriter(new FileWriter("Seguros Existentes.txt"));
            for(Titular T : emp)
            {
                
                if(T.getSegurosDoTitular()!=null)
                {
                    fOut1.write(T.getIDtitular()+","+T.getNome()+","+T.getIdade()+","+T.getMorada()+","+T.getSexo());
                    fOut1.newLine();

                    for(Seguro s : T.getSegurosDoTitular())
                    {
                        if(s instanceof SeguroVida)
                        {
                            SeguroVida sv = (SeguroVida) s;
                            fOut1.write(sv.getSeguroID()+","+sv.getTipo()+","+sv.getPrecoInicial()+","
                                +sv.getNomeDoFamiliar()+","+sv.getGrauParentesco());
                        }
                        if(s instanceof SeguroSaudeAdulto || s instanceof SeguroSaudeSenior ||
                            s instanceof SeguroSaudeJunior)
                        {
                            SeguroSaude ss = (SeguroSaude) s;
                            fOut1.write(ss.getSeguroID()+","+ss.getTipo()+","+ss.getPrecoInicial());
                            for(Despesas d : ss.getDespesasDoTitular())
                            {
                                fOut1.write(d.getDescricao()+","+d.getValor());
                                fOut1.newLine();
                            }
                        }
                        if(s instanceof SeguroCasa)
                        {
                            SeguroCasa sc = (SeguroCasa) s;
                            fOut1.write(sc.getSeguroID()+","+sc.getTipo()+","+sc.getPrecoInicial()+","+sc.getRecheio());

                        }
                        if(s instanceof SeguroVeiculo)
                        {
                            if(s instanceof SeguroCarro)
                            {
                                SeguroCarro sc = (SeguroCarro) s;
                                fOut1.write(sc.getSeguroID()+","+sc.getTipo()+","+sc.getPrecoInicial()
                                    +","+sc.getCoberturaPassageiros()+","+sc.getTeveacidente());
                            }
                            if(s instanceof SeguroMota)
                            {
                                SeguroMota sm = (SeguroMota) s;
                                fOut1.write(sm.getSeguroID()+","+sm.getTipo()+","+sm.getPrecoInicial()
                                    +","+sm.getTeveacidente());
                            }
                        }
                    }
                }
            }
            if(fOut1 !=null)
                fOut1.close();
            
            JOptionPane.showMessageDialog(null, "Os ficheiros foram guardados com sucesso.");
        }
        catch(IOException e)
        {

        }
        catch(Exception e)
        {

        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
