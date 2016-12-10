package club.xmlpro.dungeon.character;

public class Character {
    private int pointX;
    private int pointY;

    public Character(int pointX, int pointY){
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public void moveX(int pointX){
        this.pointX = pointX;
    }

    public void moveY(int pointY){
        this.pointY = pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }
}
