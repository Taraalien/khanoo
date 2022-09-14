package com.kurdsoft.khanoo.image;


import com.kurdsoft.khanoo.common.base.BaseEntity;
import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.realestate.RealEstate;
import com.kurdsoft.khanoo.region.Region;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_img")
@Data
@Audited
public class Image extends BaseEntity {

    @NotNull
    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name ="realestate_id")
    private RealEstate realEstate;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

}
