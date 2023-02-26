package pixformer.model;

import pixformer.model.modelinput.CompleteModelInput;

/**
 * A mock of a ModelInputComponent whose only goal is to explain how the MVC
 * architecture works.
 * 
 * @deprecated it will be removed as soon as its goal is achieved (or I accept
 *             the other architecture ☹).
 */
@Deprecated
public final class ModelMock implements CompleteModelInput {

    private final String name;

    /**
     * Construct a model.
     * @param name which will be used printing.
     */
    public ModelMock(final String name) {
        this.name = name;
    }

    /*
        * The reason of the following suppressions is because this is just a mock for
        * explanatory purposes.
        */

    @Override
    public void left() {
        System.out.println(name + " left"); // NOPMD see above
    }

    @Override
    public void right() {
        System.out.println(name + " right"); // NOPMD see above
    }

    @Override
    public void fire() {
        System.out.println("Mario fire"); // NOPMD see above
    }

    @Override
    public void jump() {
        System.out.println(name + " jump"); // NOPMD see above
    }

    @Override
    public void crouch() {
        System.out.println(name + " crouch"); // NOPMD see above
    }

}

