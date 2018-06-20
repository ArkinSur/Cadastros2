/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros2;
    

public class Professores extends Funcionarios {
    private Escolas escola;

    public Professores(String nome, String endereco, int telefone, String data, int salario) {
        super(nome, endereco, telefone, data, salario);
    }

    public Escolas getEscola() {
        return escola;
    }

    public void setEscola(Escolas escola) {
        this.escola = escola;
    }

    
}
