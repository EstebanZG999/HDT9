import java.io.*;
import java.util.*;
public class Controlador {

    Scanner scan = new Scanner(System.in);
    String elec;
    String elec2 = "";
    Tree<String, String> tree;
    ArrayList<String> lineas = new ArrayList<String>();

    public void principal() {
        System.out.println("Escriba que tipo de arbol desea utilizar: AVL ----- RedBlackTree");
        elec = scan.next().toLowerCase();
        tree = TreeFactory.createTree(elec);

        /**
         * @param Filename Es la direccion en donde esta el archivo que se debe leer
         * @return String
         * @author Juan Pablo Solis Proyecto Datos
         */
        try (BufferedReader br = new BufferedReader(new FileReader("src/Palabras.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("-");
                if (words.length == 2) {
                    String engWord = words[0].trim();
                    String spaWord = words[1].trim();
                    tree.insert(engWord, spaWord);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/TextoIngles.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/TextoEspañol.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    String translation = tree.search(word);
                    bw.write(translation != null ? translation : word);
                    bw.write(" ");
                }
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/TextoEspañol.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
