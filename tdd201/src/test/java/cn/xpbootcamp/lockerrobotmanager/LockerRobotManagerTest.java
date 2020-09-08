package cn.xpbootcamp.lockerrobotmanager;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import cn.xpbootcamp.primaryLockerRobot.PrimaryLockerRobot;
import cn.xpbootcamp.smartlockerrobot.SmartLockerRobot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class LockerRobotManagerTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_LockerRobotManager_managed_lockerA_and_lockerB_both_have_available_spaces_when_store_bagA_then_store_successfully() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        Bag bagA = new Bag();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);

        LockerRobotManager lockerRobotManager = new LockerRobotManager(lockers);
        Ticket ticketA = lockerRobotManager.store(bagA);

        assertNotNull(ticketA);
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_without_space_and_lockerB_with_space_when_store_bagA_then_store_success() {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        Bag bagA = new Bag();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        LockerRobotManager lockerRobotManager = new LockerRobotManager(lockers);
        Ticket ticketA = lockerRobotManager.store(bagA);
        assertNotNull(ticketA);
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_and_lockerB_both_lockers_have_no_available_space_when_store_bagA_then_store_failed() throws NoAvailableSpaceException {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        lockerB.store(new Bag());
        Bag bagA = new Bag();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        LockerRobotManager lockerRobotManager = new LockerRobotManager(lockers);

        expectedEx.expect(NoAvailableSpaceException.class);
        lockerRobotManager.store(bagA);
    }
}
