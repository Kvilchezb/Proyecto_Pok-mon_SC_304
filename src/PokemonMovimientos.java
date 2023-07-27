public class PokemonMovimientos {
    private String nombre;
    private String movimiento1;
    private String movimiento2;
    private String movimiento3;
    private String movimiento4;

    // Constructor
    public PokemonMovimientos(String nombre, String movimiento1, String movimiento2, String movimiento3, String movimiento4) {
        this.nombre = nombre;
        this.movimiento1 = movimiento1;
        this.movimiento2 = movimiento2;
        this.movimiento3 = movimiento3;
        this.movimiento4 = movimiento4;
    }

    // Getters y setters (omitiendo setters para vida por simplicidad)
    public String getNombre() {
        return nombre;
    }

    public String getMovimiento1() {
        return movimiento1;
    }

    public String getMovimiento2() {
        return movimiento2;
    }

    public String getMovimiento3() {
        return movimiento3;
    }

    public String getMovimiento4() {
        return movimiento4;
    }
}