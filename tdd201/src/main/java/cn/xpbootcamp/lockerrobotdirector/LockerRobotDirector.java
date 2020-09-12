package cn.xpbootcamp.lockerrobotdirector;

import cn.xpbootcamp.lockerrobotmanager.LockerRobotManager;

import java.util.List;

public class LockerRobotDirector {
    private List<LockerRobotManager> managers;

    public LockerRobotDirector(List<LockerRobotManager> managers) {
        this.managers = managers;
    }

    public String generateReport() {
        String output = "";
        for (LockerRobotManager m : managers){
            output += m.report().print(0);

        }
       return output;
    }
}
