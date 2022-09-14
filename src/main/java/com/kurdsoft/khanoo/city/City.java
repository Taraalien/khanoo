package com.kurdsoft.khanoo.city;


import com.kurdsoft.khanoo.common.base.BaseEntity;
import com.kurdsoft.khanoo.region.Region;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="tbl_city")
@Audited
@Data
public class City extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;


   @OneToMany(fetch = FetchType.LAZY,mappedBy = "city",cascade = CascadeType.ALL)
    private List<Region>regions;

}
