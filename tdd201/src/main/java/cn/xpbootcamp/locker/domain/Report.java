package cn.xpbootcamp.locker.domain;

import cn.xpbootcamp.locker.enums.TypeEnum;

import java.util.List;

public class Report {
    private TypeEnum type;
    private Integer available;
    private Integer capacity;
    private List<Report> subReports;

    public Report() {
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getAvailable() {
        return available;
    }

    public List<Report> getSubReports() {
        return subReports;
    }

    public void setSubReports(List<Report> subReports) {
        this.subReports = subReports;
    }

    public String print(Integer indentation) {
        StringBuilder builder = new StringBuilder();
        String typeStr;
        switch (type) {
            case LOCKER:
                typeStr = "L";
                break;
            case LOCKER_ROBOT:
                typeStr = "R";
                break;
            case LOCKER_ROBOT_MANAGER:
                typeStr = "M";
                break;
            default:
                typeStr = null;
        }

        builder.append(typeStr).append(" ").append(available).append(" ").append(capacity).append("\n");


        if (subReports != null && !subReports.isEmpty()) {
            indentation +=2;
            String spaces = new String(new char[indentation]).replace("\0", " ");
            for (Report sr : subReports) {
                builder.append(spaces).append(sr.print(indentation));
            }
        }
        return builder.toString();
    }
}
