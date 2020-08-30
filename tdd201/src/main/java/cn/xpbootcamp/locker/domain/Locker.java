package cn.xpbootcamp.locker.domain;

import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

import java.util.HashMap;

public class Locker {
    private Integer availableSpaceNumber;
    private HashMap<Ticket, Bag> bagMap = new HashMap<>();

    public Ticket store(Bag bag) {
        if(this.getAvailableSpaceNumber() == 0){
            throw new NoAvailableSpaceException("No available space");
        }else {
            Ticket ticket = new Ticket();
            bagMap.put(ticket, bag);
            return ticket;
        }
    }

    public Integer getAvailableSpaceNumber() {
        return availableSpaceNumber;
    }

    public void setAvailableSpaceNumber(Integer availableSpaceNumber) {
        this.availableSpaceNumber = availableSpaceNumber;
    }

    public Bag getBag(Ticket ticket) {
        return bagMap.get(ticket);
    }
}
