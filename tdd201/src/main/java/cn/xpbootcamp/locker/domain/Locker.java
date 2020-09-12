package cn.xpbootcamp.locker.domain;

import cn.xpbootcamp.locker.enums.TypeEnum;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

import java.util.HashMap;

public class Locker implements Reportable {
    private HashMap<Ticket, Bag> bagMap = new HashMap<>();
    private Integer capacity;


    public Locker(Integer capacity) {
        this.capacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (this.getAvailableSpaceNumber() == 0) {
            throw new NoAvailableSpaceException();
        } else {
            Ticket ticket = new Ticket();
            bagMap.put(ticket, bag);
            return ticket;
        }
    }

    public Integer getAvailableSpaceNumber() {
        return this.capacity - bagMap.size();

    }

    public Bag getBag(Ticket ticket) {
        if (bagMap.isEmpty()) {
            throw new InvalidTicketException();
        } else {
            if (bagMap.containsKey(ticket)) {
                return bagMap.remove(ticket);
            } else {
                throw new InvalidTicketException();
            }
        }
    }

    public boolean exist(Ticket ticket) {
        return bagMap.containsKey(ticket);
    }

    @Override
    public Report report() {
        Report report = new Report();
        report.setType(TypeEnum.LOCKER);
        report.setAvailable(getAvailableSpaceNumber());
        report.setCapacity(capacity);
        return report;
    }
}
