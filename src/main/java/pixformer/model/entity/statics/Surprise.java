package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidEntity;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.dynamic.player.Player;
//import pixformer.model.entity.powerups.FireFlower;
//import pixformer.model.entity.powerups.Mushroom;
import pixformer.view.engine.Color;
import pixformer.view.entity.RectangleGraphicsComponent;

import java.util.Optional;
import java.util.Set;

/**
 * Surprise block, which contains a power-up.
 */
public class Surprise extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent = new RectangleGraphicsComponent(this, new Color(1, 0, 1));

    /**
     * Constructor of the Surprise block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Surprise(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(new CollisionComponent(this) {

            /**
             * {@inheritDoc}
             */
            @Override
            public void update(final double dt, final Set<Collision> collisions) {
                collisions.stream()
                        .filter(x -> x.side() == CollisionSide.BOTTOM && getWorld().isPresent() && x.entity() instanceof Player)
                        .map(x -> (Player)x.entity())
                        .forEach(p -> {
                            if (p.getPowerup().isPresent()) {
                                getWorld().get().spawnEntity(new Brick(super.getEntity().getX(), super.getEntity().getY() + 10));
                            } else {
                                getWorld().get().spawnEntity(new Brick(super.getEntity().getX(), super.getEntity().getY() + 10));
                            }
                        });
            }
        });
    }
}
