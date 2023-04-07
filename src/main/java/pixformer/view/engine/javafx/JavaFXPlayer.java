package pixformer.view.engine.javafx;

import java.util.ArrayList;
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
    private Map<String, Media> songsCache = new HashMap<>();
    private List<MediaPlayer> playingSongs = new ArrayList<>();

    /**
     * Play a list sounds.
     * @param sounds list of new sounds to play.
     */
    public void play(final List<SoundEvent> sounds) {

        for (var sound : sounds) {
            if (!songsCache.containsKey(sound.audioFilePath())) {
                songsCache.put(sound.audioFilePath(), new Media(sound.audioFilePath()));
            }

            playingSongs.add(new MediaPlayer(songsCache.get(sound.audioFilePath())));
        }

        playingSongs.stream()
                    .filter(x -> x.getStatus() == MediaPlayer.Status.READY)
                    .forEach(x -> x.play());

        clearFinishedSongs();
    }

    /**
     * Clear the list of current sounds from already stopped sounds.
     */
    private void clearFinishedSongs() {
        List<MediaPlayer> stoppedSongs = playingSongs.stream()
                                                    .filter(x -> x.getStatus() == MediaPlayer.Status.STOPPED)
                                                    .toList();
        stoppedSongs.stream()
                    .forEach(x -> songsCache.remove(x));
    }
}
