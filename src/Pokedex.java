import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Pokedex {

    private static class PokemonStack {
        private static class Node {
            private Pokemon pokemon;
            private Node next;

            public Node(Pokemon pokemon) {
                this.pokemon = pokemon;
                this.next = null;
            }
        }

        private Node top;

        public PokemonStack() {
            this.top = null;
        }

        public void push(Pokemon pokemon) {
            Node newNode = new Node(pokemon);
            if (isEmpty()) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
        }

        public Pokemon pop() {
            if (isEmpty()) {
                return null;
            } else {
                Pokemon poppedPokemon = top.pokemon;
                top = top.next;
                return poppedPokemon;
            }
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void printStack() {
            Node current = top;
            int count = 1;
            while (current != null) {
                System.out.println(count + ". " + current.pokemon.getName() + " (Tipo: " + current.pokemon.getType() + ")");
                current = current.next;
                count++;
            }
        }

        public int printStackAndGetCount() {
            printStack();
            Node current = top;
            int count = 0;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        public boolean containsPokemon(Pokemon pokemon) {
            Node current = top;
            while (current != null) {
                if (current.pokemon.equals(pokemon)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    private static class Pokemon {
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }
    }

    private static final Pokemon[] POKEMONS = {
        new Pokemon("Bulbasaur", "Grass/Poison"),
        new Pokemon("Charmander", "Fire"),
        new Pokemon("Squirtle", "Water"),
        new Pokemon("Pikachu", "Electric"),
        new Pokemon("Jigglypuff", "Fairy"),
        new Pokemon("Geodude", "Rock/Ground"),
        // Agrega más Pokémon a esta lista si lo deseas.
    };

    private static final Random random = new Random();

    public static Pokemon chooseRandomPokemon() {
        int index = random.nextInt(POKEMONS.length);
        return POKEMONS[index];
    }

    public static Pokemon selectPokemonFromConsole(Scanner scanner, Set<Integer> chosenIndices) {
        Pokemon selectedPokemon = null;
        while (selectedPokemon == null) {
            System.out.println("Pokémon disponibles:");
            int index = 1;
            for (Pokemon pokemon : POKEMONS) {
                if (!chosenIndices.contains(index)) {
                    System.out.println(index + ". " + pokemon.getName() + " (Tipo: " + pokemon.getType() + ")");
                }
                index++;
            }

            System.out.print("Ingresa el número del Pokémon que deseas seleccionar: ");
            int pokemonIndex = scanner.nextInt();

            if (pokemonIndex >= 1 && pokemonIndex <= POKEMONS.length && !chosenIndices.contains(pokemonIndex)) {
                selectedPokemon = POKEMONS[pokemonIndex - 1];
                chosenIndices.add(pokemonIndex);
            } else {
                System.out.println("Selección inválida o Pokémon ya seleccionado. Intenta de nuevo.");
            }
        }
        return selectedPokemon;
    }

    public static void main(String[] args) {
        System.out.println("¡Bienvenido a la Pokedex!");

        PokemonStack userPokemonStack = new PokemonStack();
        PokemonStack aiPokemonStack = new PokemonStack();

        // El jugador elige sus 4 Pokémon y los pone en su Pokedex.
        System.out.println("¡Jugador, elige tus 4 Pokémon!");
        Scanner scanner = new Scanner(System.in);
        Set<Integer> chosenIndices = new HashSet<>();
        while (userPokemonStack.isEmpty() || userPokemonStack.printStackAndGetCount() < 4) {
            Pokemon selectedPokemon = selectPokemonFromConsole(scanner, chosenIndices);
            userPokemonStack.push(selectedPokemon);
        }

        // El oponente (inteligencia artificial) selecciona 4 Pokémon aleatoriamente.
        System.out.println("\nEl oponente seleccionó sus Pokémon:");
        while (aiPokemonStack.isEmpty() || aiPokemonStack.printStackAndGetCount() < 4) {
            Pokemon selectedPokemon = chooseRandomPokemon();
            aiPokemonStack.push(selectedPokemon);
        }

        // Batalla entre el jugador y el oponente.
        System.out.println("\n¡Comienza la batalla!");
        while (!userPokemonStack.isEmpty() && !aiPokemonStack.isEmpty()) {
            Pokemon userSelectedPokemon = userPokemonStack.pop();
            System.out.println("\nJugador utiliza: " + userSelectedPokemon.getName() + " (Tipo: " + userSelectedPokemon.getType() + ")");
            

            Pokemon aiSelectedPokemon = aiPokemonStack.pop();
            System.out.println("Oponente utiliza: " + aiSelectedPokemon.getName() + " (Tipo: " + aiSelectedPokemon.getType() + ")");
            

            // Simulación de la batalla.

            // Después de la batalla, se podría agregar el Pokémon ganador nuevamente a la pila correspondiente.
        }
    }
}
