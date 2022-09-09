package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IIAData2 {


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            String url;
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

            for (int j = 2; j <=12; j++){
                url = "https://localhost:44347/Admin/Language/Edit/" + j;
                Page page = browser.newPage();
                ExcelReader excelReader = new ExcelReader("readData.xlsx");

                page.navigate(url);
                page.waitForLoadState();
                page.fill("#userNameInput", "brainstationtest@iiadev.org");
                page.fill("#passwordInput", "Testing123456789");
                page.click("#submitButton");
                System.out.println(url);
                System.out.println(excelReader.getRowCount("Sheet1"));

                for (int i = 1; i <= excelReader.getRowCount("Sheet1"); i++) {
                    String key = excelReader.getCellData("Sheet1", 0, i);
                    String value = excelReader.getCellData("Sheet1", j, i);


                    page.fill("//input[@id='LocaleResourceSearchModel_AddResourceString_ResourceName']", key);
                    page.fill("//input[@id='LocaleResourceSearchModel_AddResourceString_ResourceValue']", value);
                    page.click("//*[@id='addResourceString']");
                    page.waitForLoadState();
//                    System.out.println(i + "," + key + ": " + value);

                }
                page.close();
            }
            browser.close();
        }

    }
}
