package cn.xpbootcamp.locker;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertNotNull;

public class LockerTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_lockerA_have_one_available_space_and_bagA_want_to_be_saved_when_store_bagA_then_store_successfully_and_get_valid_ticketA(){
        Locker lockerA = new Locker();
        lockerA.setAvailableSpaceNumber(1);
        Bag bagA = new Bag();

        Ticket tickerA = lockerA.store(bagA);

        assertNotNull(tickerA);
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


}
