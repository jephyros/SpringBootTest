package link.chis.exceltest.dto;

import java.util.Arrays;
import java.util.List;

/**
 * @author InSeok <kr.chis@gmail.com>
 * Date : 2019-04-26
 * Time : 09:34
 * Remark :
 */
public class UserDtoExcel implements DtoExcel {
    private String name;
    private String email;
    private String desc;
    private int grade;

    public UserDtoExcel(String name, String email, String desc, int grade) {
        this.name = name;
        this.email = email;
        this.desc = desc;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public List<String> toArray() {
        return Arrays.asList(this.name, this.email,this.desc, String.valueOf(this.grade));
    }
}
