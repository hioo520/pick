**XML 对象提取器 DIY返回Key**
---
``详细测试pickFactoryTest``

#接口
---
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
#测试结果如下
```{name=你好师姐, id=0, address=    , email=}
{name=你好师姐, id=0, address=    , email=}
{name=你好师姐, id=0, address=    , email=}
{name=你好师姐, id=0, address=    , email=}
{Id=0, Email=, Date=Fri Jul 20 21:12:14 CST 2018, Name=你好师姐}
{Id=0, Email=, Date=Fri Jul 20 21:12:14 CST 2018, Name=你好师姐}
{Id=0, Email=, Date=Fri Jul 20 21:12:14 CST 2018, Name=你好师姐}
{Id=0, Email=, Date=Fri Jul 20 21:12:14 CST 2018, Name=你好师姐}
{DATE=Fri Jul 20 21:12:14 CST 2018, ID=0, NAME=你好师姐}
{DATE=Fri Jul 20 21:12:14 CST 2018, ID=0, NAME=你好师姐}
{DATE=Fri Jul 20 21:12:14 CST 2018, ID=0, NAME=你好师姐}
{DATE=Fri Jul 20 21:12:14 CST 2018, ID=0, NAME=你好师姐}
{我是key头address=    , 我是key头id=0, 我是key头name=你好师姐, 我是key头date=Fri Jul 20 21:12:14 CST 2018}
{我是key头address=    , 我是key头id=0, 我是key头name=你好师姐, 我是key头date=Fri Jul 20 21:12:14 CST 2018}
{我是key头address=    , 我是key头id=0, 我是key头name=你好师姐, 我是key头date=Fri Jul 20 21:12:14 CST 2018}
{我是key头address=    , 我是key头id=0, 我是key头name=你好师姐, 我是key头date=Fri Jul 20 21:12:14 CST 2018}
{我是key头address=    , 我是key头id=0, 我是key头name=你好师姐, 我是key头date=Fri Jul 20 21:12:14 CST 2018}```