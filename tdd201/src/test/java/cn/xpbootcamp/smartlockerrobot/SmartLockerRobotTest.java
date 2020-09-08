package cn.xpbootcamp.smartlockerrobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartLockerRobotTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_smartLockerRobot_managed_lockerA_with_one_available_space_when_store_bagA_then_store_successfully() {
        Locker lockerA = new Locker(1);
        Bag bagA = new Bag();

        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA));

        Ticket ticketA = smartLockerRobot.store(bagA);
        assertNotNull(ticketA);
    }

    @Test
    public void given_smartLockerRobot_managed_lockerA_with_no_available_space_when_store_bagA_then_store_failed() throws NoAvailableSpaceException {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());

        Bag bagA = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA));

        expectedEx.expect(NoAvailableSpaceException.class);
        smartLockerRobot.store(bagA);
    }

    @Test
    public void given_smartLockerRobot_managed_lockerA_lockerB_and_lockerA_has_more_available_space_when_store_bagA_then_bagA_is_stored_in_lockerA() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(1);
        Bag bagA = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA, lockerB));

        Ticket ticketA = smartLockerRobot.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerA.getBag(ticketA));
    }

    @Test
    public void given_smartLockerRobot_managed_lockerA_lockerB_and_lockerB_has_more_available_space_when_store_bagA_then_bagA_is_stored_in_lockerB() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(2);
        Bag bagA = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA, lockerB));

        Ticket ticketA = smartLockerRobot.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerB.getBag(ticketA));
    }

    @Test
    public void given_smartLockerRobot_managed_lockerA_lockerB_and_both_have_same_available_space_when_store_bagA_then_bagA_is_stored_by_locker_order() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);
        Bag bagA = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA, lockerB));

        Ticket ticketA = smartLockerRobot.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerA.getBag(ticketA));
    }

    @Test
    public void given_smartLockerRobot_managed_lockerA_lockerB_and_both_have_no_available_space_when_store_bagA_then_store_failed() throws NoAvailableSpaceException {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        lockerA.store(new Bag());
        lockerB.store(new Bag());
        Bag bagA = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA, lockerB));

        expectedEx.expect(NoAvailableSpaceException.class);
        smartLockerRobot.store(bagA);
    }

    @Test
    public void given_smartLockerRobot_managed_lockerA_and_it_stored_bagA_when_get_bag_then_get_bagA() {
        Locker lockerA = new Locker(1);
        Bag bagA = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA));

        Ticket ticketA = smartLockerRobot.store(bagA);

        Bag bagFromSLRobot = smartLockerRobot.getBag(ticketA);
        assertEquals(bagA, bagFromSLRobot);
    }

    @Test
    public void given_SmartLockerRobot_managed_LockerA_and_it_stored_bagA_when_get_bag_with_fake_ticket_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(12);
        Bag bagA = new Bag();
        Ticket invalidTicket = new Ticket();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA));

        smartLockerRobot.store(bagA);

        expectedEx.expect(InvalidTicketException.class);
        smartLockerRobot.getBag(invalidTicket);
    }

    @Test
    public void given_smartLockerRobot_managed_lockerA_lockerB_and_it_stored_bagA_when_get_bag_then_get_bagA() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(2);
        Bag bagB = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA, lockerB));

        Ticket ticketB = smartLockerRobot.store(bagB);

        Bag bagFromSLRobot = smartLockerRobot.getBag(ticketB);
        assertEquals(bagB, bagFromSLRobot);
    }

    @Test
    public void given_SmartLockerRobot_managed_LockerA_lockerB_when_get_bag_with_fake_ticket_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(12);
        Locker lockerB = new Locker(12);
        Bag bagA = new Bag();
        Ticket invalidTicket = new Ticket();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(lockerA, lockerB));

        smartLockerRobot.store(bagA);

        expectedEx.expect(InvalidTicketException.class);
        smartLockerRobot.getBag(invalidTicket);
    }
}
