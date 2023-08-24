public class Pila<T> {
    private Nodo<T> mainTop;
    private Nodo<T> auxTop;
    private int currentIndex; // Variable para mantener el índice actual

    public Pila() {
        mainTop = null;
        auxTop = null;
        currentIndex = 0; // Inicializar el índice en 0
    }

    public void push(T item) {
        Nodo<T> newNode = new Nodo<>(item, currentIndex); // Pasar el índice al constructor
        currentIndex++; // Incrementar el índice

        if (mainTop == null) {
            mainTop = newNode;
        } else {
            newNode.next = mainTop;
            mainTop = newNode;
        }
    }

    public T eliminar() {
        if (mainTop == null) {
            throw new IllegalStateException("Main stack is empty");
        }

        T item = mainTop.data;
        mainTop = mainTop.next;
        currentIndex--; // Decrementar el índice al eliminar un elemento
        
        System.out.println("Se ha eliminado el elemento de la pila");

        return item;
    }

    public void eliminarPrimerElemento() {
        if (mainTop != null) {
            mainTop = mainTop.next;
        }
    }

    public void moveraAux() {
    Nodo<T> current = mainTop; // Nodo actual en la pila principal
    
    while (current != null) {
        Nodo<T> newNode = new Nodo<>(current.data, current.index); // Crear un nuevo nodo con el mismo elemento e índice
        newNode.next = auxTop; // Conectar el nuevo nodo al nodo superior actual de la pila auxiliar
        auxTop = newNode;      // El nuevo nodo ahora es el nodo superior de la pila auxiliar
        
        current = current.next; // Mover al siguiente nodo en la pila principal
    }
    
    mainTop = null; // Vaciar la pila principal después de mover todos los elementos
}

    public void regresaralMain(int targetIndex) {
        Nodo<T> prev = null;
        Nodo<T> current = auxTop;

        // Encontrar el nodo con el índice objetivo en la pila auxiliar
        while (current != null && current.index != targetIndex) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev != null) {
                prev.next = current.next; // Saltar el nodo objetivo en la pila auxiliar
            } else {
                auxTop = auxTop.next; // Si el nodo objetivo es el superior, actualizar auxTop
            }

            current.next = mainTop; // Conectar el nodo objetivo al nodo superior de la pila principal
            mainTop = current;      // El nodo objetivo ahora es el nodo superior de la pila principal
        }
    }

    public T peek() {
        if (mainTop == null) {
            throw new IllegalStateException("Main stack is empty");
        }
        
        return mainTop.data;
    } 

    public boolean isEmpty() {
        return mainTop == null;
    }

    private static class Nodo<T> {
        T data;
        Nodo<T> next;
        int index;

        public Nodo(T data, int index) {
            this.data = data;
            this.index = index;
            this.next = null;
        }
    }
}