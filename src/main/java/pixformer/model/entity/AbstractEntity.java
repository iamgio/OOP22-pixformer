package pixformer.model.entity;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.collision.SolidEntity;
import pixformer.model.sound.SoundEvent;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * The base class for a mutable entity.
 */
public abstract class AbstractEntity implements MutableEntity {

    private World world;
    private double x;
    private double y;
    private double width;
    private double height;
    private Vector2D velocity;
    private final List<SoundEvent> soundList = new LinkedList<>();

    /**
     * Constructor for the AbstractEntity.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param width  width of the entity
     * @param height height of the entity
     */
    protected AbstractEntity(final double x, final double y, final double width, final double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = new Vector2D(0, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<World> getWorld() {
        return Optional.ofNullable(this.world);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return this.y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(final double y) {
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        return this.width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWidth(final double width) {
        this.width = width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeight() {
        return this.height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHeight(final double height) {
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector2D getVelocity() {
        return this.velocity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVelocity(final Vector2D velocity) {
        this.velocity = velocity;
    }

    /**
     * {@inheritDoc}
     * @see pixformer.model.entity.collision.SolidEntity
     */
    @Override
    public boolean isSolid() {
        return this instanceof SolidEntity;
    }

    /**
     * {@inheritDoc}
     */
    @OverridingMethodsMustInvokeSuper
    @Override
    public void onSpawn(final World world) {
        this.world = world;
    }

    /**
     * {@inheritDoc}
     */
    @OverridingMethodsMustInvokeSuper
    @Override
    public void onDespawn(final World world) {
        this.world = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        MutableEntity.super.update(dt);

        // Fall kill
        getWorld().ifPresent(world -> {
            if (getY() >= world.getOptions().yFallThreshold()) {
                world.queueEntityDrop(this);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSound(final SoundEvent newSound) {
        this.soundList.add(newSound);
    }

    /**
     * {@inheritDoc}
     */
    public List<SoundEvent> getSounds() {
        return this.soundList;
    }
}
