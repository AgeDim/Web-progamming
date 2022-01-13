package application.entities;

import javax.persistence.*;

@Entity
@Table(name = "points")
public class Point {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "next_result_id")
    private Long id;

    @Column(name = "xcord")
    private double x;

    @Column(name = "ycord")
    private double y;

    @Column(name = "radius")
    private double r;

    @Column(name = "is_in_area")
    private boolean isInArea;

    @Column(name = "date")
    private String date;

    @Column(name = "username")
    private String username;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setInArea(boolean inArea) {
        isInArea = inArea;
    }

    public boolean isInArea() {
        return isInArea;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Point() {

    }

    public Point(double x, double y, double r, boolean isInArea, String date, String username) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = isInArea;
        this.date = date;
        this.username = username;
    }
}
