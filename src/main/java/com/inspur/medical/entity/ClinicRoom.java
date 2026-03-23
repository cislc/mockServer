package com.inspur.medical.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "clinic_room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicRoom implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    
    @Column(name = "room_code", unique = true, nullable = false, length = 50)
    @JsonProperty("RoomCode")
    private String roomCode;
    
    @Column(name = "room_name", nullable = false, length = 100)
    @JsonProperty("RoomName")
    private String roomName;
    
    @Column(name = "department_code", nullable = false, length = 50)
    @JsonProperty("DepartmentCode")
    private String departmentCode;
}
