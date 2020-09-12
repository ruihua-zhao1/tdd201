package cn.xpbootcamp.lockerrobotdirector;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.lockerrobotmanager.LockerRobotManager;
import cn.xpbootcamp.primaryLockerRobot.PrimaryLockerRobot;
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

        assertEquals("M 1 2\n  L 1 2\n", output);
    }

    @Test
    public void given_LockerRobotDirector_managed_1_manager_managed_2_locker_when_generate_report_then_generate_correct_report() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);
        lockerA.store(new Bag());
        lockerA.store(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA, lockerB), null);
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager));
        String output = lockerRobotDirector.generateReport();

        assertEquals("M 2 4\n  L 0 2\n  L 2 2\n", output);
    }

    @Test
    public void given_LockerRobotDirector_managed_1_manager_managed_1_robot_2_locker_when_generate_report_then_generate_correct_report() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);
        lockerB.store(new Bag());

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot));
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager));
        String output = lockerRobotDirector.generateReport();

        assertEquals("M 3 4\n  R 3 4\n    L 2 2\n    L 1 2\n", output);
    }

    @Test
    public void given_LockerRobotDirector_managed_1_manager_managed_2_robots_when_generate_report_then_generate_correct_report() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);
        Locker lockerC = new Locker(11);
        lockerB.store(new Bag());
        lockerB.store(new Bag());

        PrimaryLockerRobot primaryLockerRobot1 = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));
        PrimaryLockerRobot primaryLockerRobot2 = new PrimaryLockerRobot(Arrays.asList(lockerC));

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot1, primaryLockerRobot2));
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager));
        String output = lockerRobotDirector.generateReport();

        assertEquals("M 13 15\n  R 2 4\n    L 2 2\n    L 0 2\n  R 11 11\n    L 11 11\n", output);
    }

    @Test
    public void given_LockerRobotDirector_managed_1_manager_managed_2_robots_and_2_lockers_when_generate_report_then_generate_correct_report() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);
        Locker lockerC = new Locker(11);
        lockerB.store(new Bag());
        lockerB.store(new Bag());

        PrimaryLockerRobot primaryLockerRobot1 = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));
        PrimaryLockerRobot primaryLockerRobot2 = new PrimaryLockerRobot(Arrays.asList(lockerC));

        Locker lockerD = new Locker(1);
        Locker lockerE = new Locker(1);
        lockerD.store(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerD, lockerE), Arrays.asList(primaryLockerRobot1, primaryLockerRobot2));
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager));
        String output = lockerRobotDirector.generateReport();

        assertEquals("M 14 17\n  R 2 4\n    L 2 2\n    L 0 2\n  R 11 11\n    L 11 11\n  L 0 1\n  L 1 1\n", output);
    }

    @Test
    public void given_LockerRobotDirector_managed_2_managers_and_both_managed_robots_and_lockers_when_generate_report_then_generate_correct_report() {
    Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);
        Locker lockerC = new Locker(11);
        lockerB.store(new Bag());
        lockerB.store(new Bag());
        PrimaryLockerRobot primaryLockerRobot1 = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));
        PrimaryLockerRobot primaryLockerRobot2 = new PrimaryLockerRobot(Arrays.asList(lockerC));
        Locker lockerD = new Locker(1);
        Locker lockerE = new Locker(1);
        lockerD.store(new Bag());
        LockerRobotManager lockerRobotManager1 = new LockerRobotManager(Arrays.asList(lockerD, lockerE), Arrays.asList(primaryLockerRobot1, primaryLockerRobot2));

        LockerRobotManager lockerRobotManager2 = lockerRobotManager1;
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager1,lockerRobotManager2));
        String output = lockerRobotDirector.generateReport();

        assertEquals("M 14 17\n  R 2 4\n    L 2 2\n    L 0 2\n  R 11 11\n    L 11 11\n  L 0 1\n  L 1 1\n" +
                "M 14 17\n  R 2 4\n    L 2 2\n    L 0 2\n  R 11 11\n    L 11 11\n  L 0 1\n  L 1 1\n", output);
    }

    @Test
    public void given_LockerRobotDirector_managed_1_manager_managed_1_locker_and_unmanaged_locker_and_robot_when_generate_report_then_generate_correct_report() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(3);
        Locker unmanagedlocker = new Locker(2);

        lockerA.store(new Bag());
        PrimaryLockerRobot primaryLockerRobot1 = new PrimaryLockerRobot(Arrays.asList(lockerB));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA), null);
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager));
        String output = lockerRobotDirector.generateReport();

        assertEquals("M 1 2\n  L 1 2\n", output);
    }
}
