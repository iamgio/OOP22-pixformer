package pixformer.model;

import pixformer.model.entity.Entity;
import pixformer.model.input.InputComponent;
import pixformer.model.input.UserInputComponent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of a game level.
 */
public class LevelImpl implements Level {

    private final String name;
    private final World world;

    /**
     * @param name level name
     * @param world game world of the level
     */
    public LevelImpl(final String name, final World world) {
        this.name = name;
        this.world = world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public World getWorld() {
        return this.world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<InputComponent> getPlayerEntityInputComponents() {
        return this.world.getEntities().stream()
                .map(Entity::getInputComponent)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(inputComponent -> inputComponent instanceof UserInputComponent)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {
        // TODO
    }
}
