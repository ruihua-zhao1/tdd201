package cn.xpbootcamp.primaryLockerRobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;

import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> managedLockers;

    public Ticket store(Bag bagA) {
        Ticket ticketA = null;
        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > 0) {
                ticketA = locker.store(bagA);
            }
        }
        return ticketA;
    }

    public void setManagedLockers(List<Locker> lockers) {
        this.managedLockers = lockers;
    }
}