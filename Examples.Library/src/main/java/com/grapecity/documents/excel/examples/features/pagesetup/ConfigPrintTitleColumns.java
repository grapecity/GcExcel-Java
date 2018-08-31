package com.grapecity.documents.excel.examples.features.pagesetup;

import java.net.URL;

import com.grapecity.documents.excel.IWorksheet;
import com.grapecity.documents.excel.Workbook;
import com.grapecity.documents.excel.examples.ExampleBase;

public class ConfigPrintTitleColumns extends ExampleBase {

    @Override
    public void execute(Workbook workbook) {
        workbook.open(this.getTemplateStream());
        IWorksheet worksheet = workbook.getWorksheets().get(0);

        //Set columns to repeat at left
        worksheet.getPageSetup().setPrintTitleColumns("$D:$G");

    }

    @Override
    public String getTemplateName() {
        return "PageSetup Demo.xlsx";
    }
}
