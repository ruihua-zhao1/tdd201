package cn.xpbootcamp.lockerrobotmanager;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;

import java.util.List;

public class LockerRobotManager {
    private List<Locker> managedLockers;

    public LockerRobotManager(List<Locker> lockers) {
        this.managedLockers = lockers;
    }

    public Ticket store(Bag bag) {
        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > 0) {
                return locker.store(bag);
            }
        }
        return null;
    }
}
