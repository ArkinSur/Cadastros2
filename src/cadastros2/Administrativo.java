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
public class Administrativo extends Funcionarios {
    private Setores setor;
    
    
    public Administrativo(String nome, String endereco, int telefone, String data, int salario) {
        super(nome, endereco, telefone, data, salario);
        
    }

    public Setores getSetor() {
        return setor;
    }

    public void setSetor(Setores setor) {
        this.setor = setor;
    }

    
}
