package cn.xpbootcamp.smartlockerrobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SmartLockerRobotTest {

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
}
