package link.chis.exceltest.dto;

import java.util.Arrays;
import java.util.List;

/**
 * @author InSeok <kr.chis@gmail.com>
 * Date : 2019-04-26
 * Time : 09:34
 * Remark :
 */
public class UserinfoDtoExcel implements DtoExcel {
    private String userid;
    private String username;
    private int age;

    public UserinfoDtoExcel(String userid, String username, int age) {
        this.userid = userid;
        this.username = username;
        this.age = age;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> toArray(){
        return Arrays.asList(this.userid, this.username, String.valueOf(this.age));
    }
}
