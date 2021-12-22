package fes.aragon.objetos;

import fes.aragon.logica.EventosTeclado;
import fes.aragon.recursos.Animacion;
import fes.aragon.recursos.Assets;
import java.awt.Graphics2D;

public class Esqueleto extends Movimiento
{
    private boolean daño = false;
    private boolean mover = true;
    public Esqueleto(int x, int y) 
    {
        super(x, y);
    }
    
    @Override
    public void CargarAnimaciones()
    {
        animacionCamina.add(new Animacion(Assets.esqueletoCamina, velocidadA, x, y));
        animacionCaminaI.add(new Animacion(Assets.esqueletoCaminaI, velocidadA, x, y));
        animacionEstatico.add(new Animacion(Assets.esqueletoEstatico, velocidadA, x, y));
        animacionEstaticoI.add(new Animacion(Assets.esqueletoEstaticoI, velocidadA, x, y));
        animacionAtaca.add(new Animacion(Assets.esqueletoAtaca, velocidadA, x, y));
        animacionAtacaI.add(new Animacion(Assets.esqueletoAtacaI, velocidadA, x, y));
        animacionMuere.add(new Animacion(Assets.esqueletoMuere, velocidadA, x, y));
        animacionMuereI.add(new Animacion(Assets.esqueletoMuereI, velocidadA, x, y));
    }
    
    @Override
    public void Dibujar(Graphics2D g2d)
    {
        if(derecha)
        {
            for(m = 0; m < animacionEstatico.size(); m++)
            {
                animacionE = animacionEstatico.get(m);
                g2d.drawImage(animacionE.getCurrentFrame(), x, y, null);
            }
        }
        else if(izquierda)
        {
            for(n = 0; n < animacionEstaticoI.size(); n++)
            {
                animacionEI = animacionEstaticoI.get(n);
                g2d.drawImage(animacionEI.getCurrentFrame(), x, y, null);
            }
        }
        else if(camina)
        {
            for(i = 0; i < animacionCamina.size(); i++)
            {
                animacionC = animacionCamina.get(i);
                g2d.drawImage(animacionC.getCurrentFrame(), x, y, null);
            }
        }
        else if(caminaI)
        {
            for(j = 0; j < animacionCaminaI.size(); j++)
            {
                animacionCI = animacionCaminaI.get(j);
                g2d.drawImage(animacionCI.getCurrentFrame(), x, y, null);
                
            }
        }
        else if(muere)
        {
            for(k = 0; k < animacionMuere.size(); k++)
            {
                animacionM = animacionMuere.get(k);
                g2d.drawImage(animacionM.getCurrentFrame(), x, y, null);
            }
        }
        else if(muereI)
        {
            for(l = 0; l < animacionMuereI.size(); l++)
            {
                animacionMI = animacionMuereI.get(l);
                g2d.drawImage(animacionMI.getCurrentFrame(), x, y, null);
            }
        }
        else if(ataca)
        {
            for(a = 0; a < animacionAtaca.size(); a++)
            {
                animacionA = animacionAtaca.get(a);
                g2d.drawImage(animacionA.getCurrentFrame(), x, y, null);
            }
        }
        else if(atacaI)
        {
            for(b = 0; b < animacionAtacaI.size(); b++)
            {
                animacionAI = animacionAtacaI.get(b);
                g2d.drawImage(animacionAI.getCurrentFrame(), x, y, null);
            }
        }
    }
    
    @Override
    public void Mover(Fondo f)
    {
        if(derecha)
        {
            for(m = 0; m < animacionEstatico.size(); m++)
            {
                animacionE = animacionEstatico.get(m);
                animacionE.Actualizar();
                if (animacionE.getIndex() == 3 || !derecha) 
                {
                    animacionE.setIndex(0);
                }
            }
            izquierda = false;
        }
        else if(izquierda)
        {
            for(n = 0; n < animacionEstaticoI.size(); n++)
            {
                animacionEI = animacionEstaticoI.get(n);
                animacionEI.Actualizar();
                if (animacionEI.getIndex() == 3 || !izquierda) 
                {
                    animacionEI.setIndex(0);
                }
            }
            derecha = false;
        }
        else if(camina)
        {
            for(i = 0; i < animacionCamina.size(); i++)
            {
                animacionC = animacionCamina.get(i);
                
                if (animacionC.getIndex() == 3 || !camina) 
                {
                    animacionC.setIndex(0);
                }
                animacionC.Actualizar();
            }
            caminaI = false;
            muere = false;
            muereI = false;
            izquierda = false;
            derecha = false;
        }
        
        else if(caminaI)
        {
            for(j = 0; j < animacionCaminaI.size(); j++)
            {
                animacionCI = animacionCaminaI.get(j);
                
                if (animacionCI.getIndex() == 3 || !caminaI) 
                {
                    animacionCI.setIndex(0);
                }
                animacionCI.Actualizar();
            }
            camina = false;
            muere = false;
            muereI = false;
            derecha= false;
            izquierda = false;
        }
        
        else if(muere)
        {
            for(k = 0; k < animacionMuere.size(); k++)
            {
                animacionM = animacionMuere.get(k);
                animacionM.Actualizar();
                if (animacionM.getIndex() == 3) 
                {
                    animacionM.setIndex(0);
                    muerto = true;
                }
            }
            camina = false;
            caminaI = false;
            muereI = false;
            derecha= false;
            izquierda = false;
            ataca = false;
            atacaI = false;
            muereI = false;
        }
        
        else if(muereI)
        {
            for(l = 0; l < animacionMuereI.size(); l++)
            {
                animacionMI = animacionMuereI.get(l);
                animacionMI.Actualizar();
                if (animacionMI.getIndex() == 3) 
                {
                    animacionMI.setIndex(0);
                    muerto = true;
                }
            }
            camina = false;
            muere = false;
            caminaI = false;
            muere = false;
            derecha= false;
            izquierda = false;
            ataca = false;
            atacaI = false;
        }
        else if(ataca)
        {
            for(a = 0; a < animacionAtaca.size(); a++)
            {
                animacionA = animacionAtaca.get(a);
                animacionA.Actualizar();
                if(animacionA.getIndex() == 3)
                {
                    animacionA.setIndex(0);
                    animacionA.setRunning(false);
                    ataca = false;
                    daño = true;
                }
                else
                    daño = false;
            }
            atacaI = false;
            camina = false;
            caminaI = false;
            muere = false;
            muereI = false;
            derecha= false;
            izquierda = false;
        }
        else if(atacaI)
        {
            for(b = 0; b < animacionAtacaI.size(); b++)
            {
                animacionAI = animacionAtacaI.get(b);
                animacionAI.Actualizar();
                if(animacionAI.getIndex() == 3)
                {
                    animacionAI.setIndex(0);
                    animacionAI.setRunning(false);
                    atacaI = false;
                }
            }
            ataca = false;
            camina = false;
            caminaI = false;
            muere = false;
            muereI = false;
            derecha= false;
            izquierda = false;
        }
        
        if(mover)
        {
            if(EventosTeclado.D && f.getX()[2] > -1746)
            {
                x -= 5;
            } 
            else if(EventosTeclado.D && f.getX()[2] < -1746)
            {
                x-= 0;
            }
            else if (EventosTeclado.A && f.getX()[2] < 2047) 
            {
                x += 5;
            }
            else if(EventosTeclado.A && f.getX()[2] > 2047)
            {
                x += 0;
            }
        }
        
        if(muerto)
        {
            camina = false;
            caminaI = false;
            ataca = false;
            atacaI = false;
            izquierda = false;
            derecha = false;
            muere = false;
            muereI = false;
        }
    }
    
    public void setSuelo(int suelo)
    {
        this.suelo = suelo;
    }
    
    public int getSuelo() 
    {
        return suelo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setCamina(boolean camina) {
        this.camina = camina;
    }

    public void setCaminaI(boolean caminaI) {
        this.caminaI = caminaI;
    }

    public void setMuere(boolean muere) {
        this.muere = muere;
    }

    public void setMuereI(boolean muereI) {
        this.muereI = muereI;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    public void setAtaca(boolean ataca) {
        this.ataca = ataca;
    }

    public void setAtacaI(boolean atacaI) {
        this.atacaI = atacaI;
    }

    public boolean isDaño() {
        return daño;
    }
    
    public boolean isAtaca() {
        return ataca;
    }

    public boolean isAtacaI() {
        return atacaI;
    }

    public boolean isMuere() {
        return muere;
    }

    public boolean isMuereI() {
        return muereI;
    }

    public boolean isMuerto() {
        return muerto;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }

    public void setMover(boolean mover) {
        this.mover = mover;
    }
    
    public void Reiniciar()
    {
        ataca = false;
        camina = false;
        caminaI = false;
        muere = false;
        muereI = false;
        derecha = true;
        izquierda = false;
        muerto = false;
    }
}
