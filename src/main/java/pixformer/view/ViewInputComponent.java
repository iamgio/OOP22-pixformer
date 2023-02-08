package pixformer.view;

import java.util.Optional;

import pixformer.model.joystick.CompleteJoystick;

public interface ViewInputComponent {
    
    Optional<Command<CompleteJoystick>> popInput();
}
