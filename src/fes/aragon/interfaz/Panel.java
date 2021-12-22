package fes.aragon.interfaz;

import fes.aragon.clases.EventosTeclado;
import fes.aragon.clases.Fondo;
import fes.aragon.clases.Hilo;
import fes.aragon.clases.Jugador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Panel extends JPanel
{
    Hilo hilo = new Hilo(this);
    private Jugador j = new Jugador(Ventana.ANCHO/2 - 130, Ventana.ALTO/2 - 130);
    private Fondo f = new Fondo();
            
    public Panel()
    {
        setBackground(Color.black);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Dibujar(g2d);
        Actualizar();
    }
    
    public void Dibujar(Graphics2D g2d)
    {
        f.Dibujar(g2d);
        j.Dibujar(g2d);
    }
    
    public void Actualizar()
    {
        f.Mover();
        j.Mover();
        Mover();
    }
    
    public void Mover()
    {
        if(f.getX()[2] < 2048 && f.getX()[2] > -467)
        {
            j.setSuelo(170);
            f.setMover(true);
        }
        else if(f.getX()[2] > -607 && f.getX()[2] < -468)
        {
            f.setMover(true);
            j.Caida(false);
            if(f.getX()[2] == -482)
            {
                j.setSuelo(295);
            }
            if(f.getX()[2] > -622 && f.getX()[2] < -592)
            {
                j.setSuelo(396);
            }
            
            if(EventosTeclado.D && j.getY() <= 397)
            {
                j.setSuelo(j.getSuelo() + 4);
            }

            if (EventosTeclado.A) 
            {
                j.setSuelo(j.getSuelo() - 4);
            }
            if (j.getY() > j.getSuelo()) 
            {
                j.setSubir(true);
            }
        }
        
        else if(f.getX()[2] == -467 && !EventosTeclado.ESPACIO)
        {
            f.setMover(false);
            j.setSuelo(295);
            j.setSubir(false);
            EventosTeclado.A = false;
        }
        
        else if(f.getX()[2] < -622 && f.getX()[2] > -682 && !EventosTeclado.ESPACIO)
        {
            j.Caida(true);
            j.setSuelo(Ventana.ALTO);
        }
        
        else if(f.getX()[2] < -682)
        {
            j.setSuelo(360);
        }
    }
    
}
