// Clase base para Pokémon
class Pokemon {
    String name;
    int hp;
    int attack;
    int defense;
    int specialAttack;
    int specialDefense;

    // Constructor
    public Pokemon(String name, int hp, int attack, int defense, int specialAttack, int specialDefense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
    }
}

// Clase para Pokémon de tipo Normal
class NormalPokemon extends Pokemon {
    // Constructor
    public NormalPokemon(String name) {
        super(name, 150, 50, 35, 70, 60);
    }
}

// Clase para Pokémon de tipo Fuego
class FirePokemon extends Pokemon {
    // Constructor
    public FirePokemon(String name) {
        super(name, 115, 70, 45, 80, 60);
    }
}

// Clase para Pokémon de tipo Agua
class WaterPokemon extends Pokemon {
    // Constructor
    public WaterPokemon(String name) {
        super(name, 190, 55, 45, 75, 65);
    }
}
