package pixformer.model.entity;

/**
 * In-Game entity
 */
public interface Entity {

    // TODO : have to create the GraphicsComponent that the entity should return
    // something like this :
    // GraphicsComponent getGraphicsComponent();

    // TODO : have to expose the position of the entity, Vector2D || Point2d || Something else
    // Vector2D<T> getVector2D();
    // Point2D<T> getPoint2D();

    // TODO : other methods that are needed

    // TODO : brainstorming with Luca
    // Interface Entity
    // - Position
    // - Dimension
    // -> Drawable Entity
    // - Graphics Component
    // - Movement Component [STATIC, FIXED, CONTROLLED]
    // right, left, up, down
    // HORIZONTAL [RIGHT, LEFT]
    // JUMPABLE [UP]
    // CROUCHABLE [DOWN]
    // The app can choose what movement components are needed
    // Controller -> input -> [1, 2, 3] -> ent.apply(input)
}
