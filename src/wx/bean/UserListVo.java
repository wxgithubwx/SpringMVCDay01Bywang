package wx.bean;

import java.util.List;

public class UserListVo {
    List<User> users;

    public UserListVo() {
    }

    public UserListVo(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListVo{" +
                "users=" + users +
                '}';
    }
}
