package com.tp.shiro.auth;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class DemoPrincipal {

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
}
