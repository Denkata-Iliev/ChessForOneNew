package Logic;

public class Player {
    public boolean isWhite;
    public boolean isChecked;

    public Player(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public void check(){
        isChecked = true;
    }

    //playmove

}
