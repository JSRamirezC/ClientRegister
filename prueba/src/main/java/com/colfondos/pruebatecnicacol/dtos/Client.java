package com.colfondos.pruebatecnicacol.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Client implements Serializable {

    @Id
    private Integer numberid;
    private String typeid;
    private String email;
    private String cellphone;

    @Override
    public String toString() {
        Integer numberidL = this.numberid == null?0:this.numberid;
        String typeidL = this.typeid == null?"NULL":this.typeid;
        String emailL = this.email == null?"NULL":this.email;
        String cellphoneL = this.cellphone == null?"NULL":this.cellphone;
        return String.format("numberid: "+numberidL + " , typeid" + typeidL +  " , email :" + emailL + " , cellphone : "+cellphoneL);
    }
}
