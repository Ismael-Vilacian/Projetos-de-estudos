
package admineventos;

import java.io.*;
public class CsvToFile {
     private String nomeArquivo;

    CsvToFile(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
    
    public void setNomeArquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
    
    private boolean arquivoExiste() {
        if (nomeArquivo != null) {
            File arquivo = new File(nomeArquivo);
            return arquivo.exists();
        }
        return false;
    }
      
    
    public void gravarLinha(Object object) {
        System.out.println(nomeArquivo);
        if (arquivoExiste()) {
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
    
    public String getLinhaPorCpf(String cpf) {
        BufferedReader reader = null;
        String linha = null;
        try {
            reader = new BufferedReader(new FileReader(nomeArquivo));
            while ((linha = reader.readLine()) != null) {
                String[] leitura = linha.split(String.valueOf(
                        separador.SEPARADOR));
                try {
                    if ((cpf).equals(leitura[1])) {
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
    
    public boolean removerLinhaString(String cpf) {
        File arquivo = new File(nomeArquivo);
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
                        String.valueOf(separador.SEPARADOR));
                String identificador = (campos[1]);
                if (!cpf.equals(identificador)) {
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
        }
        System.out.println("Excluido com sucesso!");
        return true;
        
    }
    
    
}
