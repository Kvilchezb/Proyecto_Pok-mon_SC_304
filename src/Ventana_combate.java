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
public class Ventana_combate extends JFrame {
     
    //Botones
    private JButton BotonDeAtaque; 
    private JButton BotonDeObjeto;
    private JButton BotonPokemon;
    private JButton BotonVolver;
    //Imagen
    private JLabel ImagenPokemonJugador1;
    private JLabel ImagenPokemonJugador2;
    private JLabel ImagenPokemonJugador3;
    private JLabel ImagenPokemonJugador4;
    private JLabel ImagenPokemonEnemigo;
    //Barra De Vida
    private JProgressBar BarraDeVidaJugador1;
    private JProgressBar BarraDeVidaJugador2;
    private JProgressBar BarraDeVidaJugador3;
    private JProgressBar BarraDeVidaJugador4;
    private JProgressBar BarraDeVidaEnemigo;
    //Panel
    private JPanel PanelBotonAccion;
    private JPanel PanelBotonMovimientos;
    private JPanel panelSeleccionPokemon;
    
    // Crear instancias de los Pokémon
    private PokemonMovimientos charizard = new PokemonMovimientos("Charizard", "Lanzallamas", "Onda Ígnea", "Arañazo", "Cuchillada");
    private PokemonMovimientos bidoof = new PokemonMovimientos("Bidoof", "Mordisco", "Ataque Rápido", "Placaje", "Rayo Burbuja");
    private PokemonMovimientos munchlax = new PokemonMovimientos("Munchlax", "Golpe Cuerpo", "Mega Impacto", "Descanso", "Hiperrayo");
    private PokemonMovimientos eevee = new PokemonMovimientos("Eevee", "Ataque Rápido", "Mordisco", "Refuerzo", "Doble Filo");
    
    public Ventana_combate() {
        super("Menú de Batalla de Pokémon");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el panel para el fondo y configurar su imagen de fondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("src/imgReserva/Fondo.png");
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
        ImageIcon enemyPokemonImage = new ImageIcon("src/img/BlastoiseFrente.gif");
        ImagenPokemonEnemigo.setIcon(enemyPokemonImage);

        // Crear la barra de vida para el Pokémon del enemigo
        BarraDeVidaEnemigo = new JProgressBar(0, 100);
        BarraDeVidaEnemigo.setValue(90);
        
        // Agregar la barra de vida y el JLabel al panel del enemigo
        enemyPanel.add(ImagenPokemonEnemigo);
        enemyPanel.add(BarraDeVidaEnemigo);

        // Crear el panel para el Pokémon del jugador 1
        JPanel playerPanel_1 = new JPanel();
        playerPanel_1.setBounds(-30, 130, 270, 270);
        playerPanel_1.setOpaque(false);
        
        // Crear el panel para el Pokémon del jugador 2
        JPanel playerPanel_2 = new JPanel();
        playerPanel_2.setBounds(-10, 260, 270, 270);
        playerPanel_2.setOpaque(false);
        playerPanel_2.setVisible(false);
        
        // Crear el panel para el Pokémon del jugador 3
        JPanel playerPanel_3 = new JPanel();
        playerPanel_3.setBounds(-10, 260, 270, 270);
        playerPanel_3.setOpaque(false);
        playerPanel_3.setVisible(false);
        
        // Crear el panel para el Pokémon del jugador 4
        JPanel playerPanel_4 = new JPanel();
        playerPanel_4.setBounds(-10, 260, 270, 270);
        playerPanel_4.setOpaque(false);
        playerPanel_4.setVisible(false);

        // Crear el JLabel para mostrar la imagen del Pokémon del jugador 1
        ImagenPokemonJugador1 = new JLabel();
        ImageIcon playerPokemonImage1 = new ImageIcon("src/img/CharizardEspalda.gif");
        ImagenPokemonJugador1.setIcon(playerPokemonImage1);
        
        // Crear el JLabel para mostrar la imagen del Pokémon del jugador 2
        ImagenPokemonJugador2 = new JLabel();
        ImageIcon playerPokemonImage2 = new ImageIcon("src/img/BidoofEspalda.gif");
        ImagenPokemonJugador2.setIcon(playerPokemonImage2);
        
        // Crear el JLabel para mostrar la imagen del Pokémon del jugador 3
        ImagenPokemonJugador3 = new JLabel();
        ImageIcon playerPokemonImage3 = new ImageIcon("src/img/MunchlaxEspalda.gif");
        ImagenPokemonJugador3.setIcon(playerPokemonImage3);
        
        // Crear el JLabel para mostrar la imagen del Pokémon del jugador 4
        ImagenPokemonJugador4 = new JLabel();
        ImageIcon playerPokemonImage4 = new ImageIcon("src/img/EeveeEspalda.gif");
        ImagenPokemonJugador4.setIcon(playerPokemonImage4);

        // Crear la barra de vida para el Pokémon del jugador 1
        BarraDeVidaJugador1 = new JProgressBar(0, 100);
        BarraDeVidaJugador1.setValue(75);
        
        // Crear la barra de vida para el Pokémon del jugador 2
        BarraDeVidaJugador2 = new JProgressBar(0, 100);
        BarraDeVidaJugador2.setValue(75);
        
        // Crear la barra de vida para el Pokémon del jugador 3
        BarraDeVidaJugador3 = new JProgressBar(0, 100);
        BarraDeVidaJugador3.setValue(75);
        
        // Crear la barra de vida para el Pokémon del jugador 4
        BarraDeVidaJugador4 = new JProgressBar(0, 100);
        BarraDeVidaJugador4.setValue(75);

        // Agregar el JLabel y la barra de vida al panel del jugador 1
        playerPanel_1.add(ImagenPokemonJugador1);
        playerPanel_1.add(BarraDeVidaJugador1);
        
        // Agregar el JLabel y la barra de vida al panel del jugador 2
        playerPanel_2.add(ImagenPokemonJugador2);
        playerPanel_2.add(BarraDeVidaJugador2);
        
        // Agregar el JLabel y la barra de vida al panel del jugador 3
        playerPanel_3.add(ImagenPokemonJugador3);
        playerPanel_3.add(BarraDeVidaJugador3);
        
        // Agregar el JLabel y la barra de vida al panel del jugador 4
        playerPanel_4.add(ImagenPokemonJugador4);
        playerPanel_4.add(BarraDeVidaJugador4);

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
        PanelBotonMovimientos.setLayout(new GridLayout(2, 2, 10, 10));  // 2 filas, 2 columnas, espaciado de 10 en ambos ejes

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
        
        // Crear el panel para los botones de selección de Pokémon y configurar su diseño
        panelSeleccionPokemon = new JPanel();
        panelSeleccionPokemon.setOpaque(false);
        panelSeleccionPokemon.setLayout(new GridLayout(2, 2, 10, 10)); // 2 filas, 2 columnas, espaciado de 10 en ambos ejes

        // Crear los botones para la selección de Pokémon
        JButton botonPokemon1 = new JButton("Charizard");
        JButton botonPokemon2 = new JButton("Bidoof");
        JButton botonPokemon3 = new JButton("Munchlax");
        JButton botonPokemon4 = new JButton("Eevee");

        // Ajustar el tamaño de la fuente de los botones de selección de Pokémon
        Font pokemonButtonFont = new Font("Arial", Font.PLAIN, 16);
        botonPokemon1.setFont(pokemonButtonFont);
        botonPokemon2.setFont(pokemonButtonFont);
        botonPokemon3.setFont(pokemonButtonFont);
        botonPokemon4.setFont(pokemonButtonFont);

        // Agregar los botones de selección de Pokémon al panel
        panelSeleccionPokemon.add(botonPokemon1);
        panelSeleccionPokemon.add(botonPokemon2);
        panelSeleccionPokemon.add(botonPokemon3);
        panelSeleccionPokemon.add(botonPokemon4);
        
        // Botón de "Regresar" para volver al panel de botones de acción
        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.setFont(buttonFont);
        panelSeleccionPokemon.add(botonRegresar);

        // Configurar los paneles en el BorderLayout de la ventana (Donde y quien sale)
        backgroundPanel.add(enemyPanel);
        backgroundPanel.add(playerPanel_1);
        backgroundPanel.add(playerPanel_2);
        backgroundPanel.add(playerPanel_3);
        backgroundPanel.add(playerPanel_4);
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
        
        // Asociar acción al botón de "Pokémon" para mostrar el panel de selección de Pokémon
        BotonPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remover los botones de acción y agregar el panel de selección de Pokémon
                PanelBotonAccion.removeAll();
                PanelBotonAccion.add(panelSeleccionPokemon);
                PanelBotonAccion.revalidate();
                PanelBotonAccion.repaint();
            }
        });
        
        // Asociar acciones a los botones de Pokémon
        botonPokemon1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar los demás paneles de Pokémon y mostrar el panel del Pokémon 1
                playerPanel_1.setVisible(true);
                playerPanel_2.setVisible(false);
                playerPanel_3.setVisible(false);
                playerPanel_4.setVisible(false);
                PanelBotonAccion.removeAll();
                PanelBotonAccion.add(BotonDeAtaque);
                PanelBotonAccion.add(BotonDeObjeto);
                PanelBotonAccion.add(BotonPokemon);

                // Actualizar los movimientos en el botón de atacar con los movimientos de Charizard
                PanelBotonMovimientos.removeAll();
                PanelBotonMovimientos.add(new JButton(charizard.getMovimiento1()));
                PanelBotonMovimientos.add(new JButton(charizard.getMovimiento2()));
                PanelBotonMovimientos.add(new JButton(charizard.getMovimiento3()));
                PanelBotonMovimientos.add(new JButton(charizard.getMovimiento4()));
            }
        });

        botonPokemon2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar los demás paneles de Pokémon y mostrar el panel del Pokémon 2
                playerPanel_1.setVisible(false);
                playerPanel_2.setVisible(true);
                playerPanel_3.setVisible(false);
                playerPanel_4.setVisible(false);
                PanelBotonAccion.removeAll();
                PanelBotonAccion.add(BotonDeAtaque);
                PanelBotonAccion.add(BotonDeObjeto);
                PanelBotonAccion.add(BotonPokemon);

                // Actualizar los movimientos en el botón de atacar con los movimientos de Bidoof
                PanelBotonMovimientos.removeAll();
                PanelBotonMovimientos.add(new JButton(bidoof.getMovimiento1()));
                PanelBotonMovimientos.add(new JButton(bidoof.getMovimiento2()));
                PanelBotonMovimientos.add(new JButton(bidoof.getMovimiento3()));
                PanelBotonMovimientos.add(new JButton(bidoof.getMovimiento4()));
            }
        });

        botonPokemon3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar los demás paneles de Pokémon y mostrar el panel del Pokémon 2
                playerPanel_1.setVisible(false);
                playerPanel_2.setVisible(false);
                playerPanel_3.setVisible(true);
                playerPanel_4.setVisible(false);
                PanelBotonAccion.removeAll();
                PanelBotonAccion.add(BotonDeAtaque);
                PanelBotonAccion.add(BotonDeObjeto);
                PanelBotonAccion.add(BotonPokemon);

                // Actualizar los movimientos en el botón de atacar con los movimientos de Bidoof
                PanelBotonMovimientos.removeAll();
                PanelBotonMovimientos.add(new JButton(munchlax.getMovimiento1()));
                PanelBotonMovimientos.add(new JButton(munchlax.getMovimiento2()));
                PanelBotonMovimientos.add(new JButton(munchlax.getMovimiento3()));
                PanelBotonMovimientos.add(new JButton(munchlax.getMovimiento4()));
            }
        });

        botonPokemon4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar los demás paneles de Pokémon y mostrar el panel del Pokémon 2
                playerPanel_1.setVisible(false);
                playerPanel_2.setVisible(false);
                playerPanel_3.setVisible(false);
                playerPanel_4.setVisible(true);
                PanelBotonAccion.removeAll();
                PanelBotonAccion.add(BotonDeAtaque);
                PanelBotonAccion.add(BotonDeObjeto);
                PanelBotonAccion.add(BotonPokemon);

                // Actualizar los movimientos en el botón de atacar con los movimientos de Bidoof
                PanelBotonMovimientos.removeAll();
                PanelBotonMovimientos.add(new JButton(eevee.getMovimiento1()));
                PanelBotonMovimientos.add(new JButton(eevee.getMovimiento2()));
                PanelBotonMovimientos.add(new JButton(eevee.getMovimiento3()));
                PanelBotonMovimientos.add(new JButton(eevee.getMovimiento4()));
            }
        });
        
        // Asociar acción al botón de "Regresar" para volver al panel de botones de acción
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remover el panel de selección de Pokémon y agregar los botones de acción
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