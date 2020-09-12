package cn.xpbootcamp.primaryLockerRobot;

import cn.xpbootcamp.locker.domain.Locker;
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