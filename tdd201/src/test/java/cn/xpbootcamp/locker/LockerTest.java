package cn.xpbootcamp.locker;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LockerTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_lockerA_capacity_is_12_when_store_a_bag_then_store_successfully_and_get_valid_ticketA() {
        Locker lockerA = new Locker(12);
        Bag bagA = new Bag();
        Ticket ticketA = lockerA.store(bagA);
        assertNotNull(ticketA);
    }

    @Test
    public void given_lockerA_has_zero_available_space_when_store_bagA_then_store_failed_and_get_error_message() throws NoAvailableSpaceException {
        Locker locker = new Locker(1);
        locker.store(new Bag());
        Bag bagA = new Bag();

        expectedEx.expect(NoAvailableSpaceException.class);
        locker.store(bagA);
    }

    @Test
    public void given_lockerA_stored_bagA_when_get_bag_with_valid_ticket_then_get_bagA() {
        Locker lockerA = new Locker(1);
        Bag bagA = new Bag();
        Ticket ticketA = lockerA.store(bagA);

        Bag bagFromLocker = lockerA.getBag(ticketA);

        assertNotNull(bagFromLocker);
        assertEquals(bagA, bagFromLocker);
    }

    @Test
    public void given_lockerA_is_empty_and_invalid_ticketA_when_get_bag_with_ticketA_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(12);
        Ticket ticketA = new Ticket();

        expectedEx.expect(InvalidTicketException.class);
        lockerA.getBag(ticketA);
    }

    @Test
    public void given_lockerA_stored_bagA_and_bagB_and_ticketA_has_been_used_to_get_bagA_when_get_bag_with_ticketA_again_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(12);
        Bag bagA = new Bag();
        Bag bagB = new Bag();
        Ticket ticketA = lockerA.store(bagA);
        lockerA.store(bagB);
        lockerA.getBag(ticketA);

        expectedEx.expect(InvalidTicketException.class);
        lockerA.getBag(ticketA);
    }
}
