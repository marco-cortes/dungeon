package fes.aragon.recursos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Loader 
{
    public static BufferedImage ImageLoader(String path)
    {
        try 
        {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (IOException ex) {
            System.out.println("error");}
        
        return null;
    }
}
