/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros2;


import java.util.ArrayList;

/**
 *
 * @author Filipe
 */
public class Escolas {
    private int codigo;
    private String nome;
    private ArrayList<Professores> profs;

    public Escolas(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        profs = new ArrayList();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Professores> getProfs() {
        return profs;
    }

    public void setProfs(ArrayList<Professores> profs) {
        this.profs = profs;
    }
    
    public void addProf (Professores P) {
        profs.add(P);
    }
    
    public void deleteProf (Professores P) {
        profs.remove(P);
    }
}
