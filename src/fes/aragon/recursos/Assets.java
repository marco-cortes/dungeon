package fes.aragon.recursos;

import java.awt.image.BufferedImage;


public class Assets 
{
    public static BufferedImage[] jugadorEstatico = new BufferedImage[4];
    public static BufferedImage[] jugadorAtaca = new BufferedImage[4];
    public static BufferedImage[] jugadorMuere = new BufferedImage[4];
    public static BufferedImage[] jugadorCamina = new BufferedImage[5];
    
    public static BufferedImage[] jugadorEstaticoI = new BufferedImage[4];
    public static BufferedImage[] jugadorAtacaI = new BufferedImage[4];
    public static BufferedImage[] jugadorMuereI = new BufferedImage[4];
    public static BufferedImage[] jugadorCaminaI = new BufferedImage[5];
    
    public static BufferedImage[] salud = new BufferedImage[6];
    public static BufferedImage[] escudo = new BufferedImage[6];
    
    public static BufferedImage jugadorSalta;
    public static BufferedImage jugadorSaltaI;
    
    public static BufferedImage[] esqueletoEstatico = new BufferedImage[4];
    public static BufferedImage[] esqueletoCamina = new BufferedImage[4];
    public static BufferedImage[] esqueletoMuere = new BufferedImage[4];
    public static BufferedImage[] esqueletoAtaca = new BufferedImage[4];
    
    public static BufferedImage[] esqueletoEstaticoI = new BufferedImage[4];
    public static BufferedImage[] esqueletoCaminaI = new BufferedImage[4];
    public static BufferedImage[] esqueletoMuereI = new BufferedImage[4];
    public static BufferedImage[] esqueletoAtacaI = new BufferedImage[4];
    
    public static BufferedImage[] duendeEstatico = new BufferedImage[4];
    public static BufferedImage[] duendeCamina = new BufferedImage[4];
    public static BufferedImage[] duendeMuere = new BufferedImage[4];
    
    public static BufferedImage[] duendeEstaticoI = new BufferedImage[4];
    public static BufferedImage[] duendeCaminaI = new BufferedImage[4];
    public static BufferedImage[] duendeMuereI = new BufferedImage[4];
    
    
    public static BufferedImage fondo[] = new BufferedImage[5];
    
    public static void Init()
    {
        
        jugadorSalta = Loader.ImageLoader("/fes/aragon/recursos/jugador/PJ.png");
        jugadorSaltaI = Loader.ImageLoader("/fes/aragon/recursos/jugador/PJI.png");
        
        for(int i = 0; i < fondo.length; i++)
        fondo[i] = Loader.ImageLoader("/fes/aragon/interfaz/fondo/fondo"+i+".png");
        
        //JUGADOR
        for(int i = 0; i < jugadorEstatico.length; i++)
            jugadorEstatico[i] = Loader.ImageLoader("/fes/aragon/recursos/jugador/PI"+i+".png");
        for(int i = 0; i < jugadorEstaticoI.length; i++)
            jugadorEstaticoI[i] = Loader.ImageLoader("/fes/aragon/recursos/jugador/PII"+i+".png");
        for(int i = 0; i < jugadorAtaca.length; i++)
            jugadorAtaca[i] = Loader.ImageLoader("/fes/aragon/recursos/jugador/PA"+i+".png");        
        for(int i = 0; i < jugadorAtacaI.length; i++)
            jugadorAtacaI[i] = Loader.ImageLoader("/fes/aragon/recursos/jugador/PAI"+i+".png");        
        for(int i = 0; i < jugadorCamina.length; i++)
            jugadorCamina[i] = Loader.ImageLoader("/fes/aragon/recursos/jugador/PW"+i+".png");
        for(int i = 0; i < jugadorCaminaI.length; i++)
            jugadorCaminaI[i] = Loader.ImageLoader("/fes/aragon/recursos/jugador/PWI"+i+".png");
        for(int i = 0; i < jugadorMuere.length; i++)
            jugadorMuere[i] = Loader.ImageLoader("/fes/aragon/recursos/jugador/PD" +i+ ".png");
        for(int i = 0; i < jugadorMuereI.length; i++)
            jugadorMuereI[i] = Loader.ImageLoader("/fes/aragon/recursos/jugador/PDI" +i+ ".png");
        
        //ESQUELETOS
        for(int i = 0; i < esqueletoCamina.length; i++)
            esqueletoCamina[i] = Loader.ImageLoader("/fes/aragon/recursos/esqueleto/SW"+i+".png");
        for(int i = 0; i < esqueletoCaminaI.length; i++)
            esqueletoCaminaI[i] = Loader.ImageLoader("/fes/aragon/recursos/esqueleto/SWI"+i+".png");
        for(int i = 0; i < esqueletoMuere.length; i++)
            esqueletoMuere[i] = Loader.ImageLoader("/fes/aragon/recursos/esqueleto/SD"+i+".png");
        for(int i = 0; i < esqueletoMuereI.length; i++)
            esqueletoMuereI[i] = Loader.ImageLoader("/fes/aragon/recursos/esqueleto/SDI"+i+".png");
        for(int i = 0; i < esqueletoEstatico.length; i++)    
            esqueletoEstatico[i] = Loader.ImageLoader("/fes/aragon/recursos/esqueleto/SI"+i+".png");
        for(int i = 0; i < esqueletoEstaticoI.length; i++)
            esqueletoEstaticoI[i] = Loader.ImageLoader("/fes/aragon/recursos/esqueleto/SII"+i+".png");
        for(int i = 0; i < esqueletoAtaca.length; i++)
            esqueletoAtaca[i] = Loader.ImageLoader("/fes/aragon/recursos/esqueleto/SA"+i+".png");
        for(int i = 0; i < esqueletoAtacaI.length; i++)
            esqueletoAtacaI[i] = Loader.ImageLoader("/fes/aragon/recursos/esqueleto/SAI"+i+".png");
        
        
        //DUENDES
        for(int i = 0; i <  duendeCamina.length; i++)
            duendeCamina[i] = Loader.ImageLoader("/fes/aragon/recursos/duende/GW"+i+".png");
        for(int i = 0; i <  duendeCaminaI.length; i++)
            duendeCaminaI[i] = Loader.ImageLoader("/fes/aragon/recursos/duende/GWI"+i+".png");
        for(int i = 0; i <  duendeMuere.length; i++)
            duendeMuere[i] = Loader.ImageLoader("/fes/aragon/recursos/duende/GD"+i+".png");
        for(int i = 0; i <  duendeMuereI.length; i++)
            duendeMuereI[i] = Loader.ImageLoader("/fes/aragon/recursos/duende/GDI"+i+".png");
        for(int i = 0; i < duendeEstatico.length; i++)
            duendeEstatico[i] =  Loader.ImageLoader("/fes/aragon/recursos/duende/GI"+i+".png");
        for(int i = 0; i < duendeEstaticoI.length; i++)
            duendeEstaticoI[i] =  Loader.ImageLoader("/fes/aragon/recursos/duende/GII"+i+".png");
        
        //HUD
        for(int i = 0; i < salud.length; i++)
            salud[i] = Loader.ImageLoader("/fes/aragon/recursos/hud/HP" + i + ".png");
        for(int i = 0; i < escudo.length; i++)
            escudo[i] = Loader.ImageLoader("/fes/aragon/recursos/hud/D" + i + ".png");
        
    }
}

