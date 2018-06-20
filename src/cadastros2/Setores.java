/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros2;

/**
 *
 * @author Filipe
 */
public class Setores {
    private int Codigo;
    private String nome;
    
    
    public Setores(int codigo, String setor) {
        this.Codigo = codigo;
        this.nome = setor;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Setor) {
        this.nome = Setor;
    }
    
    
}
