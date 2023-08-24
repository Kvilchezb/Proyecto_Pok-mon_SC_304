// Clase base para Pokémon
public class Pokemon {
    
    public String nombre;
    public String tipo;
    public int puntosVida;
    public int ataque;
   
    public int defensa;
    public int ataqueEspecial;
    public int defensaEspecial;
    public String imgFrente;
    public String imgEspalda;

    public Pokemon(String nombre, String tipo, int puntosVida, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, String imgFrente, String imgEspalda) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.imgFrente = imgFrente;
        this.imgEspalda = imgEspalda;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getAtaque() {
        return ataque;
    }

   
    
    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    } 
    
    public String getimgFrente() {
        return imgFrente;
    } 
    
    public String getimgEspalda() {
        return imgEspalda;
    } 
    
}