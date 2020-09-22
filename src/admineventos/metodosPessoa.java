package admineventos;
import java.util.*;
import java.io.*;
public class metodosPessoa {
     //METODO CADASTRO DE PESSOAS
    public  String cadastroDePessoa(String nome,String cpf, String numTele, String cep, String valorCarteira, String valorGasto)throws IOException
    {
        CsvToFile acessoFile = new CsvToFile("dadosDasPessoas.csv");
     
        String Resultado = "PESSOA CADASTRADA!";
        // CONDIÇAO PARA VER SE NAO ESTA CADASTRANDO O MSM CPF
        
        if(acessoFile.getLinhaPorCpf(cpf)==null){
         
            //GUARDAR AS INFORMAÇOES DO OBJETO PESSOA NO ARQUIVO CSV.
            pessoa acesso = new pessoa(nome,cpf,numTele,cep,valorCarteira,valorGasto);
            criandoArquivo acessoCsvFile = new criandoArquivo("dadosDasPessoas.csv");
            acessoCsvFile.fazerArquivo();
            pessoaToFile acessoPessoaToFile = new pessoaToFile(acessoCsvFile.getNomeArquivo());
            acessoPessoaToFile.gravarObjeto(acesso);
            return Resultado;
        
        }
        //CASO JA EXTISTA ESSE NUMERO DE CPF CADASTRADO, O PROGRAMA RETORNARA ESSA MENSAGEN
        else 
        {
            return "Não é possivel cadastrar pois o CPF ja existe no banco de dados.";
        }
    
    
    }  
        //METODO PARA MOSTRAR TODAS AS PESSOAS CADASTRADAS    
        public String mostrarPessoas()throws IOException
        {
          String csvArquivo = "dadosDasPessoas.csv";
          BufferedReader conteudoCSV = null;
          String linha = "";
          String csvSeparadorCampo = ";";
          try
          {
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
            while((linha = conteudoCSV.readLine()) != null)
            {
               String[] pessoa = linha.split(csvSeparadorCampo);
               System.out.println("Nome: "+pessoa[0]+
                                   " CPF: "+pessoa[1]+
                                   " Numero De Telefone: "+pessoa[2]+
                                   " CEP: "+pessoa[3]+
                                   " Valor em Dinheiro na Carteira Virtual : "+pessoa[4]+
                                   " Valor já Gasto com Ingressos: "+pessoa[5]);
            }
              
          }    
          catch(IOException e)
          {
            
          }
          return "ok";
        
        
        
        }
       
    //METODO PARA EXCLUIR PESSOAS JA CADASTRADAS 
    public boolean exclusaoDePessoa(String cpf)throws IOException
    {
        Scanner in = new Scanner(System.in);
        String nomeArquivo = "dadosDasPessoas.csv";
 
        // RECEPTOR DE INFORMAÇOES;
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
        }catch (IOException ie) {
            System.out.println("Falha ao excluir!");
            return false;
        }
        if (!arquivo.delete()) {
            System.out.println("Falha ao excluir!");
            return false;
        }
        if (!arquivoTemporario.renameTo(arquivo)) {
            System.out.println("Falha ao excluir!");
            return false;
        }
        System.out.println("Sucesso ao excluir!");
        return true;
    }
    
    public boolean adicionarPacoteDePessoas(String csvArquivo)throws IOException
    {
        
        CsvToFile acessoFile = new  CsvToFile("dadosDasPessoas.csv");
        Scanner ler = new Scanner(System.in);    
        String nome, CPF, numeroDeTelefone, CEP, ValorEmDinheiroNaCarteiraVirtual , ValorJáGastoComIngressos;
        BufferedReader conteudoCSV = null;
        String linha = "";
        String csvSeparadorCampo = ";";
        boolean resultado = true;
        try
        {
         conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
          while((linha = conteudoCSV.readLine()) != null)
          {  
             String[] pessoa = linha.split(csvSeparadorCampo);
             nome = pessoa[0];
             CPF = pessoa[1];
             numeroDeTelefone = pessoa[2];
             CEP = pessoa[3];
             ValorEmDinheiroNaCarteiraVirtual = pessoa[4];
             ValorJáGastoComIngressos = pessoa[5];
              if(acessoFile.getLinhaPorCpf(CPF) == null)
              {
              
                //GUARDAR AS INFORMAÇOES DO OBJETO PESSOA NO ARQUIVO CSV.
                pessoa acesso = new pessoa(nome,CPF,numeroDeTelefone,CEP,ValorEmDinheiroNaCarteiraVirtual,ValorJáGastoComIngressos);
                criandoArquivo acessoCsvFile = new criandoArquivo("dadosDasPessoas.csv");
                 acessoCsvFile.fazerArquivo();
                 pessoaToFile acessoPessoaToFile = new pessoaToFile(acessoCsvFile.getNomeArquivo());
                 acessoPessoaToFile.gravarObjeto(acesso);
                 System.out.print("\n");
              }  
            
            }
        resultado = true;
        } catch(IOException e)
          {
            resultado = false;
          }
        System.out.println("Processo Realizado com secesso!\n");
        return resultado;       
    }

}
