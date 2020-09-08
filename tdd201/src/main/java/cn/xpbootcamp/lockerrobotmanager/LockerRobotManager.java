package cn.xpbootcamp.lockerrobotmanager;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;

import java.util.List;

public class LockerRobotManager {
    private List<Locker> lockers;

    public LockerRobotManager(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bagA) {
       return lockers.get(0).store(bagA);
    }
}
