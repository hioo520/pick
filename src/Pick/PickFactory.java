package Pick;

import Pick.bean.PickEnum;
import Pick.core.PickTool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Features:
 * @Date:
 * @Author: hihuzi  2018/6/27 6:50
 */
public interface PickFactory {

    PickTool pickTool = null;

    static PickFactory batch() {

        if (pickTool == null)
            return new PickTool();
        return pickTool;
    }

    /**
     * tips 同一对象集合 返回选定字段 集合返回
     *
     * @Author:hihuzi 2018/7/12 8:03
     */

    <E> List<Map> pick(List<E> list, String... str) throws Exception;

    /**
     * tips 同一对象集合 返回选定字段 集合返回  DIY 配置返回key
     *
     * @Author:hihuzi 2018/7/12 8:03
     */
    <E> List<Map> pick(List<E> list, PickEnum pickEnum, String... str) throws Exception;

    /**
     * tips 同一对象集合 返回选定字段 返回value(去重)
     *
     * @Author:hihuzi 2018/4/30 15:49
     */
    <E> Set pickValue(List<E> list, String... str) throws Exception;

    <E> Set<String> pickValue(List<E> list, PickEnum enums, String... str) throws Exception;

    /**
     * tips 单个对象 返回选定字段
     *
     * @Author:hihuzi 2018/4/30 15:49
     */
    <E> Map pickSingle(E obj, String... str) throws Exception;

    <E> Map pickSingle(E obj, PickEnum pickEnum, String... str) throws Exception;

}
