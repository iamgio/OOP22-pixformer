package pixformer.model.sound;

/**
 * A record representing a sound to play.
 */
public record SoundEvent(String audioFilePath, boolean isLooping) {

    /**
     * @param audioFilePath path of the sound to play.
     * @param isLooping true if the sound have to loop, false otherwise
     */
    public SoundEvent(final String audioFilePath, boolean isLooping) {
        this.audioFilePath = audioFilePath;
        this.isLooping = isLooping;
    }
}
