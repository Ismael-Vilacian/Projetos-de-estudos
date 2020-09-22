
package admineventos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class pessoaToFile {
    private String nomeArquivo;

  public pessoaToFile(String nomeArquivo){
    this.nomeArquivo=nomeArquivo;
  }
   // METODO PARA ROGANIZAR A LISTA 
   private String toLine(pessoa c){
    
   StringBuilder sb = new StringBuilder();
   sb.append(c.getNome());
   sb.append(separador.SEPARADOR);
   sb.append(c.getCPF());
   sb.append(separador.SEPARADOR);
   sb.append(c.getNúmeroDeTelefone());
   sb.append(separador.SEPARADOR);
   sb.append(c.getCEP());
   sb.append(separador.SEPARADOR);
   sb.append(c.getValorEmDinheiroNaCarteiraVirtual());
   sb.append(separador.SEPARADOR);
   sb.append(c.getValorJáGastoComIngressos());
   return sb.toString();
  }
   //RETORNA O NOME DO AQUIVO CSV
  public String getnomeArquivo()
  {
    return this.nomeArquivo;
   
  }
//GRAVA O OBJETO NO CSV
  public void gravarObjeto(pessoa pessoa){
      
  CsvToFile gerenciadorDeArquivo =new CsvToFile(nomeArquivo);
gerenciadorDeArquivo.gravarLinha(toLine(pessoa));
}         

  public pessoa getPessoaPorCpf(String CPF)
  {
      CsvToFile gerenciadorDeArquivo =new CsvToFile(nomeArquivo);
      String aux;
      aux = gerenciadorDeArquivo.getLinhaPorCpf(CPF);
      String [] leitura =aux.split(String.valueOf(separador.SEPARADOR));
      pessoa a = new pessoa(leitura[1],leitura[2],leitura[3],leitura[4],leitura[5],leitura[6]);
      return a;
  }        
       

  public boolean remove(String CPF){
       CsvToFile gerenciadorDeArquivo = new CsvToFile(nomeArquivo);      
      return gerenciadorDeArquivo.removerLinhaString(CPF);
  }

 
  
}
