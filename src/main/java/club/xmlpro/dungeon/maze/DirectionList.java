package club.xmlpro.dungeon.maze;

public enum DirectionList {
    UP(0),
    DOWN(1),
    RIGHT(2),
    LEFT(3);

    private final int directionNumber;

    DirectionList(int directionNumber) {
        this.directionNumber = directionNumber;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }
}
