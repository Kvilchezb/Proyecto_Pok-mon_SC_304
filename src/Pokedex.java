import java.util.EmptyStackException;

class CustomStack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
/*Estoy utilizando una pila temporal (tempStack) para almacenar temporalmente los elementos de
la pila original (pokemonStack) mientras los muestro. 
Esto se debe a que las pilas se comportan como una estructura de datos LIFO 
(último en entrar, primero en salir), por lo que necesitas 
desapilar elementos para acceder a ellos.*/
class Pokedex {
    private CustomStack<Pokemon> pokemonStack = new CustomStack<>(); // Creamos una pila personalizada para almacenar los Pokémon.
    private static final int MAX_POKEMON_COUNT = 4; // Tamaño máximo de la Pokedex

    // Método para agregar un Pokémon a la Pokedex
    public void addPokemon(Pokemon pokemon) {
        if (pokemonStack.size() < MAX_POKEMON_COUNT) { // Verificamos si la Pokedex está llena.
            pokemonStack.push(pokemon); // Agregamos el Pokémon a la pila.
        } else {
            System.out.println("Pokedex is full. Cannot add more Pokemon.");
        }
    }
    
    public void removePokemon() {
        if (!pokemonStack.isEmpty()) {
            pokemonStack.pop(); // Eliminamos un Pokémon de la pila.
        } else {
            System.out.println("Pokedex is empty. No Pokemon to remove.");
        }
    }

    // Método para mostrar los Pokémon en la Pokedex
    public void displayPokemon() {
        CustomStack<Pokemon> tempStack = new CustomStack<>(); // Creamos una pila temporal para reorganizar los Pokémon.
        while (!pokemonStack.isEmpty()) { // Mientras haya Pokémon en la pila original:
            Pokemon pokemon = pokemonStack.pop(); // Sacamos un Pokémon de la pila original.
            System.out.println(pokemon.name); // Mostramos el nombre del Pokémon.
            tempStack.push(pokemon); // Agregamos el Pokémon a la pila temporal.
        }
        while (!tempStack.isEmpty()) { // Mientras haya Pokémon en la pila temporal:
            pokemonStack.push(tempStack.pop()); // Devolvemos los Pokémon a la pila original en orden inverso.
        }
    }
}
/*la clase CustomStack utiliza una lista enlazada para implementar una pila dinámica. 
La clase Pokedex utiliza esta pila para almacenar Pokémon, y ahora también verifica 
el tamaño máximo de la Pokedex antes de agregar un Pokémon.*/
