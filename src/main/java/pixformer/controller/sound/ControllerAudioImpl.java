package pixformer.controller.sound;

import java.util.List;
import java.util.Optional;

import pixformer.controller.Controller;
import pixformer.model.Level;
import pixformer.model.sound.SoundEvent;

/**
 * Implementation for {@link }
 */
class ControllerAudioImpl implements ControllerAudio{

    private final Controller controller;

    /**
     * @param controller controller of the game.
     */
    public ControllerAudioImpl(final Controller controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SoundEvent> getSounds() {
        Optional<Level> level = controller.getLevelManager()
                                        .getCurrentLevel();
        if (level.isPresent()) {
            return level.get()
                .getWorld()
                .getEntities()
                .stream()
                .map(entity -> entity.getSounds())
                .flatMap(List::stream)
                .toList();
        }
        
        return List.of();
    }
  
}
