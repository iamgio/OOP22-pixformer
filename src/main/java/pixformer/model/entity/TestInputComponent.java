package pixformer.model.entity;

import pixformer.model.input.UserInputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Input component for the test entity.
 * @deprecated test
 */
@Deprecated
public class TestInputComponent extends UserInputComponent implements CompleteModelInput {

    public TestInputComponent(Entity testEntity) {
        super(testEntity);
        // Si potrebbe non tenere il campo con l'entità specifica,
        // ed usare super.getEntity() appena Entity esporrà setX
    }

    @Override
    public void jump() {
        // testEntity.setX(testEntity.getX() + 0.1);
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void crouch() {

    }

    @Override
    public void ability() {

    }
}
