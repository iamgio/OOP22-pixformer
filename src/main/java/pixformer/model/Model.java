package pixformer.model;

import pixformer.model.entity.Entity;

import java.util.List;

public interface Model {

    List<Entity> getEntities();

    // CompleteModelInput getMarioInput();

    void update();

}
