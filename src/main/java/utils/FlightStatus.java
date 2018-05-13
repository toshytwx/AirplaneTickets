package utils;

public enum FlightStatus {
    BOARDING, CANCELLED, CHECKIN, SCHEDULED, DELAYED, DEPARTED, GATEOPEN, GATECLOSED;
}

/*
Boarding – идет посадка;

Cancelled либо Diverted– рейс отменен;

Check-in – регистрация на рейс началась, можно направляться к стойке регистрации; часто при появлении этой надписи появляется также и номер стойки, где нужно зарегистрироваться на данный рейс.

Scheduled либо On time – означает, что самолет вылетит согласно расписанию;

Delayed – рейс задерживается (может быть указано, на сколько минут – например, 40m late);

Departed либо Airborne – рейс уже улетел;

Gate open либо Go to date – выход на посадку открыт; после этой надписи появляется Boarding – посадка началась;

Gate closing либо Last call либо Final Call– регистрация закрывается через несколько минут, вам стоит поторопиться;

Gate closed – регистрация на рейс завершена.
*/
