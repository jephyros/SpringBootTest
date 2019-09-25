package link.chis.exceltest.controller;

import link.chis.exceltest.dto.DtoExcel;
import link.chis.exceltest.dto.Product;
import link.chis.exceltest.dto.UserDtoExcel;
import link.chis.exceltest.dto.UserinfoDtoExcel;
import link.chis.exceltest.excel.ExcelConstant;
import link.chis.exceltest.excel.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author InSeok <kr.chis@gmail.com>
 * Date : 2019-04-26
 * Time : 09:35
 * Remark : 엑셀다운 예제용 컨트롤러
 *
 */
@Controller
public class MainController {

    @Autowired
    private ExcelReader excelReader;

    //엑셀 다운로드
    @GetMapping("/")
    public String get(Model model) {
        return "index";

    }

    @GetMapping("/stat.xls")
    public String getExcelByExt(Model model) {

        List<String> header = Arrays.asList("ID", "이름", "나이");
        UserinfoDtoExcel e1 = new UserinfoDtoExcel("cis","최인석2",44);
        UserinfoDtoExcel e2 = new UserinfoDtoExcel("hdg","홍길동3",33);
        List<DtoExcel> excelDowns = Arrays.asList(e1,e2);

        exceldataModel(model,header,excelDowns);


        return "excelDownXls";

    }

    @GetMapping(path = "/stat", params = "format=xls")
    public String getExcelByType(Model model) {

        List<String> header = Arrays.asList("이름", "", "나이");
        UserDtoExcel e1 = new UserDtoExcel("최인석","abc@mail.com","기타사항없음",1);
        UserDtoExcel e2 = new UserDtoExcel("홍길동","hgd@mail.com","의적",2);

        List<DtoExcel> excelDowns = Arrays.asList(e1,e2);

        exceldataModel(model,header,excelDowns);


        return "excelDownXls";

    }

    private void exceldataModel(Model model, List<String> header, List<DtoExcel> excelDtos) {


        List<List<String>> excelData  = new ArrayList<>();
        excelDtos.stream().forEach(e-> excelData.add(e.toArray()));

        model.addAttribute(ExcelConstant.FILE_NAME, "longTermData_excel");
        model.addAttribute(ExcelConstant.HEAD, header);
        model.addAttribute(ExcelConstant.BODY,excelData);

    }

    //엑셀업로드

    @GetMapping("upload")
    public String upload(){
        return "upload";
    }

    @PostMapping("excelupload")
    public String readExcel(@RequestParam("file") MultipartFile multipartFile) throws IOException, InvalidFormatException {

        List<Product> products = excelReader.readFileToList(multipartFile, Product::from);
        products.stream().forEach(e->
        {
            System.out.println(e.toString());
        });
        return "upload";
    }




}
