package pixformer.model;

import pixformer.common.Updatable;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.score.ScoreManager;

import java.util.Set;
import java.util.stream.Stream;

/**
 * The environment where entities live, interact and die.
 */
public interface World extends Updatable {

    /**
     * @return the entities living within this world
     */
    Set<Entity> getEntities();

    /**
     * @return entities within the 'update range' from any player
     */
    Stream<Entity> getUpdatableEntities();

    /**
     * @return the score manager of the game world
     */
    ScoreManager getScoreManager();

    /**
     * @return an immutable subset of {@link World#getEntities()} with only user-controlled entities.
     */
    Set<Entity> getUserControlledEntities();

    /**
     * Adds an entity to the game world.
     * 
     * @param entity entity to add
     */
    void spawnEntity(Entity entity);

    /**
     * Add an entity to spawn in the game world.
     *
     * @param entity entity to spawn
     */
    void addEntityToSpawn(Entity entity);

    /**
     * Destroy an entity in the game world after the entity got killed.
     *
     * @param entity entity to destroy
     * @param player player who killed the entity
     */
    void killEntity(Entity entity, Entity player);

    /**
     * Remove an entity in the game world if the entity dropped out of it.
     *
     * @param entity entity to remove
     */
    void dropEntity(Entity entity);

    /**
     * @return the handler of entity collisions for this world
     */
    EntityCollisionManager getCollisionManager();

    /**
     * End the game because someone have won.
     *
     * @param winner player who won the game
     */
    void endGame(Player winner);
}
