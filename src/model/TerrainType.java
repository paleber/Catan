package model;

public enum TerrainType {
    Hill(true, true),
    Pasture(true, true),
    Mountain(true, true),
    Grain(true, true),
    Forest(true, true),
    Desert(true, false),
    Sea(false, false);

    private final boolean walkable;
    private final boolean collectable;

    TerrainType(boolean walkable, boolean collectable) {
        this.walkable = walkable;
        this.collectable = collectable;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public boolean isCollectable() {
        return collectable;
    }

}
