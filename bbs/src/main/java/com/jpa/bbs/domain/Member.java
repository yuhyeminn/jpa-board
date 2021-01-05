package com.jpa.bbs.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long memberId;
    @Column(name = "password")
    private String password;
    @Column(name = "member_name")
    private String name;
    @Column(name = "member_email")
    private String email;
}
