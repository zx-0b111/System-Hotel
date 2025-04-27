import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cardapio {
    public static void escolherCardapio() {
          try {
            String[] breakfast = {"bacon", "ovos-mexidos", "panquecas", "sanduiche-natural", "bolo-chocolate", "joseph", "cafe", "acholatado", "pao-de-queijo", "boykisser"}; //10
            String[] lunch = {"tropeiro", "feijoada", "yuri", "sal-picao", "lasanha", "macarronada", "torta-de-frango", "churrasco", "strogonoff", "femboy", "vinagrete"}; //11
            String[] dinner = {"david", "picanha", "sopa", "macarrao", "arroz-temperado", "tomboy", "parmegiana"}; //7

            System.out.println("Escolha as opcoes de cardapio:\n");
            System.out.println("0. breakfast\n");
            System.out.println("1. lunch\n");
            System.out.println("2. dinner\n");

            FileWriter fw = new FileWriter("cardapio_usuarios.txt", true);
            Scanner sc = new Scanner(System.in);
            int opcoes = sc.nextInt();
            System.out.println("Opcao escolhida: " + opcoes);

            switch (opcoes) {
            case 0:
                    for (String elementos: breakfast) {
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("\n\nNome: " + Hospedagem.nome);
                        bw.write("\nCafe: ");
                        bw.write(elementos);

                        fw.flush();
                        bw.flush();
                    }
                    break;

            case 1:
                    for(String elementos2: lunch) {
                        BufferedWriter bw2 = new BufferedWriter(fw);
                        bw2.write("\n\nNome: " + Hospedagem.nome);
                        bw2.write("\nAlmoco: ");
                        bw2.write(elementos2);

                        fw.flush();
                        bw2.flush();
                    }
                    break;

            case 2:
                    for(String elementos3: dinner) {
                        BufferedWriter bw3 = new BufferedWriter(fw);
                        bw3.write("\n\nNome: " + Hospedagem.nome);
                        bw3.write("\nJanta: ");
                        bw3.write(elementos3);

                        fw.flush();
                        bw3.flush();
                    }
                    break;
                }

        } catch (IOException eeeeee) {
            System.out.println("Deu ruim " + eeeeee.getMessage());
        }   
    }
}