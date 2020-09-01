package cn.xpbootcamp.primaryLockerRobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> managedLockers;

    public Ticket store(Bag bagA) {
        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > 0) {
                return locker.store(bagA);
            }
        }
        throw new NoAvailableSpaceException("No available space");
    }

    public void setManagedLockers(List<Locker> lockers) {
        this.managedLockers = lockers;
    }
}