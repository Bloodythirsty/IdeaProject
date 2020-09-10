package demo01.classs;

import demo01.domain.User;

import java.util.Map;

public interface TestTypeUsage {
    @Select("hahahahha")
    public Map<String, User> find();
    // {
        // HashMap<String, User> map = new HashMap<>();
        // map.put("kang",new User());
        // return map;
    // };

    public int getSdd();
    // {
    //     return 1;
    // }
}
