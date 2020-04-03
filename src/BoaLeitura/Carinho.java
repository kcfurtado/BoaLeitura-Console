
package BoaLeitura;

import java.util.Date;

public class Carinho {
    String titulo;
    int  isbn, quantidade;
    float preco;
    
    public Carinho(){
    }
    
    public Carinho(String titulo, int isnb, int quantidade,float preco){
        this.titulo = titulo;
        this.isbn = isnb;
        this.quantidade = quantidade; 
        this.preco = preco;
    }
    
    

    public String getTitulo() {
        return titulo;
    }
    
    public int getIsbn() {
        return isbn;
    }    

    public int getQuantidade() {
        return quantidade;
    }
    
    public float getPreco() {
        return preco;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }    

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setPreco(float preco) {
        this.preco= preco;
    }

    Carinho add(Date time) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
}
