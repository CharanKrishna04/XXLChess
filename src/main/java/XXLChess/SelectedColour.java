package XXLChess;
public enum SelectedColour{
    LIGHT_BLUE (173, 216, 230),
    DARK_BLUE (135, 206, 250),
    LIGHT_BROWN (196, 164, 132),
    DARK_BROWN (118, 78, 55),
    GREEN (50,205,50),
    YELLOW (255,255,102),
    ORANGE (255, 172, 28),
    RED (170, 74, 68), ;
    public final int R;
    public final int G;
    public final int B;
    SelectedColour(int R, int G, int B){
        this.R = R;
        this.G = G;
        this.B = B;
    }
}
