package pixformer.common.time;

public class TimerImpl implements Timer {

    private long timeLeft;

    @Override
    public void start(long time) {
        timeLeft = time;
    }

    @Override
    public boolean hasTimeLeft() {
        return timeLeft > 0;
    }

    @Override
    public long getTimeLeft() {
        return timeLeft;
    }

    @Override
    public void update(long dt) {
        timeLeft -= dt;

        if (timeLeft < 0) {
            timeLeft = 0;
        }
    }
    
}
