
package BoaLeitura;


public class Venda {
    
    String nomeCliente, titulo, email, morada, dataVenda;
    
    int isnb, telefoneCliente;
    private int numLivro;
    
    public Venda(){
    }
    
    // construtor com parametros
    public Venda(String nomeCliente, String titulo, String email, String morada, String dataVenda,int telefoneCliente, int isbn, int numLivro){
        this.isnb= isbn;
        this.nomeCliente = nomeCliente;
        this.titulo = titulo;
        this.email = email;
        this.morada = morada;
        this.dataVenda = dataVenda;
        this.telefoneCliente = telefoneCliente;
        
    }
    
    //metodos para acessar dados
    public String getnomeCliente(){
        return nomeCliente;
    }
    
     public String gettitulo(){
         return titulo;
     }
     
      public String getemail(){
         return email;
     } 

    String getmorada() {
        return morada;
    }
    
    public String getdataVenda(){
         return dataVenda;
    }
    public int  gettelefoneCliente(){
         return telefoneCliente;
     }     

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setMorada(String morada) {
        this.morada = morada;
    }
    
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setTelefoneCliente(int telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    void setISBN(int parseInt) {
    }

    void setPais(String string) {
    }

    void setCidade(String string) {
    }

    /**
     * @return the isnb
     */
    public int getIsnb() {
        return isnb;
    }

    /**
     * @param isnb the isnb to set
     */
    public void setIsnb(int isnb) {
        this.isnb = isnb;
    }

    /**
     * @return the numLivro
     */
    public int getNumLivro() {
        return numLivro;
    }

    /**
     * @param numLivro the numLivro to set
     */
    public void setNumLivro(int numLivro) {
        this.numLivro = numLivro;
    }
     
}
 