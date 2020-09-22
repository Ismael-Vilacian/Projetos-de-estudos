package admineventos;

/**
 * @author ISMAEL
 */

public class eventoFile {
    private String nomeArquivo;
    
    eventoFile(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
    
    // Organizando as linhas
    private String toLine(evento obgEvento) {
        StringBuilder sb = new StringBuilder();
        sb.append(obgEvento.getNomeEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(obgEvento.getIdEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(obgEvento.getDescricaoEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(obgEvento.getValorIngressoEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(obgEvento.getTotalIngrecosEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(obgEvento.getIngrecosVendidoEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(obgEvento.getPessoasCadastradaEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(obgEvento.getDataEvento());
        return sb.toString();
    }
    
    //Retorna o nome do arquivo
    public String getNomeArquivo(){
        return this.nomeArquivo;
    }
    
    //Grava o objeto no arquivo CSV
    public void gravarObjeto(evento Evento) {
        csvFile gerenciadorArquivo = new csvFile(nomeArquivo);
        gerenciadorArquivo.guardarLinha(toLine(Evento));
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
