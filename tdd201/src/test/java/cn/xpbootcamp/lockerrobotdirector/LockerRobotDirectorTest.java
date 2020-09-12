package cn.xpbootcamp.lockerrobotdirector;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.lockerrobotmanager.LockerRobotManager;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LockerRobotDirectorTest {

    @Test
    public void given_LockerRobotDirector_managed_1_manager_managed_1_locker_when_generate_report_then_generate_correct_report() {
        Locker lockerA = new Locker(2);
        lockerA.store(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA), null);
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager));
        String output = lockerRobotDirector.generateReport();

        assertEquals("M 1 2\n  L 1 2" , output);
    }

    @Test
    public void given_LockerRobotDirector_managed_1_manager_managed_2_locker_when_generate_report_then_generate_correct_report() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);
        lockerA.store(new Bag());
        lockerA.store(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA,lockerB), null);
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager));
        String output = lockerRobotDirector.generateReport();

        assertEquals("M 2 4\n  L 0 2\n  L 2 2" , output);
    }
}
