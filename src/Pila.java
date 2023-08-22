public class Pila<T> {
    // Definición de los nodos que formarán la estructura de la pila
    private Nodo<T> mainTop; // Nodo superior de la pila principal
    private Nodo<T> auxTop;  // Nodo superior de la pila auxiliar

    // Constructor que inicializa la pila vacía
    public Pila() {
        mainTop = null;
        auxTop = null;
    }

    // Método para agregar un elemento a la pila principal
    public void push(T item) {
        Nodo<T> newNode = new Nodo<>(item); // Crear un nuevo nodo con el elemento

        if (mainTop == null) {
            mainTop = newNode; // Si la pila principal está vacía, el nuevo nodo es el nodo superior
        } else {
            newNode.next = mainTop; // Conectar el nuevo nodo al nodo superior actual
            mainTop = newNode;      // El nuevo nodo ahora es el nodo superior
        }
    }

    // Método para eliminar y devolver el elemento del nodo superior de la pila principal
    public T eliminar() {
        if (mainTop == null) {
            throw new IllegalStateException("Main stack is empty");
        }

        T item = mainTop.data; // Obtener el elemento del nodo superior
        mainTop = mainTop.next; // Actualizar el nodo superior al siguiente nodo

        return item;
    }

    // Método para mover elementos de la pila principal a la pila auxiliar
    public void moveraAux() {
        while (mainTop != null) {
            Nodo<T> newNode = new Nodo<>(mainTop.data); // Crear un nuevo nodo con el mismo elemento

            if (auxTop == null) {
                auxTop = newNode; // Si la pila auxiliar está vacía, el nuevo nodo es el nodo superior
            } else {
                newNode.next = auxTop; // Conectar el nuevo nodo al nodo superior actual de la pila auxiliar
                auxTop = newNode;      // El nuevo nodo ahora es el nodo superior de la pila auxiliar
            }

            mainTop = mainTop.next; // Mover al siguiente nodo en la pila principal
        }
    }

    // Método para mover elementos de la pila auxiliar de regreso a la pila principal
    public void regresaralMain() {
        while (auxTop != null) {
            Nodo<T> newNode = new Nodo<>(auxTop.data); // Crear un nuevo nodo con el mismo elemento

            if (mainTop == null) {
                mainTop = newNode; // Si la pila principal está vacía, el nuevo nodo es el nodo superior
            } else {
                newNode.next = mainTop; // Conectar el nuevo nodo al nodo superior actual de la pila principal
                mainTop = newNode;      // El nuevo nodo ahora es el nodo superior de la pila principal
            }

            auxTop = auxTop.next; // Mover al siguiente nodo en la pila auxiliar
        }
    }

    // Clase interna que representa los nodos de la pila
    private static class Nodo<T> {
        T data;           // El elemento almacenado en el nodo
        Nodo<T> next;     // Referencia al siguiente nodo en la pila

        public Nodo(T data) {
            this.data = data;
            this.next = null;
        }
    }
}