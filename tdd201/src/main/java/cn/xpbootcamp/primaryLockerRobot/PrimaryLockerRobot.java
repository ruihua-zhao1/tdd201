package cn.xpbootcamp.primaryLockerRobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> managedLockers;

    public Ticket store(Bag bag) {
        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > 0) {
                return locker.store(bag);
            }
        }
        throw new NoAvailableSpaceException();
    }

    public void setManagedLockers(List<Locker> lockers) {
        this.managedLockers = lockers;
    }

    public Bag getBag(Ticket ticket) {
        for (Locker locker : managedLockers) {
            if (locker.exist(ticket)) {
                return locker.getBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}