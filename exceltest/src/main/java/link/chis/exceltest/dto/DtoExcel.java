package link.chis.exceltest.dto;

import java.util.List;

/**
 * @author InSeok <kr.chis@gmail.com>
 * Date : 2019-04-26
 * Time : 09:33
 * Remark : 엑셀 전환용 Dto 생성시 toArray 를 강제하기위한 인터페이스
 */
public interface DtoExcel {
    List<String> toArray();
}
