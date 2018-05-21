package gmail.dimon0272.WebApp.controller;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.Assert.*;

public class MainControllerTest {
    @Test
    public void registration() throws Exception {
        MainController mainController = new MainController();
        ExtendedModelMap model = new ExtendedModelMap();
        String actual = mainController.registration(model);
        String expected = "index";
        assertEquals(actual, expected);
    }

    @Test
    public void getTicketInfo() throws Exception {
        MainController mainController = new MainController();
        ExtendedModelMap model = new ExtendedModelMap();
        String actual = mainController.getTicketInfo(model);
        String expected = "ticket";
        assertEquals(actual, expected);
    }

}