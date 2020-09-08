package cn.xpbootcamp.lockerrobotmanager;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import cn.xpbootcamp.primaryLockerRobot.PrimaryLockerRobot;
import cn.xpbootcamp.smartlockerrobot.SmartLockerRobot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LockerRobotManagerTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_LockerRobotManager_managed_lockerA_and_lockerB_both_have_available_spaces_when_store_bagA_then_store_successfully() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        Bag bagA = new Bag();

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA, lockerB), null);
        Ticket ticketA = lockerRobotManager.store(bagA);

        assertNotNull(ticketA);
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_without_space_and_lockerB_with_space_when_store_bagA_then_store_success() {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        Bag bagA = new Bag();

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA, lockerB), null);
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

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA, lockerB), null);

        expectedEx.expect(NoAvailableSpaceException.class);
        lockerRobotManager.store(bagA);
    }

    @Test
    public void given_LockerRobotManager_managed_robotA_and_robotB_both_are_available_when_store_bagA_then_store_success() {

        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerB));
        Bag bagA = new Bag();

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot, smartLockerRobot));
        Ticket ticketA = lockerRobotManager.store(bagA);

        assertNotNull(ticketA);
    }

    @Test
    public void given_LockerRobotManager_managed_robotA_is_not_available_and_robotB_is_available_when_store_bagA_then_store_success() {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerB));
        Bag bagA = new Bag();

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot, smartLockerRobot));
        Ticket ticketA = lockerRobotManager.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, smartLockerRobot.getBag(ticketA));
    }

    @Test
    public void given_LockerRobotManager_managed_two_robots_both_are_not_available_when_store_bagA_then_store_failed() throws NoAvailableSpaceException {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        lockerB.store(new Bag());
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerB));
        Bag bagA = new Bag();

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot, smartLockerRobot));

        expectedEx.expect(NoAvailableSpaceException.class);
        lockerRobotManager.store(bagA);
    }

    @Test
    public void given_LockerRobotManager_managed_available_robotA_and_available_lockers_when_store_bagA_then_store_success() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerB));
        Bag bagA = new Bag();

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA), Arrays.asList(primaryLockerRobot));
        Ticket ticketA = lockerRobotManager.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, primaryLockerRobot.getBag(ticketA));
    }

    @Test
    public void given_LockerRobotManager_managed_unavailable_robotA_and_available_lockerA_when_store_bagA_then_store_success() {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));
        Bag bagA = new Bag();

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerB), Arrays.asList(primaryLockerRobot));
        Ticket ticketA = lockerRobotManager.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerB.getBag(ticketA));
    }

    @Test
    public void given_LockerRobotManager_managed_unavailable_robotA_and_unavailable_lockerA_when_store_bagA_then_store_failed() throws NoAvailableSpaceException {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        lockerB.store(new Bag());
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));
        Bag bagA = new Bag();

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerB), Arrays.asList(primaryLockerRobot));

        expectedEx.expect(NoAvailableSpaceException.class);
        lockerRobotManager.store(bagA);
    }

    @Test
    public void given_LockerRobotManager_managed_robotA_and_robotB_store_bag_success_to_robotB_when_get_bag_then_get_bag_success(){
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        PrimaryLockerRobot primaryLockerRobotA = new PrimaryLockerRobot(Arrays.asList(lockerA));
        PrimaryLockerRobot primaryLockerRobotB = new PrimaryLockerRobot(Arrays.asList(lockerB));
        Bag bagA = new Bag();
        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobotA, primaryLockerRobotB));
        Ticket ticketA = lockerRobotManager.store(bagA);

        assertEquals(bagA, lockerRobotManager.getBag(ticketA));
    }

    @Test
    public void given_LockerRobotManager_managed_two_robots_and_store_a_bag_when_get_bag_with_fake_ticket_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        PrimaryLockerRobot primaryLockerRobotA = new PrimaryLockerRobot(Arrays.asList(lockerA));
        PrimaryLockerRobot primaryLockerRobotB = new PrimaryLockerRobot(Arrays.asList(lockerB));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobotA, primaryLockerRobotB));

        expectedEx.expect(InvalidTicketException.class);
        lockerRobotManager.getBag(new Ticket());
    }

    @Test
    public void given_LockerRobotManager_managed_two_lockers_and_store_a_bag_to_lockerB_when_get_bag_then_get_bag_success() {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA, lockerB), null);
        Bag bagA = new Bag();
        Ticket ticketA = lockerRobotManager.store(bagA);

        assertEquals(bagA, lockerRobotManager.getBag(ticketA));
    }

    @Test
    public void given_LockerRobotManager_managed_two_lockers_and_store_a_bag_when_get_bag_with_fake_ticket_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());
        Locker lockerB = new Locker(1);

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA,lockerB),null);

        expectedEx.expect(InvalidTicketException.class);
        lockerRobotManager.getBag(new Ticket());
    }
}
