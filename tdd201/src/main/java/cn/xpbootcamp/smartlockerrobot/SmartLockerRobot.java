package cn.xpbootcamp.smartlockerrobot;

import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.lockerrobot.LockerRobot;

import java.util.List;

public class SmartLockerRobot extends LockerRobot {
    private List<Locker> managedLockers;

    public SmartLockerRobot(List<Locker> managedLockers) {
        super(managedLockers);
        this.managedLockers = managedLockers;
    }

    @Override
    public Locker getTargetLocker() {
        Locker lockerWithMostAvaliableSpace = managedLockers.get(0);

        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > lockerWithMostAvaliableSpace.getAvailableSpaceNumber()) {
                lockerWithMostAvaliableSpace = locker;
            }
        }
        if (lockerWithMostAvaliableSpace.getAvailableSpaceNumber() > 0) {
            return lockerWithMostAvaliableSpace;
        }
        return null;
    }
}
