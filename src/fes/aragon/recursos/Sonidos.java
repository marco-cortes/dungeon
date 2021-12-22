package fes.aragon.recursos;

import javax.sound.sampled.Clip;

public class Sonidos
{
    private Clip clip;

    public Sonidos(Clip clip) 
    {
        this.clip = clip;
    }
    
    public void Reproducir()
    {
        clip.setFramePosition(0);
        clip.start();
    }
    
    public void Detener()
    {
        clip.stop();
    }
    
    public int getFramePosition()
    {
        return clip.getFramePosition();
    }
}
