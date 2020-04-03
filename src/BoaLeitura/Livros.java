
package BoaLeitura;


public class Livros {
    
    String categoria, editora, titulo, pais_publicado, tradutor, resumo,sumario, estilo_capa, idioma;
    private String nome_autor;
    private String profissao_autor;
    private String nacion_autor;
     int ISBN, numPag, ano_publicacao, numero_edicao, preco, quantidade;
    private int numObra_autor;
    private int telefone_autor;
     
   public Livros(){
    }
   // construtor com parametros 
   public Livros(int ISBN, String categoria, String editora, String titulo, String pais_publicado,
         String tradutor, String resumo,String sumario,int numPag, String estilo_capa, String idioma,  
         int ano_publicacao, int numero_edicao, int preco, int quantidade,String nome_autor,String profissao_autor, String nacion_autorint,int numObra_autor,int telefone_autor) { 
       
        this.ISBN = ISBN;
        this.categoria = categoria;
        this.editora = editora;         
        this.titulo = titulo;
        this.pais_publicado = pais_publicado;
        this.tradutor = tradutor;
        this.resumo = resumo; 
        this.sumario = sumario;
        this.numPag = numPag;
        this.estilo_capa = estilo_capa;
        this.idioma = idioma;
        this.ano_publicacao = ano_publicacao;        
        this.numero_edicao = numero_edicao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.nome_autor = nome_autor;
        this.profissao_autor = profissao_autor;
        this.nacion_autor = nacion_autorint;
        this.numObra_autor = numObra_autor;
        this.telefone_autor = telefone_autor;
        
    }
 
   
   //metodos para acessar dados
   
   
   public int getISBN() {
        return ISBN;
    }
   public String getCategoria() {
        return categoria;
    }
   
   public String getEditora() {
        return editora;
    }
   
   public String getTitulo() {
        return titulo;
    }
   
   public String getPais_publicado() {
        return pais_publicado;
    }
   
   public String getTradutor() {
        return tradutor;
    }
   
   public String getResumo() {
        return resumo;
    }
   
    public String getSumario() {
        return sumario;
    }
    
    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
    
    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
   
   public String getEstilo_capa() {
        return estilo_capa;
    }
   
   public String getIdioma() {
        return idioma;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }   
    
    public int getNumero_edicao() {
        return numero_edicao;
    }   

    public int getQuantidade() {
        return quantidade;
    }    

    public int getPreco() {
        return preco;
    }    

    
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void setEditora(String editora) {
        this.editora = editora;
    }
     
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setPais_publicado(String pais_publicado) {
        this.pais_publicado = pais_publicado;
    }
    
    public void setTradutor(String tradutor) {
        this.tradutor = tradutor;
    }
    
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }   
    
    public void setEstilo_capa(String estilo_capa) {
        this.estilo_capa = estilo_capa;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }
      

    public void setNumero_edicao(int numero_edicao) {
        this.numero_edicao = numero_edicao;
    }   

    public void setPreco(int preco) {
        this.preco = preco;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the nome_autor
     */
    public String getNome_autor() {
        return nome_autor;
    }

    /**
     * @return the profissao_autor
     */
    public String getProfissao_autor() {
        return profissao_autor;
    }

    /**
     * @return the nacion_autor
     */
    public String getNacion_autor() {
        return nacion_autor;
    }

    /**
     * @return the numObra_autor
     */
    public int getNumObra_autor() {
        return numObra_autor;
    }

    /**
     * @return the telefone_autor
     */
    public int getTelefone_autor() {
        return telefone_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public void setProfissao_autor(String profissao_autor) {
        this.profissao_autor = profissao_autor;
    }

    public void setNacion_autor(String nacion_autor) {
        this.nacion_autor = nacion_autor;
    }

    public void setNumObra_autor(int numObra_autor) {
        this.numObra_autor = numObra_autor;
    }

    public void setTelefone_autor(int telefone_autor) {
        this.telefone_autor = telefone_autor;
    }

       
}
