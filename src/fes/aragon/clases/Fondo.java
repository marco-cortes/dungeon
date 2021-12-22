package fes.aragon.clases;

import fes.aragon.interfaz.Ventana;
import fes.aragon.recursos.Assets;
import java.awt.Graphics2D;

public class Fondo 
{
    private int[] x = new int[5];
    private int limite = 0;
    private int y = 0;
    private int vel = 5;
    private boolean mover = true;
    private boolean moverI = true;

    public Fondo() 
    {
        x[0] = 0;
        x[1] = Ventana.ANCHO;
        x[2] = x[1] + Ventana.ANCHO;   
        x[3] = x[2] + Ventana.ANCHO;
        x[4] = x[3] + Ventana.ANCHO;
    }

    public void Dibujar(Graphics2D g2d)
    {
        for(int i = 0; i < x.length; i++)
        {
            g2d.drawImage(Assets.fondo[i], x[i], y, Ventana.ANCHO,Ventana.ALTO, null);
        }
    }
    
    public void Mover()
    {
        if(EventosTeclado.A && limite > x[0] && mover)
        {
            for(int i = 0; i < x.length; i++)
            {
                x[i] += vel;
            }
                
        }
        else if(EventosTeclado.D && x[2] > -1747 && moverI)
        {
            for(int i = 0; i < x.length; i++)
                x[i] -= vel;
        }
    }

    public int[] getX() {
        return x;
    }
    
    public void setMover(boolean mover)
    {
        this.mover = mover;
    }
    
    public void setMoverI(boolean moverI)
    {
        this.moverI = moverI;
    }
}
