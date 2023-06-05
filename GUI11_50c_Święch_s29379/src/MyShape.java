import java.awt.Color;
import java.util.List;
import java.awt.Point;
import java.util.Random;

import javax.swing.JComponent;

public abstract class MyShape extends JComponent {
    static final List<Color> COLORS = List.of(
            Color.BLACK, // 0
            Color.RED, // 1
            new Color(255, 192, 203), // pink, 2
            new Color(176, 224, 230), // powder blue, 3
            new Color(255, 228, 181), // moccasin, 4
            new Color(255, 105, 180), // hot pink, 5
            new Color(0, 255, 255), // cyan, 6
            new Color(255, 255, 0), // yellow, 7
            new Color(255, 165, 0), // orange, 8
            new Color(0, 128, 0), // green, 9
            new Color(128, 0, 128), // purple, 10
            new Color(0, 0, 255), // blue, 11
            new Color(255, 20, 147), // deep pink, 12
            new Color(173, 216, 230), // light blue, 13
            new Color(240, 230, 140), // khaki ,14
            new Color(255 ,215 ,0) ,// gold ,15 
            new Color(255 ,0 ,255) ,// magenta ,16 
            new Color(0 ,255 ,0) ,// lime ,17 
            new Color(192 ,192 ,192) ,// silver ,18 
            new Color(255 ,182 ,193) ,// light pink ,19 
            new Color(135 ,206 ,235) ,// sky blue ,20 
            new Color(245 ,245 ,220) ,// beige ,21 
            new Color(218 ,165 ,32) ,// goldenrod ,22 
            new Color(128 ,128 ,128) ,// gray ,23 
            new Color(221 ,160 ,221) ,// plum ,24 
            new Color(144 ,238 ,144) ,// light green ,25 
            new Color(230 ,230 ,250) ,// lavender ,26 
            new Color(139 ,69 ,19) ,// saddle brown ,27 
            new Color(255 ,140 ,0) ,// dark orange .28 
            new Color(102,204,204), // teal,29
            new Color (153,153,102), // olive,30
            new Color (204,102,153), // mauve,31
            new Color (153,204,102), // mint,32
            new Color (204,153,102), // peach,33
            new Color (102,153,204), // periwinkle,34
            new Color (153,102,204), // orchid,35
            new Color (102,204,153), // turquoise,36
            new Color (204,102,102), // coral,37
            new Color (51,153,153), // dark teal,38
            new Color (102,102,51), // dark olive,39
            new Color (153,51,102), // dark mauve ,40
            new Color (102,153,51), // sage,41
            new Color (153,204,51), // lemon,42
            new Color (51,102,153), // navy,43
            new Color (102,51,153), // indigo,44
            new Color (51,204,153), // aqua,45
            new Color (153,102,51), // copper,46
            new Color (0,102,102), // charcoal ,47
            new Color (51,51,0), // brown ,48
            new Color (102,0,51), // maroon ,49
            new Color (0,153,51), // forest ,50
            new Color (153,153,0), // mustard ,51
            new Color (0,0,102), // midnight ,52
            new Color (51,0,102), // plum ,53
            new Color (0,102,51), // emerald ,54
            new Color (102,51,0), // rust ,55
            new Color (255, 250, 240), // floral white ,56
            new Color(240, 255, 240), // honeydew ,57
            new Color(255, 240, 245), // lavender blush ,58
            new Color(240, 255, 255), // azure ,59
            new Color(250, 235, 215), // antique white ,60
            new Color(255, 239, 213), // papaya whip ,61
            new Color(255, 228, 225), // misty rose ,62
            new Color(255, 248, 220) // silky urine,63 
       );
    
    protected Color color;
    protected int x;
    protected int y;
    protected int size;

    protected int id;
    protected String type = "Pen";
    static int ID = 0;
    static boolean randomColor;
    public MyShape(String type, Color color, int x, int y, int size) {
        if( randomColor ){
            this.color = getRandomColor();
        }
        this.x = x;
        this.y = y;
        this.size = size;

        this.id = ID++;
    }
    public abstract boolean contains(Point p);
    protected Color getRandomColor(){
        // create a random object
        Random random = new Random();
        int index = random.nextInt(COLORS.size());
        // return the color at that index
        return COLORS.get(index);
       }
    public Color getCurrentColor() {
        return color;
    }

    @Override
    public String toString() {
        return "" + id + " " + type + " " + color.getRGB() + " " + x + " " + y + " " + size;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getShapeSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public static int getID() {
        return ID;
    }

}
