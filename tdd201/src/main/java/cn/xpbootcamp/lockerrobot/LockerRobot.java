package cn.xpbootcamp.lockerrobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

import java.util.List;

public abstract class LockerRobot {
    private List<Locker> managedLockers;

    public LockerRobot(List<Locker> managedLockers) {
        this.managedLockers = managedLockers;
    }

    public Ticket store(Bag bag) {
        Locker targetLocker = getTargetLocker();
        if (getTargetLocker() == null) {
            throw new NoAvailableSpaceException();
        }

        return targetLocker.store(bag);
    }

    public Bag getBag(Ticket ticket) {
        for (Locker locker : managedLockers) {
            if (locker.exist(ticket)) {
                return locker.getBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public boolean isAvailable() {
        if (managedLockers != null) {
            for (Locker locker : managedLockers) {
                if (locker.getAvailableSpaceNumber() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(Ticket ticket) {
        if (managedLockers != null) {
            for (Locker locker : managedLockers) {
                if (locker.exist(ticket)) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract Locker getTargetLocker();
}
