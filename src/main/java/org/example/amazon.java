package org.example;

import com.microsoft.playwright.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class amazon {
    public static void main(String[] args) throws IOException, InterruptedException {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("Input: ");
        n = scan.nextInt();
        try (Playwright playwright = Playwright.create()) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Productbook");


            String url = "https://www.amazon.com/s?k=water+bottles&i=sporting&rh=n%3A3394801%2Cn%3A3395091&dc&page=3&qid=1662370050&rnid=2941120011&sprefix=water+%2Caps%2C477&ref=sr_pg_3";
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            //Page n[] = new Page[100];
            for(int i = 1; i<=n; i++) {
                page.navigate(url);
                String productListXp = "(//span[contains(@class, 'a-size-base-plus')])[" + i + "]";
                String productNameXp = "//h1[@id= 'title']";
                String productPriceType1Xp = "//span[@class = 'a-price aok-align-center reinventPricePriceToPayMargin priceToPay']";
                String productPriceType2Xp = "//span[@class = 'a-price a-text-price a-size-medium apexPriceToPay']";
                String productShortDescriptionXp = "//ul[@class='a-unordered-list a-vertical a-spacing-mini']";
                String productShortDescriptionXp2 = "//div[@id='feature-bullets']";
                String productLongDescription1Xp = "//div[@id='aplus']";
                String productLongDescription2Xp = "//div[@id='prodDetails']";
                String productLongDescription3Xp = "//div[@id='detailBullets_feature_div']";
                String imageXp = "//div[@id='imgTagWrapperId']";
                String imgType1 = "(//div[@class='ivThumbImage'])[3]";
                String imgType2 = "(//div[@class='ivThumbImage'])[4]";
                String imgType3 = "(//div[@class='ivThumbImage'])[5]";
                String imgTypeA = "(//span[@class='a-button-inner'])[3]";
                String imgTypeB = "(//span[@class='a-button-inner'])[4]";
                String imgTypeC = "(//span[@class='a-button-inner'])[5]";
                String fullImageType1Xp = "//img[@class='fullscreen']";
                String image1xp = "//img[@class='a-dynamic-image']";
                page.click(productListXp);
                String productPrice = "";
                String productLongDescription = "";
                String img1Url, img2Url, img3Url;
                String productShortDescription = "";
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
                } else {
                    int min, max;
                    min = 60; max = 120;
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

                if (page.isVisible(productShortDescriptionXp)){
                    productShortDescription = page.innerText(productShortDescriptionXp);
                    System.out.println(productShortDescription);
                } else {
                    productShortDescription = page.innerText(productShortDescriptionXp2);
                    System.out.println(productShortDescription);
                }

                page.waitForLoadState();
                if (page.isVisible(productLongDescription1Xp)) {
                    productLongDescription = page.innerHTML(productLongDescription1Xp);
                    System.out.println("des1");
                    System.out.println(productLongDescription.length());
                    if (productLongDescription.length() > 30000 && page.isVisible(productLongDescription2Xp)){
                        productLongDescription = page.innerHTML(productLongDescription2Xp);
                        System.out.println("des2");
                        System.out.println(productLongDescription.length());
                    } else if (productLongDescription.length() > 30000 && page.isVisible(productLongDescription3Xp)) {
                        productLongDescription = page.innerHTML(productLongDescription3Xp);
                        System.out.println("des3");
                        System.out.println(productLongDescription.length());
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
//                page.waitForLoadState();
                if(page.isVisible(imgType1)){

                    if (!page.isVisible(imgType1) || !page.isVisible(imgType2) || !page.isVisible(imgType3)){
                        continue;
                    }

                    page.click(imgType1);
                    page.waitForLoadState();
                    img1Url = page.getAttribute(fullImageType1Xp, "src");
                    page.click(imgType2);
//                    page.waitForLoadState();
                    img2Url = page.getAttribute(fullImageType1Xp, "src");
                    page.click(imgType3);
//                    page.waitForLoadState();
                    img3Url = page.getAttribute(fullImageType1Xp, "src");
                } else {
                    if (!page.isVisible(imgTypeA) || !page.isVisible(imgTypeB) || !page.isVisible(imgTypeC)){
                        continue;
                    }
                    page.click(imgTypeA);
                    page.waitForLoadState();
                    img1Url = page.getAttribute(image1xp, "src");
                    page.click(imgTypeB);
//                    page.waitForLoadState();
                    img2Url = page.getAttribute(image1xp, "src");
                    page.click(imgTypeC);
//                    page.waitForLoadState();
                    img3Url = page.getAttribute(image1xp, "src");
                }
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
