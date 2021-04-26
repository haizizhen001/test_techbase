package com.techbase.entity;

import com.techbase.constant.RoleEmployee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_team_ref")
public class EmployeeTeamRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private RoleEmployee roleEmployee;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEmployee getRoleEmployee() {
        return roleEmployee;
    }

    public void setRoleEmployee(RoleEmployee roleEmployee) {
        this.roleEmployee = roleEmployee;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
