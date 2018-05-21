package gmail.dimon0272.WebApp.actions;

import gmail.dimon0272.WebApp.model.Ticket;
import gmail.dimon0272.WebApp.service.TicketService;

public class AddTicketAction implements Action {
    private TicketService ticketService;
    private Ticket ticket;

    public AddTicketAction(TicketService ticketService, Ticket ticket) {
        this.ticketService = ticketService;
        this.ticket = ticket;
    }
    @Override
    public void execute() {
        ticketService.saveTicket(ticket);
    }
}
