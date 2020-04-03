/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BoaLeitura;

class DadosLogin {
    private int bi;
    private String usuario;
    String nome, palavraPasse;
    
    public DadosLogin(){
    }
    
    public DadosLogin(int bi,String usuario, String nome, String palavraPasse){
        this.bi = bi;
        this.usuario= usuario;
        this.nome = nome;
        this.palavraPasse = palavraPasse; 
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getPalavraPasse(){
        return palavraPasse;
    }

    /**
     * @return the bi
     */
    public int getBi() {
        return bi;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }
 
}
