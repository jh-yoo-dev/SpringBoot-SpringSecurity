package com.example.demo.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String memberId;

    private String password;

    public Member(String memberId, String password){
        this.memberId = memberId;
        this.password = password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
