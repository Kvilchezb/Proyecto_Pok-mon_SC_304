public class Combate {
    
    public static void atacar(Pila<Pokemon> atacante, Pila<Pokemon> defensor) {
        Pokemon pokemonAtacante = atacante.eliminar(); // Obtener el Pokemon atacante
        Pokemon pokemonDefensor = defensor.eliminar(); // Obtener el Pokemon defensor

        // Restar puntos de vida al defensor basados en el ataque del atacante
        int puntosDano = pokemonAtacante.ataque;
        pokemonDefensor.puntosVida -= puntosDano;
         
        // Agregar de nuevo los Pokemon a las pilas
        atacante.push(pokemonAtacante);
        defensor.push(pokemonDefensor);
    }

    public static void atacarEspecial(Pila<Pokemon> atacante, Pila<Pokemon> defensor) {
        Pokemon pokemonAtacante = atacante.eliminar(); // Obtener el Pokemon atacante
        Pokemon pokemonDefensor = defensor.eliminar(); // Obtener el Pokemon defensor

        // Calcular el valor del ataque especial sin modificar el valor original
        int puntosDanoEspecial = pokemonAtacante.ataqueEspecial;

        // Verificar modificadores de tipo
        if (pokemonAtacante.tipo.equals("Normal") && pokemonDefensor.tipo.equals("Agua")) {
            puntosDanoEspecial = Math.min(puntosDanoEspecial + 75, 100); // Subir el valor a 75 si cumple la condición
        } else if (pokemonAtacante.tipo.equals("Fuego") && pokemonDefensor.tipo.equals("Normal")) {
            puntosDanoEspecial = Math.min(puntosDanoEspecial + 85, 100); // Subir el valor a 85 si cumple la condición
        } else if (pokemonAtacante.tipo.equals("Agua") && pokemonDefensor.tipo.equals("Fuego")) {
            puntosDanoEspecial = Math.min(puntosDanoEspecial + 85, 100); // Subir el valor a 85 si cumple la condición
        }

        // Restar puntos de vida al defensor basados en el ataque especial del atacante
        pokemonDefensor.puntosVida -= puntosDanoEspecial;

        // Agregar de nuevo los Pokemon a las pilas
        atacante.push(pokemonAtacante);
        defensor.push(pokemonDefensor);
    }
    
    public static void defensa(Pila<Pokemon> atacante, Pila<Pokemon> defensor) {
        Pokemon pokemonAtacante = atacante.eliminar(); // Obtener el Pokemon atacante
        Pokemon pokemonDefensor = defensor.eliminar(); // Obtener el Pokemon defensor

        // Calcular el ataque reducido basado en la defensa del defensor
        int ataqueReduccion = pokemonDefensor.defensa;
        int nuevoAtaqueAtacante = Math.max(pokemonAtacante.ataque - ataqueReduccion, 0);
         
        // Realizar el ataque con el nuevo valor de ataque
        int puntosDano = nuevoAtaqueAtacante;
        pokemonDefensor.puntosVida -= puntosDano;

        // Agregar de nuevo los Pokemon a las pilas
        atacante.push(pokemonAtacante);
        defensor.push(pokemonDefensor);
    }
    
     public static void defensaEspecial(Pila<Pokemon> atacante, Pila<Pokemon> defensor) {
        Pokemon pokemonAtacante = atacante.eliminar(); // Obtener el Pokemon atacante
        Pokemon pokemonDefensor = defensor.eliminar(); // Obtener el Pokemon defensor

        // Calcular el valor del ataque especial sin modificar el valor original
        int puntosDanoEspecial = pokemonAtacante.ataqueEspecial;

        // Reducir daño recibido basado en la defensa especial del defensor
        int defensaEspecialReduccion = pokemonDefensor.defensaEspecial;
        puntosDanoEspecial -= defensaEspecialReduccion;

        // Modificar la defensa especial del defensor según las verificaciones
        if (pokemonDefensor.tipo.equals("Normal") && pokemonAtacante.tipo.equals("Agua")) {
            pokemonDefensor.defensaEspecial = Math.min(pokemonDefensor.defensaEspecial + 65, 100);
        } else if (pokemonDefensor.tipo.equals("Fuego") && pokemonAtacante.tipo.equals("Normal")) {
            pokemonDefensor.defensaEspecial = Math.min(pokemonDefensor.defensaEspecial + 70, 100);
        } else if (pokemonDefensor.tipo.equals("Agua") && pokemonAtacante.tipo.equals("Fuego")) {
            pokemonDefensor.defensaEspecial = Math.min(pokemonDefensor.defensaEspecial + 75, 100);
        }

        // Restar puntos de vida al defensor basados en el ataque especial del atacante
        pokemonDefensor.puntosVida -= Math.max(puntosDanoEspecial, 0);

        // Agregar de nuevo los Pokemon a las pilas
        atacante.push(pokemonAtacante);
        defensor.push(pokemonDefensor);
    }
}