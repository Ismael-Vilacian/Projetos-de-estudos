
package admineventos;

import java.io.File;
import java.io.IOException;
public class criandoArquivo {
    private String nomeArquivo;
  
public criandoArquivo(String nomeArquivo){
      this.nomeArquivo= nomeArquivo;
  }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return this.nomeArquivo;
    }
    
    private boolean arquivoExiste(){
        if (nomeArquivo != null){
            File arquivo = new File(nomeArquivo);
            return arquivo.exists();
        }
        return false;
    }
    
    
    
    public void fazerArquivo() throws IOException{
        File arquivo = new File(nomeArquivo);
        if(arquivo.exists() == false )
        {
          arquivo.createNewFile();
        }
    } 
    
}
