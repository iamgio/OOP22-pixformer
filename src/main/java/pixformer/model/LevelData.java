package pixformer.model;

import pixformer.model.entity.Entity;

import java.util.Set;

/**
 * Read-only data of a {@link Level}.
 *
 * @param name name of the level
 * @param entities initial entities living in the level's world
 * @param spawnPointX X coordinate of the level's spawn point
 * @param spawnPointY Y coordinate of the level's spawn point
 */
public record LevelData(
        String name,
        Set<Entity> entities,
        int spawnPointX,
        int spawnPointY
) {

}
