package cn.xpbootcamp.lockerrobotmanager;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import cn.xpbootcamp.lockerrobot.LockerRobot;

import java.util.List;

public class LockerRobotManager {
    private List<Locker> managedLockers;
    private List<LockerRobot> managedLockerRobots;

    public LockerRobotManager(List<Locker> lockers, List<LockerRobot> managedLockerRobots) {
        this.managedLockers = lockers;
        this.managedLockerRobots = managedLockerRobots;
    }

    public Ticket store(Bag bag) {
        if (managedLockerRobots != null) {
            for (LockerRobot lockerRobot : managedLockerRobots) {
                if (lockerRobot.isAvailable()) {
                    return lockerRobot.store(bag);
                }
            }
        }
        if (managedLockers != null) {
            for (Locker locker : managedLockers) {
                if (locker.getAvailableSpaceNumber() > 0) {
                    return locker.store(bag);
                }
            }
        }
        throw new NoAvailableSpaceException();
    }

    public Bag getBag(Ticket ticket) {
        for (LockerRobot lockerRobot : managedLockerRobots) {
            if(lockerRobot.exist(ticket)){
                return lockerRobot.getBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
