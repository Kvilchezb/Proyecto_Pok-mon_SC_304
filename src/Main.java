
import java.util.Random;
import java.util.Scanner;


public class Main{
    
    public static void main(String[] args) {
        Combate combate = new Combate();


        int tipoNormal = Pokemones.NORMAL;
        int tipoFuego = Pokemones.FUEGO;
        int tipoAgua = Pokemones.AGUA;
        
        System.out.println("Informaci�n del Pok�mon tipo Normal:");
        System.out.println(Pokemones.obtenerDatosTipo(tipoNormal));
        
        System.out.println("\nInformaci�n del Pok�mon tipo Fuego:");
        System.out.println(Pokemones.obtenerDatosTipo(tipoFuego));
        
        System.out.println("\nInformaci�n del Pok�mon tipo Agua:");
        System.out.println(Pokemones.obtenerDatosTipo(tipoAgua));
        
        Pokedex.main(args);
        
        
    }

    }
