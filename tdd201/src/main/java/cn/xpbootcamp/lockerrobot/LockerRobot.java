package cn.xpbootcamp.lockerrobot;

import cn.xpbootcamp.locker.domain.*;
import cn.xpbootcamp.locker.enums.TypeEnum;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

import java.util.ArrayList;
import java.util.List;

public abstract class LockerRobot implements Reportable {
    private List<Locker> managedLockers;

    public LockerRobot(List<Locker> managedLockers) {
        this.managedLockers = managedLockers;
    }

    public Ticket store(Bag bag) {
        Locker targetLocker = getTargetLocker();
        if (getTargetLocker() == null) {
            throw new NoAvailableSpaceException();
        }

        return targetLocker.store(bag);
    }

    public Bag getBag(Ticket ticket) {
        for (Locker locker : managedLockers) {
            if (locker.exist(ticket)) {
                return locker.getBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public boolean isAvailable() {
        if (managedLockers != null) {
            for (Locker locker : managedLockers) {
                if (locker.getAvailableSpaceNumber() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(Ticket ticket) {
        if (managedLockers != null) {
            for (Locker locker : managedLockers) {
                if (locker.exist(ticket)) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract Locker getTargetLocker();

    @Override
    public Report report() {
        Report report = new Report();
        report.setType(TypeEnum.LOCKER_ROBOT);
        Integer available = 0;
        Integer capacity = 0;
        List<Report> lockerReports = new ArrayList<Report>();

        for (Locker locker : managedLockers) {
            lockerReports.add(locker.report());
        }
        for (Report r : lockerReports) {
            available += r.getAvailable();
            capacity += r.getCapacity();
        }
        report.setCapacity(capacity);
        report.setAvailable(available);
        report.setSubReports(lockerReports);

        return report;
    }
}
