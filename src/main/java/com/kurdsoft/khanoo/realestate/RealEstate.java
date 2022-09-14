package com.kurdsoft.khanoo.realestate;

import com.kurdsoft.khanoo.common.base.BaseEntity;
import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.image.Image;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "tbl_realestate")
@Data
@Audited
public class RealEstate extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "activity")
    private String activity;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "logo")
    private String logo;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "realEstate",cascade = CascadeType.ALL)
    private List<House> house;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "realEstate",cascade = CascadeType.ALL)
    private List<Image> images;
}
