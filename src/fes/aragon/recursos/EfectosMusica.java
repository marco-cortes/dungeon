package fes.aragon.recursos;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class EfectosMusica implements Runnable 
{

    private BufferedInputStream buffer = null;
    private FileInputStream archivo;
    private Player player = null;

    public EfectosMusica(String archivo) 
    {
        try 
        {
            this.archivo = new FileInputStream(
                    this.getClass().getResource("/fes/aragon/recursos/sonidos/"
                            + archivo)
                            .toURI().getPath());

        } catch (FileNotFoundException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void run() 
    {
        try 
        {
            buffer = new BufferedInputStream(this.archivo);
            player = new Player(buffer);
            player.play();
            if(player.isComplete())
            {
                player.close();
            }
        } catch (JavaLayerException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

