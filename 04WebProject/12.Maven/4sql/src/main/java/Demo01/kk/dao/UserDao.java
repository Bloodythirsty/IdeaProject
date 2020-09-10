package Demo01.kk.dao;

import Demo01.kk.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll() throws Exception;
}
