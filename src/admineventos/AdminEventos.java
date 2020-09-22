package admineventos;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author ISMAEL
 */
public class AdminEventos 
{
    /*
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        
        String dataAtual, resultadoDoCadastro, apagaPessoas;
        boolean resultadoApagar;
        LocalDate localDate = LocalDate.now();        
        dataAtual = localDate.toString();
        Scanner in = new Scanner(System.in);
        
        
        int numeroSelecionado = 189898;
        
        
        while(true){
            //Enquanto a variavel numeroSelecionado for igual a 50, o menu vai ser executado.
                System.out.println("#########################################");
                System.out.println("##     CADASTRO DE EVENTOS & PESSOAS   ##");
                System.out.println("##                  Data: "+localDate+"   ##");
                System.out.println("##                                     ##");
                System.out.println("##                             V 1.0.1 ##");
                System.out.println("#########################################");


                System.out.println("\nESCOLHA UMA OPÇÃO\n");
                System.out.println("0 – Para finalizar programa");
                System.out.println("\n1 - Cadastro de Pessoas");
                System.out.println("2 - Verificação de Pessoas Cadastradas");
                System.out.println("3 - Exclusão de Pessoas Cadastradas");
                System.out.println("4 - Adicionar Eventos");
                System.out.println("5 - Visualizar Eventos");
                System.out.println("6 - Realizar compra");
                System.out.println("7 - Excluir compra");
                System.out.println("8 - Imprimir lista de compradores");
                System.out.println("9 – Adicionar pacote de pessoas");
                System.out.println("10 – Adicionar pacote de eventos");
                System.out.println("\nESCOLHA UMA OPÇÃO: ");
                numeroSelecionado = in.nextInt();
                if(numeroSelecionado == 0){
                    break;
                }
                if(numeroSelecionado < 0 || numeroSelecionado > 10 ){
                    System.out.println("\nOpcao invalida, informe uma opcao valida.\n");
                    Thread.currentThread().sleep(3000);
                }
                
                //Recebe a escolha do usuario e executa a opcao desejada
                switch(numeroSelecionado)
                {
                    case 1:
                        //Acessa a classe para cadastrar o evento
                        metodosPessoa gravar = new metodosPessoa();
                        //Recebe o resultado do cadastro
                        resultadoDoCadastro = gravar.cadastroDePessoa();      
                        //Imprime se foi cadastrado ou nao
                        System.out.println("\n#####################################################");
                        System.out.println("           "+resultadoDoCadastro);
                        System.out.println("#####################################################\n");
                        System.out.println("\n\n\n");
                        //Da uma pausa de 2 segundos para para ter tempo de ver o resultado
                        Thread.currentThread().sleep(2000);
                        break;
                        
                    case 2:
                        //Busca os dados do arquivo e printa para o usuario
                        metodosPessoa gravar2 = new metodosPessoa();
                        gravar2.mostrarPessoas();
                        //Da uma pausa de 3 segundos para para ter tempo de ver o resultado
                        Thread.currentThread().sleep(3000);
                        System.out.println("\n\n\n");
                        break;
                        
                    case 3:
                        //acessar a classe para excluir algum cadastro pessoa
                        metodosPessoa gravar3 = new metodosPessoa();
                        //excluir pessoa
                        
                        gravar3.exclusaoDePessoa();
                        
                        Thread.currentThread().sleep(1000);
                        System.out.println("\n\n\n");
                        break;
                            
                    case 4:
                        //Acessa a classe para cadastrar o evento
                        gravarDadosEvento gravar4 = new gravarDadosEvento();
                        //Recebe o resultado do cadastro
                        resultadoDoCadastro = gravar4.gravarDados();      
                        //Imprime se foi cadastrado ou nao
                        System.out.println("\n#####################################################");
                        System.out.println("           "+resultadoDoCadastro);
                        System.out.println("#####################################################\n");
                        System.out.println("\n\n\n");
                        //Da uma pausa de 2 segundos para para ter tempo de ver o resultado
                        Thread.currentThread().sleep(2000);
                        break;
                    
                    case 5:
                        //Busca os dados do arquivo e printa para o usuario
                        gravarDadosEvento gravar5 = new gravarDadosEvento();
                        gravar5.mostrarDados();
                        //Da uma pausa de 3 segundos para para ter tempo de ver o resultado
                        Thread.currentThread().sleep(3000);
                        System.out.println("\n\n\n");
                        break;
                        
                    case 6:
                        
                    case 7:
                        
                    case 8:
                        
                    case 9:
                        metodosPessoa gravarPacote01 = new metodosPessoa();
                        gravarPacote01.adicionarPacoteDePessoas();
                        //Da uma pausa de 3 segundos para para ter tempo de ver o resultado
                        Thread.currentThread().sleep(3000);
                        break;
                        
                    case 10:
                        gravarDadosEvento gravarPacote02 = new gravarDadosEvento();
                        gravarPacote02.adicionarPacotesEvento();
                        //Da uma pausa de 3 segundos para para ter tempo de ver o resultado
                        Thread.currentThread().sleep(3000);
                        break;
                }
        }   
    }
    */
}