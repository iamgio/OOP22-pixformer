package pixformer.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pixformer.controller.input.PauseControllerInput;
import pixformer.model.modelInput.CompleteModelInput;
import pixformer.view.ControllerCommandProducer;
import pixformer.view.GameCommandProducer;
import pixformer.view.View;

public class GameLoopBuilder {
    
    private final View view;
    private final Set<ControllerCommandProducer<PauseControllerInput>> controllerInputs = new HashSet<>();
    private final Map<GameCommandProducer<CompleteModelInput>, CompleteModelInput> players = 
        new HashMap<>();

    public GameLoopBuilder(final View view) {
        this.view = view;
    }

    public GameLoopBuilder addControllerInput(final ControllerCommandProducer<PauseControllerInput> controllerInput) {
        controllerInputs.add(controllerInput);
        return this;
    }

    public GameLoopBuilder addPlayer(
        final GameCommandProducer<CompleteModelInput> view,
        final CompleteModelInput model
    ) {
        players.put(view, model);
        return this;
    }

    public GameLoop build() {
        return new GameLoop() {

            private boolean isRunning = true;
            private final PauseControllerInput mockController = new PauseControllerInput() {

                @Override
                public void pause() {
                    isRunning = false;
                }

                @Override
                public void unpause() {
                    isRunning = true;
                }

            };

            @Override
            public void loop(final long now) {
                controllerInputs.stream()
                    .flatMap(i -> i.popControllerCommand().stream())
                    .forEach(i -> i.accept(mockController));
                
                if (isRunning) {
                    players.entrySet().stream()
                        .map(e -> Map.entry(e.getKey().popCommand(), e.getValue()))
                        .filter(e -> e.getKey().isPresent())
                        .map(e -> Map.entry(e.getKey().get(), e.getValue()))
                        .forEach(e -> e.getKey().accept(e.getValue()));
                }
                view.update(0 /* TODO delta time */);
            }
            
        };
    }

}
