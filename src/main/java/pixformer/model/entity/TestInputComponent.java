package pixformer.model.entity;

import pixformer.model.input.InputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Input component for the test entity.
 * @deprecated test
 */
public class TestInputComponent extends InputComponent implements CompleteModelInput {

    private final TestEntity testEntity;

    public TestInputComponent(TestEntity testEntity) {
        super(testEntity);
        this.testEntity = testEntity;
        // Si potrebbe non tenere il campo con l'entità specifica,
        // ed usare super.getEntity() appena Entity esporrà setX
    }

    @Override
    public void jump() {
        testEntity.setX(testEntity.getX() + 0.1);
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
    public void fire() {

    }
}
