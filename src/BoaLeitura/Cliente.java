
package BoaLeitura;

public class Cliente{
    
    int bi_cliente,nif_cliente,  telefone_cliente;
     String usuario;
    
    String  password,nome_cliente, pais,cidade, localidade, email_cliente;
    
    public Cliente(){
    }
    
    // construtor com parametros
    public Cliente (int bi_cliente,String usuario,String nome_cliente, String password, int nif_cliente,  String pais, String cidade,String localidade, String email, int telefone){
        
        this.bi_cliente = bi_cliente;
        this.usuario = usuario;
        this.password = password;
        this.nome_cliente = nome_cliente;
        this.nif_cliente = nif_cliente;        
        this.pais = pais;
        this.cidade = cidade;
        this.localidade = localidade;
        this.email_cliente = email;
        this.telefone_cliente = telefone;
    }
    //metodos para acessar dados
    
    public int getBi_cliente(){
        return bi_cliente;
    }
    
    public String getNome_cliente() {
        return nome_cliente;
    }
    
    public String getPassword() {
        return password;
         
    } 
    public int getNif_cliente(){
        return nif_cliente;
    }   
    
      
    public String getPais()
    {
        return pais;
    }
    
    public String getCidade()
    {
        return cidade;
    }
    
    public String getLocalidade()
    {
        return localidade;
    }
    
    public String getEmail_cliente(){
        return email_cliente;
    } 
      
    public int getTelefone_cliente(){
        return telefone_cliente;
    } 
    
    public void setBi_cliente(int bi_cliente) {
        this.bi_cliente = bi_cliente;
    }
    
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    
    public void setNif_cliente(int nif_cliente) {
        this.nif_cliente = nif_cliente;
    }
    
    
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    } 
    
    public void setTelefone_cliente(int telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    

    
}
