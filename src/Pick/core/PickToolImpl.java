package Pick.core;


import Pick.bean.PickEnum;
import Pick.util.NullEmptyTool;

import java.util.*;

/**
 * tips
 *
 * @Author:hihuzi 2018/7/19 17:54
 */
public class PickToolImpl {

    public Map batchMap(Map map, PickEnum enums, String... str) {

        if (map == null || map.size() == 0)
            throw new IndexOutOfBoundsException("调用batch: 输入的是null! 或者为空值");
        Map result = new HashMap<>(str.length);
        for (String property : str) {
            Object str0 = map.get(property);
            if (NullEmptyTool.isNNoEE(str0))
                result.put(property, str0);
            else if (enums.getVulue() == 0)
                result.put(property, "");
            else {
                throw new RuntimeException("数据输出超出范围 参考PickEnum定义");
            }
        }
        return result;
    }

    public <T> Collection batch(List<T> list, PickEnum enums, String... str) throws Exception {

        if (list == null)
            throw new IndexOutOfBoundsException("调用batch: 输入的是null!");
        Class<?> clazz = list.get(0).getClass();
        List<Map> lists = new ArrayList<>(list.size());
        Set sets = new HashSet<>(list.size());
        Map maps = new HashMap();
        for (T t : list) {
            Map map = new HashMap<>(str.length);
            for (String property : str) {
                StringBuffer getName = new StringBuffer().append("get").append(property.substring(0, 1).toUpperCase()).append(property.substring(1));
                Object invoke = null;
                try {
                    invoke = clazz.getMethod(getName.toString()).invoke(t);
                } catch (Exception e) {
                    System.err.println("对应的实体里面没有方法: " + getName);
                }
                switch (enums.getVulue()) {
                    case 0:
                        getMap(map, property, invoke, enums);
                        break;
                    case 1:
                        getMap(map, property, invoke, enums);
                        break;
                    case 2:
                        getMap(maps, property, invoke, enums);
                        break;
                    case 3:
                        if (invoke != null)
                            sets.add(invoke);
                        else if (1 != enums.getNullDiscard())
                            sets.add(invoke);
                        break;
                    default:
                        throw new Exception("数据输出超出范围 参考PickEnum定义");
                }
            }
            if (enums.getVulue() == 0 || enums.getVulue() == 1)
                lists.add(map);
        }
        if (sets != null && sets.size() != 0)
            return sets;
        if (lists != null && lists.size() != 0)
            return lists;
        if (maps != null && maps.size() != 0) {
            lists.add(maps);
            return lists;
        }
        return null;
    }

    private void getMap(Map map, String key, Object invoke, PickEnum enums) {

        if (invoke != null)
            map.put(getkey(key, enums.getRenameKey()), invoke);
        else if (enums.getNullDiscard() != 1)
            map.put(getkey(key, enums.getRenameKey()), "");
    }

    private String getkey(String property, String style) {

        if ("0".equals(style))
            return property;
        else if ("1".equals(style))
            return new StringBuffer().append(property.substring(0, 1).toUpperCase()).append(property.substring(1)).toString();
        else if ("2".equals(style))
            return new StringBuffer().append(property.toLowerCase()).toString();
        else if ("3".equals(style))
            return new StringBuffer().append(property.toUpperCase()).toString();
        else
            return style + property;
    }

}