package fes.aragon.recursos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Musica implements Runnable 
{

    private BufferedInputStream buffer = null;
    private Player player = null;

    @Override
    public void run() 
    {
        try 
        {
            FileInputStream archivo = new FileInputStream(
                    this.getClass().getResource("/fes/aragon/recursos/sonidos/musicaFondo.mp3")
                            .toURI().getPath());
            buffer = new BufferedInputStream(archivo);
            player = new Player(buffer);
            player.play();
            while (true) 
            {
                if (player.isComplete()) 
                {
                    archivo.close();
                    try 
                    {
                        archivo = new FileInputStream(this.getClass().getResource(
                                "/fes/aragon/recursos/sonidos/musicaFondo.mp3").toURI().getPath());
                    } catch (URISyntaxException e) 
                    {
                        e.printStackTrace();
                    }
                    buffer = new BufferedInputStream(archivo);
                    player = new Player(buffer);
                    player.play();                    
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JavaLayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
}
