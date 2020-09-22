/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admineventos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ISMAE
 */
public class removerLinha {
    
    private String nomeCsv;
    
    public removerLinha(String nomeCsv){
        this.nomeCsv = nomeCsv;
    }
    
    public void setNomeArquivo(String nomeCsv){
        this.nomeCsv = nomeCsv;
    }
    
    private boolean arquivoExiste() {
        if (nomeCsv != null) {
            File arquivo = new File(nomeCsv);
            return arquivo.exists();
        }
        return false;
    }
    
    public boolean removerLinhaString(String Numero) {
        File arquivo = new File(nomeCsv);
        File arquivoTemporario = null;
        BufferedReader reader = null;
        PrintWriter printWrite = null;
        String linha = null;
        try {
            reader = new BufferedReader(new FileReader(arquivo));
            arquivoTemporario = new File(arquivo.getAbsolutePath() + ".tmp");
            printWrite = new PrintWriter(new FileWriter(arquivoTemporario));
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.trim().split(
                String.valueOf(ServiceHelper.SEPARADOR));
                String identificador = (campos[1]);
                if (!Numero.equals(identificador)) {
                    printWrite.println(linha);
                    printWrite.flush();
                }
            }
            reader.close();
            printWrite.close();
        } catch (IOException ie) {
            return false;
        }
        if (!arquivo.delete()) {
            return false;
        }
        if (!arquivoTemporario.renameTo(arquivo)) {
            return false;
        }else{
            return true;
        }
        
    }
}
