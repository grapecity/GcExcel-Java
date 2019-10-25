package com.grapecity.documents.excel.examples.templates.datasource;

import java.io.InputStream;

import com.grapecity.documents.excel.Workbook;
import com.grapecity.documents.excel.examples.ExampleBase;
import com.grapecity.documents.excel.examples.GcMockResultSet;

public class ResultSet extends ExampleBase {
	@Override
	public void execute(Workbook workbook) {
		//Load template file Template_Score.xlsx from resource
		InputStream templateFile = this.getResourceStream("xlsx/Template_Score.xlsx");
		workbook.open(templateFile);

		//Here in the demo, we use a mock class to generate instance of java.sql.ResultSet.
		//User who use template in product, must get instance of java.sql.ResultSet from the 
		//related database connection.
		java.sql.ResultSet datasource = new GcMockResultSet(this.getResourceStream("score.csv"));

		//Add data source
		workbook.addDataSource("ds", datasource);
		//Invoke to process the template
		workbook.processTemplate();
	}

	@Override
	public boolean getIsNew() {
		return true;
	}

	@Override
	public String getTemplateName() {
		return "Template_Score.xlsx";
	}

	@Override
	public boolean getHasTemplate() {
		return true;
	}

	@Override
	public String[] getResources() {
		return new String[] { "xlsx/Template_Score.xlsx", "score.csv" };
	}
}