package org.example;

import com.microsoft.playwright.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class amazon {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Playwright playwright = Playwright.create()) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Productbook");


            String url = "https://www.amazon.com/s?i=specialty-aps&bbn=16225007011&rh=n%3A16225007011%2Cn%3A1292115011&ref=nav_em__nav_desktop_sa_intl_monitors_0_2_6_8";
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            //Page n[] = new Page[100];
            for(int i = 1; i<=20; i++) {
                page.navigate(url);
                String productListXp = "(//span[contains(@class, 'a-size-base-plus')])[" + i + "]";
                String productNameXp = "//h1[@id= 'title']";
                String productPriceType1Xp = "//span[@class = 'a-price aok-align-center reinventPricePriceToPayMargin priceToPay']";
                String productPriceType2Xp = "//span[@class = 'a-price a-text-price a-size-medium apexPriceToPay']";
                String productShortDescriptionXp = "//ul[@class='a-unordered-list a-vertical a-spacing-mini']";
                String productLongDescription1Xp = "//div[@id='aplus']";
                String productLongDescription2Xp = "//div[@id='prodDetails']";
                String productLongDescription3Xp = "//div[@id='detailBullets_feature_div']";
                String imageXp = "//div[@id='imgTagWrapperId']";
                String img1 = "(//div[@class='ivThumbImage'])[3]";
                String img2 = "(//div[@class='ivThumbImage'])[4]";
                String img3 = "(//div[@class='ivThumbImage'])[5]";
                String fullImageXp = "//img[@class='fullscreen']";
                page.click(productListXp);
                String productPrice = "";
                String productLongDescription = "";
                String img1Url, img2Url, img3Url;
                //page.waitForLoadState();
                String productName = page.innerText(productNameXp);
                if (page.isVisible(productPriceType1Xp)) {
                    productPrice = page.innerText(productPriceType1Xp);
                    productPrice = productPrice.substring(1,productPrice.indexOf("\n"));
                    productPrice = productPrice.replaceAll("[^0-9.]", "");
//                    System.out.println(productName + " " + productPrice);
                } else if (page.isVisible(productPriceType2Xp)) {
                    productPrice = page.innerText(productPriceType2Xp);
                    productPrice = productPrice.substring(1,productPrice.indexOf("\n"));
                    productPrice = productPrice.replaceAll("[^0-9.]", "");
//                    System.out.println(productName + " " + productPrice);
                } else if(page.isVisible(productPriceType1Xp) || page.isVisible(productPriceType2Xp)){
                    int min, max;
                    min = 300; max = 900;
                    int b = (int)(Math.random()*(max-min+1)+min);
                    productPrice = String.valueOf(b);
                }
                System.out.println(productName);
                System.out.println(productPrice);
                String currlink = page.url();
                String SEName = currlink.substring(currlink.indexOf("com/")+4, currlink.indexOf("/dp"));
                System.out.println(SEName);
                String SKU = currlink.substring(currlink.indexOf("dp/")+3, currlink.indexOf("/ref"));
                System.out.println(SKU);
                String productShortDescription = page.innerText(productShortDescriptionXp);
                System.out.println(productShortDescription);
                page.waitForLoadState();
                if (page.isVisible(productLongDescription1Xp)) {
                    productLongDescription = page.innerHTML(productLongDescription1Xp);
                    System.out.println("des1");
                    System.out.println(productLongDescription.length());
                    if (productLongDescription.length() > 30000 && page.isVisible(productLongDescription2Xp)){
                        productLongDescription = page.innerHTML(productLongDescription2Xp);
                        System.out.println("des2");
                    } else if (productLongDescription.length() > 30000 && page.isVisible(productLongDescription3Xp)) {
                        productLongDescription = page.innerHTML(productLongDescription3Xp);
                        System.out.println("des3");
                    }
                } else if (page.isVisible(productLongDescription2Xp)) {
                    productLongDescription = page.innerHTML(productLongDescription2Xp);
                    System.out.println("des2out");
                } else if (page.isVisible(productLongDescription3Xp)) {
                    productLongDescription = page.innerHTML(productLongDescription3Xp);
                    System.out.println("des3out");
                }
//                System.out.println(productLongDescription);

                page.click(imageXp);
                page.waitForLoadState();
                page.click(img1);
                page.waitForLoadState();
                img1Url = page.getAttribute(fullImageXp, "src");
                page.click(img2);
                page.waitForLoadState();
                img2Url = page.getAttribute(fullImageXp, "src");
                page.click(img3);
                page.waitForLoadState();
                img3Url = page.getAttribute(fullImageXp, "src");
                System.out.println(img1Url);
                System.out.println(img2Url);
                System.out.println(img3Url);

                Object[][] pro = {
                        { "Simple Product",0, "TRUE" ,productName, productShortDescription, productLongDescription,"", "Simple product", "FALSE", 0,"","","",SEName, "TRUE", "TRUE", SKU, productPrice, img1Url, img2Url, img3Url}
                };
                int rowNum = i;
                for (Object[] proRow : pro) {
                    Row row = sheet.createRow(rowNum++);
                    int colNum = 0;
                    for (Object field : proRow) {
                        Cell cell = row.createCell(colNum++);
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        } else if (field instanceof Long) {
                            cell.setCellValue((Long) field);
                        } else if (field instanceof Float) {
                            cell.setCellValue((Float) field);
                        }
                    }
                }
                try {
                    FileOutputStream outputStream = new FileOutputStream("Productbook.xlsx");
                    workbook.write(outputStream);
                    outputStream.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            browser.close();
        }
    }
}
