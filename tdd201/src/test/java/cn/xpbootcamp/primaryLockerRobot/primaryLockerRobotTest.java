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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class primaryLockerRobotTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_PrimaryLockerRobot_manages_LockerA_and_lockerA_has_one_available_space_when_PrimaryLockerRobot_stores_bagA_then_store_successfully_and_get_valid_ticketA() {
        Locker lockerA = new Locker();
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
        Locker lockerA = new Locker();
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

}
