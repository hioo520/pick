package Pick.core;



import Pick.PickFactory;
import Pick.bean.PickEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * tips  方法的具体实现
 *
 * @Author:hihuzi 2018/7/19 17:53
 */
public class PickTool extends PickToolImpl implements PickFactory {

    /**
     * tips 同一对象集合 返回选定字段 集合返回
     *
     * @Author:hihuzi 2018/7/12 8:03
     */

    @Override
    public <E> List<Map> pick(List<E> list, String... str) throws Exception {

        return (List<Map>) batch(list, PickEnum.ReturnStyle.setVulue(0), str);
    }

    /**
     * tips 同一对象集合 返回选定字段 集合返回  DIY 配置返回key
     *
     * @Author:hihuzi 2018/7/12 8:03
     */
    @Override
    public <E> List<Map> pick(List<E> list, PickEnum pickEnum, String... str) throws Exception {

        return (List<Map>) batch(list, PickEnum.ReturnStyle.setVulue(1), str);
    }

    /**
     * tips 同一对象集合 返回选定字段 返回value(去重)
     *
     * @Author:hihuzi 2018/4/30 15:49
     */
    @Override
    public <E> Set<String> pickValue(List<E> list, String... str) throws Exception {

        return (Set) batch(list, PickEnum.ReturnStyle.setVulue(3), str);
    }

    /**
     * tips 同一对象集合 返回选定字段 返回value(去重)
     *
     * @Author:hihuzi 2018/4/30 15:49
     */
    @Override
    public <E> Set<String> pickValue(List<E> list, PickEnum enmu, String... str) throws Exception {

        return (Set) batch(list, enmu.setVulue(3), str);
    }

    /**
     * tips 单个对象 返回选定字段 集合
     *
     * @Author:hihuzi 2018/4/30 15:49
     */
    @Override
    public <E> Map pickSingle(E obj, String... str) throws Exception {

        List<E> list = new ArrayList<>();
        list.add(obj);
        return ((List<Map>) batch(list, PickEnum.ReturnStyle.setVulue(2), str)).get(0);
    }

    /**
     * tips 单个对象 返回选定字段 集合
     *
     * @Author:hihuzi 2018/4/30 15:49
     */
    @Override
    public <E> Map pickSingle(E obj, PickEnum enums, String... str) throws Exception {

        List<E> list = new ArrayList<>();
        list.add(obj);
        return ((List<Map>) batch(list, enums.setVulue(2), str)).get(0);
    }

}
