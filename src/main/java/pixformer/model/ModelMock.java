package pixformer.model;

import java.util.function.Consumer;

import pixformer.model.joystick.CompleteJoystick;

/**
 * A mock of a ModelInputComponent whose only goal is to explain how the MVC
 * architecture works.
 * 
 * @deprecated it will be removed as soon as its goal is achieved (or I accept
 *             the other architecture ☹).
 */
@Deprecated
public final class ModelMock implements ModelInputComponent {

    private static class MockJoystick implements CompleteJoystick {

        /*
         * The reason of the following suppressions is because this is just a mock for
         * explanatory purposes.
         */

        @Override
        public void left() {
            System.out.println("Mario left"); // NOPMD see above
        }

        @Override
        public void right() {
            System.out.println("Mario right"); // NOPMD see above
        }

        @Override
        public void fire() {
            System.out.println("Mario fire"); // NOPMD see above
        }

        @Override
        public void jump() {
            System.out.println("Mario jump"); // NOPMD see above
        }

        @Override
        public void crouch() {
            System.out.println("Mario crouch"); // NOPMD see above
        }

    }

    @Override
    public void acceptMarioInput(final Consumer<CompleteJoystick> input) {
        final var mockJoystick = new MockJoystick();
        input.accept(mockJoystick);
    }

}
