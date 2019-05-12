/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author Mateus Edival
 */
public class Equacao {
    private String tratar = new String();
    private Vector<String> pilha = new Vector<>();
    private Set<String> av = new TreeSet<>();
 
    
    public Equacao(String _tratar){
        tratar = _tratar;
        
    }
    //Mudar para public e propagar com exception
    public boolean tratamento(){
        clearVector();
        int fecha = 0;
        int numeroInvalido = 0;
        int varInvalido = 0;
        for (int i = 0; i < tratar.length(); i++) {
            char c = tratar.charAt(i);
            if(c == '(')
            {
                pilha.add(String.valueOf(c));
                fecha++;
            }
            else if(c == ')')
            {
                pilha.add(String.valueOf(c));
                fecha--;
            }
            else if((int)c > 47  && (int)c < 58) //numero
            {
                String num = "";
               while(((int)c > 47  && (int)c < 58) )
               {
                   num+=String.valueOf(c);
                   i++;
                   if(i >= tratar.length())
                      break;
                   c = tratar.charAt(i);
               }
               if(checkNum(num))
               {
                   pilha.add(num);
               }
               else
               {
                pilha.add("##");
                numeroInvalido++;  
               }
            }
            else if(((int)c > 64 && (int)c < 91) || ((int )c > 96 && (int)c < 123))//letra
            {
               String var = "";
               while((((int)c > 64 && (int)c < 91) || ((int )c > 96 && (int)c < 123)) )
               {
                   var+=String.valueOf(c);
                   i++;
                   if(i >= tratar.length())
                      break;
                   c = tratar.charAt(i);
               }
               if(checkVar(var))
               {
                   pilha.add(var);
                   av.add(var);
               }
               else
               {
                pilha.add("##");
                varInvalido++;  
               }
            }
            else if (c == '/' ||c == '*' ||c == '+' ||c == '-')
            {
                pilha.add(String.valueOf(c)); 
            }
            else 
            {
                continue;
            }
            
        }
        if(fecha == 0 || varInvalido == 0 || numeroInvalido == 0)
            return true;
        return false;
    }
    
    private boolean checkNum(String num)
    {
        char c;
        if(num.length() > 0)
            for (int i = 1; i < num.length(); i++) {
                c = num.charAt(i);
                if(!((int)c > 47  && (int)c < 58))
                    return false;
            }
        return true;
    }
    private boolean checkVar(String num)
    {
        char c;
        if(num.length() > 0)
            for (int i = 1; i < num.length(); i++) {
                c = num.charAt(i);
                if(!((int)c > 47  && (int)c < 58) || !(((int)c > 64 && (int)c < 91) || ((int )c > 96 && (int)c < 123)))
                    return false;
            }
        return true;
    }
    
    public int countAv()
    {
        return av.size();
    }

    private void clearVector() 
    {
        if(av.size() > 0)
             av.clear();
    
        if(pilha.size() > 0)
            pilha.clear();
    }    
    public void printEq()
    {
        for (int i = 0; i < pilha.size(); i++) {
            System.out.print(pilha.get(i)+" ");
        }
    }
    
}
