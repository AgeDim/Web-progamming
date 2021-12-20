package web.Lab3.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "RESULT")
@Data
public class Result {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "make_id")
    private int id;

    @Column(name = "X")
    private Float x;

    @Column(name = "Y")
    private Float y;

    @Column(name = "R")
    private Float r;

    @Column(name = "CURRENTTIME")
    private String currentTime;

    @Column(name = "1")
    private String executionTime;

    @Column(name = "RESULT")
    private boolean result;
}
