
package BoaLeitura;
public class Autor {
    String nome, nacionalidade, profissao, endereco;
    int num_registo,telefone,num_obras;
    
    public Autor(){
    }
    
    public Autor(int num_registo, String nome, String nacionalidade, String profissao, String endereco,int telefone, int num_obras){
        
        this.num_registo = num_registo;
        this.nome = nome;
        this.nacionalidade = nacionalidade;        
        this.profissao = profissao;
        this.endereco = endereco;
        this.telefone = telefone;
        this.num_obras = num_obras;
        
    }

    

    public int getNum_registo() {
        return num_registo;
    }

    public String getNome() {
        return nome;
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getProfissao() {
        return profissao;
    }
    
    
    public String getEndereco() {
        return endereco;
    }   

    public int getTelefone() {
        return telefone;
    }
    
    public int getNum_obras() {
        return num_obras;
    }
    
    
    
    public void setNum_registo(int num_registo) {
        this.num_registo = num_registo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }  

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    public void setNum_obras(int num_obras) {
        this.num_obras = num_obras;
    }
    
       
}
