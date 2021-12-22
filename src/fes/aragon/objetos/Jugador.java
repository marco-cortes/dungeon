package fes.aragon.objetos;

import fes.aragon.inicio.Iniciar;
import fes.aragon.logica.EventosTeclado;
import fes.aragon.recursos.Animacion;
import fes.aragon.recursos.Assets;
import java.awt.Graphics2D;

public class Jugador extends Movimiento
{
    private boolean direccion = true;
    private boolean subir = false;
    private boolean saltar = false;
    private boolean muerto = false;
    private float gravedad = 10f;
    private float velocidad = 5;
    private float tiempo = 0;
    private int hp = 5;
    private int escudo = 5;
    
    

    public Jugador(int x, int y) 
    {
        super(x, y);
    }
    
    @Override
    public void CargarAnimaciones()
    {
        animacionCamina.add(new Animacion(Assets.jugadorCamina, velocidadA, x, y));
        animacionAtaca.add(new Animacion(Assets.jugadorAtaca, velocidadA, x, y));
        animacionCaminaI.add(new Animacion(Assets.jugadorCaminaI, velocidadA, x, y));
        animacionAtacaI.add(new Animacion(Assets.jugadorAtacaI, velocidadA, x, y));
        animacionEstatico.add(new Animacion(Assets.jugadorEstatico, velocidadA, x, y));
        animacionEstaticoI.add(new Animacion(Assets.jugadorEstaticoI, velocidadA, x, y));
        animacionMuere.add(new Animacion(Assets.jugadorMuere, velocidadA, x , y));
        animacionMuereI.add(new Animacion(Assets.jugadorMuereI, velocidadA, x ,y));
    }
    
    @Override
    public void Dibujar(Graphics2D g2d)
    {
        if(!muerto)
        {
            if(EventosTeclado.D && !EventosTeclado.ESPACIO)
            {
                for(i = 0; i < animacionCamina.size(); i++)
                {
                    animacionC = animacionCamina.get(i);
                    g2d.drawImage(animacionC.getCurrentFrame(), x, y, null);
                }
                
            }

            else if(EventosTeclado.A && !EventosTeclado.ESPACIO)
            {
                
                for(j = 0; j < animacionCaminaI.size(); j++)
                {
                    animacionCI = animacionCaminaI.get(j);
                    g2d.drawImage(animacionCI.getCurrentFrame(), x, y, null);
                }
                
            }
            else if(EventosTeclado.ESPACIO && direccion)
            {
                g2d.drawImage(Assets.jugadorSalta, x,y, null);
                EventosTeclado.P = false;
                EventosTeclado.A = false;
                
            }

            else if(EventosTeclado.ESPACIO && !direccion)
            {
                g2d.drawImage(Assets.jugadorSaltaI, x, y, null);
                EventosTeclado.P = false;
                EventosTeclado.D = false;
            }

            else if(EventosTeclado.P && direccion && !EventosTeclado.ESPACIO)
            {
                for(m = 0; m < animacionAtaca.size(); m++)
                {
                    animacionA = animacionAtaca.get(m);
                    g2d.drawImage(animacionA.getCurrentFrame(), x, y, null);
                }
            }

            else if(EventosTeclado.P && !direccion && !EventosTeclado.ESPACIO)
            {
                for(n = 0; n < animacionAtacaI.size(); n++)
                {
                    animacionAI = animacionAtacaI.get(n);
                    g2d.drawImage(animacionAI.getCurrentFrame(), x, y, null);
                }
                
            }

            else if(direccion == true && !EventosTeclado.ESPACIO)
            {
                for(k = 0; k < animacionEstatico.size(); k++)
                {
                    animacionE = animacionEstatico.get(k);
                    g2d.drawImage(animacionE.getCurrentFrame(), x, y, null);
                }
            }

            else if(direccion == false && !EventosTeclado.ESPACIO)
            {
                for(l = 0; l < animacionEstaticoI.size(); l++)
                {
                    animacionEI = animacionEstaticoI.get(l);
                    g2d.drawImage(animacionEI.getCurrentFrame(), x, y, null);
                }
            }
            
            else if(muere)
            {
                for(a = 0; a < animacionMuere.size(); a++)
                {
                    animacionM = animacionMuere.get(a);
                    g2d.drawImage(animacionM.getCurrentFrame(), x, y, null);
                }
            }
            
            else if(muereI)
            {
                for(b = 0; b < animacionMuereI.size(); b++)
                {
                    animacionMI = animacionMuereI.get(b);
                    g2d.drawImage(animacionMI.getCurrentFrame(), x, y, null);
                }
            }
            
        }
    }
    
    @Override
    public void Mover(Fondo f)
    {
        if(!muerto)
        {
            if(EventosTeclado.D && !EventosTeclado.ESPACIO && !muere && !muereI)
            {
                //EfectosMusica caminar = new EfectosMusica("paso.flac");
                //Thread t = new Thread(caminar);
                for(i = 0; i < animacionCamina.size(); i++)
                {
                    animacionC.setRunning(true);
                    animacionC = animacionCamina.get(i);
                    if(animacionC.getIndex() == 0)
                    {
                        //t.start();
                    }
                    animacionC.Actualizar();
                    if(animacionC.getIndex() == 4 || !EventosTeclado.D)
                    {
                        animacionC.setIndex(0);
                        animacionC.setRunning(false);
                        
                        /*try 
                        {
                            t.join();
                        } catch (InterruptedException ex) {
                        }*/
                    }
                }
                EventosTeclado.A = false;
                EventosTeclado.P = false;
                direccion = true;
            }
            else if(EventosTeclado.A && !EventosTeclado.ESPACIO && !muere && !muereI)
            {
                for(j = 0; j < animacionCaminaI.size(); j++)
                {
                    animacionCI.setRunning(true);
                    animacionCI = animacionCaminaI.get(j);
                    animacionCI.Actualizar();
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

            else if(EventosTeclado.P && direccion && !EventosTeclado.ESPACIO && !muere && !muereI)
            {
                //EfectosMusica pegar = new EfectosMusica("cuchilla.mp3");
                //Thread t = new Thread(pegar);
                for(m = 0; m < animacionAtaca.size(); m++)
                {
                    animacionA = animacionAtaca.get(m);
                    if(animacionA.getIndex() == 0)
                    {
                        //t.start();
                    }
                    animacionA.Actualizar();
                    if(animacionA.getIndex() == 3)
                    {
                        animacionA.setIndex(0);
                        animacionA.setRunning(false);
                        EventosTeclado.P = false;
                        /*try 
                        {
                            t.join();
                        } catch (InterruptedException ex) {
                        }*/
                    }
                }
                EventosTeclado.A = false;
                EventosTeclado.D = false;
                EventosTeclado.ESPACIO = false;
                
            }

            else if(EventosTeclado.P && !direccion && !EventosTeclado.ESPACIO && !muere && !muereI)
            {
                //EfectosMusica pegar = new EfectosMusica("cuchilla.mp3");
                //Thread t = new Thread(pegar);
                for(n = 0; n < animacionAtacaI.size(); n++)
                {
                    animacionAI = animacionAtacaI.get(n);
                    if(animacionAI.getIndex() == 0)
                    {
                       // t.start();
                    }
                    animacionAI.Actualizar();
                    if(animacionAI.getIndex() == 3)
                    {
                        animacionAI.setIndex(0);
                        animacionAI.setRunning(false);
                        EventosTeclado.P = false;
                        /*try 
                        {
                            t.join();
                        } catch (InterruptedException ex) {
                        }*/
                    }
                }
                EventosTeclado.A = false;
                EventosTeclado.D = false;
                EventosTeclado.ESPACIO = false;
            }

            else if(EventosTeclado.ESPACIO && !muere && !muereI)
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

            else if(direccion == true && !EventosTeclado.ESPACIO && !muere && !muereI)
            {
                for(k = 0; k < animacionEstatico.size(); k++)
                {
                    animacionE = animacionEstatico.get(k);
                    animacionE.Actualizar();
                    if(animacionE.getIndex() == 3 || !direccion)
                    {
                        animacionE.setIndex(0);
                        animacionE.setRunning(false);
                    }
                }
            }

            else if(direccion == false && !EventosTeclado.ESPACIO && !muere && !muereI)
            {
                for(l = 0; l < animacionEstaticoI.size(); l++)
                {
                    animacionEI = animacionEstaticoI.get(l);
                    animacionEI.Actualizar();
                    if(animacionEI.getIndex() == 3 || direccion)
                    {
                        animacionEI.setIndex(0);
                        animacionEI.setRunning(false);
                    }
                }
            }
            
            else if(muere)
            {
                for(a = 0; a < animacionMuere.size(); a++)
                {
                    animacionM = animacionMuere.get(a);
                    animacionM.Actualizar();
                    if (animacionM.getIndex() == 3) 
                    {
                        animacionM.setIndex(0);
                        muerto = true;
                    }
                }
                EventosTeclado.A = false;
                EventosTeclado.ESPACIO = false;
                EventosTeclado.P = false;
                EventosTeclado.D = false;
            }
            else if(muereI)
            {
                for(b = 0; b < animacionMuereI.size(); b++)
                {
                    animacionMI = animacionMuereI.get(b);
                    animacionMI.Actualizar();
                    if (animacionMI.getIndex() == 3) 
                    {
                        animacionMI.setIndex(0);
                        muerto = true;
                    }
                }
                EventosTeclado.A = false;
                EventosTeclado.ESPACIO = false;
                EventosTeclado.P = false;
                EventosTeclado.D = false;
            }
        }
        Inclinar();
    }
    
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
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
            y += 10;
        else if(caer)
            y += 10;
    }

    public int getSuelo() 
    {
        return suelo;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public boolean isMuerto() {
        return muerto;
    }
    
    public void setMuere(boolean muere)
    {
        this.muere = muere;
    }
    
    public void setMuereI(boolean muereI)
    {
        this.muereI = muereI;
    }
    
    public void Reiniciar()
    {
        direccion = true;
        muere = false;
        muereI = false;
        muerto = false;
        y = Iniciar.ALTO/2 - 130;
        x = Iniciar.ANCHO/2 - 130;
        hp = 5;
        escudo = 5;
    }
}
