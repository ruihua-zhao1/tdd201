package cn.xpbootcamp.locker.domain;

import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

public class Locker {
    private Integer availableSpaceNumber;

    public Ticket store(Bag bagA) {
        if(this.getAvailableSpaceNumber() == 0){
            throw new NoAvailableSpaceException("No available space");
        }else {
            return new Ticket();
        }
    }

    public Integer getAvailableSpaceNumber() {
        return availableSpaceNumber;
    }

    public void setAvailableSpaceNumber(Integer availableSpaceNumber) {
        this.availableSpaceNumber = availableSpaceNumber;
    }

    public Bag getBag(Ticket ticketA) {
        return null;
    }
}
