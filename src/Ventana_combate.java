import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ventana_combate extends JFrame {

    
    Pila<Pokemon> pila = PokedexSwing.pila_jugador;
    Pila<Pokemon> pila_IA = PokedexSwing.pila_IA;
    
    public static boolean seRealizoAccionD = false;
    public static boolean seRealizoAccionS = false;
    
    public static boolean seRealizoAccionD_IA = false;
    public static boolean seRealizoAccionS_IA = false;
    
    private boolean keepUpdating = true; // Bandera para controlar el hilo
    private Thread updateThread; // El hilo en el que se ejecutará la serie de verificaciones
    
    
    
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
    
    //Barras de vida de los pokemon
    //Normal
    private JProgressBar Vida_Eevee;
    private JProgressBar Vida_Munchlax;
    private JProgressBar Vida_Bidoof;
    //Fuego
    private JProgressBar Vida_Charizard;
    private JProgressBar Vida_Torchic;
    private JProgressBar Vida_Tepig;
    //Agua
    private JProgressBar Vida_Piplup;
    private JProgressBar Vida_Magikarp;
    private JProgressBar Vida_Blastoise;
    

    //Imagen de los Pokémon de la IA
    //Normal
    private JLabel JLEevee_IA;
    private JLabel JLMunchlax_IA;
    private JLabel JLBidoof_IA;
    //Fuego
    private JLabel JLCharizard_IA;
    private JLabel JLTorchic_IA;
    private JLabel JLTepig_IA;
    //Agua
    private JLabel JLPiplup_IA;
    private JLabel JLMagikarp_IA;
    private JLabel JLBlastoise_IA;
    
    
    //Barras de vida de los pokemon de la IA
    //Normal
    private JProgressBar Vida_Eevee_IA;
    private JProgressBar Vida_Munchlax_IA;
    private JProgressBar Vida_Bidoof_IA;
    //Fuego
    private JProgressBar Vida_Charizard_IA;
    private JProgressBar Vida_Torchic_IA;
    private JProgressBar Vida_Tepig_IA;
    //Agua
    private JProgressBar Vida_Piplup_IA;
    private JProgressBar Vida_Magikarp_IA;
    private JProgressBar Vida_Blastoise_IA;

    public Ventana_combate() {
        
       
        
        super("Menú de Batalla de Pokémon");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Crear el panel para el fondo y configurar su imagen de fondo
        // Cargar la imagen de fondo y ajustar al tamaño de la ventana
        ImageIcon backgroundImageIcon = new ImageIcon("src/imgReserva/Fondo.png");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        setContentPane(new JLabel(new ImageIcon(backgroundImage))); // Establecer el contenido principal

        
       //Creamos los Paneles para cada Pokémon
        
        //Pokémon de tipo Normal
        // Crear el panel para Eevee
        JPanel EeveePanel = new JPanel();
        EeveePanel.setBounds(100, 470, 200, 200);
        EeveePanel.setOpaque(false);
        // Crear el panel para Monchlax
        JPanel MunchlaxPanel = new JPanel();
        MunchlaxPanel.setBounds(100, 470, 200, 200);
        MunchlaxPanel.setOpaque(false);
        // Crear el panel para Bidoof
        JPanel BidoofPanel = new JPanel();
        BidoofPanel.setBounds(100, 470, 200, 200);
        BidoofPanel.setOpaque(false);
        
        //Pokémon de tipo Fuego
        // Crear el panel para Charizard
        JPanel CharizardPanel = new JPanel();
        CharizardPanel.setBounds(50, 350, 270, 270);
        CharizardPanel.setOpaque(false);
        // Crear el panel para Torchic
        JPanel TorchicPanel = new JPanel();
        TorchicPanel.setBounds(100, 470, 200, 200);
        TorchicPanel.setOpaque(false);
        // Crear el panel para Tepig
        JPanel TepigPanel = new JPanel();
        TepigPanel.setBounds(100, 470, 200, 200);
        TepigPanel.setOpaque(false);
        
        //Pokémon de tipo Agua
        // Crear el panel para Piplup
        JPanel PiplupPanel = new JPanel();
        PiplupPanel.setBounds(100, 470, 200, 200);
        PiplupPanel.setOpaque(false);
        // Crear el panel para Magikarp
        JPanel MagikarpPanel = new JPanel();
        MagikarpPanel.setBounds(100, 470, 200, 200);
        MagikarpPanel.setOpaque(false);
        // Crear el panel para Blastoise
        JPanel BlastoisePanel = new JPanel();
        BlastoisePanel.setBounds(100, 400, 200, 200);
        BlastoisePanel.setOpaque(false);
        
        
        //Creamos los Paneles para cada Pokémon de la IA
        
        //Pokémon de tipo Normal
        // Crear el panel para Eevee
        JPanel EeveePanel_IA = new JPanel();
        EeveePanel_IA.setBounds(500, 350, 200, 200);
        EeveePanel_IA.setOpaque(false);
        // Crear el panel para Monchlax
        JPanel MunchlaxPanel_IA = new JPanel();
        MunchlaxPanel_IA.setBounds(500, 350, 200, 200);
        MunchlaxPanel_IA.setOpaque(false);
        // Crear el panel para Bidoof
        JPanel BidoofPanel_IA = new JPanel();
        BidoofPanel_IA.setBounds(500, 350, 200, 200);
        BidoofPanel_IA.setOpaque(false);
        
        //Pokémon de tipo Fuego
        // Crear el panel para Charizard
        JPanel CharizardPanel_IA = new JPanel();
        CharizardPanel_IA.setBounds(450, 250, 270, 270);
        CharizardPanel_IA.setOpaque(false);
        // Crear el panel para Torchic
        JPanel TorchicPanel_IA = new JPanel();
        TorchicPanel_IA.setBounds(500, 350, 200, 200);
        TorchicPanel_IA.setOpaque(false);
        // Crear el panel para Tepig
        JPanel TepigPanel_IA = new JPanel();
        TepigPanel_IA.setBounds(500, 350, 200, 200);
        TepigPanel_IA.setOpaque(false);
        
        //Pokémon de tipo Agua
        // Crear el panel para Piplup
        JPanel PiplupPanel_IA = new JPanel();
        PiplupPanel_IA.setBounds(500, 350, 200, 200);
        PiplupPanel_IA.setOpaque(false);
        // Crear el panel para Magikarp
        JPanel MagikarpPanel_IA = new JPanel();
        MagikarpPanel_IA.setBounds(500, 350, 200, 200);
        MagikarpPanel_IA.setOpaque(false);
        // Crear el panel para Blastoise
        JPanel BlastoisePanel_IA = new JPanel();
        BlastoisePanel_IA.setBounds(500, 300, 200, 200);
        BlastoisePanel_IA.setOpaque(false);

        
        // Crear el JLabel para mostrar la imagen del Pokémon
        
        //Pokémon de tipo Normal
        //Eevee
        JLEevee = new JLabel();
        ImageIcon PokemonImageEevee = new ImageIcon("src/img/EeveeEspalda.gif");
        JLEevee.setIcon(PokemonImageEevee);
        JLEevee.setVisible(false);
        //Munchlax
        JLMunchlax = new JLabel();
        ImageIcon PokemonImageMunchlax = new ImageIcon("src/img/MunchlaxEspalda.gif");
        JLMunchlax.setIcon(PokemonImageMunchlax);
        JLMunchlax.setVisible(false);
        //Bidoof
        JLBidoof = new JLabel();
        ImageIcon PokemonImageBidoof = new ImageIcon("src/img/BidoofEspalda.gif");
        JLBidoof.setIcon(PokemonImageBidoof);
        JLBidoof.setVisible(false);
        
        //Pokémon de tipo Fuego
        //Charizard
        JLCharizard = new JLabel();
        ImageIcon PokemonImageCharizard = new ImageIcon("src/img/CharizardEspalda.gif");
        JLCharizard.setIcon(PokemonImageCharizard);
        JLCharizard.setVisible(false);
        //Torchic
        JLTorchic = new JLabel();
        ImageIcon PokemonImageTorchic = new ImageIcon("src/img/TorchicEspalda.gif");
        JLTorchic.setIcon(PokemonImageTorchic);
        JLTorchic.setVisible(false);
        //Tepig
        JLTepig = new JLabel();
        ImageIcon PokemonImageTepig = new ImageIcon("src/img/TepigEspalda.gif");
        JLTepig.setIcon(PokemonImageTepig);
        JLTepig.setVisible(false);
        
        //Pokémon de tipo Agua
        //Piplup
        JLPiplup = new JLabel();
        ImageIcon PokemonImagePiplup = new ImageIcon("src/img/PiplupEspalda.gif");
        JLPiplup.setIcon(PokemonImagePiplup);
        JLPiplup.setVisible(false);
        //Magikarp
        JLMagikarp = new JLabel();
        ImageIcon PokemonImageMagikarp = new ImageIcon("src/img/MagikarpEspalda.gif");
        JLMagikarp.setIcon(PokemonImageMagikarp);
        JLMagikarp.setVisible(false);
        //Blastoise
        JLBlastoise = new JLabel();
        ImageIcon PokemonImageBlastoise = new ImageIcon("src/img/BlastoiseEspalda.gif");
        JLBlastoise.setIcon(PokemonImageBlastoise);
        JLBlastoise.setVisible(false);
        
        
        
        
        
        // Crear el JLabel para mostrar la imagen del Pokémon de la IA
        
        //Pokémon de tipo Normal
        //Eevee
        JLEevee_IA = new JLabel();
        ImageIcon PokemonImageEevee_IA = new ImageIcon("src/img/EeveeFrente.gif");
        JLEevee_IA.setIcon(PokemonImageEevee_IA);
        JLEevee_IA.setVisible(false);
        //Munchlax
        JLMunchlax_IA = new JLabel();
        ImageIcon PokemonImageMunchlax_IA = new ImageIcon("src/img/MunchlaxFrente.gif");
        JLMunchlax_IA.setIcon(PokemonImageMunchlax_IA);
        JLMunchlax_IA.setVisible(false);
        //Bidoof
        JLBidoof_IA = new JLabel();
        ImageIcon PokemonImageBidoof_IA = new ImageIcon("src/img/BidoofFrente.gif");
        JLBidoof_IA.setIcon(PokemonImageBidoof_IA);
        JLBidoof_IA.setVisible(false);
        
        //Pokémon de tipo Fuego
        //Charizard
        JLCharizard_IA = new JLabel();
        ImageIcon PokemonImageCharizard_IA = new ImageIcon("src/img/CharizardFrente.gif");
        JLCharizard_IA.setIcon(PokemonImageCharizard_IA);
        JLCharizard_IA.setVisible(false);
        //Torchic
        JLTorchic_IA = new JLabel();
        ImageIcon PokemonImageTorchic_IA = new ImageIcon("src/img/TorchicFrente.gif");
        JLTorchic_IA.setIcon(PokemonImageTorchic_IA);
        JLTorchic_IA.setVisible(false);
        //Tepig
        JLTepig_IA = new JLabel();
        ImageIcon PokemonImageTepig_IA = new ImageIcon("src/img/TepigFrente.gif");
        JLTepig_IA.setIcon(PokemonImageTepig_IA);
        JLTepig_IA.setVisible(false);
        
        //Pokémon de tipo Agua
        //Piplup
        JLPiplup_IA = new JLabel();
        ImageIcon PokemonImagePiplup_IA = new ImageIcon("src/img/PiplupFrente.gif");
        JLPiplup_IA.setIcon(PokemonImagePiplup_IA);
        JLPiplup_IA.setVisible(false);
        //Magikarp
        JLMagikarp_IA = new JLabel();
        ImageIcon PokemonImageMagikarp_IA = new ImageIcon("src/img/MagikarpFrente.gif");
        JLMagikarp_IA.setIcon(PokemonImageMagikarp_IA);
        JLMagikarp_IA.setVisible(false);
        //Blastoise
        JLBlastoise_IA = new JLabel();
        ImageIcon PokemonImageBlastoise_IA = new ImageIcon("src/img/BlastoiseFrente.gif");
        JLBlastoise_IA.setIcon(PokemonImageBlastoise_IA);
        JLBlastoise_IA.setVisible(false);
        
        
        
        
        
        //Crear las barras de vida
        //Normal
        Vida_Eevee = new JProgressBar(0,100);
        Vida_Eevee.setForeground(Color.red);
        Vida_Eevee.setVisible(false);
        
        Vida_Munchlax = new JProgressBar(0,100);
        Vida_Munchlax.setForeground(Color.red);
        Vida_Munchlax.setVisible(false);
        
        Vida_Bidoof = new JProgressBar(0,100);
        Vida_Bidoof.setForeground(Color.red);
        Vida_Bidoof.setVisible(false);
        
        //Fuego
        Vida_Charizard = new JProgressBar(0,100);
        Vida_Charizard.setForeground(Color.red);
        Vida_Charizard.setVisible(false);
        
        Vida_Torchic = new JProgressBar(0,100);
        Vida_Torchic.setForeground(Color.red);
        Vida_Torchic.setVisible(false);
        
        Vida_Tepig = new JProgressBar(0,100);
        Vida_Tepig.setForeground(Color.red);
        Vida_Tepig.setVisible(false);
        
        //Agua
        Vida_Piplup = new JProgressBar(0,100);
        Vida_Piplup.setForeground(Color.red);
        Vida_Piplup.setVisible(false);
        
        Vida_Magikarp = new JProgressBar (0,100);
        Vida_Magikarp.setForeground(Color.red);
        Vida_Magikarp.setVisible(false);
        
        Vida_Blastoise = new JProgressBar(0,100);
        Vida_Blastoise.setForeground(Color.red);
        Vida_Blastoise.setVisible(false);
        
        
        
        
        
        //Crear las barras de vida para la IA
        //Normal
        Vida_Eevee_IA = new JProgressBar(0,100);
        Vida_Eevee_IA.setForeground(Color.red);
        Vida_Eevee_IA.setVisible(false);
        
        Vida_Munchlax_IA = new JProgressBar(0,100);
        Vida_Munchlax_IA.setForeground(Color.red);
        Vida_Munchlax_IA.setVisible(false);
        
        Vida_Bidoof_IA = new JProgressBar(0,100);
        Vida_Bidoof_IA.setForeground(Color.red);
        Vida_Bidoof_IA.setVisible(false);
        
        //Fuego
        Vida_Charizard_IA = new JProgressBar(0,100);
        Vida_Charizard_IA.setForeground(Color.red);
        Vida_Charizard_IA.setVisible(false);
        
        Vida_Torchic_IA = new JProgressBar(0,100);
        Vida_Torchic_IA.setForeground(Color.red);
        Vida_Torchic_IA.setVisible(false);
        
        Vida_Tepig_IA = new JProgressBar(0,100);
        Vida_Tepig_IA.setForeground(Color.red);
        Vida_Tepig_IA.setVisible(false);
        
        //Agua
        Vida_Piplup_IA = new JProgressBar(0,100);
        Vida_Piplup_IA.setForeground(Color.red);
        Vida_Piplup_IA.setVisible(false);
        
        Vida_Magikarp_IA = new JProgressBar (0,100);
        Vida_Magikarp_IA.setForeground(Color.red);
        Vida_Magikarp_IA.setVisible(false);
        
        Vida_Blastoise_IA = new JProgressBar(0,100);
        Vida_Blastoise_IA.setForeground(Color.red);
        Vida_Blastoise_IA.setVisible(false);
        
        
        
        //Logica para los pokemones de jugador
        int vida = PokedexSwing.pila_jugador.peek().getPuntosVida();    
        
        Vida_Eevee.setMaximum(vida);
        Vida_Eevee.setValue(vida);
        
        Vida_Munchlax.setMaximum(vida);
        Vida_Munchlax.setValue(vida);
        
        Vida_Bidoof.setMaximum(vida);
        Vida_Bidoof.setValue(vida);
            
        Vida_Charizard.setMaximum(vida);
        Vida_Charizard.setValue(vida);    
           
        Vida_Torchic.setMaximum(vida);
        Vida_Torchic.setValue(vida);
        
        Vida_Tepig.setMaximum(vida);
        Vida_Tepig.setValue(vida);
        
        Vida_Piplup.setMaximum(vida);
        Vida_Piplup.setValue(vida);
        
        Vida_Magikarp.setMaximum(vida);
        Vida_Magikarp.setValue(vida);
        
        Vida_Blastoise.setMaximum(vida);
        Vida_Blastoise.setValue(vida);
        
        updateThread = new Thread(() -> {
            while (keepUpdating) {
                // Verificar si el objeto en la cima de la pila tiene 0 de vida
                if (!pila.isEmpty() && pila.peek().getPuntosVida() <= 0) {
                    
                    pila.eliminarPrimerElemento(); // Eliminar el objeto con 0 de vida  
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof_IA.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    
                    // Realizar las actualizaciones necesarias con el nuevo elemento en la cima
                    if (!pila.isEmpty()) {
                        Pokemon nuevoPokemonSuperior = pila.peek();
                        int nuevaVida = nuevoPokemonSuperior.getPuntosVida();
                        String rutaImagenTopPila = nuevoPokemonSuperior.getimgEspalda();
                        // Actualizar la interfaz gráfica con los nuevos valores
                        if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                            JLEevee.setVisible(true);
                            Vida_Eevee.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                            JLMunchlax.setVisible(true);                         
                            Vida_Munchlax.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                            JLBidoof.setVisible(true);                         
                            Vida_Bidoof.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                            JLCharizard.setVisible(true);                            
                            Vida_Charizard.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                            JLTorchic.setVisible(true);                           
                            Vida_Torchic.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                            JLTepig.setVisible(true);                            
                            Vida_Tepig.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                            JLPiplup.setVisible(true);                           
                            Vida_Piplup.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                            JLMagikarp.setVisible(true);                            
                            Vida_Magikarp.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                            JLBlastoise.setVisible(true);                           
                            Vida_Blastoise.setVisible(true);
                        }
                    } else {
                        // Si no hay elementos en la pila, realizar acciones necesarias
                        
                    }
                } else {
                    
                        Pokemon nuevoPokemonSuperior = pila.peek();
                        int nuevaVida = nuevoPokemonSuperior.getPuntosVida();
                        String rutaImagenTopPila = nuevoPokemonSuperior.getimgEspalda();
                        // Actualizar la interfaz gráfica con los nuevos valores
                        if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                            JLEevee.setVisible(true);
                           
                            Vida_Eevee.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                            JLMunchlax.setVisible(true);
                            
                            Vida_Munchlax.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                            JLBidoof.setVisible(true);
                            
                            Vida_Bidoof.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                            JLCharizard.setVisible(true);
                            
                            Vida_Charizard.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                            JLTorchic.setVisible(true);
                            
                            Vida_Torchic.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                            JLTepig.setVisible(true);
                            
                            Vida_Tepig.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                            JLPiplup.setVisible(true);
                            
                            Vida_Piplup.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                            JLMagikarp.setVisible(true);
                            
                            Vida_Magikarp.setVisible(true);
                        } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                            JLBlastoise.setVisible(true);
                            
                            Vida_Blastoise.setVisible(true);
                        }
                    
                }

                try {
                    Thread.sleep(100); // Espera 100 milisegundos antes de la siguiente iteración
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateThread.start();
        
        
        //Logica para los pokemon de la IA
        int vida_IA = PokedexSwing.pila_IA.peek().getPuntosVida();    
        
        //Poner el maximo de vida de todos los pokemon IA
        Vida_Eevee_IA.setMaximum(vida_IA);
        Vida_Eevee_IA.setValue(vida_IA);
        
        Vida_Munchlax_IA.setMaximum(vida_IA);
        Vida_Munchlax_IA.setValue(vida_IA);
        
        Vida_Bidoof_IA.setMaximum(vida_IA);
        Vida_Bidoof_IA.setValue(vida_IA);
        
        Vida_Charizard_IA.setMaximum(vida_IA);
        Vida_Charizard_IA.setValue(vida_IA);
        
        Vida_Torchic_IA.setMaximum(vida_IA);
        Vida_Torchic_IA.setValue(vida_IA);
        
        Vida_Tepig_IA.setMaximum(vida_IA);
        Vida_Tepig_IA.setValue(vida_IA);
        
        Vida_Piplup_IA.setMaximum(vida_IA);
        Vida_Piplup_IA.setValue(vida_IA);
        
        Vida_Magikarp_IA.setMaximum(vida_IA);
        Vida_Magikarp_IA.setValue(vida_IA);
        
        Vida_Blastoise_IA.setMaximum(vida_IA);
        Vida_Blastoise_IA.setValue(vida_IA);
        
        updateThread = new Thread(() -> {
            while (keepUpdating) {
                // Verificar si el objeto en la cima de la pila tiene 0 de vida
                if (!pila_IA.isEmpty() && pila_IA.peek().getPuntosVida() <= 0) {
                    
                    pila_IA.eliminarPrimerElemento(); // Eliminar el objeto con 0 de vida  
                    
                    JLEevee_IA.setVisible(false);
                    Vida_Eevee_IA.setVisible(false);
                    JLMunchlax_IA.setVisible(false);                         
                    Vida_Munchlax_IA.setVisible(false);
                    JLBidoof_IA.setVisible(false);                         
                    Vida_Bidoof_IA.setVisible(false);
                    JLCharizard_IA.setVisible(false);                            
                    Vida_Charizard_IA.setVisible(false);
                    JLTorchic_IA.setVisible(false);                           
                    Vida_Torchic_IA.setVisible(false);
                    JLTepig_IA.setVisible(false);                            
                    Vida_Tepig_IA.setVisible(false);
                    JLPiplup_IA.setVisible(false);                           
                    Vida_Piplup_IA.setVisible(false);
                    JLMagikarp_IA.setVisible(false);                            
                    Vida_Magikarp_IA.setVisible(false);
                    JLBlastoise_IA.setVisible(false);                           
                    Vida_Blastoise_IA.setVisible(false);
                    
                    // Realizar las actualizaciones necesarias con el nuevo elemento en la cima
                    if (!pila_IA.isEmpty()) {
                        Pokemon nuevoPokemonSuperior = pila_IA.peek();
                        int nuevaVida_IA = nuevoPokemonSuperior.getPuntosVida();
                        String rutaImagenTopPila_IA = nuevoPokemonSuperior.getimgFrente();
                        // Actualizar la interfaz gráfica con los nuevos valores
                        if (rutaImagenTopPila_IA.equals("src/img/EeveeFrente.gif")) {
                            JLEevee_IA.setVisible(true);
                            Vida_Eevee_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/MunchlaxFrente.gif")) {
                            JLMunchlax_IA.setVisible(true);                         
                            Vida_Munchlax_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/BidoofFrente.gif")) {
                            JLBidoof_IA.setVisible(true);                         
                            Vida_Bidoof_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/CharizardFrente.gif")) {
                            JLCharizard_IA.setVisible(true);                            
                            Vida_Charizard_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/TorchicFrente.gif")) {
                            JLTorchic_IA.setVisible(true);                           
                            Vida_Torchic_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/TepigFrente.gif")) {
                            JLTepig_IA.setVisible(true);                            
                            Vida_Tepig_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/PiplupFrente.gif")) {
                            JLPiplup_IA.setVisible(true);                           
                            Vida_Piplup_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/MagikarpFrente.gif")) {
                            JLMagikarp_IA.setVisible(true);                            
                            Vida_Magikarp_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/BlastoiseFrente.gif")) {
                            JLBlastoise_IA.setVisible(true);                           
                            Vida_Blastoise_IA.setVisible(true);
                        }
                    } else {
                        // Si no hay elementos en la pila, realizar acciones necesarias
                        
                    }
                } else {
                    
                        Pokemon nuevoPokemonSuperior = pila_IA.peek();
                        int nuevaVida_IA = nuevoPokemonSuperior.getPuntosVida();
                        String rutaImagenTopPila_IA = nuevoPokemonSuperior.getimgFrente();
                        // Actualizar la interfaz gráfica con los nuevos valores
                        if (rutaImagenTopPila_IA.equals("src/img/EeveeFrente.gif")) {
                            JLEevee_IA.setVisible(true);
                           
                            Vida_Eevee_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/MunchlaxFrente.gif")) {
                            JLMunchlax_IA.setVisible(true);
                            
                            Vida_Munchlax_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/BidoofFrente.gif")) {
                            JLBidoof_IA.setVisible(true);
                            
                            Vida_Bidoof_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/CharizardFrente.gif")) {
                            JLCharizard_IA.setVisible(true);
                            
                            Vida_Charizard_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/TorchicFrente.gif")) {
                            JLTorchic_IA.setVisible(true);
                            
                            Vida_Torchic_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/TepigFrente.gif")) {
                            JLTepig_IA.setVisible(true);
                            
                            Vida_Tepig_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/PiplupFrente.gif")) {
                            JLPiplup_IA.setVisible(true);
                            
                            Vida_Piplup_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/MagikarpFrente.gif")) {
                            JLMagikarp_IA.setVisible(true);
                            
                            Vida_Magikarp_IA.setVisible(true);
                        } else if (rutaImagenTopPila_IA.equals("src/img/BlastoiseFrente.gif")) {
                            JLBlastoise_IA.setVisible(true);
                            
                            Vida_Blastoise_IA.setVisible(true);
                        }
                    
                }
                
                //Cerrar Todo 

                try {
                    Thread.sleep(100); // Espera 100 milisegundos antes de la siguiente iteración
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateThread.start();
 
        
        
        
        
        
        
        
        // Agregar los JLabel a los paneles
        
        // Pokémon de tipo Normal
        EeveePanel.add(JLEevee);
        EeveePanel.add(Vida_Eevee);
        
        MunchlaxPanel.add(JLMunchlax);
        MunchlaxPanel.add(Vida_Munchlax);
        
        BidoofPanel.add(JLBidoof);
        BidoofPanel.add(Vida_Bidoof);
        
        // Pokémon de tipo Fuego
        CharizardPanel.add(JLCharizard);
        CharizardPanel.add(Vida_Charizard);
        
        TorchicPanel.add(JLTorchic);
        TorchicPanel.add(Vida_Torchic);
         
        TepigPanel.add(JLTepig);
        TepigPanel.add(Vida_Tepig);
        
        // Pokémon de tipo Agua
        PiplupPanel.add(JLPiplup);
        PiplupPanel.add(Vida_Piplup);
        
        MagikarpPanel.add(JLMagikarp);
        MagikarpPanel.add(Vida_Magikarp);
        
        BlastoisePanel.add(JLBlastoise);
        BlastoisePanel.add(Vida_Blastoise);
        
        
        // Agregar los JLabel a los paneles de la IA
        
        // Pokémon de tipo Normal
        EeveePanel_IA.add(JLEevee_IA);
        EeveePanel_IA.add(Vida_Eevee_IA);
        
        MunchlaxPanel_IA.add(JLMunchlax_IA);
        MunchlaxPanel_IA.add(Vida_Munchlax_IA);
        
        BidoofPanel_IA.add(JLBidoof_IA);
        BidoofPanel_IA.add(Vida_Bidoof_IA);
        
        // Pokémon de tipo Fuego
        CharizardPanel_IA.add(JLCharizard_IA);
        CharizardPanel_IA.add(Vida_Charizard_IA);
        
        TorchicPanel_IA.add(JLTorchic_IA);
        TorchicPanel_IA.add(Vida_Torchic_IA);
         
        TepigPanel_IA.add(JLTepig_IA);
        TepigPanel_IA.add(Vida_Tepig_IA);
        
        // Pokémon de tipo Agua
        PiplupPanel_IA.add(JLPiplup_IA);
        PiplupPanel_IA.add(Vida_Piplup_IA);
        
        MagikarpPanel_IA.add(JLMagikarp_IA);
        MagikarpPanel_IA.add(Vida_Magikarp_IA);
        
        BlastoisePanel_IA.add(JLBlastoise_IA);
        BlastoisePanel_IA.add(Vida_Blastoise_IA);
        
        
        
        
        
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
        
        
        // Agregar los paneles a la ventana de la IA
        add(EeveePanel_IA);
        add(MunchlaxPanel_IA);
        add(BidoofPanel_IA);
        add(CharizardPanel_IA);
        add(TorchicPanel_IA);
        add(TepigPanel_IA);
        add(PiplupPanel_IA);
        add(MagikarpPanel_IA);
        add(BlastoisePanel_IA);
        
        
        
        

        // Crear los botones de acción, ataque y Pokémon
        JButton atacarButton = createButton("Movimientos", 150,600);
        
        JButton PokemonButton = createButton("Pokemon", 550,600);
        
        
        
        //Botones que salen al precionar atacar
        JButton ataqueButton = createButton("Ark", 100,600);
        ataqueButton.setVisible(false);
        
        JButton ataque_especialButton = createButton("Atk S", 250,600);
        ataque_especialButton.setVisible(false);
        
        JButton defensaButton = createButton("DF", 400,600);
        defensaButton.setVisible(false);
        
        JButton defensa_especialButton = createButton("DF S", 550,600);
        defensa_especialButton.setVisible(false);
        
        //Botones para elegir pokemon
        JButton pokemon1Button = createButton("Pokemon 1", 100,600);
        pokemon1Button.setVisible(false);
        
        JButton pokemon2Button = createButton("Pokemon 2", 250,600);
        pokemon2Button.setVisible(false);
        
        JButton pokemon3Button = createButton("Pokemon 3", 400,600);
        pokemon3Button.setVisible(false);
        
        JButton pokemon4Button = createButton("Pokemon 4", 550,600);
        pokemon4Button.setVisible(false);
        
        JButton regresarPButton = createButton("Regresar", 350,700);
        regresarPButton.setVisible(false);
        
        JButton regresarAButton = createButton("Regresar", 350,700);
        regresarAButton.setVisible(false);
        
        
        atacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                atacarButton.setVisible(false);
                PokemonButton.setVisible(false);
                ataqueButton.setVisible(true);
                ataque_especialButton.setVisible(true);
                defensaButton.setVisible(true);
                defensa_especialButton.setVisible(true);
                regresarAButton.setVisible(true);
                
                
    }
});

        PokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                atacarButton.setVisible(false);
                PokemonButton.setVisible(false);
                pokemon1Button.setVisible(true);
                pokemon2Button.setVisible(true);
                pokemon3Button.setVisible(true);
                pokemon4Button.setVisible(true);
                regresarPButton.setVisible(true);

            }
        });
        
        regresarPButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
            
                
                pokemon1Button.setVisible(false);
                pokemon2Button.setVisible(false);
                pokemon3Button.setVisible(false);
                pokemon4Button.setVisible(false);
                regresarPButton.setVisible(false);
                atacarButton.setVisible(true);
                PokemonButton.setVisible(true);
                
            } 
        });
        
        regresarAButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
            
                
                
                ataqueButton.setVisible(false);
                ataque_especialButton.setVisible(false);
                defensaButton.setVisible(false);
                defensa_especialButton.setVisible(false);
                regresarAButton.setVisible(false);
                atacarButton.setVisible(true);
                PokemonButton.setVisible(true);
            } 
        });
        
        ataqueButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                
            
            
                 if(seRealizoAccionD_IA){
                    int ataqueJugador = pila.peek().ataque;
                    int defensaIA = pila_IA.peek().defensa;

                    // Reducir el ataque de la IA según la defensa del jugador
                    int nuevoAtaqueJugador = Math.max(ataqueJugador - defensaIA, 0);

                    // Realizar el ataque con el nuevo valor de ataque
                    int puntosDano = nuevoAtaqueJugador;
                    pila_IA.peek().puntosVida -= puntosDano;    
                    Ventana_combate.seRealizoAccionD_IA = false;  
  
                }else if(seRealizoAccionS_IA){
                    int ataqueJugador = pila.peek().ataque;
                    int defensaSIA = pila_IA.peek().defensaEspecial;
                    // Reducir el ataque de la IA según la defensa del jugador
                    int nuevoAtaqueJugador = Math.max(ataqueJugador - defensaSIA, 0);

                    // Realizar el ataque con el nuevo valor de ataque
                    int puntosDano = nuevoAtaqueJugador;
                    pila_IA.peek().puntosVida -= puntosDano;
                    Ventana_combate.seRealizoAccionS = false;  
                    
                }else{
                    Combate.atacar(pila, pila_IA);  
                }
                
                
                //Actualizamos la progressbar
                int vida_IA = PokedexSwing.pila_IA.peek().getPuntosVida();    
                
                //Verificacion del pokemon (img)
                //Guardamos el valor en una variable para un manejo más facil
                String rutaImagenTopPila_IA = PokedexSwing.pila_IA.peek().getimgFrente();
                
                
                if (rutaImagenTopPila_IA.equals("src/img/EeveeFrente.gif")) {
                     
                        Vida_Eevee_IA.setValue(vida_IA);
                     
                } else if (rutaImagenTopPila_IA.equals("src/img/MunchlaxFrente.gif")) {
                    
                    Vida_Munchlax_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/BidoofFrente.gif")) {
                    
                    Vida_Bidoof_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/CharizardFrente.gif")) {
                    
                    Vida_Charizard_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/TorchicFrente.gif")) {
                    
                    Vida_Torchic_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/TepigFrente.gif")) {
                    
                    Vida_Tepig_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/PiplupFrente.gif")) {
                    
                    Vida_Piplup_IA.setValue(vida_IA);
                   

                } else if (rutaImagenTopPila_IA.equals("src/img/MagikarpFrente.gif")) {
                    
                    Vida_Magikarp_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/BlastoiseFrente.gif")) {
                    
                    Vida_Blastoise_IA.setValue(vida_IA);
                    
                }
                
             
                
                
 
                //Agregar animacion (OPCIONAL)
                
                //Timer
                
                //Accion de la IA
                int delayMilliseconds = 2000; // 2 segundos
                ActionListener delayedAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
 
                        Acciones_IA.elegirYRealizarAccion();
                       
                        int vida = PokedexSwing.pila_jugador.peek().getPuntosVida(); 
                        
                        //Verificacion del pokemon (img)
                        //Guardamos el valor en una variable para un manejo más facil
                        String rutaImagenTopPila = PokedexSwing.pila_jugador.peek().getimgEspalda();
                        if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                            
                            Vida_Eevee.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                            
                            Vida_Munchlax.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                            
                            Vida_Bidoof.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                            
                            Vida_Charizard.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                            
                            Vida_Torchic.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                            
                            Vida_Tepig.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                            
                            Vida_Piplup.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                            
                            Vida_Magikarp.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                            
                            Vida_Blastoise.setValue(vida);
                            
                        }

                    }
                };

                // Crear un temporizador que dispare después de 2 segundos
                Timer timer = new Timer(delayMilliseconds, delayedAction);
                timer.setRepeats(false); // Solo se ejecutará una vez
                timer.start(); // Iniciar el temporizador
                
                
            }
        });

        ataque_especialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                //Hacemos llamar la funcion de ataque
                    if(seRealizoAccionD_IA){
                        int ataqueJugador = pila.peek().ataqueEspecial;
                        int defensaIA = pila_IA.peek().defensa;

                        // Reducir el ataque de la IA según la defensa del jugador
                        int nuevoAtaqueJugador = Math.max(ataqueJugador - defensaIA, 0);

                        // Realizar el ataque con el nuevo valor de ataque
                        int puntosDano = nuevoAtaqueJugador;
                        pila_IA.peek().puntosVida -= puntosDano;    
                        Ventana_combate.seRealizoAccionD_IA = false;  


                    }else if(seRealizoAccionS_IA){
                        int ataqueJugador = pila.peek().ataqueEspecial;
                        int defensaIA = pila_IA.peek().defensaEspecial;
                        // Reducir el ataque de la IA según la defensa del jugador
                        int nuevoAtaqueJugador = Math.max(ataqueJugador - defensaIA, 0);

                        // Realizar el ataque con el nuevo valor de ataque
                        int puntosDano = nuevoAtaqueJugador;
                        pila_IA.peek().puntosVida -= puntosDano;
                        Ventana_combate.seRealizoAccionS = false;  

                    }else{
                        Combate.atacarEspecial(pila, pila_IA);  
                    }
                
                //Actualizamos la progressbar
                int vida_IA = PokedexSwing.pila_IA.peek().getPuntosVida();    
                //Verificacion del pokemon (img)
                //Guardamos el valor en una variable para un manejo más facil
                String rutaImagenTopPila_IA = PokedexSwing.pila_IA.peek().getimgFrente();
                
                if (rutaImagenTopPila_IA.equals("src/img/EeveeFrente.gif")) {
                    Vida_Eevee_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/MunchlaxFrente.gif")) {
                    
                    Vida_Munchlax_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/BidoofFrente.gif")) {
                    
                    Vida_Bidoof_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/CharizardFrente.gif")) {
                    
                    Vida_Charizard_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/TorchicFrente.gif")) {
                    
                    Vida_Torchic_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/TepigFrente.gif")) {
                    
                    Vida_Tepig_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/PiplupFrente.gif")) {
                    
                    Vida_Piplup_IA.setValue(vida_IA);
                   

                } else if (rutaImagenTopPila_IA.equals("src/img/MagikarpFrente.gif")) {
                    
                    Vida_Magikarp_IA.setValue(vida_IA);
                    

                } else if (rutaImagenTopPila_IA.equals("src/img/BlastoiseFrente.gif")) {
                    
                    Vida_Blastoise_IA.setValue(vida_IA);
                    
                }
                
                //Agregar animacion (OPCIONAL)
                
                //Timer
                
                //Accion de la IA
                int delayMilliseconds = 2000; // 2 segundos
                ActionListener delayedAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
 
                        Acciones_IA.elegirYRealizarAccion();
                       
                       int vida = PokedexSwing.pila_jugador.peek().getPuntosVida();    
                        //Verificacion del pokemon (img)
                        //Guardamos el valor en una variable para un manejo más facil
                        String rutaImagenTopPila = PokedexSwing.pila_jugador.peek().getimgEspalda();
                        if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                            
                            Vida_Eevee.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                            
                            Vida_Munchlax.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                            
                            Vida_Bidoof.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                            
                            Vida_Charizard.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                            
                            Vida_Torchic.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                            
                            Vida_Tepig.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                            
                            Vida_Piplup.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                            
                            Vida_Magikarp.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                            
                            Vida_Blastoise.setValue(vida);
                            
                        }

                    }
                };

                // Crear un temporizador que dispare después de 2 segundos
                Timer timer = new Timer(delayMilliseconds, delayedAction);
                timer.setRepeats(false); // Solo se ejecutará una vez
                timer.start(); // Iniciar el temporizador
                
                
                
                
                
                
            }
        });

        defensaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
              seRealizoAccionD = true;  
              
              //Accion de la IA
                int delayMilliseconds = 500; // 2 segundos
                ActionListener delayedAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
 
                        Acciones_IA.elegirYRealizarAccion();
                       
                        int vida = PokedexSwing.pila_jugador.peek().getPuntosVida();    
                        //Verificacion del pokemon (img)
                        //Guardamos el valor en una variable para un manejo más facil
                        String rutaImagenTopPila = PokedexSwing.pila_jugador.peek().getimgEspalda();
                        if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                            
                            Vida_Eevee.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                            
                            Vida_Munchlax.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                            
                            Vida_Bidoof.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                            
                            Vida_Charizard.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                            
                            Vida_Torchic.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                            
                            Vida_Tepig.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                            
                            Vida_Piplup.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                            
                            Vida_Magikarp.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                            
                            Vida_Blastoise.setValue(vida);
                            
                        }

                    }
                };

                // Crear un temporizador que dispare después de 2 segundos
                Timer timer = new Timer(delayMilliseconds, delayedAction);
                timer.setRepeats(false); // Solo se ejecutará una vez
                timer.start(); // Iniciar el temporizador
                
              
              

            }
        });

        defensa_especialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
              seRealizoAccionS = true;  
              
              //Accion de la IA
                int delayMilliseconds = 2000; // 2 segundos
                ActionListener delayedAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
 
                        Acciones_IA.elegirYRealizarAccion();
                       
                        int vida = PokedexSwing.pila_jugador.peek().getPuntosVida();    
                        //Verificacion del pokemon (img)
                        //Guardamos el valor en una variable para un manejo más facil
                        String rutaImagenTopPila = PokedexSwing.pila_jugador.peek().getimgEspalda();
                        if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                            
                            Vida_Eevee.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                            
                            Vida_Munchlax.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                            
                            Vida_Bidoof.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                            
                            Vida_Charizard.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                            
                            Vida_Torchic.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                            
                            Vida_Tepig.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                            
                            Vida_Piplup.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                            
                            Vida_Magikarp.setValue(vida);
                            

                        } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                            
                            Vida_Blastoise.setValue(vida);
                            
                        }

                    }
                };

                // Crear un temporizador que dispare después de 2 segundos
                Timer timer = new Timer(delayMilliseconds, delayedAction);
                timer.setRepeats(false); // Solo se ejecutará una vez
                timer.start(); // Iniciar el temporizador
                
              
              

            }
        });
        
        pokemon1Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            pila.moveraAux(); // Mover todos los elementos a la pila auxiliar
            // Mover los dos elementos de la pila auxiliar de regreso a la pila principal
            pila.regresaralMain(3);
            
            String rutaImagenTopPila = PokedexSwing.pila_jugador.peek().getimgEspalda();
                
                
                if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                      
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                   
                   
                     
                } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                       
                    

                } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                    
                   
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    

                } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                   
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    

                } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                   
                    
                }

            }
        });

        pokemon2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                pila.moveraAux(); // Mover todos los elementos a la pila auxiliar
                // Mover los dos elementos de la pila auxiliar de regreso a la pila principal
                pila.regresaralMain(3);
                pila.regresaralMain(2);

                String rutaImagenTopPila = PokedexSwing.pila_jugador.peek().getimgEspalda();
                
                
                if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                      
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                   
                   
                     
                } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                       
                    

                } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                    
                   
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    

                } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                   
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    

                } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                   
                    
                }
                
                
                
                
            }
        });

        pokemon3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                pila.moveraAux(); // Mover todos los elementos a la pila auxiliar
                // Mover los dos elementos de la pila auxiliar de regreso a la pila principal
                pila.regresaralMain(3);
                pila.regresaralMain(2);
                pila.regresaralMain(1);

                String rutaImagenTopPila = PokedexSwing.pila_jugador.peek().getimgEspalda();
                
                
                if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                      
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                   
                   
                     
                } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                       
                    

                } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                    
                   
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    

                } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                   
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    

                } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                   
                    
                }
                
                
            }
        });

        pokemon4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                pila.moveraAux(); // Mover todos los elementos a la pila auxiliar
                // Mover los dos elementos de la pila auxiliar de regreso a la pila principal
                pila.regresaralMain(3);
                pila.regresaralMain(2);
                pila.regresaralMain(1);
                pila.regresaralMain(0);

                String rutaImagenTopPila = PokedexSwing.pila_jugador.peek().getimgEspalda();
                
                
                if (rutaImagenTopPila.equals("src/img/EeveeEspalda.gif")) {
                      
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                   
                   
                     
                } else if (rutaImagenTopPila.equals("src/img/MunchlaxEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                       
                    

                } else if (rutaImagenTopPila.equals("src/img/BidoofEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/CharizardEspalda.gif")) {
                    
                   
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/TorchicEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    

                } else if (rutaImagenTopPila.equals("src/img/TepigEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/PiplupEspalda.gif")) {
                    
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                   
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);

                } else if (rutaImagenTopPila.equals("src/img/MagikarpEspalda.gif")) {
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    
                    JLBlastoise.setVisible(false);                           
                    Vida_Blastoise.setVisible(false);
                    

                } else if (rutaImagenTopPila.equals("src/img/BlastoiseEspalda.gif")) {
                    
                    JLEevee.setVisible(false);
                    Vida_Eevee.setVisible(false);
                    JLMunchlax.setVisible(false);                         
                    Vida_Munchlax.setVisible(false);
                    JLBidoof.setVisible(false);                         
                    Vida_Bidoof.setVisible(false);
                    JLCharizard.setVisible(false);                            
                    Vida_Charizard.setVisible(false);
                    JLTorchic.setVisible(false);                           
                    Vida_Torchic.setVisible(false);
                    JLTepig.setVisible(false);                            
                    Vida_Tepig.setVisible(false);
                    JLPiplup.setVisible(false);                           
                    Vida_Piplup.setVisible(false);
                    JLMagikarp.setVisible(false);                            
                    Vida_Magikarp.setVisible(false);
                   
                    
                }
                
                
            }
        });

        
        
        setVisible(true);
        
               
    }
    
   private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 30);
        add(button);
        return button;
    }
  
}