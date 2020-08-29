package cn.xpbootcamp.locker;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class LockerTest {

    @Test
    public void given_locker_have_one_available_space_and_bagA_want_to_be_saved_when_store_bagA_then_store_successfully_and_get_valid_ticketA(){
        Locker locker = new Locker();
        locker.setAvailableSpaceNumber(1);
        Bag bagA = new Bag();

        Ticket tickerA = locker.store(bagA);

        assertNotNull(tickerA);
    }
}
