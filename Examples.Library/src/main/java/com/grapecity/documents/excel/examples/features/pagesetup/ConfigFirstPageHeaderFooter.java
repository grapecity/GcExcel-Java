package com.grapecity.documents.excel.examples.features.pagesetup;

import java.io.InputStream;
import java.net.URL;

import com.grapecity.documents.excel.IWorksheet;
import com.grapecity.documents.excel.Workbook;
import com.grapecity.documents.excel.drawing.ImageType;
import com.grapecity.documents.excel.examples.ExampleBase;

public class ConfigFirstPageHeaderFooter extends ExampleBase {

    @Override
    public void execute(Workbook workbook) {
        workbook.open(this.getTemplateStream());
        IWorksheet worksheet = workbook.getWorksheets().get(0);

        //Set first page headerfooter
        worksheet.getPageSetup().setDifferentFirstPageHeaderFooter(true);

        worksheet.getPageSetup().getFirstPage().getCenterHeader().setText("&T");
        worksheet.getPageSetup().getFirstPage().getRightFooter().setText("&D");

        //Set first page headerfooter's graphic
        worksheet.getPageSetup().getFirstPage().getLeftFooter().setText("&G");
        InputStream stream = ClassLoader.getSystemResourceAsStream("logo.png");
        worksheet.getPageSetup().getFirstPage().getLeftFooter().getPicture().setGraphicStream(stream, ImageType.PNG);
        worksheet.getPageSetup().getFirstPage().getLeftFooter().getPicture().setWidth(100);
        worksheet.getPageSetup().getFirstPage().getLeftFooter().getPicture().setHeight(13);

    }


    @Override
    public String getTemplateName() {
        return "PageSetup Demo.xlsx";
    }

}
