package cn.xpbootcamp.locker.domain;

import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

import java.util.HashMap;

public class Locker {
    private Integer availableSpaceNumber;
    private HashMap<Ticket, Bag> bagMap = new HashMap<>();
    private String id;

    public Locker(String id) {
        this.id = id;
    }

    public Ticket store(Bag bag) {
        if (this.getAvailableSpaceNumber() == 0) {
            throw new NoAvailableSpaceException("No available space");
        } else {
            Ticket ticket = new Ticket(this.id);
            bagMap.put(ticket, bag);
            this.availableSpaceNumber--;
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
        if (bagMap.isEmpty()) {
            throw new InvalidTicketException("Invalid ticket");
        } else {
            if (bagMap.containsKey(ticket)) {
                this.availableSpaceNumber++;
                return bagMap.remove(ticket);
            } else {
                throw new InvalidTicketException("Invalid ticket");
            }
        }
    }
}
