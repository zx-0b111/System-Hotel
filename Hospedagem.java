import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hospedagem {
    static String nome;
    static int idade;
    static double cpf;

    public static void registroPessoa() {
        System.out.println("Digite o seu nome: ");
        Scanner texto = new Scanner(System.in);
        String nome = texto.nextLine();

        System.out.println("Digite sua idade: ");
        Scanner age = new Scanner(System.in);
        int idade = age.nextInt();

        System.out.println("Digite seu cpf: ");
        Scanner numero = new Scanner(System.in);
        int cpf = numero.nextInt();

        if(idade<18) {
            System.out.println("Menor de 18 não pode!!!");
            System.exit(0);
        }

        try {
            FileWriter fw = new FileWriter("agendamento.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            ArrayList<String> nomes= new ArrayList<String>();
            ArrayList<Integer> dados = new ArrayList<Integer>();
            ArrayList<Integer> rg = new ArrayList<Integer>();
            
            nomes.add(0, nome);
            dados.add(0, idade);
            rg.add(0, cpf);
            bw.write("\n Nome: " + nomes.get(0));
            bw.write("\n Idade: " + dados.get(0)); 
            bw.write("\n Cpf: " + rg.get(0));
            FileWriter fw2 = new FileWriter("agendamento.txt", true);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            ArrayList<String> nomes2= new ArrayList<String>();
            ArrayList<Integer> dados2 = new ArrayList<Integer>();
            ArrayList<Integer> rg2 = new ArrayList<Integer>();

            try {
                File meuArquivo = new File("agendamento.txt");
                Scanner meuLeitor = new Scanner(meuArquivo);
                while(meuLeitor.hasNextLine()) {
                    String acessa_nome = meuLeitor.nextLine();

                    nomes2.add(0, nome);
                    dados2.add(0, idade);
                    rg2.add(0, cpf);
                    bw2.write("\n Nome: " + nomes2.get(0));
                    bw2.write("\n Idade: " + dados2.get(0)); 
                    bw2.write("\n Cpf: " + rg2.get(0));

                    File acessa_arquivo = new File("agendamento.txt");
                    Scanner meu_leitor = new Scanner(acessa_arquivo);
                    if(meu_leitor.hasNextLine()) {
                        String dados3 = meu_leitor.nextLine();
                        int contador = 0;
                        int soma = contador+1;
                        if(dados3 == null ? nomes2.get(0) == null : dados3.equals(nomes2.get(0))) {
                            nomes2.add(soma, nome);
                            dados2.add(soma, idade);
                            rg2.add(soma, cpf);
                            bw2.write("\n Nome(List 2): " + nomes2.get(soma));
                            bw2.write("\n Idade(List 2): " + dados2.get(soma)); 
                            bw2.write("\n Cpf(List 2): " + rg2.get(soma));
                            fw2.flush();
                            bw2.flush();
                        }
                        }
                        meu_leitor.close();
                }
            } catch (ArrayIndexOutOfBoundsException eeee) {
                System.out.println("Feito com sucesso");
            }

            fw.flush();
            bw.flush();
            
            //Apenas para testar as ArrayLists
            System.out.println("Primeiro nome da lista: " + nomes.get(0));
            System.out.println("Primeira idade da lista: " + dados.get(0));
            System.out.println("Primeiro cpf da lista: " + rg.get(0));

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever o arquivo " + e.getMessage());
        }

        //Seletiva de quartos
        int[] rooms = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
        Random random = new Random();
        int escolhe_quarto = random.nextInt(rooms.length);

        try {
             FileWriter fw = new FileWriter("quartos.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             
             bw.write("\n Nome: " + nome);
             bw.write("\n Quarto: " + escolhe_quarto);
             
             fw.flush();
             bw.flush();
        
        } catch (IOException ee) {
            System.out.println("Deu ruim " + ee.getMessage());
        }

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
                        bw.write("\n\nNome: " + nome);
                        bw.write("\nCafe: ");
                        bw.write(elementos);

                        fw.flush();
                        bw.flush();
                    }
                    break;

            case 1:
                    for(String elementos2: lunch) {
                        BufferedWriter bw2 = new BufferedWriter(fw);
                        bw2.write("\n\nNome: " + nome);
                        bw2.write("\nAlmoco: ");
                        bw2.write(elementos2);

                        fw.flush();
                        bw2.flush();
                    }
                    break;

            case 2:
                    for(String elementos3: dinner) {
                        BufferedWriter bw3 = new BufferedWriter(fw);
                        bw3.write("\n\nNome: " + nome);
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