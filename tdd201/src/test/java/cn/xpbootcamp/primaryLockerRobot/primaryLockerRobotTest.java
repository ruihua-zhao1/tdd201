package cn.xpbootcamp.primaryLockerRobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertEquals;

public class primaryLockerRobotTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_PrimaryLockerRobot_manages_LockerA_and_lockerA_has_one_available_space_when_PrimaryLockerRobot_stores_bagA_then_store_successfully_and_get_valid_ticketA() {
        Locker lockerA = new Locker("A");
        lockerA.setAvailableSpaceNumber(1);
        Bag bagA = new Bag();

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        primaryLockerRobot.setManagedLockers(lockers);
        Ticket ticketA = primaryLockerRobot.store(bagA);
        assertNotNull(ticketA);
    }

    @Test
    public void given_primaryLockerRobot_manages_LockerA_and_lockerA_has_no_available_space_when_PrimaryLockerRobot_stores_bagA_then_get_error_message() {
        Locker lockerA = new Locker("A");
        lockerA.setAvailableSpaceNumber(0);
        Bag bagA = new Bag();

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        primaryLockerRobot.setManagedLockers(lockers);

        expectedEx.expect(NoAvailableSpaceException.class);
        expectedEx.expectMessage("No available space");
        primaryLockerRobot.store(bagA);
    }

    @Test
    public void given_PrimaryLockerRobot_manage_LockerA_and_LockerB_both_lockers_have_available_spaces_when_PrimaryLockerRobot_stores_bagA_then_get_valid_ticketA_and_bagA_is_stored_in_LockerA() {
        Locker lockerA = new Locker("A");
        Locker lockerB = new Locker("B");
        lockerA.setAvailableSpaceNumber(1);
        lockerB.setAvailableSpaceNumber(1);
        Bag bagA = new Bag();

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        lockers.add(lockerB);
        primaryLockerRobot.setManagedLockers(lockers);
        Ticket ticketA = primaryLockerRobot.store(bagA);
        assertNotNull(ticketA);
        assertEquals("A", ticketA.lockerId);
    }

    @Test
    public void given_PrimaryLockerRobot_manage_LockerA_and_LockerB_only_LockerB_has_available_spaces_when_PrimaryLockerRobot_store_bagA_then_get_valid_ticketA_and_bagA_is_stored_in_LockerB() {
        Locker lockerA = new Locker("A");
        Locker lockerB = new Locker("B");
        lockerA.setAvailableSpaceNumber(0);
        lockerB.setAvailableSpaceNumber(1);
        Bag bagA = new Bag();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        lockers.add(lockerB);
        primaryLockerRobot.setManagedLockers(lockers);

        Ticket ticketB = primaryLockerRobot.store(bagA);

        assertNotNull(ticketB);
        assertEquals("B", ticketB.lockerId);
    }
}
