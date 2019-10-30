package com.freesun.votemanager.commons;

import com.freesun.votemanager.pojo.Userinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser {

    private Userinfo userinfo;
    private List<String> roles;
    private List<String> permissons;
}
