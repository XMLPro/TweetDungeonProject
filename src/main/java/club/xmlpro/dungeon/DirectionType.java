package club.xmlpro.dungeon;

public enum DirectionType {
    UP(0),
    DOWN(1),
    RIGHT(2),
    LEFT(3);

    private final int directionNumber;

    DirectionType(int directionNumber) {
        this.directionNumber = directionNumber;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }
}
