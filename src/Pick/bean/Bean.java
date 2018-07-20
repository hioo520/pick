package Pick.bean;

import java.util.Date;

/**
 * @Features: 测试bean
 * @Date:
 * @Author: hihuzi  2018/6/27 6:39
 */
public class Bean {

    private String id;

    private String name;

    private String email;

    private String address;

    private Date date = new Date();

    public String getName() {

        return name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }


}
