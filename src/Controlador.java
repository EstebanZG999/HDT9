import java.io.*;
import java.util.*;
public class Controlador {

    Scanner scan = new Scanner(System.in);
    String elec;
    String elec2 = "";
    Tree<String, String> tree;
    ArrayList<String> texto = new ArrayList<String>();
    ArrayList<String> palabras = new ArrayList<String>();

    /**
     * El método principal es el punto de entrada del programa. Pide al usuario que seleccione el tipo de árbol o mapa que desea utilizar y lee los datos del archivo de palabras.
     * A continuación, construye el árbol o mapa a partir de los datos y lee el archivo de texto para traducir las palabras utilizando el árbol o mapa.
     */
    public void principal() {
        System.out.println("Escriba que tipo de arbol desea utilizar: AVL --- RedBlackTree --- Map");
        elec = scan.next().toLowerCase();
        tree = TreeFactory.createTree(elec);

        /**
         * @param Filename Es la direccion en donde esta el archivo que se debe leer
         * @return String
         * @author Juan Pablo Solis Proyecto Datos
         */
        try (BufferedReader br = new BufferedReader(new FileReader("src/Palabras.txt"))) {
            String lineaActual;
            while ((lineaActual = br.readLine()) != null) {
                palabras.add(lineaActual);
            }//Por si surge error leyendo el archivo, para que no salga error en el codigo
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

        //Construir el árbol o mapa a partir de los datos del archivo
        for (int i = 0; i <= palabras.size() - 1; i++) {
            String[] array = palabras.get(i).split("-");
            tree.insert(array[1].toLowerCase(), array[0].toLowerCase());
        }

        /**
         * @param Filename Es la direccion en donde esta el archivo que se debe leer
         * @return String
         * @author Juan Pablo Solis Proyecto Datos
         */
        try (BufferedReader br = new BufferedReader(new FileReader("src/Texto.txt"))) {
            String lineaActual;
            while ((lineaActual = br.readLine()) != null) {
                texto.add(lineaActual);
            }//Por si surge error leyendo el archivo, para que no salga error en el codigo
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

        //Construir el árbol o mapa a partir de los datos del archivo
        for (int i = 0; i < texto.size(); i++) {
            String traductor = texto.get(i);
            String[] array2 = texto.get(i).split(" ");
            for (int j = 0; j < array2.length; j++) {
                String x = translate(array2[j]);
                elec2 = elec2 + " " + x;
            }
            System.out.println(elec2);
            elec2 = "";
        }
    }

    //Traducir las palabras
    public String translate(String traductor) {
        return tree.search(traductor) != null ? tree.search(traductor) : "*" + traductor + "*";
    }
}
