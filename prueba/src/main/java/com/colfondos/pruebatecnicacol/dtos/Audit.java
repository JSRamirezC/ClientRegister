package com.colfondos.pruebatecnicacol.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter

public class Audit implements Serializable {

    @Id
    private Integer id;
    private String clientinfo;
    private String date;
    private String status;

}
