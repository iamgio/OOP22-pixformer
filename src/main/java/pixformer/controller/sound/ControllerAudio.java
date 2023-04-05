package pixformer.controller.sound;

import java.util.List;

import pixformer.model.sound.SoundEvent;

interface ControllerAudio {

    /**
     * @return a list of SoundEvent from the game.
     */
    List<SoundEvent> getSounds();
  
}
