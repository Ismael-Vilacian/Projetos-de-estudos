
package admineventos.interfaceEvento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class visualizarPessoas extends javax.swing.JInternalFrame {

    public visualizarPessoas() {
        initComponents();
    }
    
    public void loadTabela() throws IOException{
        String csvArquivo = "dadosDasPessoas.csv";
        BufferedReader conteudoCSV = null;
        String linha = "";
        String csvSeparadorCampo = ";";
        DefaultTableModel tabela = (DefaultTableModel) tabelaPessoa.getModel();
        
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
            //O loop continua ate reconhecer que não tem mais linhas no arquivo
            while((linha = conteudoCSV.readLine()) != null){
                /*
                Pega os dados por linhaz e separa ao reconhecer ";"
                e grava os dados em um vetor com nome "pessoa"
                */
                String[] pessoa = linha.split(csvSeparadorCampo);
                //Imprime os dados dos eventos
                tabela.addRow(pessoa);
                
            }
            
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPessoa = new javax.swing.JTable();

        setClosable(true);

        tabelaPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "CEP", "Valor Disponivel", "Valor Gasto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPessoa.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelaPessoaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tabelaPessoa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaPessoaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelaPessoaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPessoaAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPessoa;
    // End of variables declaration//GEN-END:variables
    public Object getTable(){
        return tabelaPessoa;
    }
}
