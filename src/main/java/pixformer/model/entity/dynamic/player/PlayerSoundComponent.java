package pixformer.model.entity.dynamic.player;

import java.io.File;

import pixformer.model.entity.Entity;
import pixformer.model.sound.SoundComponent;
import pixformer.model.sound.SoundEvent;

public class PlayerSoundComponent extends SoundComponent {
    static File file = new File(Thread.currentThread().getContextClassLoader().getResource("sounds/entities/mario/common/get_powerup.wav").toString());
    protected PlayerSoundComponent(Entity entity) {
        super(entity);
    }

    public void miniJumpSound() {
        this.addSound(new SoundEvent(Thread.currentThread().getContextClassLoader().getResource("sounds/entities/mario/common/jump_mini.wav").toString(), false));
    }

    public void bigJumpSound() {
        this.addSound(new SoundEvent(Thread.currentThread().getContextClassLoader().getResource("sounds/entities/mario/common/jump_big.wav").toString(), false));
    }

    public void getPowerup() {
        this.addSound(new SoundEvent(Thread.currentThread().getContextClassLoader().getResource("sounds/entities/mario/common/get_powerup.wav").toString(), false));
    }

    public void marioDies() {
        this.addSound(new SoundEvent(Thread.currentThread().getContextClassLoader().getResource("sounds/entities/mario/common/mario_dies.wav").toString(), false));
    }
}
