package cn.xpbootcamp.lockerrobotdirector;

import cn.xpbootcamp.locker.domain.Report;
import cn.xpbootcamp.lockerrobotmanager.LockerRobotManager;

import java.util.List;

public class LockerRobotDirector {
    private List<LockerRobotManager> managers;

    public LockerRobotDirector(List<LockerRobotManager> managers) {
        this.managers = managers;
    }

    public String generateReport() {
        Report report = managers.get(0).report();
        return report.print();
    }
}
