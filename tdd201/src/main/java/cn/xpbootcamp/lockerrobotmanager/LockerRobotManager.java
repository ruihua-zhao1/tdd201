package cn.xpbootcamp.lockerrobotmanager;

import cn.xpbootcamp.locker.domain.*;
import cn.xpbootcamp.locker.enums.TypeEnum;
import cn.xpbootcamp.locker.exception.InvalidTicketException;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;
import cn.xpbootcamp.lockerrobot.LockerRobot;

import java.util.ArrayList;
import java.util.List;

public class LockerRobotManager implements Reportable {
    private List<Locker> managedLockers;
    private List<LockerRobot> managedLockerRobots;

    public LockerRobotManager(List<Locker> lockers, List<LockerRobot> managedLockerRobots) {
        this.managedLockers = lockers;
        this.managedLockerRobots = managedLockerRobots;
    }

    public Ticket store(Bag bag) {
        if (managedLockerRobots != null && !managedLockerRobots.isEmpty()) {
            for (LockerRobot lockerRobot : managedLockerRobots) {
                if (lockerRobot.isAvailable()) {
                    return lockerRobot.store(bag);
                }
            }
        }
        if (managedLockers != null && !managedLockers.isEmpty()) {
            for (Locker locker : managedLockers) {
                if (locker.getAvailableSpaceNumber() > 0) {
                    return locker.store(bag);
                }
            }
        }
        throw new NoAvailableSpaceException();
    }

    public Bag getBag(Ticket ticket) {
        if (managedLockerRobots != null && !managedLockerRobots.isEmpty()) {
            for (LockerRobot lockerRobot : managedLockerRobots) {
                if (lockerRobot.exist(ticket)) {
                    return lockerRobot.getBag(ticket);
                }
            }
        }
        if (managedLockers != null && !managedLockers.isEmpty()) {
            for (Locker locker : managedLockers) {
                if (locker.exist(ticket)) {
                    return locker.getBag(ticket);
                }
            }
        }
        throw new InvalidTicketException();
    }

    @Override
    public Report report() {
        Report report = new Report();
        report.setType(TypeEnum.LOCKER_ROBOT_MANAGER);
        Integer available = 0;
        Integer capacity = 0;
        List<Report> subReports = new ArrayList<Report>();
        if (managedLockerRobots != null && !managedLockerRobots.isEmpty()) {
            for (LockerRobot robot : managedLockerRobots) {
                subReports.add(robot.report());
            }
        }

        if (managedLockers != null && !managedLockers.isEmpty()) {
            for (Locker locker : managedLockers) {
                subReports.add(locker.report());
            }
        }
        for (Report r : subReports) {
            available += r.getAvailable();
            capacity += r.getCapacity();
        }
        report.setCapacity(capacity);
        report.setAvailable(available);
        report.setSubReports(subReports);
        return report;
    }
}
