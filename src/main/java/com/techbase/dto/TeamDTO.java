package com.techbase.dto;
import com.techbase.entity.Team;
public class TeamDTO {
    private Integer id;
    private String name;
    private DepartmentDTO departmentDTO;
    public TeamDTO() {
    }

    public TeamDTO(Integer id, String name, DepartmentDTO departmentDTO) {
        this.id = id;
        this.name = name;
        this.departmentDTO = departmentDTO;
    }

    public static TeamDTO from(Team entity) {
       return new TeamDTO(entity.getId(), entity.getName(), DepartmentDTO.from(entity.getDepartment()));
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

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

}
