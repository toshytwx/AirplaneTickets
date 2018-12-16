package gmail.dimon0272.WebApp.controller;

import gmail.dimon0272.WebApp.actions.AddCustomerAction;
import gmail.dimon0272.WebApp.actions.AddFlightAction;
import gmail.dimon0272.WebApp.actions.AddLuggageAction;
import gmail.dimon0272.WebApp.actions.AddTicketAction;
import gmail.dimon0272.WebApp.model.*;
import gmail.dimon0272.WebApp.service.*;
import gmail.dimon0272.WebApp.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @org.springframework.beans.factory.annotation.Autowired
    CustomerService customerService;

    @Autowired
    LuggageService luggageService;

    @Autowired
    TicketService ticketService;

    @Autowired
    AirportService airportService;

    @Autowired
    FlightService flightService;

    @Autowired
    CompanyService companyService;
    private Customer customer;
    private Luggage luggage;
    private Flight flight;
    private Ticket ticket;

    private String arrivalAirportName;
    private String departureAirportName;

    @RequestMapping(value = {"/"} , method = RequestMethod.GET)
    public String registration(Model model) {
        if (airportService != null) {
            List<String> airportsListNames = airportService.airportsNames();
            model.addAttribute("departureAirportsList", airportsListNames);
            model.addAttribute("arrivalAirportsList", airportsListNames);
        }
        return "index";
    }

    @RequestMapping(value = {"/ticket"} , method = RequestMethod.GET)
    public String getTicketInfo(Model model) {
        if (companyService != null &&
                customer != null && flight != null &&
                ticket != null && departureAirportName != null &&
                arrivalAirportName != null && airportService != null
                && luggage != null) {
            Company company = companyService.getCompanyById(1L);
            model.addAttribute("surname", customer.getSurname());
            model.addAttribute("name", customer.getFirstName());
            model.addAttribute("signature", flight.getSignature());
            model.addAttribute("seat", "48");
            model.addAttribute("ticketClass", ticket.getType());
            model.addAttribute("ticketPrice", ticket.getPrice());
            model.addAttribute("departureAirportName", departureAirportName);
            model.addAttribute("arrivalAirportName", arrivalAirportName);
            Airport departureAirport = airportService.findAirportByName(departureAirportName);
            model.addAttribute("latStart", departureAirport.getLat());
            model.addAttribute("lngStart", departureAirport.getLng());
            Airport arrivalAirport = airportService.findAirportByName(arrivalAirportName);
            model.addAttribute("latEnd", arrivalAirport.getLat());
            model.addAttribute("lngEnd", arrivalAirport.getLng());
            model.addAttribute("luggageWeight", luggage.getWeight());
            model.addAttribute("handLuggage", luggage.getHandLuggage());
            model.addAttribute("companyName", company.getName());
            model.addAttribute("bortNumber", "737");
            model.addAttribute("planeCapacity", "150");
            model.addAttribute("terminalSignature", "2A");
        }
        return "ticket";
    }

    @RequestMapping(value = {"/buyticket"} , method = RequestMethod.POST)
    public String buyTicket(Model model, @RequestParam String customerFirstName,
                            @RequestParam String customerSecondName, @RequestParam String customerPhoneNumber,
                            @RequestParam String customerPassportCode, @RequestParam String birthDay,
                            @RequestParam String luggageWeight, @RequestParam String luggageType,
                            @RequestParam String departureAirport, @RequestParam String arrivalAirport,
                            @RequestParam String flightDate, @RequestParam String ticketType) {
        customer = addNewCustomer(customerFirstName, customerSecondName, customerPhoneNumber, customerPassportCode, birthDay);
        luggage = addNewLuggage(luggageWeight, luggageType, customer);
        flight = addNewFlight(flightDate, arrivalAirport, departureAirport);
        addTicket(customer, luggage, flight, ticketType);
        return "redirect:/ticket";
    }

    @RequestMapping(value = {"/findTicket"} , method = RequestMethod.GET)
    public String findTicket(Model model, @RequestParam String phoneNumber) {
        customer = customerService.findCustomerByPhone(phoneNumber);
        Company company = companyService.getCompanyById(1L);
        flight = flightService.findFlightById(customer.getId());
        ticket = ticketService.findTicketByCustomer(customer);
        luggage = luggageService.findLuggageByOwner(customer);
        model.addAttribute("surname", customer.getSurname());
        model.addAttribute("name", customer.getFirstName());
        model.addAttribute("signature", flight.getSignature());
        model.addAttribute("seat", "78");
        model.addAttribute("ticketClass", ticket.getType());
        model.addAttribute("ticketPrice", ticket.getPrice());
        model.addAttribute("departureAirportName", departureAirportName);
        model.addAttribute("arrivalAirportName", arrivalAirportName);
        Airport departureAirport = airportService.findAirportByName(departureAirportName);
        model.addAttribute("latStart", departureAirport.getLat());
        model.addAttribute("lngStart", departureAirport.getLng());
        Airport arrivalAirport = airportService.findAirportByName(arrivalAirportName);
        model.addAttribute("latEnd", arrivalAirport.getLat());
        model.addAttribute("lngEnd", arrivalAirport.getLng());
        model.addAttribute("luggageWeight", luggage.getWeight());
        model.addAttribute("handLuggage", luggage.getHandLuggage());
        model.addAttribute("companyName", company.getName());
        model.addAttribute("bortNumber", "727");
        model.addAttribute("planeCapacity", "125");
        model.addAttribute("terminalSignature", "2B");
        return "redirect:/ticket";
    }


    private void addTicket(Customer customer, Luggage luggage, Flight flight, String ticketType) {
        ticket = new Ticket();
        ticket.setCustomer(customer);
        ticket.setFlight(flight);
        ticket.setLuggage(luggage);
        ticket.setType(TicketType.getTypeFromString(ticketType));
        ticket.setPrice("");
        new AddTicketAction(ticketService, ticket).execute();
    }

    private Flight addNewFlight(String flightDate, String arrivalAirport, String departureAirport) {
        Flight flight = new Flight();
        Date departureDate = DateUtils.getDateFromString(flightDate);
        flight.setDepartureDate(departureDate);
        String arrivalSignature = AirportUtils.getSignature(arrivalAirport);
        String departureSignature = AirportUtils.getSignature(departureAirport);
        arrivalAirportName = arrivalAirport;
        departureAirportName = departureAirport;
        flight.setSignature(arrivalSignature + "-" + departureSignature);
        flight.setStatus(FlightStatus.SCHEDULED);
        new AddFlightAction(flightService, flight).execute();
        return flight;
    }

    private Luggage addNewLuggage(String luggageWeight, String luggageType, Customer owner) {
        Luggage luggage = new Luggage();
        luggage.setWeight(Double.valueOf(luggageWeight));
        luggage.setHandLuggage(LuggageUtils.isLuggageHand(luggageType));
        luggage.setOwner(owner);
        new AddLuggageAction(luggageService, luggage).execute();
        return luggage;
    }

    private Customer addNewCustomer(String customerFirstName, String customerSecondName, String customerPhoneNumber, String customerPassportCode, String birthDay) {
        Customer customer = new Customer();
        customer.setFirstName(customerFirstName);
        customer.setSurname(customerSecondName);
        customer.setPhoneNumber(customerPhoneNumber);
        customer.setPassportCode(customerPassportCode);
        customer.setBirthDay(birthDay);
        new AddCustomerAction(customerService, customer).execute();
        return customer;
    }
}
