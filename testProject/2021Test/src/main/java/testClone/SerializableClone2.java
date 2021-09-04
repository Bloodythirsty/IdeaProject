package testClone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.User2;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * @author zhangkangkang
 * @date 2021/09/02 18:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerializableClone2 implements Serializable {


    private int age;
    private User2 user2;

    private SerializableClone2 deepClone(){
        return SerializationUtils.clone(this);
    }

    public static void main(String[] args) {
        User2 kk = User2.builder().userId(1).userName("kk").build();
        SerializableClone2 conle2 = new SerializableClone2();
        conle2.setAge(111);
        conle2.setUser2(kk);
        System.out.println(conle2);

        SerializableClone2 clone3 = conle2.deepClone();
        clone3.getUser2().setUserId(2);
        System.out.println(clone3);

    }
}
