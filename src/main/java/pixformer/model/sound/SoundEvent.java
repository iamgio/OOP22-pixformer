package pixformer.model.sound;

/**
 * A record representing a sound to play.
 * @param audioFilePath path of the sound to play.
 * @param isLooping true if the sound have to loop, false otherwise
 */
public record SoundEvent(String audioFilePath, boolean isLooping) {

    /**
     * @param audioFilePath path of the sound to play.
     * @param isLooping true if the sound have to loop, false otherwise
     */
    public SoundEvent(final String audioFilePath, final boolean isLooping) {
        this.audioFilePath = Thread.currentThread().getContextClassLoader().getResource(audioFilePath).toString();
        this.isLooping = isLooping;
    }
}
