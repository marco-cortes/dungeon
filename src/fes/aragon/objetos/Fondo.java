package fes.aragon.objetos;

import fes.aragon.inicio.Iniciar;
import fes.aragon.logica.EventosTeclado;
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
        x[1] = Iniciar.ANCHO;
        x[2] = x[1] + Iniciar.ANCHO;   
        x[3] = x[2] + Iniciar.ANCHO;
        x[4] = x[3] + Iniciar.ANCHO;
    }

    public void Dibujar(Graphics2D g2d)
    {
        for(int i = 0; i < x.length; i++)
        {
            g2d.drawImage(Assets.fondo[i], x[i], y, Iniciar.ANCHO,Iniciar.ALTO, null);
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

    public boolean isMover() {
        return mover;
    }

    public boolean isMoverI() {
        return moverI;
    }
    
    public void Reiniciar()
    {
        x[0] = 0;
        x[1] = Iniciar.ANCHO;
        x[2] = x[1] + Iniciar.ANCHO;   
        x[3] = x[2] + Iniciar.ANCHO;
        x[4] = x[3] + Iniciar.ANCHO;
    }
}
