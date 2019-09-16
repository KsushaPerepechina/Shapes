package by.epam.cone.warehouse;

import by.epam.cone.observer.ConeEvent;
import by.epam.cone.observer.Observer;

public class ConeRegisterUpdateHandler implements Observer {
    @Override
    public void handleEvent(ConeEvent event) {
        ConeRegister register = ConeRegister.getInstance();
        register.addRecord(event.getCone());
    }
}
