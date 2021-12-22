package fes.aragon.logica;

import fes.aragon.objetos.Duende;
import fes.aragon.objetos.Esqueleto;
import fes.aragon.objetos.Fondo;
import fes.aragon.objetos.Jugador;
import fes.aragon.inicio.Iniciar;
import java.util.ArrayList;

public class Logica 
{
    
    public void Mapa(Jugador j, Fondo f)
    {
        if(f.getX()[2] < 2048 && f.getX()[2] > -467)
        {
            j.setSuelo(170);
            f.setMover(true);
        }
        else if(f.getX()[2] > -607 && f.getX()[2] < -468)
        {
            f.setMover(true);
            j.Caida(false);
            if(f.getX()[2] == -482)
            {
                j.setSuelo(295);
            }
            if(f.getX()[2] > -622 && f.getX()[2] < -592)
            {
                j.setSuelo(396);
            }
            
            if(EventosTeclado.D && j.getY() <= 397)
            {
                j.setSuelo(j.getSuelo() + 4);
            }

            if (EventosTeclado.A) 
            {
                j.setSuelo(j.getSuelo() - 4);
            }
            if (j.getY() > j.getSuelo()) 
            {
                j.setSubir(true);
            }
        }
        
        else if(f.getX()[2] == -467 && !EventosTeclado.ESPACIO)
        {
            f.setMover(false);
            j.setSuelo(295);
            j.setSubir(false);
            EventosTeclado.A = false;
        }
        
        else if(f.getX()[2] < -622 && f.getX()[2] > -682 && !EventosTeclado.ESPACIO)
        {
            j.Caida(true);
            j.setSuelo(Iniciar.ALTO);
        }
        
        else if(f.getX()[2] < -682)
        {
            j.setSuelo(360);
        }
    }
    private int contador = 5;
    public void IA(Jugador j, ArrayList<Duende> d, ArrayList<Esqueleto> e, int suelo)
    {
        int de = 0, dd = 0;
        for(int i = 0; i < e.size(); i++)
        {
            de = e.get(i).getX() - j.getX();
            if(!e.get(i).isMuerto())
            {
                if(de <= 300 && j.getY() <= suelo) 
                {
                    if(e.get(i).getX() > j.getX() + 50  && !e.get(i).isAtacaI())
                    {
                        e.get(i).setX(e.get(i).getX() - 3);
                        e.get(i).setCaminaI(true);
                        e.get(i).setDerecha(false);
                        e.get(i).setIzquierda(false);
                    }
                    else if(de <= 50 && de >= 0)
                    {
                        e.get(i).setAtacaI(true);
                        e.get(i).setIzquierda(false);
                        e.get(i).setDerecha(false);
                        e.get(i).setCaminaI(false);

                        if(de <= 50 && de >= 0  && !EventosTeclado.ESPACIO)
                        {
                            if(e.get(i).isAtacaI() && !EventosTeclado.P)
                            {
                                contador--;
                                if(contador == -20 && !e.get(i).isMuereI())
                                {
                                    j.setEscudo(j.getEscudo() - 1);
                                    if(j.getEscudo() <= 0)
                                    {
                                        j.setHp(j.getHp() - 1);
                                        if(j.getHp() == 0)
                                        {
                                            j.setMuere(true);
                                        }
                                    }
                                }
                                if(contador <= -20 || !(de <= 50 && de >= 0))
                                {
                                    contador = 5;
                                }
                            }
                            else if(EventosTeclado.P)
                            {
                                e.get(i).setMuere(true);
                            }
                        }
                    }
                    else
                    {
                        e.get(i).setAtacaI(false);
                        e.get(i).setCaminaI(false);
                    }
                }
                else
                {
                    e.get(i).setIzquierda(true);
                    e.get(i).setDerecha(false);
                    e.get(i).setCaminaI(false);
                }

                if(de >= -300 && j.getY() <= suelo)
                {
                    if(e.get(i).getX() < j.getX() - 50 && !e.get(i).isAtaca())
                    {
                        e.get(i).setX(e.get(i).getX() + 3);
                        e.get(i).setCamina(true);
                        e.get(i).setDerecha(false);
                        e.get(i).setIzquierda(false);
                    }
                    else if(de >= -50 && de <= 0)
                    {
                        e.get(i).setAtaca(true);
                        e.get(i).setDerecha(false);
                        e.get(i).setIzquierda(false);
                        e.get(i).setCamina(false);

                        if(de >= -50 && de <= 0 && !EventosTeclado.ESPACIO)
                        {
                            if(e.get(i).isAtaca() && !EventosTeclado.P)
                            {
                                contador--;
                                if (contador == -20 && !e.get(i).isMuere()) 
                                {
                                    j.setEscudo(j.getEscudo() - 1);
                                    if (j.getEscudo() <= 0) 
                                    {
                                        j.setHp(j.getHp() - 1);
                                        if(j.getHp() == 0)
                                        {
                                            j.setMuere(true);
                                        }
                                    }
                                }
                                if (contador <= -20 || !(de >= -50 && de <= 0)) 
                                {
                                    contador = 5;
                                }
                            }
                            else if(EventosTeclado.P)
                            {
                                e.get(i).setMuere(true);
                            }
                        }
                    }
                    else
                    {
                        e.get(i).setAtaca(false);
                        e.get(i).setCamina(false);
                    }
                }
                else
                {
                    e.get(i).setDerecha(true);
                    e.get(i).setIzquierda(false);
                    e.get(i).setCamina(false);
                }
            }
        }
        
        for(int i = 0; i < d.size(); i++)
        {
            dd = d.get(i).getX() - j.getX();
            if(!d.get(i).isMuerto())
            {
                if(dd <= 200 && j.getY() <= suelo)
                {
                    if(d.get(i).getX() > j.getX() + 50)
                    {
                        d.get(i).setX(d.get(i).getX() - 2);
                        d.get(i).setCaminaI(true);
                        d.get(i).setDerecha(false);
                        d.get(i).setIzquierda(false);
                    }
                    else if(dd <= 50 && dd >= 0)
                    {
                        d.get(i).setAtacaI(true);
                        d.get(i).setIzquierda(false);
                        d.get(i).setDerecha(false);
                        d.get(i).setCaminaI(false);
                        if(dd <= 50 && dd >= 0  && !EventosTeclado.ESPACIO)
                            {
                                if(d.get(i).isAtacaI() && !EventosTeclado.P)
                                {
                                    contador--;
                                    if(contador == -20 && !d.get(i).isMuereI())
                                    {
                                        j.setEscudo(j.getEscudo() - 1);
                                        if(j.getEscudo() <= 0)
                                        {
                                            j.setHp(j.getHp() - 1);
                                            if(j.getHp() == 0)
                                            {
                                                j.setMuere(true);
                                            }
                                        }
                                    }
                                    if(contador <= -20 || !(dd <= 50 && dd >= 0))
                                    {
                                        contador = 5;
                                    }
                                }
                                else if(EventosTeclado.P)
                                {
                                    d.get(i).setMuere(true);
                                }
                            }
                    }
                    else
                    {
                        d.get(i).setAtacaI(false);
                        d.get(i).setCaminaI(false);
                    }
                }
                else
                {
                    d.get(i).setIzquierda(true);
                    d.get(i).setDerecha(false);
                    d.get(i).setCaminaI(false);
                }

                if(dd >= -200 && j.getY() <= suelo)
                {
                    if(d.get(i).getX() < j.getX() - 50)
                    {
                        d.get(i).setX(d.get(i).getX() + 2);
                        d.get(i).setCamina(true);
                        d.get(i).setDerecha(false);
                        d.get(i).setIzquierda(false);
                    }
                    else if(dd >= -50 && dd <= 0)
                    {
                        d.get(i).setAtaca(true);
                        d.get(i).setDerecha(false);
                        d.get(i).setIzquierda(false);
                        d.get(i).setCamina(false);
                        if(dd >= -50 && dd <= 0 && !EventosTeclado.ESPACIO)
                            {
                                if(d.get(i).isAtaca() && !EventosTeclado.P)
                                {
                                    contador--;
                                    if (contador == -20 && !d.get(i).isMuere()) 
                                    {
                                        j.setEscudo(j.getEscudo() - 1);
                                        if (j.getEscudo() <= 0) 
                                        {
                                            j.setHp(j.getHp() - 1);
                                            if(j.getHp() == 0)
                                            {
                                                j.setMuere(true);
                                            }
                                        }
                                    }
                                    if (contador <= -20 || !(de >= -50 && de <= 0)) 
                                    {
                                        contador = 5;
                                    }
                                }
                                else if(EventosTeclado.P)
                                {
                                    d.get(i).setMuere(true);
                                }
                            }
                    }
                    else
                    {
                        d.get(i).setAtaca(false);
                        d.get(i).setCamina(false);
                    }
                }
                else
                {
                    d.get(i).setDerecha(true);
                    d.get(i).setIzquierda(false);
                    d.get(i).setCamina(false);
                }
                
            }
        }
    }
}
