
package admineventos;
//OBJETO PESSOA
public class pessoa {
private String  Nome;  
private String  CPF; 
private String  NúmeroDeTelefone;         
private String  CEP;     
private String  ValorEmDinheiroNaCarteiraVirtual;     
private String  ValorJáGastoComIngressos;       
    
 //METODO CONSTRUTOR
pessoa(String  Nome,String  CPF,String  NúmeroDeTelefone,String  CEP,String  ValorEmDinheiroNaCarteiraVirtual,String  ValorJáGastoComIngressos)
{
    this.Nome=Nome;
    this.CPF=CPF;
    this.NúmeroDeTelefone=NúmeroDeTelefone;   
    this.CEP=CEP;        
    this.ValorEmDinheiroNaCarteiraVirtual= ValorEmDinheiroNaCarteiraVirtual;        
    this.ValorJáGastoComIngressos=ValorJáGastoComIngressos;        
}   

    pessoa(String Nome, String CPF, String NúmeroDeTelefone, String ValorEmDinheiroNaCarteiraVirtual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 //getters e setters
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNúmeroDeTelefone() {
        return NúmeroDeTelefone;
    }

    public void setNúmeroDeTelefone(String NúmeroDeTelefone) {
        this.NúmeroDeTelefone = NúmeroDeTelefone;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getValorEmDinheiroNaCarteiraVirtual() {
        return ValorEmDinheiroNaCarteiraVirtual;
    }

    public void setValorEmDinheiroNaCarteiraVirtual(String ValorEmDinheiroNaCarteiraVirtual) {
        this.ValorEmDinheiroNaCarteiraVirtual = ValorEmDinheiroNaCarteiraVirtual;
    }

    public String getValorJáGastoComIngressos() {
        return ValorJáGastoComIngressos;
    }

    public void setValorJáGastoComIngressos(String ValorJáGastoComIngressos) {
        this.ValorJáGastoComIngressos = ValorJáGastoComIngressos;
    }
    
}
