//Bibliotecas
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

//Ventana para el combate
public class Combate extends JFrame {
    
    //Botones
    private JButton BotonDeAtaque; 
    private JButton BotonDeObjeto;
    private JButton BotonPokemon;
    private JButton BotonVolver;
    //Imagen
    private JLabel ImagenPokemonJugador;
    private JLabel ImagenPokemonEnemigo;
    //Barra De Vida
    private JProgressBar BarraDeVidaJugador;
    private JProgressBar BarraDeVidaEnemigo;
    //Panel
    private JPanel PanelBotonAccion;
    private JPanel PanelBotonMovimientos;
    
    public Combate() {
        super("Menú de Batalla de Pokémon");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el panel para el fondo y configurar su imagen de fondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("src/img/Fondo.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        backgroundPanel.setLayout(null);

        // Crear el panel para el Pokémon enemigo
        JPanel enemyPanel = new JPanel();
        enemyPanel.setBounds(230, 100, 150, 150);
        enemyPanel.setOpaque(false);


        // Crear el JLabel para mostrar la imagen del Pokémon enemigo
        ImagenPokemonEnemigo = new JLabel();
        ImageIcon enemyPokemonImage = new ImageIcon("src/img/blastoise.gif");
        ImagenPokemonEnemigo.setIcon(enemyPokemonImage);

        // Crear la barra de vida para el Pokémon del enemigo
        BarraDeVidaEnemigo = new JProgressBar(0, 100);
        BarraDeVidaEnemigo.setValue(90);
        
        // Agregar la barra de vida y el JLabel al panel del enemigo
        enemyPanel.add(ImagenPokemonEnemigo);
        enemyPanel.add(BarraDeVidaEnemigo);

        // Crear el panel para el Pokémon del jugador
        JPanel playerPanel = new JPanel();
        playerPanel.setBounds(-30, 140, 270, 270);
        playerPanel.setOpaque(false);

        // Crear el JLabel para mostrar la imagen del Pokémon del jugador
        ImagenPokemonJugador = new JLabel();
        ImageIcon playerPokemonImage = new ImageIcon("src/img/charizard.gif");
        ImagenPokemonJugador.setIcon(playerPokemonImage);

        // Crear la barra de vida para el Pokémon del jugador
        BarraDeVidaJugador = new JProgressBar(0, 100);
        BarraDeVidaJugador.setValue(75);

        // Agregar el JLabel y la barra de vida al panel del jugador
        playerPanel.add(ImagenPokemonJugador);
        playerPanel.add(BarraDeVidaJugador);

        // Crear el panel para los botones de acción y configurar su diseño
        PanelBotonAccion = new JPanel();
        PanelBotonAccion.setOpaque(false);
        PanelBotonAccion.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Crear los botones para las opciones del menú
        BotonDeAtaque = new JButton("Atacar");
        BotonDeObjeto = new JButton("Objeto");
        BotonPokemon = new JButton("Pokémon");

        // Ajustar el tamaño de la fuente de los botones
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        BotonDeAtaque.setFont(buttonFont);
        BotonDeObjeto.setFont(buttonFont);
        BotonPokemon.setFont(buttonFont);

        // Agregar los botones de acción al panel
        PanelBotonAccion.add(BotonDeAtaque);
        PanelBotonAccion.add(BotonDeObjeto);
        PanelBotonAccion.add(BotonPokemon);

        // Crear el panel para los botones de movimiento y configurar su diseño
        PanelBotonMovimientos = new JPanel();
        PanelBotonMovimientos.setOpaque(false);
        PanelBotonMovimientos.setLayout(new GridLayout(2, 2, 10, 10));

        // Crear los botones para los movimientos del Pokémon
        JButton BotonDeMovimiento1 = new JButton("Lanzallamas");
        JButton BotonDeMovimiento2 = new JButton("Onda Ígnea");
        JButton BotonDeMovimiento3 = new JButton("Arañazo");
        JButton BotonDeMovimiento4 = new JButton("Cuchillada");

        // Ajustar el tamaño de la fuente de los botones de movimiento
        Font moveButtonFont = new Font("Arial", Font.PLAIN, 12);
        BotonDeMovimiento1.setFont(moveButtonFont);
        BotonDeMovimiento2.setFont(moveButtonFont);
        BotonDeMovimiento3.setFont(moveButtonFont);
        BotonDeMovimiento4.setFont(moveButtonFont);

        // Agregar los botones de movimiento al panel
        PanelBotonMovimientos.add(BotonDeMovimiento1);
        PanelBotonMovimientos.add(BotonDeMovimiento2);
        PanelBotonMovimientos.add(BotonDeMovimiento3);
        PanelBotonMovimientos.add(BotonDeMovimiento4);

        // Crear el botón para regresar al menú anterior
        BotonVolver = new JButton("Regresar");
        BotonVolver.setFont(buttonFont);

        // Configurar los paneles en el BorderLayout de la ventana
        backgroundPanel.add(enemyPanel);
        backgroundPanel.add(playerPanel);
        add(backgroundPanel, BorderLayout.CENTER);
        add(PanelBotonAccion, BorderLayout.SOUTH);

        // Asociar acciones a los botones
        BotonDeAtaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remover los botones de acción y agregar los botones de movimiento y el botón de regresar
                PanelBotonAccion.removeAll();
                PanelBotonAccion.add(PanelBotonMovimientos);
                PanelBotonAccion.add(BotonVolver);
                PanelBotonAccion.revalidate();
                PanelBotonAccion.repaint();
            }
        });

        BotonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remover los botones de movimiento y el botón de regresar, y agregar los botones de acción
                PanelBotonAccion.removeAll();
                PanelBotonAccion.add(BotonDeAtaque);
                PanelBotonAccion.add(BotonDeObjeto);
                PanelBotonAccion.add(BotonPokemon);
                PanelBotonAccion.revalidate();
                PanelBotonAccion.repaint();
            }
        });

        setVisible(true);
    }
}