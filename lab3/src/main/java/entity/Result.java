package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Result")
@Data
public class Result {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "next_shots_id")
    private int id;

    @Column(name="x")
    private Float x;

    @Column(name="y")
    private Float y;

    @Column(name="r")
    private Float r;

    @Column(name="currentTime")
    private String currentTime;

    @Column(name="executeTime")
    private long executeTime;

    @Column(name="result")
    private boolean result;
}
