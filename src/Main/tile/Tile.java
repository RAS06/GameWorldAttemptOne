package Main.tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Tile {
    public BufferedImage image;
    public boolean collision = false;

    public Tile() throws IOException {
        image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/world/decentBackgroundTile.jpg")));
    }
}
