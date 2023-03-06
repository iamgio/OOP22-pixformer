package pixformer.model.entity.dynamic;

import java.util.Optional;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.dynamic.ai.GoombaAI;
import pixformer.model.input.InputComponent;

public class Goomba extends AbstractEntity implements DefaultRectangleBoundingBoxEntity {

    private static int WIDTH = 1;
    private static int HEIGHT = 1;
    private final GoombaAI ai;

    public Goomba(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
        ai = new GoombaAI(this);
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(ai);
    }
    
}
