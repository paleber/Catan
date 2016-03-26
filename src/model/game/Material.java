package model.game;

/**
 * Enum with Materials used for Resources and Terrain.
 */
public enum Material {

    /**
     * Default material Brick, terrain Hill.
     */
    BRICK(true, true), // Brick Hill

    /**
     * Default material Wool, terrain Pasture.
     */
    WOOL(true, true), // Wool Pasture

    /**
     * Default material Ore, terrain Hill.
     */
    ORE(true, true), // Ore Mountain

    /**
     * Default material Grain, Terrain Terrain.
     */
    GRAIN(true, true), // Grain Terrain

    /**
     * Default material Lumber, Terrain Forest.
     */
    LUMBER(true, true), // Lumber Forest

    /**
     * Non-collectable material Sand, Terrain Desert.
     */
    SAND(true, false), // Sand Desert

    /**
     * Non-collectable and non-walkable material water, Terrain Sea.
     */
    WATER(false, false); // Water Sea

    private final boolean walkable;
    private final boolean collectable;

    Material(final boolean walkable, final boolean collectable) {
        this.walkable = walkable;
        this.collectable = collectable;
    }

    /**
     * Check if the material is walkable.
     *
     * @return is walkable
     */
    public boolean isWalkable() {
        return walkable;
    }

    /**
     * Check if the material is collectable.
     *
     * @return is collectable
     */
    public boolean isCollectable() {
        return collectable;
    }

}
