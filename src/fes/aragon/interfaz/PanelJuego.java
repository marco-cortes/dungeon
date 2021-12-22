package fes.aragon.interfaz;

import fes.aragon.inicio.Iniciar;
import fes.aragon.logica.EventosTeclado;
import fes.aragon.objetos.Duende;
import fes.aragon.objetos.Esqueleto;
import fes.aragon.objetos.Fondo;
import fes.aragon.objetos.Jugador;
import fes.aragon.logica.Logica;
import fes.aragon.recursos.Assets;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;


public class PanelJuego extends JPanel
{
    private Jugador j = new Jugador(Iniciar.ANCHO/2 - 130, Iniciar.ALTO/2 - 130);
    private int n = 3;
    private ArrayList<Esqueleto> e = new ArrayList<Esqueleto>();
    private ArrayList<Duende> d = new ArrayList<Duende>();
    private ArrayList<Esqueleto> eDos = new ArrayList<Esqueleto>();
    private ArrayList<Duende> dDos = new ArrayList<Duende>();
    
    
    private Fondo f = new Fondo();
    private Logica l = new Logica();
    
            
    public PanelJuego()
    {
        GeneracionMounstros();
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Dibujar(g2d);
        Actualizar();
    }
    
    public void Dibujar(Graphics2D g2d)
    {
        f.Dibujar(g2d);
        DibujarHUD(g2d);
        j.Dibujar(g2d);
        for(int i = 0; i < n; i++)
        {
            e.get(i).Dibujar(g2d);
            d.get(i).Dibujar(g2d);
            eDos.get(i).Dibujar(g2d);
            dDos.get(i).Dibujar(g2d);
        }
            
    }
    
    public void Actualizar()
    {
        if(!EventosTeclado.ESC && !j.isMuerto())
        {
            f.Mover();
            j.Mover(f);
            l.Mapa(j,f);
            l.IA(j, d, e, 170);
            l.IA(j, dDos, eDos, 360);

            for(int i = 0; i < n; i++)
            {
                e.get(i).Mover(f);
                d.get(i).Mover(f);
                eDos.get(i).Mover(f);
                dDos.get(i).Mover(f);
            }
            
        }  
        if(j.isMuerto())
        {
            Reiniciar();
        }
        
    }
    
    public void GeneracionMounstros()
    {
        int y = Iniciar.ALTO/2 - 130;
        int x = 0;
        
        for(int i = 0; i < n; i++)
        {
            x = (int)(Math.random()*(f.getX()[2] - 200)) + 900;
            e.add(new Esqueleto(x , y));
            x = (int)(Math.random()*(f.getX()[2] - 200)) + 900;
            d.add(new Duende(x, y));
        }
        y = 360;
        for(int i = 0; i < n; i++)
        {
            x = (int)(Math.random()*1000) + 3200;
            eDos.add(new Esqueleto(x, y));
            x = (int)(Math.random()*1000) + 3200;
            dDos.add(new Duende(x, y));
        }
    }
    
    public void DibujarHUD(Graphics2D g2d)
    {
        if(j.getHp() <= 0)
            j.setHp(0);
        g2d.drawImage(Assets.salud[j.getHp()], -20, -100, null);
        if(j.getEscudo() <= 0)
            j.setEscudo(0);
        g2d.drawImage(Assets.escudo[j.getEscudo()], 795, -95, null);
    }

    public Jugador getJ() {
        return j;
    }
    
    public void Reiniciar()
    {
        int x = 0;
        for(int i = 0; i < n; i++)
        {
            x = (int)(Math.random()*(f.getX()[2] - 200)) + 1000;
            e.get(i).setX(x);
            x = (int)(Math.random()*(f.getX()[2] - 200)) + 1000;
            d.get(i).setX(x);
            
            d.get(i).Reiniciar();
            e.get(i).Reiniciar();
        }
        
        for(int i = 0; i < n; i++)
        {
            x = (int)(Math.random()*1000) + 3200;
            eDos.get(i).setX(x);
            x = (int)(Math.random()*1000) + 3200;
            dDos.get(i).setX(x);
            
            dDos.get(i).Reiniciar();
            eDos.get(i).Reiniciar();
        }
        f.Reiniciar();
        j.Reiniciar();
    }
   
}
