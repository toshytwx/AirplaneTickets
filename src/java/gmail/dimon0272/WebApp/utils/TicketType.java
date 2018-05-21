package gmail.dimon0272.WebApp.utils;

public enum TicketType {
BUSSINES, FIRST, SECOND, ECONOM;

public static TicketType getTypeFromString(String type) {
    if (type.equals("Business")) {
        return BUSSINES;
    } else if (type.equals("First")) {
        return FIRST;
    } else if (type.equals("Second")) {
        return SECOND;
    } else {
        return ECONOM;
    }
}
}
