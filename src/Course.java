package EX26;

public class Course {
    private String tenMH;
    private double diem;

    public Course(String tenMH, double diem) {
        this.tenMH = tenMH;
        this.diem = diem;
    }

    public String getTenMH() {
        return tenMH;
    }
    public double getDiem() {
        return diem;
    }
}
