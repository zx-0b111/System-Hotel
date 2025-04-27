import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospedagem {
    
    public static int idade;
    public static double cpf;
    public static Scanner texto;
    public static String nome;

    public static void registroPessoa() {
        System.out.println("Digite o seu nome: ");
        texto = new Scanner(System.in);
        nome = texto.nextLine();
        
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
                    while(meu_leitor.hasNextLine()) {
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
    }
}