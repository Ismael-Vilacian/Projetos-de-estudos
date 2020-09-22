package admineventos;
import java.util.Random;
import admineventos.interfaceEvento.interfaceCompra;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author ISMAEL
 */
public class gravarDadosEvento 
{
    
    String nome, ID, Descricao, Valor, total, vendidos, pessoas, data;
    String [] vetoridevento, vetorPessoa;
    public void setNomeEvento(String nome)
    {
        this.nome = nome;
    }
    public String getNomeEvento()
    {
        return nome;
    }
    
    public void setIdEvento(String ID)
    {
        this.ID = ID;
    }
    public String getIdEvento()
    {
        return ID;
    }
    
    public void setDescricaoEvento(String Descricao)
    {
        this.Descricao = Descricao;
    }
    public String getDescricaoEvento()
    {
        return Descricao;
    }
    
    public void setValorIngressoEvento(String Valor)
    {
        this.Valor = Valor;
    }
    public String getValorIngressoEvento()
    {
        return Valor;
    }
    
    public void setTotalIngrecosEvento(String total)
    {
        this.total = total;
    }
    public String getTotalIngrecosEvento()
    {
        return total;
    }
    
    public void setIngrecosVendidoEvento(String vendidos)
    {
        this.vendidos = vendidos;
    }
    public String getIngrecosVendidoEvento()
    {
        return vendidos;
    }
    
    public void setPessoasCadastradaEvento(String pessoas)
    {
        this.pessoas = pessoas;
    }
    public String getPessoasCadastradaEvento()
    {
        return pessoas;
    }
    
    public void setDataEvento(String data)
    {
        this.data = data;
    }
    public String getDataEvento()
    {
        return data;
    }
    
    public void setvetorID(String [] vetoridevento)
    {
        this.vetoridevento = vetoridevento;
    }
    public String [] getvetorEvento()
    {
        return vetoridevento;
    }
    
    public void setvetorPessoa(String [] vetorPessoa)
    {
        this.vetorPessoa = vetorPessoa;
    }
    public String [] getvetorPessoa()
    {
        return vetorPessoa;
    }
    
    public String gravarDados() throws IOException
    {
         
         csvFile acessoFile = new csvFile("arquivoEvento.csv");
         
         //Essa condicao verifica se o ID do evento ja existe no arquivo
         if(acessoFile.getLinhaPorID(ID) == null)
         {
            //Grava os dados recebido no arquivo CSV
            evento acesso = new evento(nome, ID, Descricao, Valor, total, vendidos, pessoas, data);
            newFile acessoCsvFile = new newFile("arquivoEvento.csv");
            acessoCsvFile.criarArquivo();
            eventoFile acessoEventoFile = new eventoFile(acessoCsvFile.getNameFile());
            acessoEventoFile.gravarObjeto(acesso);
            return "Evento cadastrado com sucesso!";
         }
         //Caso a ID ja exista no arquivo, nada e gravado, e retorna o informativo
         else
         {
             return "Evento não cadastrado pois a ID ja existe!";
         }
    }
    
    
        
    //Metodo para adicionar pacotes no arquivo principal
    public String adicionarPacotesEvento(String csvArquivo) throws IOException
    {   
        
        csvFile acessoFile = new csvFile("arquivoEvento.csv");
        Scanner in = new Scanner(System.in);
        String nome, ID, Descricao, Valor, total, vendidos, pessoas, data;
        BufferedReader conteudoCSV = null;
        String linha = "";
        String csvSeparadorCampo = ";";
        
        int confirma = 10;
        try
        {
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
            //O loop continua ate reconhecer que não tenha mais linhas no arquivo
            while((linha = conteudoCSV.readLine()) != null)
            {
                /*
                Pega os dados por linhaz e separa ao reconhecer ";"
                grava os dados em um vetor com nome "evento"
                */
                String[] evento = linha.split(csvSeparadorCampo);
                
                //Para melhor vizualizar o que esta acontecendo, foi feita uma variavel para cada espaco do vetor;
                nome = evento[0];
                ID = evento[1];
                Descricao = evento[2];
                Valor = evento[3];
                total = evento[4];
                vendidos = evento[5];
                pessoas = evento[6];
                data = evento[7];
                
                /*
                  Essa condicao verifica se a ID que esta sendo copiado ja existe no arquivo pricipal
                  e verifica se os dados recebidos estão todos corretos de acordo com o campo
                */
                if(acessoFile.getLinhaPorID(ID) == null && verificaInt(ID) == true
                   && verificaFloat(Valor) == true && verificaInt(total) == true
                   && verificaInt(vendidos) == true && verificaInt(pessoas) == true
                   && verificaData(data) == true)
                {
                    evento acesso = new evento(nome, ID, Descricao, Valor, total, vendidos, pessoas, data);
                    newFile acessoCsvFile = new newFile("arquivoEvento.csv");
                    acessoCsvFile.criarArquivo();
                    eventoFile acessoEventoFile = new eventoFile(acessoCsvFile.getNameFile());
                    acessoEventoFile.gravarObjeto(acesso);
                    confirma = 1;
                    
                }
                //Caso ja exista, os dados nãoo seram copiados
                else
                {
                    confirma = 0;
                }
            }
  
        }catch(IOException e)
        {
            
        }
        //Se não ocorreu erros no processo, é retornado uma mensagem informativa
        if(confirma == 0)
        {
            return "ID's dessa linha ja exite no banco de dados ou dados invalidos, favor alterar.";    
        }
        //Se ocorreu erros no processo, é retornado uma mensagem informativa
        else
        {
            return "Processo Realizado com secesso!\n";
        } 
    }
    
    //Este metodo, verifica se a informacoes passada e do tipo Int
    public boolean verificaInt(String verificaInt){
        try{
            Integer.parseInt(verificaInt);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
 
    //Este metodo, verifica se a informacoes passada e do tipo float
    public boolean verificaFloat(String verificaFloat){
        try{
            Float.parseFloat(verificaFloat);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    //Este metodo verifica se a data e valida, e se foi passada no formado dd/mm/aaaa
    public boolean verificaData(String dataR)
    {
        Date data = null;
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	try {
    		format.setLenient(false);
    		data = format.parse(dataR);
                return true;
               
    	} catch (ParseException e) {
    		
               return false;
        }   
    }
    
    //Pega a data atual
    public String getData() {

        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = formatar.format(data);

        return dataAtual;
    }
    
    //ESTE METODO PEGA OS DADOS DE ACORDO COM AS ID´S ESCOLHIDAS
    public String [] pegaDadosEvento(String ID)
    {
        String csvArquivo = "arquivoEvento.csv";
        BufferedReader conteudoCSV = null;
        String linha = "";
        String csvSeparadorCampo = ";";       
        
        String [] retorna = {"","","","","","","",""};
        
        try 
        {
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));            
            //O loop continua ate reconhecer que nãoo tem mais linhas no arquivo
            while((linha = conteudoCSV.readLine()) != null){
                /*
                Pega os dados por linhaz e separa ao reconhecer ";"
                e grava os dados em um vetor com nome "evento"
                */
                String[] evento = linha.split(csvSeparadorCampo);
                
                /*
                  Nessa condição, e feita uma conversão  do tipo String para tipo inteiro da posição 1 da vetor 
                  evento (que corresponde ao ID que ja esta gravado no arquivo) e o mesmo acontece com a ID
                  recebida pelo o usuario, em seguida, é feito uma comparação se os mesmos correspondem,
                  caso a condição seja verdadeira, o vetor evento e gravado dentro de outro evento, para que
                  seja possivel retornar o valor para o codigo solicitante.
                */
                
                if( Integer.parseInt(evento[1]) == Integer.parseInt(ID)){
                    retorna [0]= evento[0];
                    retorna [1]= evento[1];
                    retorna [2]= evento[2];
                    retorna [3]= evento[3];
                    retorna [4]= evento[4];
                    retorna [5]= evento[5];
                    retorna [6]= evento[6];
                    retorna [7]= evento[7];
                    break;
                    
                }
            }
        } catch (IOException ex) 
        {
            Logger.getLogger(interfaceCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Retorna todos os valores coletados no arquivo
        return retorna;
        
    }
    

    //ESTE METODO PEGA OS DADOS DE ACORDO COM OS CPF´S ESCOLHIDOS
    public String [] pegaDadosPessoa(String CPF){
        String csvArquivo = "dadosDasPessoas.csv";
        BufferedReader conteudoCSV = null;
        String linha = "";
        String csvSeparadorCampo = ";";       
       
        String [] retorna = {"","","","","",""};

        try {
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));            
            //O loop continua ate reconhecer que nÃ£o tem mais linhas no arquivo
            while((linha = conteudoCSV.readLine()) != null){
                /*
                Pega os dados por linhaz e separa ao reconhecer ";"
                e grava os dados em um vetor com nome "evento"
                */
                String[] pessoa = linha.split(csvSeparadorCampo);
                /*
                Como o CPF tem 11 digitos, o codigo não consegue converter a String com esse tamanho,
                portanto, não acontce converção como no metodo pegaDadosEvento(), e é usado o equals()
                que faz a comparação de duas Strings
                */
                if(pessoa[1].equals(CPF)){
                    retorna [0]= pessoa[0];
                    retorna [1]= pessoa[1];
                    retorna [2]= pessoa[2];
                    retorna [3]= pessoa[3];
                    retorna [4]= pessoa[4];
                    retorna [5]= pessoa[5];
                    
                    break;
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(interfaceCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorna;       
    }
    
    
    
 
    public String compra(String idEvento, String CPFcomprador, String quantIngreco, String valorTotal) throws IOException{
        /*
        Nesta parte, e pegado as informações do evento e usuario, e são gravados em um vetor
        e em seguida e excluido do arquivo csv
        */
        String[] dadosPessoa, dadosEvento;
        dadosPessoa = pegaDadosPessoa(CPFcomprador);
        dadosEvento = pegaDadosEvento(idEvento);
        
        
        
        boolean resultado;
  
        //Nesta parte do metodo e gravada as iformações da compra no arquivo csv
        String CodCompra = codigoDeVendas();
        objCompra acesso = new objCompra(idEvento,CPFcomprador,quantIngreco,valorTotal, CodCompra);
        newFile acessoCsvFile = new newFile("dadosDeCompra.csv");
        acessoCsvFile.criarArquivo();
        compraFile acessoEventoFile = new compraFile(acessoCsvFile.getNameFile());
        acessoEventoFile.gravarObjeto(acesso);
       
        return "Compra realizada com sucesso!";
    }
    
    public String calcUsuario(String idEvento, String CPFcomprador, String quantIngreco, String valorTotal, String [] pessoa) throws IOException{
         /*
        Aqui e feito todos os calculos necessários para finalizar a compra em relação ao usuario
        como exemplo retirar o dinheiro da carteira e etc
        */ 
        float valorCarteira, valorGasto;
        valorCarteira = (Float.parseFloat(pessoa[4]) - Float.parseFloat(valorTotal));
        valorGasto = (Float.parseFloat(pessoa[5]) + Float.parseFloat(valorTotal));
        pessoa[4] = String.valueOf(valorCarteira);
        pessoa[5] = String.valueOf(valorGasto);
        
        pessoa acesso = new pessoa(pessoa[0],pessoa[1],pessoa[2],pessoa[3],pessoa[4],pessoa[5]);
        criandoArquivo acessoCsvFile = new criandoArquivo("dadosDasPessoas.csv");
        acessoCsvFile.fazerArquivo();
        pessoaToFile acessoPessoaToFile = new pessoaToFile(acessoCsvFile.getNomeArquivo());
        acessoPessoaToFile.gravarObjeto(acesso);
         
        removerLinha remover = new removerLinha("dadosDasPessoas.csv");
        remover.removerLinhaString(pessoa[1]);
        return "ok";
    }
    
    public String calcEvento(String idEvento, String CPFcomprador, String quantIngreco, String valorTotal, String [] evento) throws IOException{
        /*
        Aqui e feito todos os calculos necessários para finalizar a compra em relação ao evento
        */
        int disponivel, vendido, cadastrados;
        disponivel = (Integer.parseInt(evento[4]) - Integer.parseInt(quantIngreco));
        vendido = (Integer.parseInt(evento[5]) + Integer.parseInt(quantIngreco));
        cadastrados = (Integer.parseInt(evento[6]) + Integer.parseInt(quantIngreco));
        evento[4] = String.valueOf(disponivel);
        evento[5] = String.valueOf(vendido);
        evento[6] = String.valueOf(cadastrados);
        
        
        evento cadas = new evento(evento[0], evento[1], evento[2], evento[3], evento[4], evento[5], evento[6], evento[7]);
        newFile acessoCsvEvento = new newFile("arquivoEvento.csv");
        acessoCsvEvento.criarArquivo();
        eventoFile acessoEvento = new eventoFile(acessoCsvEvento.getNameFile());
        acessoEvento.gravarObjeto(cadas);
        
        removerLinha remover = new removerLinha("arquivoEvento.csv");
        remover.removerLinhaString(evento[1]);
        return "";
    }
    /*
    Este metodo tem como objetivo randomizar um numero que sera sorteado ente 0 e 1000;
    A principal função deste metodo, e gerar uma "Senha" para cada compra efetuada, para 
    facilitar a remoção da compra atraves da "senha";
    A probabilidade de sar um numero repetido e de 1/10000 = 0.0001;
    */
    public String codigoDeVendas(){
        Random rand = new Random();
        String resultado;
        int rand_int1 = rand.nextInt(10000);
        
        resultado = String.valueOf(rand_int1);
        return resultado;
        
    }
    
    
    /*
    Este metodo serve para pagar uma linha, mais especificamente "Cancelar uma compra"
    */
    public boolean removerLinhaString(String codigo) {
        File arquivo = new File("dadosDeCompra.csv");
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
                String identificador = (campos[4]);
                if (!codigo.equals(identificador)) {
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
