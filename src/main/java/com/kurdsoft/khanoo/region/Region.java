package com.kurdsoft.khanoo.region;


import com.kurdsoft.khanoo.common.base.BaseEntity;
import com.kurdsoft.khanoo.city.City;
import com.kurdsoft.khanoo.houseproperty.House;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_region")
@Data
@Audited
public class Region extends BaseEntity {
    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "region",cascade = CascadeType.ALL)
    private List<House>houses;


}
