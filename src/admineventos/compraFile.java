/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admineventos;

/**
 *
 * @author ISMAE
 */
public class compraFile {
    private String nomeArquivo;
    
    compraFile(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
    
    // Organizando as linhas
    private String toLine(objCompra Compra) {
        StringBuilder sb = new StringBuilder();
        sb.append(Compra.getIdCompra());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(Compra.getCpfCompra());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(Compra.getQauntIngrCompra());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(Compra.getvalorTotal());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(Compra.getCodCompra());
        
        return sb.toString();
    }
    
    //Retorna o nome do arquivo
    public String getNomeArquivo(){
        return this.nomeArquivo;
    }
    
    //Grava o objeto no arquivo CSV
    public void gravarObjeto(objCompra Compra) {
        csvFile gerenciadorArquivo = new csvFile(nomeArquivo);
        gerenciadorArquivo.guardarLinha(toLine(Compra));
    }
    
    // Retorna um objeto da classe a partir da ID buscado no arquivo .csv
    public evento getEventoPorId(String ID){
        csvFile gerenciadorDeArquivo = new csvFile(nomeArquivo);
        String aux;
        aux = gerenciadorDeArquivo.getLinhaPorID(ID);
        String[] leitura = aux.split(String.valueOf(
                        ServiceHelper.SEPARADOR));
        evento nEvento = new evento(leitura[1],leitura[2],leitura[3],leitura[4],leitura[5],leitura[6],leitura[7],leitura[8]);
        
        return nEvento;
    }
}
