package pixformer.view.engine.javafx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pixformer.model.sound.SoundEvent;

/**
 * A sound player using JavaFX library.
 */
public class JavaFXPlayer {
    private final Map<String, MediaPlayer> songsCache = new HashMap<>();

    /**
     * Play a list sounds.
     * @param sounds list of new sounds to play.
     */
    public void play(final List<SoundEvent> sounds) {
        for (final var sound : sounds) {
            if (!songsCache.containsKey(sound.audioFilePath())) {
                final MediaPlayer player = new MediaPlayer(new Media(sound.audioFilePath()));
                player.setOnEndOfMedia(new Runnable() {
                    @Override
                    public void run() {
                        player.stop();
                    }
                });

                songsCache.put(sound.audioFilePath(), player);
            }

            songsCache.get(sound.audioFilePath()).play();
        }
    }

    /**
     * Stop all current playing sounds and clear the cache.
     */
    public void stopAll() {
        songsCache.values().stream().forEach(x -> x.stop());
        songsCache.clear();
    }
}
