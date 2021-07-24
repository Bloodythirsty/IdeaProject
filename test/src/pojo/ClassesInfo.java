package pojo;

import java.util.Objects;

public class ClassesInfo {
    private String part;
    private String addr;

    public ClassesInfo(String part, String addr) {
        this.part = part;
        this.addr = addr;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassesInfo that = (ClassesInfo) o;
        return Objects.equals(part, that.part) &&
                Objects.equals(addr, that.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(part, addr);
    }
}
