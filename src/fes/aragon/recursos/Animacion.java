package fes.aragon.recursos;

import java.awt.image.BufferedImage;

public class Animacion 
{
    private BufferedImage[] frames;
    private int limite;
    private int indice;
    private int x, y;
    private boolean running;
    private long inicio, transcurrido;
    

    public Animacion(BufferedImage[] frames, int limite, int x, int y) 
    {
        this.frames = frames;
        this.limite = limite;
        this.x = x;
        this.y = y;
        indice = 0;
        running = true;
        inicio = 0;
        transcurrido = System.currentTimeMillis();
    }
    
    public void Actualizar()
    {
        inicio += System.currentTimeMillis() - transcurrido;
        transcurrido = System.currentTimeMillis();
        if(inicio > limite)
        {
            inicio = 0;
            indice++;
            running = true;
        }
        
    }
    

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public BufferedImage getCurrentFrame()
    {
        return frames[indice];
    }
    
    public void setIndex(int indice)
    {
        this.indice = indice;
    }
    
    public int getIndex()
    {
        return indice;
    }
    
    
}
