/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PokemonGameGUI extends Application {
    private Pokedex pokedex = new Pokedex();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pokemon Game");

        VBox root = new VBox(10);
        Scene scene = new Scene(root, 300, 200);

        Button addButton = new Button("Add Pokemon");
        addButton.setOnAction(e -> addPokemon());

        Button displayButton = new Button("Display Pokemon");
        displayButton.setOnAction(e -> displayPokemon());

        root.getChildren().addAll(addButton, displayButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addPokemon() {
        // Simulamos agregar Pokémon a la Pokedex utilizando nuestra estructura de pila personalizada
        NormalPokemon pidgey = new NormalPokemon("Pidgey");
        FirePokemon charizard = new FirePokemon("Charizard");
        WaterPokemon squirtle = new WaterPokemon("Squirtle");

        pokedex.addPokemon(pidgey);
        pokedex.addPokemon(charizard);
        pokedex.addPokemon(squirtle);
    }

    private void displayPokemon() {
        pokedex.displayPokemon();
    }
}*/


//ACA SE CREA LA INTERFAZ GRAFICA PARA IMPLEMENTAR LAS CLASES PARA LA POKEDEX
/* esta es la forma en que estarías utilizando la pila para almacenar y 
acceder a los Pokémon en el contexto de la interfaz gráfica.*/