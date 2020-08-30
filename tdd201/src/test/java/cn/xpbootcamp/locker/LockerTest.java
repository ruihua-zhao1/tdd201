package cn.xpbootcamp.locker;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LockerTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_lockerA_have_one_available_space_and_bagA_want_to_be_saved_when_store_bagA_then_store_successfully_and_get_valid_ticketA(){
        Locker lockerA = new Locker();
        lockerA.setAvailableSpaceNumber(1);
        Bag bagA = new Bag();

        Ticket ticketA = lockerA.store(bagA);

        assertNotNull(ticketA);
    }

    @Test
    public void given_lockerA_has_zero_available_space_and_bagA_want_to_be_saved_when_bagA_is_storing_then_store_failed_and_get_error_message() throws NoAvailableSpaceException {
        Locker locker = new Locker();
        locker.setAvailableSpaceNumber(0);
        Bag bagA = new Bag();

        expectedEx.expect(NoAvailableSpaceException.class);
        expectedEx.expectMessage("No available space");
        locker.store(bagA);
    }

    @Test
    public void given_lockerA_stored_a_bagA_and_ticketA_of_bagA_when_get_bagA_with_ticketA_then_get_bagA(){
        Locker lockerA = new Locker();
        lockerA.setAvailableSpaceNumber(1);
        Bag bagA = new Bag();
        Ticket ticketA = lockerA.store(bagA);

        Bag bagFromLocker = lockerA.getBag(ticketA);

        assertNotNull(bagFromLocker);
        assertEquals(bagA, bagFromLocker);
    }

    @Test
    public void given_lockerA_is_empty_and_ticketA_when_get_bag_with_ticketA_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker();
        Ticket ticketA = new Ticket();

        expectedEx.expect(InvalidTicketException.class);
        expectedEx.expectMessage("Invalid ticket");
        lockerA.getBag(ticketA);
    }

    @Test
    public void given_lockerA_stored_bagA_and_bagB_and_ticketA_has_been_used_to_get_bagA_when_get_bag_with_ticketA_again_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker();
        lockerA.setAvailableSpaceNumber(2);
        Bag bagA = new Bag();
        Bag bagB = new Bag();
        Ticket ticketA = lockerA.store(bagA);
        lockerA.store(bagB);
        lockerA.getBag(ticketA);

        expectedEx.expect(InvalidTicketException.class);
        expectedEx.expectMessage("Invalid ticket");
        lockerA.getBag(ticketA);

    }
}
