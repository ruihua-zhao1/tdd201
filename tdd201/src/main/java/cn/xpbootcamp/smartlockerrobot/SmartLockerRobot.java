package cn.xpbootcamp.smartlockerrobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;

import java.util.List;

public class SmartLockerRobot {
    private List<Locker> managedLockers;

    public void setManagedLockers(List<Locker> lockers) {
        this.managedLockers = lockers;
    }

    public Ticket store(Bag bag) {

        Locker lockerWithMostAvaliableSpace = managedLockers.get(0);

        for(Locker locker: managedLockers){
            if(locker.getAvailableSpaceNumber() > lockerWithMostAvaliableSpace.getAvailableSpaceNumber()){
                lockerWithMostAvaliableSpace = locker;
            }
        }
       return lockerWithMostAvaliableSpace.store(bag);
    }
}
