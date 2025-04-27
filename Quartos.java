import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Quartos {
    
    public static void SelecionaQuarto() {
        int[] rooms = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
        Random random = new Random();
        int escolhe_quarto = random.nextInt(rooms.length);

        try {
             FileWriter fw = new FileWriter("quartos.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             
             bw.write("\n Nome: " + Hospedagem.nome);
             bw.write("\n Quarto: " + escolhe_quarto);
             
             fw.flush();
             bw.flush();
        
        } catch (IOException ee) {
            System.out.println("Deu ruim " + ee.getMessage());
        }
    }
}