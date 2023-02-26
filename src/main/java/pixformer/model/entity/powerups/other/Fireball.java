package pixformer.model.entity.powerups.other;

import pixformer.common.Updatable;
import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractDrawableEntity;

public class Fireball extends AbstractDrawableEntity implements Updatable {

    final double SPEED = 1.0;

    public Fireball(double x, double y, double width, double height, Direction direction){
        super(x,y,width,height);
        this.direction = direction;
    }

    @Override
    public void update(double dt) {
        int movement = 0;


        if (this.leftKey) {
            movement--;
        }


        if (this.rightKey) {
            movement++;
        }

        this.position = this.position.sum(new Vector2D(SPEED * dt * movement, 0));
    }    
}
