package com.techbase.dto;


import com.techbase.constant.RoleEmployee;
import com.techbase.entity.Department;
import com.techbase.entity.Employee;
import com.techbase.entity.Team;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private RoleEmployee role;
    private List<TeamDTO> teams;
    private List<DepartmentDTO> manages;
    public EmployeeDTO() {
    }

    public static EmployeeDTO from(Employee entity) {
        EmployeeDTO dto = new EmployeeDTO(entity.getId(), entity.getName());
        if(entity.isCEO()){
            dto.setRole(RoleEmployee.CEO);
        }else {
            Map<Integer, DepartmentDTO> managerDepartments = new HashMap<>();
            dto.setTeams(entity.getTeamRefs().stream().map(teamRef -> {
                if (teamRef.getRoleEmployee().equals(RoleEmployee.MANAGER)
                        && !managerDepartments.containsKey(teamRef.getTeam().getDepartment().getId())){
                    managerDepartments.put(teamRef.getTeam().getDepartment().getId()
                            ,DepartmentDTO.from(teamRef.getTeam().getDepartment()));
                }
                return TeamDTO.from(teamRef.getTeam());
            }).collect(Collectors.toList()));
            if (managerDepartments.values().size() > 0) {
                dto.setRole(RoleEmployee.MANAGER);
            } else {
                dto.setRole(RoleEmployee.STAFF);
            }
            dto.setManages(managerDepartments.values().stream().collect(Collectors.toList()));
        }
        return dto;
    }

    public EmployeeDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public RoleEmployee getRole() {
        return role;
    }

    public void setRole(RoleEmployee role) {
        this.role = role;
    }

    public List<TeamDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDTO> teams) {
        this.teams = teams;
    }

    public List<DepartmentDTO> getManages() {
        return manages;
    }

    public void setManages(List<DepartmentDTO> manages) {
        this.manages = manages;
    }

}
