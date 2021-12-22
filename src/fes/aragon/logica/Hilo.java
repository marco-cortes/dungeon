package fes.aragon.logica;

import fes.aragon.recursos.Assets;
import javax.swing.JPanel;

public class Hilo extends Thread
{
    JPanel panel;
    
    boolean correr = true;

    public Hilo(JPanel panel) 
    {
        this.panel = panel;
        this.start();
    }
    
    @Override
    public void run()
    {
        long inicio = 0;
        long transcurrido = System.nanoTime();
        final int FPS = 60;
        double tiempoObjetivo = 1000000000 / FPS;
        double diferenciaTiempo = 0;
        
        Init();
        while(correr)
        {
            inicio = System.nanoTime();
            diferenciaTiempo += (inicio - transcurrido) / tiempoObjetivo;
            transcurrido = inicio;
            
            if(diferenciaTiempo >= 1)
            {
                panel.repaint();
                diferenciaTiempo--;
            }
            
        }
    }
    
    private void Init()
    {
        Assets.Init();
    }
    
}
