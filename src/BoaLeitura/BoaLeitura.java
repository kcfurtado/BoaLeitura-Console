/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~ Universidade de Cabo Verdde ~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~- UNICV ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Gelson Moreira ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Kelton Furtado ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Liliano        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PROJECTO Nº 1 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-- POO --~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * -----------------------------------------------------------------------------
 */

package BoaLeitura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BoaLeitura {
    
    // instanciação de Claase Date para apresentar da no meu
    static Date date = new Date();
    // instanciação um novo objeto do tipo Scanner
    static Scanner ler = new Scanner(System.in); 
    
    // Inicio declaração e criação de ArraysLists
    static GregorianCalendar GreCal = new GregorianCalendar(); //CLASSE PARA ARMAZENAR DODOS DA DATA
    static ArrayList <DadosLogin> lista_Login = new ArrayList<>(); // GUARDA DADOS DOS LOGIN'S // GUARD ADADDOS DE FUNCIONARIO
    static ArrayList <Livros> lista_livros = new ArrayList<>();
    static ArrayList <Cliente> lista_cliente = new ArrayList<>();
    static ArrayList <Venda> lista_venda = new ArrayList<>();
    static ArrayList <Carinho> lista_carinho = new ArrayList<>();
    static ArrayList <Autor>  lista_autor = new ArrayList<>();
    
    // fim declaração e criação de ArraysLists
    static File pasta;
    
    // instanciamento de objetos do tipo de  construtorres
    static DadosLogin dados_login = new DadosLogin();
    static Livros dados_livro = new Livros();
    static Cliente dados_cliente = new Cliente();
    static Venda dados_venda = new Venda();
    static Carinho dados_carinho = new Carinho();
    static Autor   dados_autor = new Autor();   
    //declaraçaõ de variaveis
    public static int op,op1, oparea, oppes,oppes1,op_1, op_12,op_13,op_14,op_15, op_16,op_17,op_18,op_19,op4;
   
    
    
 //========================================================================================================================//   
 //========================= Fim das de declaracoes de ArraysLists, variaveis construtors =================================// 
 //========================================================================================================================//     
 //================ Inicio de programação dos procedimentos funcioções e fincionalidades do programa=======================//
 //========================================================================================================================// 
     // LOGO da Empresa
    
    //Scannear numero com excepção de caracteres/ String
    public static int lerNum(){
        Scanner ler = new Scanner(System.in);
        int num;
        try{
            num = ler.nextInt();
            if (num == 99) {
                System.err.println("\t\t!!! Saiu da Edição !!!");
               menuMain();
            }
        }catch(InputMismatchException ex){
            System.err.println("!!! So e Possivel Introduzir Numeros !!!");
            System.out.print("\n Introduza Novamente: ");
            num = lerNum();        
        }
        return num;
    }
    
    //Scanner String
    public static String lerString()//funcao que permite ler palavras com espacos
    {
        Scanner palavras = new Scanner(System.in);

        String string = palavras.nextLine();
        try{
            if (string.equals("sair")||string.equals("SAIR")|| string.equals("exit")) {
            System.err.println("\t\t!!! Saiu da Edição !!!");
            menuMain();
            }
        }catch(InputMismatchException ex){
            System.err.println("!!! So e Possivel Introduzir Numeros !!!");
            System.out.print("\n Introduza Novamente ");
                    
            
        }

        return string;
    }
    
    public static float lerFloat(){
        Scanner ler = new Scanner(System.in);
        float num;
        try{
            num = ler.nextFloat();
        }catch(InputMismatchException ex){
            System.err.println("So e Possivel Introduzir Numeros!!!!");
            System.out.print("\n Introduza Novamente: ");
            num = lerFloat();        
        }
        return num;
    }
    
    //  CRIAR UMA PASTA
    public static void novaPasta(){
        
        pasta = new File("Base_de_Dados/");
        pasta.mkdir();
       
    }
   
 
 public static void registar_cliente() {
     
     Cliente cliente = new Cliente();
     int bi;
     boolean registar_cliente = true;
    
        System.out.println("\n");
        System.out.println("---------------------- Registo do Cliente -------------------|");
        System.out.print("\t\tDigitar o número de BI: ");        
        bi = lerNum();        
        for (int i = 0; i < lista_cliente.size(); i++)
        {
            dados_cliente = lista_cliente.get(i);
            if (bi == lista_cliente.get(i).getBi_cliente()) { 
                System.err.println("\t\t!!!AVISO: CLIENTE JÁ ESTÁ CADASTRADO !!!");
                return;
            }            
        }
        cliente.setBi_cliente(bi);
        System.out.print("\t\tDigitar o Usuario: ");
        cliente.setUsuario(lerString());
        System.out.print("\t\tDigitar o Password: ");
        cliente.setPassword(lerString());
        System.out.print("\t\tDigitar o Nome: ");
        cliente.setNome_cliente(lerString());
        System.out.print("\t\tDigitar o NIF: ");
        int nif = lerNum();        
        for (int i = 0; i < lista_cliente.size(); i++)
        {
            dados_cliente = lista_cliente.get(i);
            if (nif == lista_cliente.get(i).getNif_cliente()) { 
                System.err.println("\t\t!!!AVISO: NIF JÁ PERTENCE A UM CLIENTE !!!"
                        + "\n\t\t\t VERIFIQUE O SEU NIF E VOLTE A CADASTRAR");
                return;
            }            
        }
        
        cliente.setNif_cliente(nif); 
        System.out.print("\t\tDigitar o Pais: ");
        cliente.setPais(lerString());
        System.out.print("\t\tDigitar a Cidade: ");
        cliente.setCidade(lerString());
        System.out.print("\t\tDigitar a Localidade: ");
        cliente.setLocalidade(lerString());
        System.out.print("\t\tDigitar o seu Email: ");
        cliente.setEmail_cliente(lerString());
        System.out.print("\t\tDigitar o seu telefone: ");
        cliente.setTelefone_cliente(lerNum());

        if (registar_cliente == true) {
            lista_cliente.add(cliente);  
            guardar_cliente();
            System.out.println("\n\t!!!Cliente registado com sucesso!!!");
        } else {
            System.err.println("\t\t!!!Este nome ja existe!!!");
          }
    }
 
 private static void guardar_cliente() {
        File arquivo_Cliente = new File("Base_de_Dados/Dados_Cliente.txt");
        BufferedWriter escrever = null;
        StringBuilder join = new StringBuilder();

        for (Cliente nom : lista_cliente) {
            join.append(nom.getBi_cliente()).append("-");
            join.append(nom.getUsuario()).append("-");
            join.append(nom.getPassword()).append("-");
            join.append(nom.getNome_cliente()).append("-");
            join.append(nom.getNif_cliente()).append("-");
            join.append(nom.getPais()).append("-");
            join.append(nom.getCidade()).append("-");
            join.append(nom.getLocalidade()).append("-");
            join.append(nom.getEmail_cliente()).append("-");
            join.append(nom.getTelefone_cliente()).append("-");
            join.append("\n");             
        }        
        try {
            
            escrever = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo_Cliente)));
            escrever.write(join.toString());
            

        } catch (Exception e) {
            System.err.println("\t!!! Erro ao Guardar Nomes !!! ");
        } finally {
            if (escrever != null) {
                try {
                    escrever.close();
                } catch (Exception e) {
                    System.out.println("!!! Erro ao fechar Buffered Writer " + e.getMessage()+" !!!");
                }
            }
        }
    }
 
 private static void guardarLogin_cliente() {
        File arquivo_Cliente = new File("Base_de_Dados/Login_Cliente.txt");
        BufferedWriter escrever = null;
        StringBuilder join = new StringBuilder();

        for (Cliente nom : lista_cliente) {
            join.append(nom.getBi_cliente()).append("-");
            join.append(nom.getUsuario()).append("-");
            join.append(nom.getPassword()).append("-");
            join.append(nom.getNome_cliente()).append("-");
            join.append("\n");             
        }        
        try {
            
            escrever = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo_Cliente)));
            escrever.write(join.toString());
            
        } catch (Exception e) {
            System.err.println("\t!!! Erro ao Guardar Nomes !!! ");
        } finally {
            if (escrever != null) {
                try {
                    escrever.close();
                } catch (Exception e) {
                    System.out.println("!!! Erro ao fechar Buffered Writer " + e.getMessage()+" !!!");
                }
            }
        }
    }
 
 private static void carregar_Clientes() {          
        File arquivo_Cliente = new File("Base_de_Dados/Dados_Cliente.txt"); 
      
        BufferedReader carrega =null;
        try {

            carrega = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo_Cliente)));
            String linha;
            while ((linha = carrega.readLine()) != null) {
                  Cliente cliente = new Cliente();
                String[]  separar = linha.split("-");                
                cliente.setBi_cliente(Integer.parseInt( separar[0]));                              
                cliente.setUsuario( separar[1]);
                cliente.setPassword( separar[2]);  
                cliente.setNome_cliente( separar[3]); 
                cliente.setNif_cliente(Integer.parseInt( separar[4]));          
                cliente.setPais( separar[5]);
                cliente.setCidade( separar[6]);
                cliente.setLocalidade( separar[7]);
                cliente.setEmail_cliente( separar[8]);
                cliente.setTelefone_cliente(Integer.parseInt( separar[9]));
                
                lista_cliente.add(cliente);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\t\t!!! Nenhum Cliente Cadastrado !!!");
        } catch (IOException e) {
            System.err.println("!!! Problema ao ler os dados");
        } finally {
            if (carrega != null) {
                try {
                    carrega.close();
                    
                }catch (IOException e) {
                 }
            }
        }
}
      
public static void mostrar_Cliente() 
    { 
            for ( int i = 0; i < lista_cliente.size(); i++){    
                  dados_cliente = lista_cliente.get(i);              
                System.out.println("-------------------------- Cliente " + (i + 1) + "-----------------------");
                System.out.println("");
                System.out.println("\t\tBI: " + dados_cliente.getBi_cliente());
                System.out.println("\t\tNome: " +dados_cliente.getNome_cliente());
                System.out.println("\t\tNif: " +dados_cliente.getNif_cliente());
                System.out.println("\t\tPais: " + dados_cliente.getPais());
                System.out.println("\t\tCidade: " +dados_cliente.getCidade());
                System.out.println("\t\tLocalidade: " +dados_cliente.getLocalidade());
                System.out.println("\t\tEmail: " +dados_cliente.getEmail_cliente());
                System.out.println("\t\tTelefone: " +dados_cliente.getTelefone_cliente());
            }      
       }

     
    
    public static void eliminar_cliente() {
        int eliminar;
        boolean eliminado = false;        
        System.out.println("---------------------------- Eliminar Cliente -------------------------");  
        for (int i = 0; i < lista_cliente.size(); i++)//mostrar so os assuntos dos eventos
        {
            System.out.println("\t\t BI - " + lista_cliente.get(i).getBi_cliente()+ "\n\t\t Nome - " + lista_cliente.get(i).getNome_cliente());
        }
        System.out.print("\tEscolha o Bi do cliente a ser Eliminado: ");
        eliminar = lerNum();
        for (int i = 0; i < lista_cliente.size(); i++) {
            if (eliminar == lista_cliente.get(i).getBi_cliente()) {
              eliminado = lista_cliente.remove(lista_cliente.get(i));
            }
        }
        
        if (eliminado == true) {
            System.out.println("\n\t!!! Cliente removido com sucesso  !!!");
            guardar_cliente();
        }else{
             System.err.println("\n\tNao foi Possivel Eliminar o Cliente " + eliminar);
        }
   }
    
public static void alterar_cliente() {
        String nome;
                                    
        System.out.println("------------------------- Alterar Dados Cliente ------------------------");
          for(int i=0;i<lista_cliente.size();i++){
               System.out.println("\tNomes: " +lista_cliente.get(i).getNome_cliente()); 
          }
          
          System.out.print("\t\tDigitar o Nome do Cliente a Editar: ");
          nome= lerString();
          for(int i=0;i<lista_cliente.size();i++){
              if(nome.equals(lista_cliente.get(i).getNome_cliente())){
                int j  = i;
                String name;
                  System.out.println("");
                System.out.print("\t\tDigite Novo Nome do Cliente:  ");
                name =lerString();
                lista_cliente.get(j).nome_cliente = name;
                
                System.out.println("\t\t!!! Nome  Alterado  Com Êxito!!!");
                guardar_cliente();
             }else{
                  System.err.println("\t!!! Nome não Registado !!!");
              }
        }
    }
     
     public static void alterar_clientebyCliente() {
        String nome,pass,usua;
         System.out.println("");                           
         System.out.println("----------------------- Alterar Dados ------------------------");
         System.out.println("                        1-> Nome                               ");
         System.out.println("                        2-> Usuário                            ");
         System.out.println("                        3-> Senha                              ");
         System.out.println("                        0-> Voltar                             ");
         System.out.print("\tDigitar opção pretendida: ");
          int dicidi= lerNum();
          System.out.println("");
          
          if (dicidi == 1 ) {
             System.out.print("\t\tDigitar Nome actual: ");
          nome= lerString();
          for(int i=0;i<lista_cliente.size();i++){
              if(nome.equals(lista_cliente.get(i).getNome_cliente())){
                    int j  = i;
                    System.out.print("\t\tDigitar Novo Nome do Cliente:  ");
                    nome =lerString();
                    lista_cliente.get(j).nome_cliente = nome;

                    System.out.println("\t\t!!! Nome  Alterado  Com Êxito!!!");
                    guardar_cliente();
                }else{
                  System.err.println("\t\t!!! Nome não Registado !!!");
              }
          }
        }else if(dicidi == 2){
            System.out.print("\t\tDigitar Nome Usuario actual: ");
            usua= lerString();
            for(int i=0;  i<lista_cliente.size();  i++){
              if(usua.equals(lista_cliente.get(i).getUsuario())){
                    int j  = i;                
                    System.out.print("\t\tDigitar Novo nome Usuario:  ");
                    usua =lerString();
                    lista_cliente.get(j).usuario= usua;
                    System.out.println("\t\t!!! Nome usuário Alterado  Com Êxito!!!");
                    guardar_cliente();
                }else{
                  System.err.println("\t!!! Usuário não Registado !!!");
              }
           }
        }else if( dicidi == 3){        
          
            System.out.print("\t\tDigitar Senha actual: ");
            pass= lerString();
            for(int i=0;  i<lista_cliente.size();  i++){
                if(pass.equals(lista_cliente.get(i).getPassword())){
                    int j  = i;              
                    System.out.print("\t\tDigitar Novo Senha:  ");
                    pass =lerString();
                    lista_cliente.get(j).password = pass;
                    System.out.println("\t!!! Senha Alterado  Com Êxito!!!");
                    guardar_cliente();
                }else{
                  System.err.println("\t!!! Senha não Registado !!!");
                 }
           }
        
        } else{ 
            return;
        } 
    }
     
    
     public static void estilo_Capa() {
          
       Livros livro = new Livros();
        System.out.print("\tDigitar o Estilo de capa (duro ou broxura): ");
        String estilo_capa = lerString();
        if (estilo_capa.equals("duro") || estilo_capa.equals("brochura")) {
            livro.setEstilo_capa(estilo_capa);
        } else {
            System.out.println("!!! Só é permitido estilos brochura ou duro !!!");
            System.out.println("\t\tDigitar novamente: ");
            estilo_Capa();
        }
    }
     
     public static void registar_livro() {
         Livros livro= new Livros();
        boolean registar_livro = true;
         
        System.out.println("---------------------- Registo do Livro ----------------------");
        
        System.out.print("\t\tDigitar o ISBN: ");
        int isbn= lerNum();
        for (int i = 0; i < lista_livros.size(); i++)
        {
            dados_livro = lista_livros.get(i);
            if (isbn == lista_livros.get(i).ISBN) {
                System.err.println("!!!ATENÇÃO: Este Livro ja existe");
                registar_livro = false;  
                return;
            }
        }
        livro.setISBN(isbn);   
        System.out.print("\t\tDigitar o Titulo: ");
        livro.setTitulo(lerString());
        System.out.print("\t\tDigitar o Numero de Edição: ");
        livro.setNumero_edicao(lerNum());
        System.out.print("\t\tDigitar a Categoria: ");
        livro.setCategoria(lerString());
        System.out.print("\t\tDigitar a Editora: ");
        livro.setEditora(lerString());
        System.out.print("\t\tDigitar ano de Publicação: ");
        livro.setAno_publicacao(Integer.parseInt(lerString()));
        System.out.print("\t\tDigitar o resumo: ");
        livro.setResumo( lerString());
        System.out.print("\t\tDigitar o Sumario: ");
        livro.setSumario(lerString());
        System.out.print("\t\tDigitar o Número de páginas: ");
        livro.setNumPag(lerNum());
        System.out.print("\t\tDigitar o Estilo de capa (duro ou brochura): ");
        String estilo_capa = lerString();
        if (estilo_capa.equals("duro") || estilo_capa.equals("brochura")) {
            livro.setEstilo_capa(estilo_capa);
        } else {
            System.out.println("!!! Só é permitido estilos brochura ou duro !!!");
            System.out.println("\t\tDigitar novamente: ");
            estilo_Capa();
        }        
        System.out.print("\t\tDigitar o País da Publicação: ");
        livro.setPais_publicado(lerString());
        System.out.print("\t\tDigitar o Preço: ");
        livro.setPreco(lerNum());
        System.out.print("\t\tDigitar a Quantidade: ");
        livro.setQuantidade(lerNum());       
        System.out.print("\t\tDigite o numero de Autores: ");
        int num= lerNum();
         for (int j = 0; j < num; j++) {
            System.out.print("\t\tDigitar Nome: ");
            livro.setNome_autor(lerString());
            System.out.print("\t\tDigitar Nacionalidade: ");
            livro.setNacion_autor(lerString());
            System.out.print("\t\tDigitar Profissão: ");
            livro.setProfissao_autor(lerString());
            System.out.print("\t\tDigitar número de obra Publicado: ");
            livro.setNumObra_autor(lerNum());
            System.out.print("\t\tDigitar Telefone: ");
            livro.setTelefone_autor(lerNum()); 
         } 

        if (registar_livro == true) {
            lista_livros.add(livro);
            guardarLivro();
           
        } else {
            System.err.println("\t!!!ATENÇÃO: Este Livro ja existe");
        }
    }
     
     private static void guardarLivro() {
         
        File arquivo_Livro = new File("Base_de_Dados/Dados_Livro.txt");
        BufferedWriter escrever = null;
        StringBuilder join = new StringBuilder();

        for (Livros liv : lista_livros) {
 
            join.append(liv.getISBN()).append("-");
            join.append(liv.getTitulo()).append("-");
            join.append(liv.getNumero_edicao()).append("-");
            join.append(liv.getCategoria()).append("-");
            join.append(liv.getEditora()).append("-");
            join.append(liv.getAno_publicacao()).append("-");
            join.append(liv.getResumo()).append("-");
            join.append(liv.getSumario()).append("-");
            join.append(liv.getNumPag()).append("-");
            join.append(liv.getEstilo_capa()).append("-");
            join.append(liv.getPais_publicado()).append("-");
            join.append(liv.getPreco()).append("-");
            join.append(liv.getQuantidade()).append("-");             
            join.append(liv.getNome_autor()).append("-");
            join.append(liv.getProfissao_autor()).append("-");
            join.append(liv.getNacion_autor()).append("-");
            join.append(liv.getNumObra_autor()).append("-");
            join.append(liv.getTelefone_autor()).append("-");
            join.append("\n"); 
        }
        
        try {
            escrever = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo_Livro)));
            escrever.write(join.toString());
            System.out.println("!!! Livro guardado com Sucesso !!! ");

        } catch (Exception e) {
            System.err.println("!!! Erro ao Guardar Livro!!! ");
        } finally {
            if (escrever != null) {
                try {
                    escrever.close();
                } catch (Exception e) {
                    System.out.println("!!!ATENÇÃO: Erro ao fechar Buffered Writer " + e.getMessage());
                }
            }
        }
    }
     
     public static void carregar_Livro() {

        BufferedReader carrega = null;
        File arquivo_Livro = new File("Base_de_Dados/Dados_Livro.txt");
        Livros livro = new Livros();
        try {

            carrega = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo_Livro)));
            String linha;
            while ((linha = carrega.readLine()) != null) {
                String[]  separar = linha.split("-");                
                                
                livro.setISBN(Integer.parseInt( separar[0]));
                livro.setTitulo( separar[1]);
                livro.setNumero_edicao(Integer.parseInt( separar[2]));
                livro.setCategoria( separar[3]);
                livro.setEditora(  separar[4]);
                livro.setAno_publicacao(Integer.parseInt( separar[5]));
                livro.setResumo( separar[6]);
                livro.setSumario( separar[7]);
                livro.setNumPag(Integer.parseInt( separar[8]));
                livro.setEstilo_capa( separar[9]);
                livro.setPais_publicado( separar[10]);
                livro.setPreco(Integer.parseInt( separar[11]));
                livro.setQuantidade(Integer.parseInt( separar[12]));                  
                livro.setNome_autor( separar[13]);
                livro.setProfissao_autor( separar[14]);
                livro.setNacion_autor( separar[15]);
                livro.setNumObra_autor(Integer.parseInt( separar[16]));
                livro.setTelefone_autor(Integer.parseInt( separar[17])); 
                lista_livros.add(livro);             }
        } catch (FileNotFoundException e) {
            System.out.println("\t\t!!! Nenhum Livro Cadastrado !!!");
        } catch (IOException e) {
            System.err.println("!!!ATENÇÃO: Problema ao ler os dados");
        } finally {
           
            if (carrega != null) {
                try {
                    carrega.close();
                } catch (IOException e) {
                    System.out.println("!!! Não foi Possivel Carreagar");
                  }
            }
        }
    }
     
     public static void mostrar_livros() {
        
 
        for (int i = 0; i < lista_livros.size(); i++) {
            dados_livro = lista_livros.get(i);              
            System.out.println("");
            System.out.println("-------------------------- LIVRO " + (i+1) + " -----------------------");
            System.out.println("\t\tISBN: " + dados_livro.getISBN());
            System.out.println("\t\tTitulo: " + dados_livro.getTitulo());
            System.out.println("\t\tNumero de Edição: " + dados_livro.getNumero_edicao());
            System.out.println("\t\tCategoria: " + dados_livro.getCategoria());
            System.out.println("\t\tEditora: " + dados_livro.getEditora());            
            System.out.println("\t\tAno de publicação: " + dados_livro.getAno_publicacao());
            System.out.println("\t\tResumo: " + dados_livro.getResumo());
            System.out.println("\t\tSumário: "+dados_livro.getSumario());
            System.out.println("\t\tNúmero de páginas: "+dados_livro.getNumPag());
            System.out.println("\t\tEstilo de capa: " + dados_livro.getEstilo_capa());
            System.out.println("\t\tPaís de Publicação: " + dados_livro.getPais_publicado());
            System.out.println("\t\tPreço: " + dados_livro.getPreco());
            System.out.println("\t\tQuantidade: " + dados_livro.getQuantidade());
            System.out.println("\t\tNome do Auntor: "+dados_livro.getNome_autor());
        }     
}
      public static void PesquisarLivro(){
         
         System.out.println("----------------------------- Pesquisa ----------------------");
         System.out.println("");
         System.out.print("|\tDigitar a Titulo/ISBN: ");
         String pal_chave= lerString();
         
         for (int i = 0; i < lista_livros.size(); i++) {
            dados_livro = lista_livros.get(i); 
             if (pal_chave.equals(lista_livros.get(i).getTitulo()) || Integer.parseInt(pal_chave) == lista_livros.get(i).getISBN() ) {
                    System.out.println("");
                    System.out.println("\t\tISBN: " + dados_livro.getISBN());
                    System.out.println("\t\tTitulo: " + dados_livro.getTitulo());
                    System.out.println("\t\tNumero de Edição: " + dados_livro.getNumero_edicao());
                    System.out.println("\t\tCategoria: " + dados_livro.getCategoria());
                    System.out.println("\t\tEditora: " + dados_livro.getEditora());            
                    System.out.println("\t\tAno de publicação: " + dados_livro.getAno_publicacao());
                    System.out.println("\t\tResumo: " + dados_livro.getResumo());
                    System.out.println("\t\tSumário: "+dados_livro.getSumario());
                    System.out.println("\t\tNúmero de páginas: "+dados_livro.getNumPag());
                    System.out.println("\t\tEstilo de capa: " + dados_livro.getEstilo_capa());
                    System.out.println("\t\tPaís de Publicação: " + dados_livro.getPais_publicado());
                    System.out.println("\t\tPreço: " + dados_livro.getPreco());
                    System.out.println("\t\tQuantidade: " + dados_livro.getQuantidade());
                    System.out.println("\t\tNome do Auntor: "+dados_livro.getNome_autor());
             }            
        }
         
     }
     
     public static void mostrar_Parametro(){
         
         System.out.println("------------------- Pesquisa Por Paramatro --------------------");
         System.out.println("");
         System.out.print("\tDigitar a categoria: ");
         String pal_chave= lerString();
         
         for (int i = 0; i < lista_livros.size(); i++) {
            dados_livro = lista_livros.get(i); 
             if (pal_chave.equals(lista_livros.get(i).getCategoria())) {
                    System.out.println("");
                    System.out.println("\t\tISBN: " + dados_livro.getISBN());
                    System.out.println("\t\tTitulo: " + dados_livro.getTitulo());
                    System.out.println("\t\tNumero de Edição: " + dados_livro.getNumero_edicao());
                    System.out.println("\t\tCategoria: " + dados_livro.getCategoria());
                    System.out.println("\t\tEditora: " + dados_livro.getEditora());            
                    System.out.println("\t\tAno de publicação: " + dados_livro.getAno_publicacao());
                    System.out.println("\t\tResumo: " + dados_livro.getResumo());
                    System.out.println("\t\tSumário: "+dados_livro.getSumario());
                    System.out.println("\t\tNúmero de páginas: "+dados_livro.getNumPag());
                    System.out.println("\t\tEstilo de capa: " + dados_livro.getEstilo_capa());
                    System.out.println("\t\tPaís de Publicação: " + dados_livro.getPais_publicado());
                    System.out.println("\t\tPreço: " + dados_livro.getPreco());
                    System.out.println("\t\tQuantidade: " + dados_livro.getQuantidade());
                    System.out.println("\t\tNome do Auntor: "+dados_livro.getNome_autor());
             }            
        }
         
     }
     
     public static void mostrar_editora(){
         
         System.out.println("------------------- Pesquisa Por Parametro--------------------");
         System.out.println("");
         System.out.print("|\tDigitar a Editora: ");
         String pal_chave= lerString();
         
         for (int i = 0; i < lista_livros.size(); i++) {
            dados_livro = lista_livros.get(i); 
             if (pal_chave.equals(lista_livros.get(i).getEditora())) {
                    System.out.println("\t\tISBN: " + dados_livro.getISBN());
                    System.out.println("\t\tTitulo: " + dados_livro.getTitulo());
                    System.out.println("\t\tNumero de Edição: " + dados_livro.getNumero_edicao());
                    System.out.println("\t\tCategoria: " + dados_livro.getCategoria());
                    System.out.println("\t\tEditora: " + dados_livro.getEditora());            
                    System.out.println("\t\tAno de publicação: " + dados_livro.getAno_publicacao());
                    System.out.println("\t\tResumo: " + dados_livro.getResumo());
                    System.out.println("\t\tSumário: "+dados_livro.getSumario());
                    System.out.println("\t\tNúmero de páginas: "+dados_livro.getNumPag());
                    System.out.println("\t\tEstilo de capa: " + dados_livro.getEstilo_capa());
                    System.out.println("\t\tPaís de Publicação: " + dados_livro.getPais_publicado());
                    System.out.println("\t\tPreço: " + dados_livro.getPreco());
                    System.out.println("\t\tQuantidade: " + dados_livro.getQuantidade());
                    System.out.println("\t\tNome do Auntor: "+dados_livro.getNome_autor());
             }            
        }
         
     }
     
     public static void mostrar_AnoPub(){
         
         System.out.println("------------------- Pesquisa Por Parametro--------------------");
         System.out.println("");
         System.out.print("|\tDigitar a Ano de Publicação: ");
         int pal_chave= lerNum();
         
         for (int i = 0; i < lista_livros.size(); i++) {
            dados_livro = lista_livros.get(i); 
             if (pal_chave == lista_livros.get(i).getAno_publicacao()) {
                    System.out.println("");
                    System.out.println("\t\tISBN: " + dados_livro.getISBN());
                    System.out.println("\t\tTitulo: " + dados_livro.getTitulo());
                    System.out.println("\t\tNumero de Edição: " + dados_livro.getNumero_edicao());
                    System.out.println("\t\tCategoria: " + dados_livro.getCategoria());
                    System.out.println("\t\tEditora: " + dados_livro.getEditora());            
                    System.out.println("\t\tAno de publicação: " + dados_livro.getAno_publicacao());
                    System.out.println("\t\tResumo: " + dados_livro.getResumo());
                    System.out.println("\t\tSumário: "+dados_livro.getSumario());
                    System.out.println("\t\tNúmero de páginas: "+dados_livro.getNumPag());
                    System.out.println("\t\tEstilo de capa: " + dados_livro.getEstilo_capa());
                    System.out.println("\t\tPaís de Publicação: " + dados_livro.getPais_publicado());
                    System.out.println("\t\tPreço: " + dados_livro.getPreco());
                    System.out.println("\t\tQuantidade: " + dados_livro.getQuantidade());
                    System.out.println("\t\tNome do Auntor: "+dados_livro.getNome_autor());
             }            
        }
         
     }
     
     
     public static void alterar_livro() {
        int alterar;        
         
          System.out.println("--------------------------- Livros --------------------------");
                                   
           for(int i=0;i<lista_livros.size();i++){
                System.out.println("|\tTitulo: "+lista_livros.get(i).getTitulo()
                        + "\n\t\tISBN: " +lista_livros.get(i).getISBN() ); 
           }
                                        
            System.out.print("\tDigitar o ISBN do Livro a Editar: ");
            int isbn_livro= lerNum();
            for( int i=0; i<lista_livros.size(); i++){
                 if(isbn_livro == lista_livros.get(i).getISBN())
            {
              int j =0;
                do{
                     
                     System.out.println("------------------------- Dados a Alterar -------------------");
                     System.out.println("                   1 -> Quantidade do Livro                  ");
                     System.out.println("                   2 -> Preco do Livro                       "
                                     +"\n                   0 -> Voltar                               ");                                  
                     System.out.print("\tEscolha a opção pretendida: ");
                   alterar = lerNum();
                      
                   if(alterar == 1){
                        int quant;
                        System.out.print("\n\tDigite Novo quantidade do livro:  ");
                        quant =lerNum();
                        lista_livros.get(j).quantidade = quant;
                        System.out.println("\t!!! Quantidade Alterado !!!");
                         guardarLivro();
                        return;
                   }
                    if(alterar == 2){
                              int Preco;
                               System.out.print("\n\tDigite novo Preco do Livro: ");
                               Preco=lerNum();
                               System.out.println("\t\t!!! Preço Alterado !!!");
                               lista_livros.get(j).preco = Preco;
                               guardarLivro();
                               return;
                         }
                    else if(alterar ==0){
                        return;
                    }
                  }while(alterar!=0); 
                }//fechar o if 
            }
    }
     
     
     public static void pesquisa_sem_login(){
         
         
         System.out.println("");
         System.out.println("--------------------- Pesquisa de Livro ----------------");
         System.out.print("\tDigitar o Titulo/ISBN: ");
         String pal_chave= lerString();
         for (int i = 0; i < lista_livros.size(); i++) {
             
             if (pal_chave.equals(lista_livros.get(i).getTitulo()) || Integer.parseInt(pal_chave) == lista_livros.get(i).getISBN()) {
                 dados_livro = lista_livros.get(i);
                    
                        System.out.println("");             
                        System.out.println("--------------------- Livro(s) " + (i + 1) + "-------------------");
                        System.out.println("\t\tISBN: " + dados_livro.getISBN());
                        System.out.println("\t\tTitulo: " + dados_livro.getTitulo());
                        System.out.println("\t\tNumero de Edição: " + dados_livro.getNumero_edicao());
                        System.out.println("\t\tPaís de Publicação: " + dados_livro.getPais_publicado());
                        System.out.println("\t\tPreço(ECV): " + dados_livro.getPreco());
                        System.out.println("\t\tQuantidade: " + dados_livro.getQuantidade());
                    
            }
         }
     }
     
     public static void pesquisa_livro(){
         
         System.out.println("");
         System.out.println("--------------------- Pesquisa de Livro ----------------");
         System.out.print("\t\tDigitar o Titulo: ");
         String pal_chave= lerString();
         
         for (int i = 0; i < lista_livros.size(); i++) {
             
             if (pal_chave.equals(lista_livros.get(i).getTitulo())) {
                 dados_livro = lista_livros.get(i);
                 
                 do {    
                        System.out.println("");             
                        System.out.println("----------------------- Livro(s) " + (i + 1) + "------------------");
                        System.out.println("\t\tISBN: " + dados_livro.getISBN());
                        System.out.println("\t\tTitulo: " + dados_livro.getTitulo());
                        System.out.println("\t\tNumero de Edição: " + dados_livro.getNumero_edicao());
                        System.out.println("\t\tPaís de Publicação: " + dados_livro.getPais_publicado());
                        System.out.println("\t\tPreço(ECV): " + dados_livro.getPreco());
                        System.out.println("\t\tQuantidade: " + dados_livro.getQuantidade());
                        
                        System.out.println("");
                        System.out.println("----------------------- Menu de Pesquisas --------------------"
                                        +"\n                  1- Detathes do Livro                        "
                                       + "\n                  2- Adicionar ao Carrinho                    "
                                        +"\n                  0- Voltar                                   ");
                        System.out.print("|\tDigite a Opção pretendida: ");
                        int op_16  = lerNum();
                        switch(op_16){
                            case 1:
                                System.out.println("\n");
                       System.out.println("---------- Menu de Pesquisas/Detalhes do(s) Livro(s) ----------");
                                    System.out.println("\t\tFormato: "+dados_livro.getEstilo_capa());
                                    System.out.println("\t\tEditora: "+dados_livro.getEditora());
                                    System.out.println("\t\tData Publicação: "+dados_livro.getAno_publicacao());
                                    System.out.println("\t\tResumo: "+dados_livro.getResumo());
                                    System.out.println("\t\tSumário: "+dados_livro.getSumario());
                                    System.out.println("\t\tNúmero de Páginas: "+dados_livro.getNumPag());
                                    System.out.println("\t\tNome do Autor: "+dados_livro.getNome_autor());
                                    System.out.println("\t\tProfissaão do Autor: "+dados_livro.getProfissao_autor());
                                    System.out.println("\t\tNacionalidade do Autor: "+dados_livro.getNacion_autor());
                                    System.out.println("\t\tNúmero de Obra: "+dados_livro.getNumObra_autor());
                                    System.out.println("\t\tContacto do Autor: "+dados_livro.getTelefone_autor());
                                    System.out.println("");
                            break;
                            case 2:                               
                                
                                do {
                                    System.out.println("");
                                   System.out.println("---------------- Pesquisas/Adicionar no Carinho ------------------"
                                                    +"\n                       1- Dados do Carinho                        "
                                                   + "\n                       2- Concluir o Pedido                       ");
                                    System.out.print("|\t\tDigite a Opção pretendida: ");
                                     op_17 = lerNum();
                                    switch(op_17){
                                            case 1:
                                                do {
                                                                                                       
                                                    System.out.println("\n");
                                                    System.out.println("-----   Pesquisas/Adicionar no Carinho/Visualizar no Carinho   -------"
                                                                    +"\n                         1- Alterar Quantidade                        "
                                                                    +"\n                         2- Retirar Item                              "
                                                                    +"\n                         3- Concluir Pedido                           "
                                                                    +"\n                         4- Encerrar Compra                           "
                                                                    +"\n                         5- Adicionar Item no Carinho                 "
                                                                    +"\n                         0- Voltar                                    ");
                                                    
                                                    System.out.print("|\t\tDigite a Opção pretendida: ");
                                                     op_18 = lerNum();
                                                    switch(op_18){
                                                             case 1:
                                                                 alterar_carinho();
                                                             break;
                                                             case 2:
                                                                 eliminar_carinho();
                                                             break;
                                                             case 3:
                                                                    
                                                                   do {
                                                                        System.out.println("");
                                                                            System.out.println("------ Pesquisas/Adicionar no Carinho/Concluir o(s) pedido(s) ----"
                                                                                            +"\n                        1- Confirmar                              "
                                                                                            +"\n                        2- Cancelar                               ");
                                                                            System.out.print("|\t Digitar opção pretendida: ");
                                                                            op_19=lerNum();
                                                                        switch(op_19){
                                                                            case 1:
                                                                                guardar_carinho();
                                                                            break;
                                                                            case 2:
                                                                                System.out.println("\t\t!!! Cancelado com Sucesso !!!");
                                                                              break;
                                                                            
                                                                        } 
                                                                    } while (op_19!=0);
                                                                   break;
                                                             case 4:
                                                                 venda_livro(); 
                                                                 limpar_carinho();
                                                             break;
                                                             case 5:
                                                                 adic_Carinho();
                                                             break;
                                                     }
                                    
                                               } while (op_18!=0);
                                            break;
                                            case 2:
                                                
                                                do {
                                                System.out.println("------ Pesquisas/Adicionar no Carinho/Concluir o(s) pedido(s) ------"
                                                                +"\n\t\t 1- Confirmar"
                                                                +"\n\t\t 2- Cancelar");
                                                System.out.print("\t Digitar opção pretendida: ");
                                                op_19=lerNum();
                                                switch(op_19){
                                                    case 1:
                                                        adic_Carinho();
                                                        guardar_carinho();
                                                    break;
                                                    case 2:                                                       
                                                        System.out.println("!!! Cancelado com Sucesso !!!");
                                                        return;
                                                    
                                                  }                                           
                                               } while (op_19!=0);                                       
                                            break;
                                    }                                    
                                } while (op_17!=0);
                            break;
                        }                 
                } while (op_16!=0);    
             }else{
                 System.out.println("!!!Não existe Ninhum Livro nessa Categoria!!!");
             }
         }
         
     }
     
     public static void eliminar_livro() {

        int eliminar;
        boolean eliminado = false;
         
        System.out.println("-------------------- Eliminar  Livros ------------------------|");
        for (int i = 0; i < lista_livros.size(); i++)//mostrar so os assuntos dos eventos
        {
            System.out.println("|\tTitulo - " + lista_livros.get(i).getTitulo());
            System.out.println("|\t ISBN-  " + lista_livros.get(i).getISBN());
        }
        System.out.print("\n\tDigitar o ISBN do Livro para ser Eliminado: ");
        eliminar = lerNum();
        
        for (int i = 0; i < lista_livros.size(); i++) {
            if (eliminar == lista_livros.get(i).getISBN()) {
              eliminado = lista_livros.remove(lista_livros.get(i));
            }
        }
        
        if (eliminado == true) {
            System.out.println("\n\t!!! Cliente removido com sucesso  !!!");
            guardarLivro();
        }else{
             System.err.println("\n\tNao foi Possivel Eliminar o Cliente " + eliminar);
        }
  }
     
     public static void verificar_cliente() {
        boolean cliente_registado = true;

        System.out.print("\tDigitar o Nome do Cliente: ");
        String nome = lerString();

        for (int i = 0; i < lista_cliente.size(); i++)
        {
            dados_cliente = lista_cliente.get(i); 
            if (nome.equals(lista_cliente.get(i).getNome_cliente())) { 
                cliente_registado = false;  
            }
        }
        if (cliente_registado == true) {
            System.err.println("!!! ATENÇÃO: Este nome de Cliente não esta registado");
            verificar_cliente();
        } else {
            return;
        }
    }
   
     
     public static void venda_livro(){        
        
       System.out.println("--------------------------- Registo das Vendas ------------------");

       boolean encontrado = false;
       int j = 0;
          
        Venda venda = new Venda();
        
         if (GreCal.get(GreCal.DAY_OF_WEEK) == 7 && GreCal.get(GreCal.HOUR_OF_DAY) >= 16) {
            System.err.println("\nNão podes fazer nebhum pedido Sabado apartir das 16 horas");
            System.out.println("\n");
             System.err.println("!!! Não é permitido fazer Compra de Livro neste Horário !!!");
             System.out.println("+--------------------------- Horário de Venda ------------------+"
                             +"\n                SEGUNDA A SEXTA FEIRA DAS 24 HORAS            "
                            + "\n                  SÁBADO DAS 00:00 ÁS 16:00 HORAS              "
                            + "\n+--------------------------------------------------------------+");
        }
         else if(GreCal.get(GreCal.DAY_OF_WEEK)== 1 && GreCal.get(GreCal.HOUR_OF_DAY)>=0 && GreCal.get(GreCal.HOUR_OF_DAY)<=23){
             System.out.println("Hoje é Domingo não pode fazer nenhum pedido");
             System.out.println("\n");
             System.err.println("!!! Não é permitido fazer Compra de Livro neste Horário !!!");
             System.out.println("+--------------------------- Horário de Venda ------------------+"
                             +"\n                SEGUNDA A SEXTA FEIRA DAS 24 HORAS            "
                            + "\n                  SÁBADO DAS 00:00 ÁS 16:00 HORAS              "
                            + "\n+--------------------------------------------------------------+");
             
         }else{
              
            System.out.print("\tDigitar o Titulo do Livro: ");
            String tituloLivro = lerString();
            boolean vendaSim= true;
            int i=0;
            dados_livro = lista_livros.get(i);
            dados_cliente = lista_cliente.get(i);
            for ( i = 0; i < lista_livros.size(); i++) 
            {
                if (tituloLivro.equals(lista_livros.get(i).getTitulo())) {
                    encontrado = true;
                    venda.setTitulo(tituloLivro);
                    System.out.println("\t\t\t!!!Livro Disponivel!!! \t\n\t\tQuantidade "+ dados_livro.getQuantidade()+ "\n\t\tPreco unitário: "+
                            dados_livro.getPreco());

                    j = i;
                }
                    if(encontrado == true && dados_livro.getQuantidade()>=5){
                        System.out.println("\t!!! Quantidade Suficiente para Venda !!!");
                        
                        System.out.print("\t\tDigitar o ISBN: ");
                        int isb=lerNum();
                        for (int k = 0; k < lista_livros.size(); k++) {
                            if (isb == lista_livros.get(i).getISBN()) {
                                int zz= lista_livros.get(i).getISBN();
                                venda.setISBN(zz);
                            }else{
                                System.out.println("\t\t!!! ISNB não Exixtente !!!");
                                return;
                            }
                    }                 
                                                
                    
                    System.out.print("\t\tDigitar o nome Cliente: ");
                    String nom= lerString();
                    for (int k = 0; k < lista_cliente.size(); k++) {
                        if (nom.equals(lista_cliente.get(i).getNome_cliente())) {
                            venda.setNomeCliente(nom);
                            continue;
                        }else
                            System.out.println("\t\t!!! Cliente não Cadastrado !!!");
                            return;
                    }
                                        
                    System.out.print("\t\tDigitar o seu Email: ");
                    String email= lerString();
                    for (int k = 0; k < lista_cliente.size(); k++) {
                        if (email.equals(lista_cliente.get(i).getEmail_cliente())) {
                              venda.setEmail(email);                    
                              continue;
                        }else{
                            System.out.println("\t\t!!! Email náo existe !!!");
                            return;
                        }
                    }
                    System.out.print("\t\tDigitar a morada: ");
                    String adres = lerString();
                    for (int k = 0; k < lista_cliente.size(); k++) {
                        if (adres.equals(lista_cliente.get(i).getLocalidade())) {
                              venda.setMorada(adres);                    
                              continue;
                        }else{
                            System.out.println("\t\t!!! Morada náo existe !!!");
                            return;
                        }
                    }
                    System.out.print("\t\tDigitar o telefone: ");
                    int telefone = lerNum();
                    for (int k = 0; k < lista_cliente.size(); k++) {
                        if (telefone==lista_cliente.get(i).getTelefone_cliente()) {
                              venda.setTelefoneCliente(telefone);                    
                        continue;
                        }else{
                            System.out.println("\t\t!!! Morada náo existe !!!");
                            return;
                        }
                    }
                     
                        System.out.print("\t\tDigitar a quantidade a Comprar: ");
                        int numLivro = lerNum();
                        venda.setNumLivro(numLivro);
                    if ( vendaSim == true) {
                        lista_venda.add(venda);
                        guardar_Venda();
                        
                        dados_livro = lista_livros.get(i);
                      for(i=0; i<lista_livros.size(); i++){
                            if (tituloLivro.equals(lista_livros.get(i).getTitulo())) {
                                    j = i;
                                    lista_livros.get(j).quantidade -= numLivro;                                   
                                    guardarLivro();
                            } else {
                                   System.err.println("!!!ATENÇÃO: Este Livro não está Registado");
                              }
                    }                              
                System.out.println("\n\t\t!!! Venda efectuado com sucesso !!!");
                }else{
                    System.out.println("!!!ATENÇÃO: Quantidade inSuficiente para Venda");
                }
         }
         if(encontrado==false) {
            System.err.println("!!!AVISO: Nenhum livro com titulo " + tituloLivro + " encontrado");
        }
    }
   }
 }
     
     public static void carregar_venda() {
        BufferedReader carrega = null;
        File arquivo_Cliente = new File("Base_de_Dados/Dados_Vendas.txt");
        Venda venda = new Venda();

        try {
                // testar função append
            carrega = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo_Cliente)));
            String linha;
            while ((linha = carrega.readLine()) != null) {
                String[]  separar = linha.split("-");
                
                venda.setTitulo( separar[0]);
                venda.setISBN( Integer.parseInt(separar[1]));                
                venda.setNomeCliente( separar[2]);
                venda.setEmail( separar[3]);
                venda.setMorada( separar[4]);
                venda.setTelefoneCliente(Integer.parseInt( separar[5]));
                venda.setNumLivro(Integer.parseInt( separar[6]));


                lista_venda.add(venda);// objecto do tipo cliente
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("\t\t!!! Nenhuma Venda Cadastrado !!!");
        } catch (IOException e) {
            System.err.println("\t!!!AVISO: Problema ao ler os dados");
        } finally {
            //Fecha o Buffered Readr(para libertar memória)
            if (carrega != null) {
                try {
                    carrega.close();
                } catch (IOException e) {
                    System.err.println("!!!AVISO: O arquivo não foi carregado");
                   }
            }
        }
    }
     
     
     public static void guardar_Venda() {
        StringBuilder join = new StringBuilder();

        for (Venda nom : lista_venda) {
            
            join.append(nom.gettitulo()).append("-");
            join.append(nom.getIsnb()).append("-");
            join.append(nom.getnomeCliente()).append("-");            
            join.append(nom.getemail()).append("-");
            join.append(nom.getmorada()).append("-");
            join.append(nom.gettelefoneCliente()).append("-");
            join.append(nom.getNumLivro()).append("-");
            
            join.append("\n"); // e acrectenta um '\n' para gravar cada dado numa linha
        }

        File arquivo_Cliente = new File("Base_de_Dados/Dados_Vendas.txt");
        BufferedWriter writer = null;
        try {
            
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo_Cliente)));
            writer.write(join.toString());
            System.out.println("\t!!! Venda guardados com Sucesso !!!");

        } catch (Exception e) {
            System.err.println("!!! Erro ao Guardar Venda!!! ");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    System.out.println("!!!ATENÇÃO: Erro ao fechar Buffered Writer " + e.getMessage());
                }

            }
        }
    }
     
     
     public static void mostar_venda()//Função Para Mostrar os Dados dos contactos de um cliente 
    {
         
             for (int i = 0; i < lista_venda.size(); i++) {
            dados_venda = lista_venda.get(i);
            
            System.out.println("-------------------Venda " + (i + 1) + "-------------------");
            System.out.println("\t\tTitulo do Livro: " + dados_venda.gettitulo());
            System.out.println("\t\tISBN do livro: " + dados_venda.getIsnb());            
            System.out.println("\t\tNome Cliente: " + dados_venda.getnomeCliente());
            System.out.println("\t\tEmail do Cliente: " + dados_venda.getemail());
            System.out.println("\t\tMorada do CLiente: " + dados_venda.getmorada());
            System.out.println("\t\tTelefone do Cliente: " + dados_venda.gettelefoneCliente());
            System.out.println("\t\tNúmero de livro Vendido: " + dados_venda.getNumLivro());
          }
  }        
     
     public static void adic_Carinho(){
             
             Carinho carinho = new Carinho();
              int i = 0;
             System.out.println("---------------------- Carinho ----------------------|");
             System.out.print("\tDigitar o Titulo que deseja adicionar: ");
             String livron= lerString();
             for( i=0;i<lista_cliente.size();i++){
                 dados_livro = lista_livros.get(i);
                 
                    if(livron.equals(lista_livros.get(i).getTitulo())){                  
                     
                        System.out.println("\t\t\tTitulo: " +lista_livros.get(i).getTitulo()); 
                        System.out.println("\t\t\tISBN: " +lista_livros.get(i).getISBN()); 
                        System.out.println("\t\t\tPreço: " +lista_livros.get(i).getPreco());                         
                     
                     System.out.print("\t\tDigitar 1 para ADICIONAR"
                                    + "\n\t\tDigitar 0 para SAIR");
                     int test = lerNum();
                     if (test== 1) {
                         System.out.println("-------------------- Entrar os Dados ---------------------");
                         System.out.print("\t\tDigitar o Titulo: "); 
                         carinho.setTitulo(lerString());
                         System.out.print("\t\tDigitar a ISBN: "); 
                         carinho.setIsbn(lerNum());
                         System.out.print("\t\tDigitar o Quantidade: "); 
                         carinho.setQuantidade(lerNum());
                         System.out.print("\t\tDigitar o Preço: "); 
                         carinho.setPreco(lerFloat());
                         
                          lista_carinho.add(carinho);  
                          guardar_carinho();
                 
                     } else if(test==0){
                         return;
                     }else{
                         System.out.println("\n!!! Opção Invalida !!!");
                     }
                     
                     
              }else{
                 System.out.println("\t!!!Esse livro não está registado !!!");
             }  
            }
         }
     
     public static void carregar_carinho() {
        BufferedReader carrega = null;
        File arquivo_Cliente = new File("Base_de_Dados/Dados_Carinho.txt");
        Carinho carinho = new  Carinho();

        try {
            carrega = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo_Cliente)));
            String linha;
            while ((linha = carrega.readLine()) != null) {
                String[]  separar = linha.split("-");
                
                carinho.setTitulo( separar[0]);
                carinho.setIsbn( Integer.parseInt(separar[1]));
                carinho.setQuantidade( Integer.parseInt(separar[2]));
                carinho.setPreco( Integer.parseInt(separar[3]));

                lista_carinho.add(carinho);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("\t\t!!! Nenhuma Item no Carinho !!!");
        } catch (IOException e) {
            System.err.println("\t!!!AVISO: Problema ao ler os dados");
        } finally {
            if (carrega != null) {
                try {
                    carrega.close();
                } catch (IOException e) {
                    System.err.println("!!!AVISO: O arquivo não foi carregado");
                   }
            }
        }
    }
     
     public static void guardar_carinho(){
         File arquivo_Carinho = new File("Base_de_Dados/Dados_Carinho.txt");
        BufferedWriter writer = null;int i=0;
        
        StringBuilder join = new StringBuilder();

        for ( Livros car: lista_livros) {

            join.append(car.getTitulo()).append("-");
            join.append(car.getISBN()).append("-");
            join.append(car.getQuantidade()).append("-");
            join.append(car.getPreco()).append("-");
            join.append("\n"); 
        }

        
        try {
            
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo_Carinho)));
            writer.write(join.toString());
            System.out.println("\t!!! Livro guardado com Sucesso !!! ");

        } catch (Exception e) {
            System.err.println("\t!!! Erro ao Guardar Livro!!! ");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    System.out.println("!!!ATENÇÃO: Erro ao fechar Buffered Writer " + e.getMessage());
                }
            }
        }
     
     }
     
     
     public static void mostra_carinho(){
         
         for (int i = 0; i < lista_carinho.size(); i++) {
            dados_carinho = lista_carinho.get(i);            
             
            System.out.println("------------------- Livro(s) do Carinho " + (i + 1) + "--------------------");
            System.out.println("\t\tTitulo: " + dados_carinho.getTitulo());
            System.out.println("\t\tISBN: " + dados_carinho.getIsbn());
            System.out.println("\t\tQuantidade: " + dados_carinho.getQuantidade());
            System.out.println("\t\tPreço: " + dados_carinho.getPreco());            
            
        }
     }
     
    public static void alterar_carinho() {
        String titul;
                                    
        System.out.println("---------------------------- Alterar dados no Carinho ------------------------|");
          for(int i=0;i<lista_carinho.size();i++){
              System.out.println("\t\tTitulo de Livro: " +lista_carinho.get(i).getTitulo());
               System.out.println("\t\tQuanidade de Livro: " +lista_carinho.get(i).getQuantidade()); 
          }
          
          System.out.print("\tDigitar o Titulo do Livro a Editar Quantidade: ");
           titul= lerString();
          for(int i=0;i<lista_livros.size();i++){
              if(titul.equals(lista_carinho.get(i).getTitulo())){
             int j  = i;
             
             int newQuant;
             System.out.print("\t\tDigite Novo Quantidade:  ");
             newQuant =lerNum();
             lista_carinho.get(j).quantidade = newQuant;
             System.out.print("\t!!! Quantidade Alterado !!!");
             guardar_carinho();
             }else{
                  System.err.println("\t!!! Nome não Registado !!!");
              }
        }
    }
    
    public static void eliminar_carinho() {

        int eliminar;
        boolean eliminado = false;
        System.out.println("-------------------- Eliminar Livro do Carinho ------------------------");
        for (int i = 0; i < lista_carinho.size(); i++)//mostrar so os assuntos dos eventos
        {
            System.out.println("\t\tTitulo - " + lista_carinho.get(i).getTitulo() + "\n\t\t ISBN-  " + lista_carinho.get(i).getIsbn());
        }
        System.out.print("\tEscolha o ISBN do Livro a Eliminar: ");
        eliminar = lerNum();

        for (int i = 0; i < lista_carinho.size(); i++) {
            if (eliminar == lista_carinho.get(i).getIsbn()) {
              eliminado = lista_carinho.remove(lista_carinho.get(i));
            }
        }
        
        if (eliminado == true) {
            System.out.println("\t!!!  Carinho removido com sucesso  !!!");
            guardar_carinho();
        }else{
             System.err.println("\tNao foi Possivel Eliminar o Cliente " + eliminar);
        }
  }    
    
    public static void limpar_carinho() {
                lista_carinho.clear();
                guardar_carinho();
  }    
    
    public static void relatorio(){
        
        System.out.println("|----------------------- Relatório do Sistema -----------------|");
        System.out.println("\t\tNúmero de Cliente: "+ lista_cliente.size());
        System.out.println("\t\tNúmero de Livro: "+ lista_livros.size());
        System.out.println("\t\tNúmero de Livro Vendido: "+ lista_venda.size());
    }     
     
    //Meno principal da aplicação
    public static void menuMain(){
        novaPasta();
        
                   
        do {       
            System.out.println("");
        System.out.println("                 BemVindo a livraria 'Boa Leitura'           ");
        System.out.println("                   Menu Principal do Aplicativo              ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("                        1-> Cliente                          ");
        System.out.println("                        2-> Gerente                          ");
        System.out.println("                        3-> Ajuda Usuário                    ");
        System.out.println("                        0-> Fechar Programa                  ");
        System.out.println("-------------------------------------------------------------");
        carregar_Clientes();
        carregar_Livro();
        carregar_venda();        
        System.out.println("-------------------------------------------------------------");
        System.out.println("    Horário Inicio Sessão: " +date+ "      ");
        System.out.println("");
        System.out.print("  Digite a opção pretendida: ");        
        Scanner entrar = new Scanner(System.in);
        op = entrar.nextInt();
         
        switch(op){
            case 1:
                               
                do{
                    System.out.println("\n");
                    System.out.println("                  BemVindo a livraria 'Boa Leitura'            "
                                      +"\n                         Menu de Cliente                     "
                                      +"\n-------------------------------------------------------------"
                                      +"\n                    1-> Pesquisar Livro por Categoria        "
                                      +"\n                    2-> Ver Todos Os Livros                  "
                                      +"\n                    3-> Login                                "
                                      +"\n                    4-> Cadastrar                            "
                                      +"\n                    0-> Voltar Menu Primcipal                ");
                    System.out.println("");
                                      System.out.print("\tDigite a opção pretendida: ");
                                      op1 =lerNum();
                    
                        switch(op1){
                            case 1:
                                System.out.println("\n");
                                   System.out.println("                   BemVindo a livraria Boa Leitura           "
                                                  +"\n      Menu de Cliente/Pesquisa de livro por categoria        v"
                                                  +"\n---------------------------------------------------------------");
                                   System.out.println("OBS: Deve usar palavras chaves Exemplo: romance,  ensino...");
                                   pesquisa_sem_login();
                                      
                            break;
                            case 2:
                                mostrar_livros();
                            break;
                                
                            case 3:
                                System.out.println("\n");
                                System.out.println("                BemVindo a livraria 'Boa Leitura'            "
                                                +"\n                     Menu de Cliente/Fazer Login             "
                                               + "\n----------------------------------------------------------------");
                                
                                        System.out.print("\t\t\t- Usuário: ");
                                        String usuari= lerString();                                
                                        System.out.print("\t\t\t- Senha : ");
                                        String senha= lerString();     
                                        
                                        for (int i= 0; i < lista_cliente.size(); i++) {
                                            dados_cliente = lista_cliente.get(i);                                         
                                                    
                                                if (usuari.equals(lista_cliente.get(i).getUsuario()) && senha.equals(lista_cliente.get(i).getPassword())) {                                                    
                                                        System.out.println("\n\t\t!!! Login concluido com êxito !!!");
                                                        carregar_carinho();
                                                        guardarLogin_cliente();                                                                                      
                                                    
                                                    System.out.println("");
                                                    do{
                                                        System.out.println("                   BemVindo a livraria Boa Leitura           "
                                                                        +"\n                           Cliente/Login                     "
                                                                        +"\n-------------------------------------------------------------" 
                                                                        +"\n                      1-> Pesquisar livros                   "
                                                                        +"\n                      2-> Comprar Livros                     "
                                                                        +"\n                      3-> Mostrar Carinho                    "
                                                                        +"\n                      4-> Meus Dados                        "
                                                                        +"\n                      5-> Alterar Dados                      "
                                                                        +"\n                      6-> Eliminar cadastro                  "
                                                                        +"\n                      0-> Encerrar Secção                    ");
                                                                        System.out.println("");
                                                                        System.out.print("| Digite a opção pretendida: ");

                                                        oppes1 = lerNum();

                                                            switch(oppes1){

                                                            case 1:
                                                                System.out.println("");
                                                                    System.out.println("                  BemVindo a livraria Boa Leitura            "
                                                                                    +"\n                     Menu de Cliente/Pesquisa                "
                                                                                    +"\n-------------------------------------------------------------");
                                                                    pesquisa_livro();                                                                
                                                             break;
                                                            case 2:
                                                                venda_livro();
                                                            break;
                                                            case 3:
                                                                    mostra_carinho();                                                                
                                                            break;
                                                            
                                                            case 4:
                                                               
                                                                for (  i = 0; i < lista_cliente.size(); i++){    
                                                                        dados_cliente = lista_cliente.get(i); 
                                                                        if (usuari.equals(lista_cliente.get(i).getUsuario())) {
                                                                                System.out.println("-------------------------- Meus Dados -----------------------");

                                                                                System.out.println("\t\tBI: " + dados_cliente.getBi_cliente());
                                                                                System.out.println("\t\tUsuario: " + dados_cliente.getUsuario());
                                                                                System.out.println("\t\tPassword: " +dados_cliente.getPassword());
                                                                                System.out.println("\t\tNome: " +dados_cliente.getNome_cliente());
                                                                                System.out.println("\t\tNif: " +dados_cliente.getNif_cliente());
                                                                                System.out.println("\t\tPais: " + dados_cliente.getPais());
                                                                                System.out.println("\t\tCidade: " +dados_cliente.getCidade());
                                                                                System.out.println("\t\tLocalidade: " +dados_cliente.getLocalidade());
                                                                                System.out.println("\t\tEmail: " +dados_cliente.getEmail_cliente());
                                                                                System.out.println("\t\tTelefone: " +dados_cliente.getTelefone_cliente());
                                                                        }
                                                                        
                                                                    }
                                                               break;                                                            
                                                            case 5:
                                                                alterar_clientebyCliente();
                                                            break;
                                                            
                                                            case 6:
                                                                boolean eliminado=true;
                                                                for (  i = 0; i < lista_cliente.size(); i++){    
                                                                        dados_cliente = lista_cliente.get(i); 
                                                                        if (usuari.equals(lista_cliente.get(i).getUsuario())) {
                                                                                   eliminado = lista_cliente.remove(lista_cliente.get(i));
                                                                            }
                                                                        }

                                                                        if (eliminado == true) {
                                                                            System.out.println("\n\t!!! Cadastro eliminado com sucesso  !!!");
                                                                            guardar_cliente();
                                                                            menuMain();
                                                                        }else{
                                                                            System.err.println("\n\tNao foi Possivel Eliminar o Cliente " );
                                                                        }
                                                                        
                                                                
                                                             break;
                                           
                                                        }
                                                    }while(oppes1!=0);
                                                }else{
                                                    System.out.println("\t\t!!! Usuario e/ou Senha incorrecta !!!");                                    
                                                }                                                                             
                                   }                                               
                            break;
                            
                            case 4:
                                registar_cliente();
                            break;
                            
                            
                     }                
                }while(op1 !=0);
                
            break;
            case 2:
                System.out.println("\n");
                System.out.println("                BemVindo a livraria 'Boa Leitura'            "
                                +"\n                   Menu de Gerente/Fazer Login               "
                                +"\n-------------------------------------------------------------"); 
                System.out.println("\t\t-> Usuário: Gerente");
                System.out.print("\t\t->Senha(predefinida): ");
                String pal_passe = lerString();
                
                 if(pal_passe.equals("password")){
                    System.out.println("");                    
                    System.out.println("                 !!!!! Senha Correcta !!!!!            ");                                      
                                      
                    do {
                        System.out.println("");
                        System.out.println("                      Livraria 'Boa Leitura'                 "
                                        +"\n                       Benvido a Aplicação                   "
                                        +"\n-------------------------------------------------------------"
                                        +"\n                1--> Gerênciamento de Clientes               "
                                        +"\n                2--> Gerênciamento de Livros                 "
                                        +"\n                3--> Gerenciamento de Venda                  "
                                        +"\n                4--> Relatório do sistema                    "
                                        +"\n                0--> Encerrar Secção                         ");
                        System.out.println("");
                         
                        System.out.print("Digite a opção pretendida:");
                        op_1=lerNum();
            
                        switch(op_1){
                            case 1: 
                                int i=0;
                                    do {
                                        System.out.println("\n");
                                        
                                        System.out.println("                      Livraria 'Boa Leitura'                 "
                                                        +"\n            Menu Gerente/Gerênciamento de Clientes           "
                                                        +"\n-------------------------------------------------------------"
                                                        +"\n                   1 -> Cadastrar Clientes                   "
                                                        +"\n                   2 -> Listar Clientes                      "
                                                        +"\n                   3 -> Eliminar Clientes                    "
                                                        +"\n                   4 -> Alterar Dados Clientes               "
                                                        +"\n                   0--> Voltar Menu Gerente                  ");
                                        System.out.println("");
                                        System.out.print("\tDigitar a opção pretendida:");
                                        op_12=lerNum();
            
                                        switch(op_12){
                                            case 1:
                                                registar_cliente();
                                            break;
                                            case 2:
                                                mostrar_Cliente();
                                            break;
                                            case 3:
                                                eliminar_cliente();
                                            break;
                                            case 4:
                                                alterar_cliente();
                                            break;
                                        } 
                                    } while (op_12!=0);              
                            break;
                    
                            case 2:
                                do {System.out.println("\n");
                                    
                                    System.out.println("                      Livraria 'Boa Leitura'                 "
                                                        +"\n                Menu Gerente/Gerênciamento de Livros         "
                                                        +"\n-------------------------------------------------------------"
                                                        +"\n                   1 -> Cadastrar Livros                     "
                                                        +"\n                   2 -> Listar Livros                        "
                                                        +"\n                   3 -> Eliminar Livros                      "
                                                        +"\n                   4 -> Alterar Dados Livros                 "
                                                        +"\n                   0--> Voltar Menu Gerente                  ");
                                    System.out.println("");
                                        System.out.print("Digite a opção pretendida: ");
                                        op_13=lerNum();
            
                                        switch(op_13){
                                            case 1:
                                                registar_livro();
                                                break;
                                            case 2:
                                                
                                                do{
                                                    System.out.println("");
                                                    System.out.println("                      Livraria 'Boa Leitura'                   "
                                                                    +"\n              Gerente/Gerênciamento de Livros/lista Livros     "
                                                                    +"\n---------------------------------------------------------------"
                                                                    +"\n                     1 -> Pesquisar livro                      "
                                                                    +"\n                     2 -> Listar por Parametro                 "
                                                                    +"\n                     3 -> Listar por Editora                   "
                                                                    +"\n                     4 -> Listar por Ano Publicação            "
                                                                    +"\n                     5 -> Listar Tudo                          "
                                                                    +"\n                     0--> Voltar Menu Gerente                  ");
                                                    System.out.println("");
                                                    System.out.print("\tDigite a opção pretendida: ");
                                                     op4 =lerNum();
                                                    switch(op4){
                                                        case 1: 
                                                            PesquisarLivro();
                                                        break;
                                                            
                                                        case 2:
                                                            mostrar_Parametro();
                                                        break;
                                                            
                                                        case 3: 
                                                            mostrar_editora();                                                           
                                                        break;
                                                            
                                                        case 4:
                                                            mostrar_AnoPub();
                                                        break;
                                                            
                                                        case 5:
                                                            mostrar_livros();
                                                        break;
                                                    }
                                                }while(op4!=0); 
                                                break;
                                        
                                            case 3:
                                                eliminar_livro();
                                                break;
                                            case 4:
                                                alterar_livro();
                                                break;
                                        }
                                  } while (op_13!=0);                
                            break;
                            case 3:
                                
                                do {
                                    System.out.println("\n");
                                    
                                    System.out.println("                      Livraria 'Boa Leitura'                     "                                                        
                                                        +"\n                Menu Gerente/Gerênciamento de Vendas         "
                                                        +"\n-------------------------------------------------------------"
                                                        +"\n                   1 -> Fazer Venda                          "
                                                        +"\n                   2 -> Listar Venda                         "
                                                        +"\n                   0 -> Voltar Menu Gerente                  ");
                                    System.out.println("");
                                        System.out.print("Digite a opção pretendida: ");
                                        op_14=lerNum();
            
                                        switch(op_14){
                                            case 1:
                                                System.out.println("                Menu Gerente/Gerênciamento de Vendas         "
                                                                +"\n-------------------------------------------------------------");
                                               venda_livro();
                                                
                                                
                                            break;
                                            case 2:                                               
                                                mostar_venda();
                                            break;
                                            
                                        }
                                } while(op_14!=0);                         
                            break;
                            
                            case 4:
                                relatorio();
                              break;
                        } 
                    } while (op_1!=0);
                                       
                } else{
                    System.out.println("\n");
                    System.out.println("                 !!! Senha incorrecta !!!        ");
                    menuMain();
                }   
                 
            break;
                
            case 3:
                System.out.println("");
                System.out.println("+------------------------- Help User -----------------------------+");
                System.out.println(" Usar número '99' para cancelar modo edição em campo de números      ");
                System.out.println(" Usar String 'sair' para cancelar modo edição em campo de palavra  ");
                System.out.println("+-----------------------------------------------------------------+");
                System.out.println("");
                break;                     
          }
        } while (op !=0);
    }     
    
    // clase principal do programa
    public static void main(String[] args) {
         menuMain();            
    }
}