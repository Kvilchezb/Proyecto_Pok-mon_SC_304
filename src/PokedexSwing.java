import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexSwing extends JFrame {
    //Todos los Private
    
    //Imagen de los Pokémon
    //Normal
    private JLabel JLEevee;
    private JLabel JLMunchlax;
    private JLabel JLBidoof;
    //Fuego
    private JLabel JLCharizard;
    private JLabel JLTorchic;
    private JLabel JLTepig;
    //Agua
    private JLabel JLPiplup;
    private JLabel JLMagikarp;
    private JLabel JLBlastoise;
    
    //Creamos las instancias de los Pokemones para el jugador
    
    //Creamos 3 pokemones Normales
    Pokemon PN1_J = new Pokemon ("Eevee","Normal", 150,50,35,70,60,"src/img/EeveeFrente.gif","src/img/EeveeEspalda.gif");
    Pokemon PN2_J = new Pokemon ("Monchlax","Normal", 150,50,35,70,60,"src/img/MonchlaxFrente.gif","src/img/MonchlaxEspalda.gif");
    Pokemon PN3_J = new Pokemon ("Bidoof","Normal", 150,50,35,70,60,"src/img/BidoofFrente.gif","src/img/BidoofEspalda.gif");
    
    //Creamos 3 pokemones de Fuego
    Pokemon PF1_J = new Pokemon ("Charizard","Fuego", 115,70,45,80,60,"src/img/CharizardFrente.gif","src/img/CharizardEspalda.gif");
    Pokemon PF2_J = new Pokemon ("Torchic","Fuego", 115,70,45,80,60,"src/img/TorchicFrente.gif","src/img/TorchicEspalda.gif");
    Pokemon PF3_J = new Pokemon ("Tepig","Fuego", 115,70,45,80,60,"src/img/TepigFrente.gif","src/img/TepigEspalda.gif");
    
    //Creamos 3 pokemones de Agua
    Pokemon PA1_J = new Pokemon ("Piplup","Agua", 190,55,45,75,65,"src/img/Piplup.gif","src/img/PiplupEspalda.gif");
    Pokemon PA2_J = new Pokemon ("Magikarp","Agua", 190,55,45,75,65,"src/img/MagikarpFrente.gif","src/img/MagikarpEspalda.gif");
    Pokemon PA3_J = new Pokemon ("Blastoise","Agua", 190,55,45,75,65,"src/img/BlastoiseFrente.gif","src/img/BlastoiseEspalda.gif");
    
    //Creamos la pila para Jugador
    Pila<Pokemon> pila_jugador = new Pila<>();
    
    
    //Creamos las instancias de los Pokemones para la IA
    
    //Creamos 3 pokemones Normales
    Pokemon PN1_IA = new Pokemon ("Eevee","Normal", 150,50,35,70,60,"src/img/EeveeFrente.gif","src/img/EeveeEspalda.gif");
    Pokemon PN2_IA = new Pokemon ("Monchlax","Normal", 150,50,35,70,60,"src/img/MonchlaxFrente.gif","src/img/MonchlaxEspalda.gif");
    Pokemon PN3_IA = new Pokemon ("Bidoof","Normal", 150,50,35,70,60,"src/img/BidoofFrente.gif","src/img/BidoofEspalda.gif");
    
    //Creamos 3 pokemones de Fuego
    Pokemon PF1_IA = new Pokemon ("Charizard","Fuego", 115,70,45,80,60,"src/img/CharizardFrente.gif","src/img/CharizardEspalda.gif");
    Pokemon PF2_IA = new Pokemon ("Torchic","Fuego", 115,70,45,80,60,"src/img/TorchicFrente.gif","src/img/TorchicEspalda.gif");
    Pokemon PF3_IA = new Pokemon ("Tepig","Fuego", 115,70,45,80,60,"src/img/TepigFrente.gif","src/img/TepigEspalda.gif");
    
    //Creamos 3 pokemones de Agua
    Pokemon PA1_IA = new Pokemon ("Piplup","Agua", 190,55,45,75,65,"src/img/Piplup.gif","src/img/PiplupEspalda.gif");
    Pokemon PA2_IA = new Pokemon ("Magikarp","Agua", 190,55,45,75,65,"src/img/MagikarpFrente.gif","src/img/MagikarpEspalda.gif");
    Pokemon PA3_IA = new Pokemon ("Blastoise","Agua", 190,55,45,75,65,"src/img/BlastoiseFrente.gif","src/img/BlastoiseEspalda.gif");
    
    //Creamos la pila para la IA
    Pila<Pokemon> pila_IA = new Pila<>(); 
    
    public PokedexSwing() {
        
        
        //Este es el Panel principal donde se desarrolla todo
        super("Menú Pokedex");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        // Cargar la imagen de fondo y ajustar al tamaño de la ventana
        ImageIcon backgroundImageIcon = new ImageIcon("src/imgReserva/FondoPokedex.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        setContentPane(new JLabel(new ImageIcon(backgroundImage))); // Establecer el contenido principal
        
        // Agregar títulos para cada tipo de Pokémon
        AgregarTituloLabel("Tipo Normal", 300, 20, 16);
        AgregarTituloLabel("Tipo Fuego", 550, 20, 16);
        AgregarTituloLabel("Tipo Agua", 30, 20, 16);
        
        //Creamos los Paneles para cada Pokémon
        
        //Pokémon de tipo Normal
        // Crear el panel para Eevee
        JPanel EeveePanel = new JPanel();
        EeveePanel.setBounds(300, 80, 200, 200);
        EeveePanel.setOpaque(false);
        // Crear el panel para Monchlax
        JPanel MunchlaxPanel = new JPanel();
        MunchlaxPanel.setBounds(300, 220, 200, 200);
        MunchlaxPanel.setOpaque(false);
        // Crear el panel para Bidoof
        JPanel BidoofPanel = new JPanel();
        BidoofPanel.setBounds(300, 350, 200, 200);
        BidoofPanel.setOpaque(false);
        
        //Pokémon de tipo Fuego
        // Crear el panel para Charizard
        JPanel CharizardPanel = new JPanel();
        CharizardPanel.setBounds(520, 340, 270, 270);
        CharizardPanel.setOpaque(false);
        // Crear el panel para Torchic
        JPanel TorchicPanel = new JPanel();
        TorchicPanel.setBounds(550, 220, 200, 200);
        TorchicPanel.setOpaque(false);
        // Crear el panel para Tepig
        JPanel TepigPanel = new JPanel();
        TepigPanel.setBounds(550, 70, 200, 200);
        TepigPanel.setOpaque(false);
        
        //Pokémon de tipo Agua
        // Crear el panel para Piplup
        JPanel PiplupPanel = new JPanel();
        PiplupPanel.setBounds(30, 70, 200, 200);
        PiplupPanel.setOpaque(false);
        // Crear el panel para Magikarp
        JPanel MagikarpPanel = new JPanel();
        MagikarpPanel.setBounds(30, 220, 200, 200);
        MagikarpPanel.setOpaque(false);
        // Crear el panel para Blastoise
        JPanel BlastoisePanel = new JPanel();
        BlastoisePanel.setBounds(30, 370, 200, 200);
        BlastoisePanel.setOpaque(false);
        
        // Crear el JLabel para mostrar la imagen del Pokémon
        
        //Pokémon de tipo Normal
        //Eevee
        JLEevee = new JLabel();
        ImageIcon PokemonImageEevee = new ImageIcon("src/img/EeveeFrente.gif");
        JLEevee.setIcon(PokemonImageEevee);
        //Munchlax
        JLMunchlax = new JLabel();
        ImageIcon PokemonImageMunchlax = new ImageIcon("src/img/MunchlaxFrente.gif");
        JLMunchlax.setIcon(PokemonImageMunchlax);
        //Bidoof
        JLBidoof = new JLabel();
        ImageIcon PokemonImageBidoof = new ImageIcon("src/img/BidoofFrente.gif");
        JLBidoof.setIcon(PokemonImageBidoof);
        
        //Pokémon de tipo Fuego
        //Charizard
        JLCharizard = new JLabel();
        ImageIcon PokemonImageCharizard = new ImageIcon("src/img/CharizardFrente.gif");
        JLCharizard.setIcon(PokemonImageCharizard);
        //Torchic
        JLTorchic = new JLabel();
        ImageIcon PokemonImageTorchic = new ImageIcon("src/img/TorchicFrente.gif");
        JLTorchic.setIcon(PokemonImageTorchic);
        //Tepig
        JLTepig = new JLabel();
        ImageIcon PokemonImageTepig = new ImageIcon("src/img/TepigFrente.gif");
        JLTepig.setIcon(PokemonImageTepig);
        
        //Pokémon de tipo Agua
        //Piplup
        JLPiplup = new JLabel();
        ImageIcon PokemonImagePiplup = new ImageIcon("src/img/PiplupFrente.gif");
        JLPiplup.setIcon(PokemonImagePiplup);
        //Magikarp
        JLMagikarp = new JLabel();
        ImageIcon PokemonImageMagikarp = new ImageIcon("src/img/MagikarpFrente.gif");
        JLMagikarp.setIcon(PokemonImageMagikarp);
        //Blastoise
        JLBlastoise = new JLabel();
        ImageIcon PokemonImageBlastoise = new ImageIcon("src/img/BlastoiseFrente.gif");
        JLBlastoise.setIcon(PokemonImageBlastoise);
        
        // Agregar los JLabel a los paneles
        
        // Pokémon de tipo Normal
        EeveePanel.add(JLEevee);
        MunchlaxPanel.add(JLMunchlax);
        BidoofPanel.add(JLBidoof);
        
        // Pokémon de tipo Fuego
        CharizardPanel.add(JLCharizard);
        TorchicPanel.add(JLTorchic);
        TepigPanel.add(JLTepig);
        
        // Pokémon de tipo Agua
        PiplupPanel.add(JLPiplup);
        MagikarpPanel.add(JLMagikarp);
        BlastoisePanel.add(JLBlastoise);
        
        // Agregar los paneles a la ventana
        add(EeveePanel);
        add(MunchlaxPanel);
        add(BidoofPanel);
        add(CharizardPanel);
        add(TorchicPanel);
        add(TepigPanel);
        add(PiplupPanel);
        add(MagikarpPanel);
        add(BlastoisePanel);
        
        //Botones de los Pokémon
        // Pokémon de tipo Normal
        JButton BotonEevee = createButton("Seleccionar", 350, 150);
        JButton BotonMunchlax = createButton("Seleccionar", 350, 290);
        JButton BotonBidoof = createButton("Seleccionar", 350, 410);

        // Pokémon de tipo Fuego
        JButton BotonCharizard = createButton("Seleccionar", 600, 500);
        JButton BotonTorchic = createButton("Seleccionar", 600, 300);
        JButton BotonTepig = createButton("Seleccionar", 600, 150);

        // Pokémon de tipo Agua
        JButton BotonPiplup = createButton("Seleccionar", 80, 150);
        JButton BotonMagikarp = createButton("Seleccionar", 80, 290);
        JButton BotonBlastoise = createButton("Seleccionar", 80, 500);
        
        //Boton para Continuar
        JButton BotonContinuar = createButton("Continuar", 350, 500);
        
        
        //ACCIONES DE LOS BOTONES
        
        //Pokémon de tipo Normal
        //BotonEevee
        BotonEevee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Eevee");
            }
        });
        //BotonMunchlax
        BotonMunchlax.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Munchlax");
            }
        });
        //BotonBidoof
        BotonBidoof.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Bidoof");
            }
        });
        
        //Pokémon de tipo Fuego
        //BotonCharizard
        BotonCharizard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Charizard");
            }
        });
        //BotonTorchic
        BotonTorchic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Torchic");
            }
        });
        //BotonTepig
        BotonTepig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Tepig");
            }
        });
        
        // Pokémon de tipo Agua
        //BotonPiplup
        BotonPiplup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Piplup");
            }
        });
        //BotonMagikarp
        BotonMagikarp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Magikarp");
            }
        });
        //BotonBlastoise
        BotonBlastoise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                JOptionPane.showMessageDialog(PokedexSwing.this, "Has seleccionado a Blastoise");
            }
        });
        
        
        //BotonContinuar
        BotonContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //AQUÍ DAMOS LAS INSTRUCCIONES
                Ventana_combate combate = new Ventana_combate();
                setVisible(false); // Ocultamos la ventana actual (ventana de inicio)
            }
        });
        
        // Mostrar la ventana después de agregar todos los componentes
        setVisible(true);
    }
    
    private void AgregarTituloLabel(String title, int x, int y, int fontSize) {
        JLabel tituloLabel = new JLabel(title);
        tituloLabel.setBounds(x, y, 200, 30);  // Ajustar la altura para títulos más grandes
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, fontSize)); // Cambiar el tamaño de fuente
        tituloLabel.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        add(tituloLabel);
    }
    
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 30);
        add(button);
        return button;
    }
}