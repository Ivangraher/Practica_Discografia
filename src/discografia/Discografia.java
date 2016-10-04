package discografia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Discografia {

    // Lista de discos, variable de clase, se puede acceder desde todo este fichero
    private static ArrayList<Disco> misDiscos;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializamos la lista de discos 
        misDiscos = new ArrayList<>();
        int opcion;
        do {
            mostrarMenu();
            opcion = pedirEntero("Escoge una opción:");
            switch (opcion) {
                case 1:
                    nuevoDisco();
                    break;
                case 2:
                    modificarDisco();
                    break;
                case 3:
                    borrarDisco();
                    break;
                case 4:
                    mostrarTituloDiscos();
                    break;
                case 5:
                    System.out.println("Hasta la próxima!");
                    break;
                case 6: // Mostrar todos los datos de todos los discos
                    mostrarDiscosOrdenadosPorTitulo();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 5);
    }

    private static void borrarDisco() {
        mostrarTituloDiscos();
        int posicion = pedirEntero("Escoge el disco que quieras eliminar");
        posicion--;
        if (posicion >= 0 && posicion < misDiscos.size()) {
            // TODO pedirle confirmación antes de borrar
            misDiscos.remove(posicion);
            System.out.println("Disco borrado.");
        } else {
            System.out.println("No hay ningún disco con ese número.");
        }
    }

    private static void modificarDisco() {
        mostrarTituloDiscos();
        int posicion = pedirEntero("Escoge el disco que quieras modificar");
        // Decrementamos en 1 posición para guardar la posición correcta
        posicion--;
        // comprobamos que esté dentro de rango
        if (posicion >= 0 && posicion < misDiscos.size()) {
            // mostramos los datos del disco escogido
            System.out.println("Datos del disco escogido:");
            System.out.println(misDiscos.get(posicion));
            String nuevoTitulo = pedirCadena("Introduce el nuevo título:");
            String nuevoArtista = pedirCadena("Introduce nuevo artista:");
            int nuevosTemas = pedirEntero("Introduce el nº de temas");
            double nuevaDuracion = pedirDouble("Introduce la duración");
            // Actualizamos los datos del disco escogido
            misDiscos.get(posicion).setTitulo(nuevoTitulo);
            misDiscos.get(posicion).setArtista(nuevoArtista);
            misDiscos.get(posicion).setTemas(nuevosTemas);
            misDiscos.get(posicion).setDuracion(nuevaDuracion);
            System.out.println("Datos del disco modificados.");
        } else {
            System.out.println("No existe ningún disco con ese número.");
        }
    }

    private static void mostrarDiscosOrdenadosPorTitulo() {
        System.out.println("Listado de discos ordenados por Título");
        Collections.sort(misDiscos);
        for (Disco d : misDiscos) {
            System.out.println(d);
        }
    }

    private static void mostrarTituloDiscos() {
//        for (int i=0; i< misDiscos.size();i++) {
//            System.out.println((i+1)+" " +misDiscos.get(i).getTitulo());
//        }
        int contador = 1;
        for (Disco d : misDiscos) {
            System.out.println(contador + " " + d.getTitulo());
            contador++;
        }
    }

    private static void nuevoDisco() {
        // TODO control de errores
        String titulo = pedirCadena("Introduce el título del disco");
        String artista = pedirCadena("Introduce el artista");
        int temas = pedirEntero("Introduce el nº de temas que tiene el disco");
        double duracion = pedirDouble("Introduce la duración del disco.");
        // Creamos el disco con los datos introducidos por el usuario
        Disco d = new Disco(titulo, artista, temas, duracion);
        // Añadimos el disco a la lista de discos de la colección
        misDiscos.add(d);
    }

    private static String pedirCadena(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                cadena = br.readLine();
                error = false;
            } catch (IOException ex) {
                System.out.println("Error entrada salida");
                error = true;
            }
        } while (error);
        return cadena;
    }

    private static int pedirEntero(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numero = 0;
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error entrada salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
        } while (error);    // es lo mismo que error == true
        return numero;
    }

    private static double pedirDouble(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double numero = 0;
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                numero = Double.parseDouble(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error entrada salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un número.");
                error = true;
            }
        } while (error);
        return numero;
    }

    private static void mostrarMenu() {
        System.out.println("**** DISCOGRAFIA ****");
        System.out.println("1. Añadir disco a colección");
        System.out.println("2. Modificar disco");
        System.out.println("3. Eliminar disco");
        System.out.println("4. Mostrar disco");
        System.out.println("5. Salir");
        System.out.println("6. Ejemplo de mostrar todo de los discos");
    }

}
