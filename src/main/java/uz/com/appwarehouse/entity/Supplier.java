package uz.com.appwarehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.appwarehouse.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

}
