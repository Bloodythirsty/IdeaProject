package cn.kk.domain;

public class QueryVo {

    /*
            1. 可以放多个domain，而不只是User
            2. 简单起见，这里只用了User
     */
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
