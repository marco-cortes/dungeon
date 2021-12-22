package fes.aragon.clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventosTeclado extends KeyAdapter
{
    public static boolean W, A, S, D, P, ESC, ENTER, ESPACIO;
    private int id;
    
    public EventosTeclado() 
    {
        W = false;
        A = false;
        S = false;
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
        if(id == KeyEvent.VK_W)
            W = true;
        if(id == KeyEvent.VK_A)
            A = true;
        if(id == KeyEvent.VK_S)
            S = true;
        if(id == KeyEvent.VK_D)
            D = true;
        
    }

    @Override
    public void keyReleased(KeyEvent ke) 
    {
        id = ke.getKeyCode();
        if(id == KeyEvent.VK_W)
            W = false;
        if(id == KeyEvent.VK_A)
            A = false;
        if(id == KeyEvent.VK_S)
            S = false;
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
    }
    
}
