/**
 * Created by Amanda on 11/01/2016.
 */
public class Jogador {
    private String nome;
    int id;
    int [] contaPontos = new int[8];


    Jogador(String nome){
        this.nome=nome;
    }

    public String getNome(){
        return nome;
    }



}
