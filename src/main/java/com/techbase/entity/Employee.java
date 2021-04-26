package com.techbase.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean isCEO;
    @OneToMany(mappedBy = "employee")
    private List<EmployeeTeamRef> teamRefs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeTeamRef> getTeamRefs() {
        return teamRefs;
    }

    public void setTeamRefs(List<EmployeeTeamRef> teamRefs) {
        this.teamRefs = teamRefs;
    }

    public boolean isCEO() {
        return isCEO;
    }

    public void setCEO(boolean CEO) {
        isCEO = CEO;
    }

}
