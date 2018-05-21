package gmail.dimon0272.WebApp.actions;

import gmail.dimon0272.WebApp.model.Luggage;
import gmail.dimon0272.WebApp.service.LuggageService;

public class AddLuggageAction implements Action {
    private LuggageService luggageService;
    private Luggage luggage;

    public AddLuggageAction(LuggageService customerService, Luggage customer) {
        this.luggageService = customerService;
        this.luggage = customer;
    }

    @Override
    public void execute() {
        luggageService.saveLuggage(luggage);
    }
}
