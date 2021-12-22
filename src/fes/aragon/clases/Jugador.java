package fes.aragon.clases;

import fes.aragon.recursos.Animacion;
import fes.aragon.recursos.Assets;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Jugador 
{
    private int x, y;
    private int vel = 3;
    private boolean direccion = true;
    private boolean subir = false;
    private boolean saltar = false;
    private int suelo = 170;
    private ArrayList<Animacion> animacionCamina = new ArrayList<>();
    private ArrayList<Animacion> animacionMuere = new ArrayList<>();
    private ArrayList<Animacion> animacionAtaca = new ArrayList<>();
    private ArrayList<Animacion> animacionCaminaI = new ArrayList<>();
    private ArrayList<Animacion> animacionMuereI = new ArrayList<>();
    private ArrayList<Animacion> animacionAtacaI = new ArrayList<>();
    private ArrayList<Animacion> animacionEstatico = new ArrayList<>();
    private ArrayList<Animacion> animacionEstaticoI = new ArrayList<>();
    private Animacion animacionC = null, animacionCI = null, animacionE = null, 
            animacionEI = null, animacionA = null, animacionAI = null;
    private int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0;
    private int velocidadA = 150;
    private float gravedad = 10f;
    private float velocidad = 10;
    private float tiempo = 0;
    

    public Jugador(int x, int y) 
    {
        this.x = x;
        this.y = y;
        CargarAnimaciones();
    }
    
    public void Dibujar(Graphics2D g2d)
    {
        if(EventosTeclado.D && !EventosTeclado.ESPACIO)
        {
            
            for(i = 0; i < animacionCamina.size(); i++)
            {
                animacionC = animacionCamina.get(i);
                g2d.drawImage(animacionC.getCurrentFrame(), x, y, null);
                if(animacionC.getIndex() == 4 || !EventosTeclado.D)
                {
                    animacionC.setIndex(0);
                    animacionC.setRunning(false);
                }
            }
            EventosTeclado.A = false;
            EventosTeclado.P = false;
            direccion = true;
        }
        
        else if(EventosTeclado.A && !EventosTeclado.ESPACIO)
        {
            
            for(j = 0; j < animacionCaminaI.size(); j++)
            {
                animacionCI = animacionCaminaI.get(j);
                g2d.drawImage(animacionCI.getCurrentFrame(), x, y, null);
                if(animacionCI.getIndex() == 4 || !EventosTeclado.A)
                {
                    animacionCI.setIndex(0);
                    animacionCI.setRunning(false);
                }
            }
            EventosTeclado.D = false;
            EventosTeclado.P = false;
            direccion = false;
        }
        else if(EventosTeclado.ESPACIO && direccion)
        {
            g2d.drawImage(Assets.jugadorSalta, x,y, null);
            EventosTeclado.P = false;
        }
        
        else if(EventosTeclado.ESPACIO && !direccion)
        {
            g2d.drawImage(Assets.jugadorSaltaI, x, y, null);
            EventosTeclado.P = false;
        }
        
        else if(EventosTeclado.P && direccion && !EventosTeclado.ESPACIO)
        {
            for(m = 0; m < animacionAtaca.size(); m++)
            {
                animacionA = animacionAtaca.get(m);
                g2d.drawImage(animacionA.getCurrentFrame(), x, y, null);
                if(animacionA.getIndex() == 3)
                {
                    animacionA.setIndex(0);
                    animacionA.setRunning(false);
                }
            }
            
            EventosTeclado.A = false;
            EventosTeclado.D = false;
            EventosTeclado.ESPACIO = false;
        }
        
        else if(EventosTeclado.P && !direccion && !EventosTeclado.ESPACIO)
        {
            for(n = 0; n < animacionAtacaI.size(); n++)
            {
                animacionAI = animacionAtacaI.get(n);
                g2d.drawImage(animacionAI.getCurrentFrame(), x, y, null);
                if(animacionAI.getIndex() == 3)
                {
                    animacionAI.setIndex(0);
                    animacionAI.setRunning(false);
                }
            }
            
            EventosTeclado.A = false;
            EventosTeclado.D = false;
            EventosTeclado.ESPACIO = false;
        }
        
        else if(direccion == true && !EventosTeclado.ESPACIO)
        {
            for(k = 0; k < animacionEstatico.size(); k++)
            {
                animacionE = animacionEstatico.get(k);
                g2d.drawImage(animacionE.getCurrentFrame(), x, y, null);
                if(animacionE.getIndex() == 3 || !direccion)
                {
                    animacionE.setIndex(0);
                    animacionE.setRunning(false);
                }
            }
        }
        
        else if(direccion == false && !EventosTeclado.ESPACIO)
        {
            for(l = 0; l < animacionEstaticoI.size(); l++)
            {
                animacionEI = animacionEstaticoI.get(l);
                g2d.drawImage(animacionEI.getCurrentFrame(), x, y, null);
                if(animacionEI.getIndex() == 3 || direccion)
                {
                    animacionEI.setIndex(0);
                    animacionEI.setRunning(false);
                }
            }
        }
        
        
    }
    
    public void Mover()
    {
        if(EventosTeclado.D && !EventosTeclado.ESPACIO)
        {
            for(i = 0; i < animacionCamina.size(); i++)
            {
                animacionC = animacionCamina.get(i);
                animacionC.Actualizar();
            }
            EventosTeclado.A = false;
            EventosTeclado.P = false;
            direccion = true;
        }
        else if(EventosTeclado.A && !EventosTeclado.ESPACIO)
        {
            for(j = 0; j < animacionCaminaI.size(); j++)
            {
                animacionCI = animacionCaminaI.get(j);
                animacionCI.Actualizar();
            }
            EventosTeclado.D = false;
            EventosTeclado.P = false;
            direccion = false;
        }
        
        else if(EventosTeclado.P && direccion && !EventosTeclado.ESPACIO)
        {
            for(m = 0; m < animacionAtaca.size(); m++)
            {
                animacionA = animacionAtaca.get(m);
                animacionA.Actualizar();
                if(animacionA.getIndex() == 3)
                {
                    EventosTeclado.P = false;
                }
            }
            EventosTeclado.A = false;
            EventosTeclado.D = false;
            EventosTeclado.ESPACIO = false;
        }
        
        else if(EventosTeclado.P && !direccion && !EventosTeclado.ESPACIO)
        {
            for(n = 0; n < animacionAtacaI.size(); n++)
            {
                animacionAI = animacionAtacaI.get(n);
                animacionAI.Actualizar();
                if(animacionAI.getIndex() == 3)
                {
                    EventosTeclado.P = false;
                }
            }
            EventosTeclado.A = false;
            EventosTeclado.D = false;
            EventosTeclado.ESPACIO = false;
        }
        
        else if(EventosTeclado.ESPACIO)
        {
            Salto();
            saltar = true;
            if(y >= suelo)
            {
                this.tiempo=0;
                this.y=suelo;
                EventosTeclado.ESPACIO = false;
                saltar = false; 
            }
            EventosTeclado.P = false;   
        }
        
        else if(direccion == true && !EventosTeclado.ESPACIO)
        {
            for(k = 0; k < animacionEstatico.size(); k++)
            {
                animacionE = animacionEstatico.get(k);
                animacionE.Actualizar();
            }
        }
        
        else if(direccion == false && !EventosTeclado.ESPACIO)
        {
            for(l = 0; l < animacionEstaticoI.size(); l++)
            {
                animacionEI = animacionEstaticoI.get(l);
                animacionEI.Actualizar();
            }
        }
        Inclinar();
    }
    
    public void CargarAnimaciones()
    {
        //animacionMuere.add(new Animacion(Assets.jugadorMuere, 200, x, y));
        animacionCamina.add(new Animacion(Assets.jugadorCamina, velocidadA, x, y));
        animacionAtaca.add(new Animacion(Assets.jugadorAtaca, velocidadA, x, y));
        animacionCaminaI.add(new Animacion(Assets.jugadorCaminaI, velocidadA, x, y));
        animacionAtacaI.add(new Animacion(Assets.jugadorAtacaI, velocidadA, x, y));
        animacionEstatico.add(new Animacion(Assets.jugadorEstatico, velocidadA, x, y));
        animacionEstaticoI.add(new Animacion(Assets.jugadorEstaticoI, velocidadA, x, y));
    }

    public int getY() {
        return y;
    }

    public void setSubir(boolean subir) {
        this.subir = subir;
    }
    
    public void setSuelo(int suelo)
    {
        this.suelo = suelo;
    }
    
    public void Salto() 
    {
        this.tiempo += .4;
        int y = (int) ((250- this.velocidad * this.tiempo) - (.5 * this.gravedad * Math.pow(this.tiempo, 2)));
        this.y -= y/12;
    }
    
    public void Inclinar()
    {
        if(subir)
        {
            if (y > suelo) {
                y -= 4;
            }
            if (y < suelo) {
                y += 4;
            }
        } 
    }
    
    public void Caida(boolean caer)
    {
        if(y < suelo && !EventosTeclado.ESPACIO)
            y += 8;
        else if(caer)
            y += 8;
    }

    public int getSuelo() 
    {
        return suelo;
    }
}
