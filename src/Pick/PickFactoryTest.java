package Pick;


import Pick.bean.Bean;
import Pick.bean.PickEnum;
import org.junit.Test;

import java.util.*;

/**
 * tips
 *
 * @Author:hihuzi 2018/7/20 8:42
 */
public class PickFactoryTest {


    @Test
    public void batch() throws Exception {

        List<Bean> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Bean userPost = new Bean();
            userPost.setName("你好师姐");
            userPost.setId(12345 * i + "");
            userPost.setEmail(null);
            userPost.setAddress("    ");
            list.add(userPost);
        }
        // tips 默认转态
        List<Map> batch0 = PickFactory.batch().pick(list, "id", "name", "email", "address");
        batch0.forEach(map -> System.out.println(map));
        // tips 和 默认一样 首字母大写
        List<Map> batch = PickFactory.batch().pick(list, PickEnum.ReturnStyle.setRenameKey("1").setNullDiscard(0), "id", "name", "email", "date");
        batch.forEach(map -> System.out.println(map));
        // tips 空值丢掉 并且全部大写
        List<Map> batch3 = PickFactory.batch().pick(list, PickEnum.ReturnStyle.setRenameKey("3").setNullDiscard(1), "id", "name", "email", "date");
        batch3.forEach(map -> System.out.println(map));
        // tips 空值丢掉 并且全部大写
        List<Map> batch2 = PickFactory.batch().pick(list, PickEnum.ReturnStyle.setRenameKey("我是key头"), "id", "name", "email", "date", "address");
        batch2.forEach(map -> System.out.println(map));

    }

    /**
     * tips 同一对象集合 返回选定字段 返回value(去重)
     *
     * @Author:hihuzi 2018/4/30 15:49
     */
    @Test
    public void pickValue() throws Exception {

        List<Bean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Bean userPost = new Bean();
            userPost.setName("你好师姐" + i);
            userPost.setId(12345 * i + "");
            userPost.setEmail(null);
            list.add(userPost);
        }
        // tips 默认设置
        Set batch1 = PickFactory.batch().pickValue(list, "id", "name", "email");
        System.out.println(Arrays.asList(batch1).toString());
        Set batch = PickFactory.batch().pickValue(list, PickEnum.DEFAULT.setNullDiscard(0), "id", "name", "email");
        System.out.println(Arrays.asList(batch).toString());

    }

    /**
     * tips 单个对象 返回选定字段
     *
     * @Author:hihuzi 2018/4/30 15:49
     */
    @Test
    public void pickSingle() throws Exception {

        Bean bean = new Bean();
        bean.setName("你好师姐");
        bean.setId(UUID.randomUUID().toString());
        bean.setEmail(null);
        bean.setAddress(UUID.randomUUID().toString().substring(32) + "@163.com");
        // tips 默认 保留 空值
        Map batch0 = PickFactory.batch().pickSingle(bean, "id", "name", "email", "date", "address");
        System.out.println(batch0.toString());
        // tips 保留 空值
        Map batch1 = PickFactory.batch().pickSingle(bean, PickEnum.ReturnStyle.setNullDiscard(0), "id", "name", "email", "date", "address");
        System.out.println(batch1.toString());
        // tips 舍弃 空值
        Map batch = PickFactory.batch().pickSingle(bean, PickEnum.ReturnStyle.setNullDiscard(1), "id", "name", "email", "date", "address");
        System.out.println(batch.toString());
    }

}