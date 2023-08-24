import java.util.Random;

public class Acciones_IA {
    private static Random random = new Random();

    public static void elegirYRealizarAccion() {
        Pila<Pokemon> pila = PokedexSwing.pila_jugador;
        Pila<Pokemon> pila_IA = PokedexSwing.pila_IA;
        int opcion = random.nextInt(4); // Genera un número aleatorio entre 0 y 3
        
        switch (opcion) {
            case 0:
                
                if(Ventana_combate.seRealizoAccionD){
                    int ataqueIA = pila_IA.peek().ataque;
                    int defensaJugador = pila.peek().defensa;

                    // Reducir el ataque de la IA según la defensa del jugador
                    int nuevoAtaqueIA = Math.max(ataqueIA - defensaJugador, 0);

                    // Realizar el ataque con el nuevo valor de ataque
                    int puntosDano = nuevoAtaqueIA;
                    pila.peek().puntosVida -= puntosDano;    
                    Ventana_combate.seRealizoAccionD = false;  
                    
                    
                }else if(Ventana_combate.seRealizoAccionS){
                    int ataqueIA = pila_IA.peek().ataque;
                    int defensaJugador = pila.peek().defensaEspecial;

                    // Reducir el ataque de la IA según la defensa del jugador
                    int nuevoAtaqueIA = Math.max(ataqueIA - defensaJugador, 0);

                    // Realizar el ataque con el nuevo valor de ataque
                    int puntosDano = nuevoAtaqueIA;
                    pila.peek().puntosVida -= puntosDano;
                    Ventana_combate.seRealizoAccionS = false;  
                    
                }else{
                    
                    Combate.atacar(pila_IA, pila);  
                }

                break;
            case 1:
                
                if(Ventana_combate.seRealizoAccionD){
                    int ataqueIA = pila_IA.peek().ataqueEspecial;
                    int defensaJugador = pila.peek().defensa;

                    // Reducir el ataque de la IA según la defensa del jugador
                    int nuevoAtaqueIA = Math.max(ataqueIA - defensaJugador, 0);

                    // Realizar el ataque con el nuevo valor de ataque
                    int puntosDano = nuevoAtaqueIA;
                    pila.peek().puntosVida -= puntosDano;    
                    Ventana_combate.seRealizoAccionD = false;  
                    
                    
                }else if(Ventana_combate.seRealizoAccionS){
                    int ataqueIA = pila_IA.peek().ataqueEspecial;
                    int defensaJugador = pila.peek().defensaEspecial;

                    // Reducir el ataque de la IA según la defensa del jugador
                    int nuevoAtaqueIA = Math.max(ataqueIA - defensaJugador, 0);

                    // Realizar el ataque con el nuevo valor de ataque
                    int puntosDano = nuevoAtaqueIA;
                    pila.peek().puntosVida -= puntosDano;
                    Ventana_combate.seRealizoAccionS = false;  
                    
                }else{
                    Combate.atacarEspecial(pila_IA, pila);  
                }
                break;
            case 2:
                Ventana_combate.seRealizoAccionD_IA = true;
                break;
            case 3:              
                Combate.defensaEspecial(pila, pila_IA);
                break;
            default:
                // Manejar algún caso de error
        }
    }
}