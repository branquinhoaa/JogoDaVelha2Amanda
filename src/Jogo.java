    /**
     * Created by Amanda on 11/01/2016.
     */
    import java.util.Random;
    import java.util.Scanner;
    public class Jogo {

        Tabuleiro tabuleiro= new Tabuleiro();
        Scanner teclado = new Scanner(System.in);
        Jogador jogador1;
        Jogador jogador2;
        Jogador jogadorDaVez;
        int aux = 1;


        public void iniciaJogadores(){
            System.out.println("Bem vindo! Digite o nome do seu jogador!");
            jogador1 = new Jogador(teclado.next());
            jogador1.id=1;
            System.out.println("Quer jogar contra a maquina (digite 1) ou com outro jogador (digite 2)? ");
            int resp=teclado.nextInt();
            if (resp==1){
                jogoMaquina();
            }
            else if (resp==2 ){
                jogoDoisJogadores();
            } else {
                System.out.println("opcao invalida! vamos começar novamente! ");
                iniciaJogadores();
            }
        }


        public void jogoMaquina() {
            jogador2 = new JogadorMaquina();
            jogador2.id = 2;
            while (tabuleiro.terminaJogo() == false) {
                determinaJogadorDaVez();
                if (jogadorDaVez.equals(jogador2)) {
                    tabuleiro.mostraTabuleiro();
                    maquinaJoga();
                    tabuleiro.contaPontos();
                } else {
                    tabuleiro.mostraTabuleiro();
                    pedeJogada();
                    tabuleiro.contaPontos();
                }
            }
        }

        public void jogoDoisJogadores(){
            System.out.println("Digite o nome do segundo jogador");
            jogador2 = new Jogador(teclado.next());
            jogador2.id=2;
                while (tabuleiro.terminaJogo()== false){
                        tabuleiro.mostraTabuleiro();
                        determinaJogadorDaVez();
                        pedeJogada();
                        tabuleiro.contaPontos();
                }
        }

        public void determinaJogadorDaVez(){
            if (aux%2==0){
                jogadorDaVez=jogador1;
                System.out.println("Vez do jogador: " + jogador1.getNome());
            } else {
                jogadorDaVez=jogador2;
                System.out.println("Vez do jogador: " + jogador2.getNome());
            }
            aux+=1;
        }

        public void pedeJogada(){
            System.out.println("Faca sua jogada! digite a linha que deseja marcar: ");
            int linha = teclado.nextInt()-1;
            System.out.println("Faca sua jogada! digite a coluna que deseja marcar: ");
            int coluna=teclado.nextInt()-1;
            if (!tabuleiro.temJogada(linha,coluna)){
                tabuleiro.guardaJogadas(linha,coluna,jogadorDaVez);
            } else {
                System.out.println("impossível jogar esse valor, pois ele já foi jogado! Faça outra jogada");
                pedeJogada();
            }
        }

        public void maquinaJoga(){

            Random gerador = new Random();
            int linhaMaquina;
            int colunaMaquina;
            do {
                linhaMaquina = gerador.nextInt(3);
                colunaMaquina = gerador.nextInt(3);}
            while (tabuleiro.temJogada(linhaMaquina,colunaMaquina));
            tabuleiro.guardaJogadas(linhaMaquina,colunaMaquina,jogador2);
            System.out.print("Jogo da maquina foi => linha: "+ (linhaMaquina+1));
            System.out.println(" coluna: "+(colunaMaquina+1));

            }
        }