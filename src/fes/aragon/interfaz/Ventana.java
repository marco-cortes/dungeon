package fes.aragon.interfaz;

import fes.aragon.clases.EventosTeclado;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Ventana extends JFrame
{   
    public static final int ANCHO = 1024, ALTO = 600;
    
    public Ventana()
    {
        Panel panel = new Panel();
        Toolkit hr = Toolkit.getDefaultToolkit();
        Image img = hr.getImage(getClass().getResource("/fes/aragon/recursos/fuentes/icono.png"));
        
        
        setTitle("Juego");
        setSize(ANCHO,ALTO);
        setLocationRelativeTo(this);
        setResizable(false);
        setIconImage(img);
        add(panel);
        addKeyListener(new EventosTeclado());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
