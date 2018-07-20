package Pick.bean;

/**
 * @Features:
 * @Date:
 * @Author: hihuzi  2018/6/28 10:07
 */
public enum PickEnum {
    DEFAULT(0),
    /*
     *tips 返回类型 value=? nullDiscard=0 默认 空值保存 nullDiscard=1 空值丢弃
     * value=0: List<Map>(默认 返回key)
     * value=1: List<Map>(支持重新命名)
     *      tips RenameKey=? 返回从新命名key
     *      RenameKey="0":默认 属性名输出
     *      RenameKey="1":首字母大写
     *      RenameKey="2":全小写
     *      RenameKey="3":全大写
     *      RenameKey="XXXX":自定义可以的头缀
     * value=2: Map
     * value=3: Set
     *
     */
    ReturnStyle(0) {String renameKey;Integer nullDiscard;};


    private int vulue;

    private String renameKey = "0";

    private Integer nullDiscard = 0;


    PickEnum(int vulue) {

        this.vulue = vulue;
    }

    public int getVulue() {

        return vulue;
    }

    public Integer getNullDiscard() {

        return nullDiscard;
    }

    public PickEnum setNullDiscard(Integer nullDiscard) {

        this.nullDiscard = nullDiscard;
        return this;
    }

    public String getRenameKey() {

        return renameKey;
    }

    public PickEnum setRenameKey(String renameKey) {

        this.renameKey = renameKey;
        return this;
    }

    /**
     * todo 链式编程
     *
     * @Author:hihuzi 2018/7/2 16:35
     */
    public PickEnum setVulue(int vulue) {

        this.vulue = vulue;
        return this;
    }
}