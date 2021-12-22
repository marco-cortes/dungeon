package fes.aragon.objetos;

import fes.aragon.recursos.Animacion;
import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class Movimiento 
{
    protected int x, y;
    protected int suelo = 170;
    protected ArrayList<Animacion> animacionCamina = new ArrayList<>();
    protected ArrayList<Animacion> animacionMuere = new ArrayList<>();
    protected ArrayList<Animacion> animacionCaminaI = new ArrayList<>();
    protected ArrayList<Animacion> animacionMuereI = new ArrayList<>();
    protected ArrayList<Animacion> animacionEstatico = new ArrayList<>();
    protected ArrayList<Animacion> animacionEstaticoI = new ArrayList<>();
    protected ArrayList<Animacion> animacionAtaca = new ArrayList<>();
    protected ArrayList<Animacion> animacionAtacaI = new ArrayList<>();
    protected Animacion animacionC = null, animacionCI = null, animacionM = null, 
            animacionMI = null, animacionE = null, animacionEI = null, animacionA = null, animacionAI = null;
    protected int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0, a = 0, b = 0;
    protected boolean camina = false, caminaI = false, muere = false, muereI = false,
            derecha = true, izquierda = false, ataca = false, atacaI = false;
    protected int velocidadA = 150;
    protected boolean muerto = false;

    protected Movimiento(int x, int y) 
    {
        this.x = x;
        this.y = y;
        CargarAnimaciones();
    }
    
    abstract void CargarAnimaciones();
    abstract void Dibujar(Graphics2D g2d);
    abstract void Mover(Fondo f);
    
    
}
