package fes.aragon.clases;

import fes.aragon.interfaz.Panel;
import fes.aragon.recursos.Assets;

public class Hilo extends Thread
{
    Panel panel;
    private final int FPS = 60;
    private double TARGETTIME = 1000000000 / FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;
    boolean correr = true;

    public Hilo(Panel panel) 
    {
        this.panel = panel;
        this.start();
    }
    
    @Override
    public void run()
    {
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;
        
        Init();
        while(correr)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / TARGETTIME;
            time += (now - lastTime);
            lastTime = now;
            if(delta >= 1)
            {
                panel.repaint();
                delta--;
                frames++;
            }
            if (time >= 1000000000) 
            {
                AVERAGEFPS = frames;
                frames = 0;
                time = 0;
            }
        }
        Pausar();
    }
    
    private void Init()
    {
        Assets.Init();
    }
    
    public void Pausar() 
    {
        try 
        {
            this.join();
            correr = false;
        } catch (InterruptedException e) 
        {}
    }
    
    public void setCorrer(boolean correr) {
        this.correr = correr;
    }
    
    
}
