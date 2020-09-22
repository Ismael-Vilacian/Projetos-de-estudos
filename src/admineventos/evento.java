package admineventos;

/**
 *
 * @author ISMAEL
 */
public class evento {
    private String nomeEvento;
    private String idEvento;
    private String descricaoEvento;
    private String valorIngressoEvento;
    private String totalIngrecosEvento;
    private String ingrecosVendidoEvento;
    private String pessoasCadastradaEvento;
    private String dataEvento;
    
    //Metodo construtor
    public evento(String nomeEvento, String idEvento, String descricaoEvento, String valorIngressoEvento, String totalIngrecosEvento, String ingrecosVendidoEvento, String pessoasCadastradaEvento, String dataEvento){
        this.nomeEvento = nomeEvento;
        this.idEvento = idEvento;
        this.descricaoEvento = descricaoEvento;
        this.valorIngressoEvento = valorIngressoEvento;
        this.totalIngrecosEvento = totalIngrecosEvento;
        this.ingrecosVendidoEvento = ingrecosVendidoEvento;
        this.pessoasCadastradaEvento = pessoasCadastradaEvento;
        this.dataEvento = dataEvento;
    }
    
    ////////////////////////////////////////////
    //Inicio Get's and Set's
    public void setNomeEvento(String nomeEvento){
        this.nomeEvento = nomeEvento;
    }
    public String getNomeEvento(){
        return nomeEvento;
    }
    
    public void setIdEvento(String idEvento){
        this.idEvento = idEvento;
    }
    public String getIdEvento(){
        return idEvento;
    }
    
    public void setDescricaoEvento(String descricaoEvento){
        this.descricaoEvento = descricaoEvento;
    }
    public String getDescricaoEvento(){
        return descricaoEvento;
    }
    
    public void setValorIngressoEvento(String valorIngressoEvento){
        this.valorIngressoEvento = valorIngressoEvento;
    }
    public String getValorIngressoEvento(){
        return valorIngressoEvento;
    }
    
    public void setTotalIngrecosEvento(String totalIngrecosEvento){
        this.totalIngrecosEvento = totalIngrecosEvento;
    }
    public String getTotalIngrecosEvento(){
        return totalIngrecosEvento;
    }
    
    public void setIngrecosVendidoEvento(String ingrecosVendidoEvento){
        this.ingrecosVendidoEvento = ingrecosVendidoEvento;
    }
    public String getIngrecosVendidoEvento(){
        return ingrecosVendidoEvento;
    }
    
    public void setPessoasCadastradaEvento(String pessoasCadastradaEvento){
        this.pessoasCadastradaEvento = pessoasCadastradaEvento;
    }
    public String getPessoasCadastradaEvento(){
        return pessoasCadastradaEvento;
    }
    
    public void setDataEvento(String dataEvento){
        this.dataEvento = dataEvento;
    }
    public String getDataEvento(){
        return dataEvento;
    }
    //Final Get's and Set's 
    ////////////////////////////////////////////
}
