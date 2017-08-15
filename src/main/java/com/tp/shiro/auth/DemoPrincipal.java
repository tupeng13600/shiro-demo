package com.tp.shiro.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class DemoPrincipal implements Serializable {



    private Long id;

    private String username;

    public DemoPrincipal(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DemoPrincipal{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DemoPrincipal) {
            return id.equals(((DemoPrincipal) obj).getId());
        }
        return false;
    }
}
