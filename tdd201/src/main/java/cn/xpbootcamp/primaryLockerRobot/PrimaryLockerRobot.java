package cn.xpbootcamp.primaryLockerRobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import cn.xpbootcamp.lockerrobot.LockerRobot;

import java.util.List;

public class PrimaryLockerRobot extends LockerRobot {
    private List<Locker> managedLockers;

    public PrimaryLockerRobot(List<Locker> managedLockers) {
        super(managedLockers);
        this.managedLockers = managedLockers;
    }

    @Override
    public Locker getTargetLocker() {
        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > 0) {
                return locker;
            }
        }

        return null;
    }
}