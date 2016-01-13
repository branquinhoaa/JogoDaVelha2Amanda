    /**
     * Created by Amanda on 11/01/2016.
     */
    public class Tabuleiro {
        Jogada jogada;
        Jogada [] guardadorJogadas = new Jogada[9];
        int aux = 0;
       String vencedor;


        public void mostraTabuleiro(){
            for (int i=0; i<3; i++){
                for (int n=0; n<3; n++){
                   // int linha =guardadorJogadas[aux-1].linha;
                    //int coluna = guardadorJogadas[aux-1].coluna;
                    //Jogador jogador = guardadorJogadas[aux-1].jogador;
                    //jogada = new Jogada (linha, coluna, jogador);
                    if(i!=2){
                        if (temJogada(i,n)){
                            if (getJogador(i,n).id==1) {
                                System.out.print("o");
                            } else {
                                System.out.print("x");
                            }
                        } else{
                            System.out.print("_");
                        }
                    }
                    else {
                        if (temJogada(i,n)) {
                            if (getJogador(i, n).id == 1) {
                                System.out.print("o");
                            } else if (getJogador(i, n).id == 2) {
                                System.out.print("x");
                            }
                        }
                            else{
                            System.out.print(" ");
                    }}

                    if ( n!=2){
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

        public void guardaJogadas(int linha, int coluna , Jogador jogador){
                guardadorJogadas[aux]=new Jogada(linha,coluna,jogador);
                aux+=1;
        }


        public boolean temJogada (int linha, int coluna){
            for (int i=0; i<guardadorJogadas.length; i++){
                if (guardadorJogadas [i]!=null && guardadorJogadas[i].linha==linha && guardadorJogadas[i].coluna==coluna ){
                    return true;
                }
            }
            return false;
        }



        public Jogador getJogador (int l,int c){
            for (int i=0; i<guardadorJogadas.length; i++){
                if (guardadorJogadas[i].linha==l && guardadorJogadas[i].coluna==c){
                    return guardadorJogadas[i].jogador;
                }
            }
            return null;
        }

        public boolean terminaJogo(){
            if(guardadorJogadas[8]!=null || ganhaJogo()==true ) {
                    return true;
            }

            return false;
        }

           public void contaPontos() {

                           if (guardadorJogadas[aux-1].jogador.id == 1) {
                               if (guardadorJogadas[aux-1].linha == 0) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[0] += 1;
                               }
                               if (guardadorJogadas[aux-1].linha == 1) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[1] += 1;
                               }
                               if (guardadorJogadas[aux-1].linha == 2) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[2] += 1;
                               }
                               if (guardadorJogadas[aux-1].coluna == 0) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[3] += 1;
                               }
                               if (guardadorJogadas[aux-1].coluna == 1) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[4] += 1;
                               }
                               if (guardadorJogadas[aux-1].coluna == 2) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[5] += 1;
                               }
                               if (guardadorJogadas[aux-1].linha == guardadorJogadas[aux-1].coluna) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[6] += 1;
                               }
                               if ((guardadorJogadas[aux-1].linha == 1 && guardadorJogadas[aux-1].coluna == 3) || (guardadorJogadas[aux-1].linha == 2 && guardadorJogadas[aux-1].coluna == 2) || (guardadorJogadas[aux-1].linha == 3 && guardadorJogadas[aux-1].coluna == 1)) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[7] += 1;
                               }
                           } else if (guardadorJogadas[aux-1].jogador.id == 2) {
                               if (guardadorJogadas[aux-1].linha == 0) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[0] += 1;
                               }
                               if (guardadorJogadas[aux-1].linha == 1) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[1] += 1;
                               }
                               if (guardadorJogadas[aux-1].linha == 2) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[2] += 1;
                               }
                               if (guardadorJogadas[aux-1].coluna == 0) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[3] += 1;
                               }
                               if (guardadorJogadas[aux-1].coluna == 1) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[4] += 1;
                               }
                               if (guardadorJogadas[aux-1].coluna == 2) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[5] += 1;
                               }
                               if (guardadorJogadas[aux-1].linha == guardadorJogadas[aux-1].coluna) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[6] += 1;
                               }
                               if ((guardadorJogadas[aux-1].linha == 0 && guardadorJogadas[aux-1].coluna == 2) || (guardadorJogadas[aux-1].linha == 1 && guardadorJogadas[aux-1].coluna == 1) || (guardadorJogadas[aux-1].linha == 2 && guardadorJogadas[aux-1].coluna == 0)) {
                                   guardadorJogadas[aux-1].jogador.contaPontos[7] += 1;
                               }

                           }
                       }




        public boolean ganhaJogo(){
            for (int i=0; i<9;i++){
                for (int j=0;j<8;j++){
                    if (guardadorJogadas[i]!=null && guardadorJogadas[i].jogador.contaPontos[j]==3){
                        vencedor = guardadorJogadas[i].jogador.getNome();
                        System.out.println("parabeeens para o jogador " + vencedor  + " vencedor dessa rodada!");
                        return true;
                    }
                }
            }
        return false;
        }
    }
