public class Pokemones {
// Declaración de constantes para los tipos de Pokémon
    public static final int NORMAL = 0;
    public static final int FUEGO = 1;
    public static final int AGUA = 2;
    
    // Declaración de constantes para los atributos de los Pokémon
    public static final int VIDA_NORMAL = 150;
    public static final int VIDA_FUEGO = 115;
    public static final int VIDA_AGUA = 190;
    
    public static final int ATAQUE_NORMAL = 50;
    public static final int ATAQUE_FUEGO = 70;
    public static final int ATAQUE_AGUA = 55;
    
    public static final int DEFENSA_NORMAL = 35;
    public static final int DEFENSA_FUEGO = 45;
    public static final int DEFENSA_AGUA = 45;
    
    public static final int ATAQUE_ESPECIAL_NORMAL = 70;
    public static final int ATAQUE_ESPECIAL_FUEGO = 80;
    public static final int ATAQUE_ESPECIAL_AGUA = 75;
    
    public static final int DEFENSA_ESPECIAL_NORMAL = 60;
    public static final int DEFENSA_ESPECIAL_FUEGO = 60;
    public static final int DEFENSA_ESPECIAL_AGUA = 65;
    
    // Método para obtener los datos de un tipo de Pokémon
    public static String obtenerDatosTipo(int tipo) {
        switch (tipo) {
            case NORMAL:
                return "Tipo: Normal\nDébil contra Fuego\nFuerte contra Agua\nVida: " + VIDA_NORMAL + " HP\nAtaque: " + ATAQUE_NORMAL + " HP\nDefensa: " + DEFENSA_NORMAL + " HP\nAtaque especial: " + ATAQUE_ESPECIAL_NORMAL + " HP\nDefensa especial: " + DEFENSA_ESPECIAL_NORMAL + " HP";
            case FUEGO:
                return "Tipo: Fuego\nDébil contra Agua\nFuerte contra Normal\nVida: " + VIDA_FUEGO + " HP\nAtaque: " + ATAQUE_FUEGO + " HP\nDefensa: " + DEFENSA_FUEGO + " HP\nAtaque especial: " + ATAQUE_ESPECIAL_FUEGO + " HP\nDefensa especial: " + DEFENSA_ESPECIAL_FUEGO + " HP";
            case AGUA:
                return "Tipo: Agua\nDébil contra Normal\nFuerte contra Fuego\nVida: " + VIDA_AGUA + " HP\nAtaque: " + ATAQUE_AGUA + " HP\nDefensa: " + DEFENSA_AGUA + " HP\nAtaque especial: " + ATAQUE_ESPECIAL_AGUA + " HP\nDefensa especial: " + DEFENSA_ESPECIAL_AGUA + " HP";
            default:
                return "Tipo de Pokémon inválido.";
        }
    }     
}
