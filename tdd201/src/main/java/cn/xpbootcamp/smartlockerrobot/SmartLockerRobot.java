package cn.xpbootcamp.smartlockerrobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;

import java.util.List;

public class SmartLockerRobot {
    private List<Locker> managedLockers;

    public void setManagedLockers(List<Locker> lockers) {
        this.managedLockers = lockers;
    }

    public Ticket store(Bag bag) {
        return managedLockers.get(0).store(bag);
    }
}
