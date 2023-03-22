package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidEntity;

import java.util.Optional;

public class Coin extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity  {

    private static final int HEIGHT = 2;
    private static final int WIDTH = 2;

    public Coin (final int x, final int y) {
        super(x, y, WIDTH, HEIGHT);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return null;
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.empty();
    }
}
