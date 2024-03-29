package link.chis.exceltest.dto;

import org.apache.poi.ss.usermodel.Row;

/**
 * @author InSeok <kr.chis@gmail.com>
 * Date : 2019-04-29
 * Time : 10:59
 * Remark :
 */
public class Product {
    private String uniqueId;

    private String name;

    private String comment;

    protected Product() { }

    public Product(String uniqueId, String name, String comment) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.comment = comment;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static Product from(Row row) {
        return new Product(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue());
    }

    @Override
    public String toString() {
        return "Product{" +
                "uniqueId='" + uniqueId + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
