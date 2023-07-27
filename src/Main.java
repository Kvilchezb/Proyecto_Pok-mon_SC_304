public class Main{
    
    public static void main(String[] args) {
        Combate combate = new Combate();


        int tipoNormal = Pokemones.NORMAL;
        int tipoFuego = Pokemones.FUEGO;
        int tipoAgua = Pokemones.AGUA;
        
        System.out.println("Información del Pokémon tipo Normal:");
        System.out.println(Pokemones.obtenerDatosTipo(tipoNormal));
        
        System.out.println("\nInformación del Pokémon tipo Fuego:");
        System.out.println(Pokemones.obtenerDatosTipo(tipoFuego));
        
        System.out.println("\nInformación del Pokémon tipo Agua:");
        System.out.println(Pokemones.obtenerDatosTipo(tipoAgua));

    }
}