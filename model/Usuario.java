package model;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Usuario
 */
public class Usuario {
    Set<Disciplina> d = new TreeSet<>();
    public boolean addDisciplina(Disciplina _d){
        if(_d!= null){
            d.add(_d);
            return true;
        }
        
        return false;
    }
    public Set<Disciplina> getDisciplinas(){
        return d;
    }
}
