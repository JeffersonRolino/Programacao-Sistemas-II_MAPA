package registers;

import entities.Enfermeira;
import entities.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public class Registro {
    private Enfermeira enfermeira;
    private final ArrayList<Usuario> cidadaos = new ArrayList<>();

    //Construtores
    public Registro() {
    }

    public Registro(Enfermeira enfermeira) {
        this.enfermeira = enfermeira;
    }

    public Enfermeira getEnfermeira() {
        return enfermeira;
    }


    //Getters and Setters
    public void setEnfermeira(Enfermeira enfermeira) {
        this.enfermeira = enfermeira;
    }

    public ArrayList<Usuario> getUsuarios() {
        return cidadaos;
    }


    //Métodos
    public void adicionarCidadao(Usuario cidadao){
        this.cidadaos.add(cidadao);
    }
}
