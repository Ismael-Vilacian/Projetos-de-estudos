/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admineventos;
import java.io.*;
/**
 *
 * @author ISMAEL
 */
public class csvFile {
   private String nomeArquivo;
   
   //Metodo do construtor
   csvFile(String nomeArquivo){
       this.nomeArquivo = nomeArquivo;
   }
   //Recebe o nome do arquivo
   public void setNameFile(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
   }
   
   //Verificando se o arquivo existe
   private boolean verificaArquivo(){
        if(nomeArquivo != null){
            File arquivo = new File(nomeArquivo);
            return arquivo.exists();
        }
        return false;
    }
   
    //Guarda as linhas no arquivo
    public void guardarLinha(Object object) {
        
        if (verificaArquivo()) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(nomeArquivo, true));
                writer.append(object.toString());
                writer.newLine();
                writer.close();
            } catch (IOException ex) {
                System.out.println("Falha ao escrever no arquivo.");
            }
        }
    }
    
    //Pega as linhas do arquivo usando o ID
    public String getLinhaPorID(String ID) {
        BufferedReader reader = null;
        String linha = null;
        try {
            reader = new BufferedReader(new FileReader(nomeArquivo));
            while ((linha = reader.readLine()) != null) {
                String[] leitura = linha.split(String.valueOf(
                        ServiceHelper.SEPARADOR));
                try {
                    if ((ID).equals(leitura[1])) {
                        reader.close();
                        return linha;
                    }
                } catch (NumberFormatException e) {
                }
            }
            reader.close();
        } catch (IOException ie) {
        }
        return null;
    }
   
}
