package pixformer.model;

import java.util.function.Consumer;

import pixformer.model.joystick.CompleteJoystick;


public interface ModelInputComponent {
    
    void acceptMarioInput(Consumer<CompleteJoystick> input);
}
