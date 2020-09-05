package cn.xpbootcamp.smartlockerrobot;

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

public class SmartLockerRobotTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_smartLockerRobot_managed_lockerA_with_one_available_space_when_store_bagA_then_store_successfully(){
        Locker lockerA = new Locker(1);
        Bag bagA = new Bag();

        SmartLockerRobot smartLockerRobot = new SmartLockerRobot();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        smartLockerRobot.setManagedLockers(lockers);

        Ticket ticketA = smartLockerRobot.store(bagA);
        assertNotNull(ticketA);
    }

    @Test
    public void given_smartLockerRobot_managed_lockerA_with_no_available_space_when_store_bagA_then_store_failed() throws NoAvailableSpaceException{
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag());

        Bag bagA = new Bag();

        SmartLockerRobot smartLockerRobot = new SmartLockerRobot();
        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        smartLockerRobot.setManagedLockers(lockers);

        expectedEx.expect(NoAvailableSpaceException.class);
        smartLockerRobot.store(bagA);
    }
}
