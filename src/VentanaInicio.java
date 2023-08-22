import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;

public class VentanaInicio extends JFrame {

    private Clip clip; // Variable para mantener la referencia del Clip que reproduce la música

    public VentanaInicio() {
        setTitle("Pokémon Game - Inicio"); // Título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        setSize(800, 600); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setResizable(false); // Evitar que se pueda redimensionar la ventana
        setLayout(null); // Establecer el diseño a null para posicionar los componentes manualmente

        // Cargar la imagen de fondo y ajustar al tamaño de la ventana
        ImageIcon backgroundImageIcon = new ImageIcon("src/imgReserva/GiratinaWallpaper.gif");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        setContentPane(new JLabel(new ImageIcon(backgroundImage))); // Establecer el contenido principal

        // Crear el JLabel para el título
        JLabel lblTitulo = new JLabel("Pokémon Giratina's Nightmare");
        lblTitulo.setBounds(100, 200, 600, 100); // Establecer posición y tamaño del JLabel
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente

        // Cambiar la fuente y el estilo del título
        Font fontTitulo = new Font("Arial", Font.BOLD, 40);
        lblTitulo.setFont(fontTitulo);
        lblTitulo.setForeground(Color.WHITE); // Cambiar el color del texto a blanco

        // Crear el botón para continuar
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(350, 500, 100, 30); // Establecer posición y tamaño del botón
        btnContinuar.addActionListener(e -> {
            // Al presionar el botón "Continuar", creamos una instancia de la ventana Combate y la hacemos visible
            PokedexSwing pokedexSwing = new PokedexSwing();
            setVisible(false); // Ocultamos la ventana actual (ventana de inicio)
            detenerMusica(); // Detenemos la música al cambiar de ventana
        });

        // Agregar los componentes a la ventana
        add(lblTitulo);
        add(btnContinuar);

        setVisible(true); // Hacer la ventana visible

        // Iniciar la música con un volumen bajo (0.05f)
        reproducirMusica("src/musica/Pokemon Black and White Music - Title Screen.wav", 0.05f); // Reemplaza la ruta por la ubicación de tu archivo de música y ajusta el volumen
    }

    // Método para reproducir la música con volumen controlado
    private void reproducirMusica(String rutaMusica, float volumen) {
        try {
            File archivoMusica = new File(rutaMusica);
            if (archivoMusica.exists()) {
                AudioInputStream entradaAudio = AudioSystem.getAudioInputStream(archivoMusica);
                clip = AudioSystem.getClip();
                clip.open(entradaAudio);

                // Configurar el control de volumen
                FloatControl controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                //db = decibelios
                float dB = (float) (Math.log(volumen) / Math.log(10.0) * 20.0);
                controlVolumen.setValue(dB);

                clip.loop(Clip.LOOP_CONTINUOUSLY); // Reproducir en bucle
            } else {
                System.out.println("El archivo de música no se encuentra.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Método para detener la música
    private void detenerMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}