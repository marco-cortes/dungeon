package fes.aragon.logica;

import fes.aragon.recursos.EfectosMusica;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventosTeclado extends KeyAdapter
{
    public static boolean A, D, P, ESC, ENTER, ESPACIO;
    private int id;
    
    public EventosTeclado() 
    {
        A = false;
        D = false;
        P = false;
        ESC = false;
        ENTER = false;
        ESPACIO = false;
    }

    @Override
    public void keyPressed(KeyEvent ke) 
    {
        id = ke.getKeyCode();
        if(id == KeyEvent.VK_A)
            A = true;
        if(id == KeyEvent.VK_D)
            D = true;
        
    }

    @Override
    public void keyReleased(KeyEvent ke) 
    {
        id = ke.getKeyCode();
        if(id == KeyEvent.VK_A)
            A = false;
        if(id == KeyEvent.VK_D)
            D = false;
    }
    
    @Override
    public void keyTyped(KeyEvent ke)
    {
        if(id == KeyEvent.VK_ESCAPE)
        {
            ESC = !ESC;
        }
        
        if(id == KeyEvent.VK_SPACE)
        {
            ESPACIO = true;
        }
        
        if(id == KeyEvent.VK_P)
        {
            P = true;
        }
        Sonidos();
    }
    
    public void Sonidos()
    {
        EfectosMusica atacar = new EfectosMusica("cuchilla.mp3");
        Thread hAtacar = new Thread(atacar);
        
        if(P && !ESPACIO && !A && !D)
        {
            hAtacar.start();
        }
        else if(!P)
        {
            try 
            {
                hAtacar.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(EventosTeclado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
