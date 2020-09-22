package admineventos;
import java.io.*;
import java.io.IOException;
/**
 *
 * @author ISMAEL
 */
public class newFile {
    private String nameFile;
    
    //Metodo do costrutor
    newFile(String nameFile){
        this.nameFile = nameFile;
    }
    //Get's and Set's
    public void setNameFile(String nameFile){
        this.nameFile = nameFile;
    }
    public String getNameFile(){
        return this.nameFile;
    }
    
    //Verificando se o arquivo existe
    private boolean verificaArquivo(){
        //Caso o arquivo seja diferente de null, ele exite, logo retorna true
        if(nameFile != null){
            File arquivo = new File(nameFile);
            return arquivo.exists();
        }
        //Caso não, retora false
        return false;
    }
    
//Criando arquivo
    public void criarArquivo() throws IOException{
        File arquivo = new File(nameFile);
        //Caso seja false, o arquivo e gerado
        if(arquivo.exists() == false){
            arquivo.createNewFile();
        }
    }
    
}
