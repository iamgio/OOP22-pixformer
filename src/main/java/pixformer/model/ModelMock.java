package pixformer.model;

import java.util.function.Consumer;

import pixformer.model.joystick.CompleteJoystick;

public class ModelMock implements ModelInputComponent {

    private class MockJoystick implements CompleteJoystick {

        @Override
        public void left() {
            System.out.println("Mario left");
        }

        @Override
        public void right() {
            System.out.println("Mario right");            
        }

        @Override
        public void fire() {
            System.out.println("Mario fire");            
        }

        @Override
        public void jump() {
            System.out.println("Mario jump");            
        }

        @Override
        public void crouch() {
            System.out.println("Mario crouch");            
        }

    }

    @Override
    public void acceptMarioInput(Consumer<CompleteJoystick> input) {
        var mockJoystick = new MockJoystick();
        input.accept(mockJoystick);
    }
    
}
