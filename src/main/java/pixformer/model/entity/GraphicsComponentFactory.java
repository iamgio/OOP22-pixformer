package pixformer.model.entity;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.entity.player.PlayerGraphicsComponent;

/**
 * A factory for {@link GraphicsComponent} implementation for different entities.
 */
public interface GraphicsComponentFactory {

    /**
     * @param entity block target
     * @return a graphics component for a tile block
     */
    GraphicsComponent tileBlock(Entity entity);

    /**
     * @param entity grass block
     * @return the graphics component for a grass block
     */
    GraphicsComponent grassBlock(Entity entity);

    /**
     * @param entity brick block
     * @return the graphics component for the brick block
     */
    GraphicsComponent brickBlock(Entity entity);

    /**
     * @param entity surprise block
     * @return the graphics component for the surprise block
     */
    GraphicsComponent surpriseBlock(Entity entity);

    /**
     * @param entity coin
     * @return the graphics component for the coin
     */
    GraphicsComponent coin(Entity entity);

    /**
     * @param entity pole
     * @return the graphics component for the pole
     */
    GraphicsComponent pole(Entity entity);

    /**
     * @param entity target entity
     * @return a new Goomba graphics component
     */
    GraphicsComponent goomba(Entity entity);

    /**
     * @param entity target entity
     * @return a new Graphics component for the koopa in default state
     */
    GraphicsComponent walkingKoopa(Entity entity);

    /**
     * @param entity target entity
     * @return a new Graphics component for the koopa in shell state
     */
    GraphicsComponent turtleKoopa(Entity entity);

    /**
     * @param entity target of the graphics component
     * @return a new fire flower graphics component
     */
    GraphicsComponent fireFlower(Entity entity);

    /**
     * @param player target of the graphics component
     * @return a new player graphics component
     */
    PlayerGraphicsComponent player(Player player);
}
