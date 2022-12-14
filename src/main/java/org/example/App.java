package org.example;

import com.microsoft.playwright.*;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Playwright playwright = Playwright.create()) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Productbook");

            String url = "https://www.aliexpress.com/category/711005/usb-flash-drives.html?spm=a2g0o.home.104.25.445b2145m5VuaA";
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            Page n[] = new Page[100];
            String productNamexp = "//h1[@class = 'product-title-text']";
            String productPricexp = "//span[@class = 'product-price-value']";
            String productDescriptionxp = "//div[@class = 'product-specs']";
            //page.navigate(url);
            for (int i = 1; i < 41; i++) {
                page.navigate(url);
                String product = "(//h1[@class = '_18_85'])[" + i + "]";
                page.click(product);

                n[i] = page.waitForPopup(() -> {
                    System.out.println("popup");
                });

                // product price element find
//                String dummy = n[i].innerText(productPricexp);
                n[i].waitForLoadState();

                String price;

                if(!n[i].isVisible(productPricexp)){
                    System.out.println("product price does not exist");
                    int min, max;
                    min = 300; max = 900;
                    int b = (int)(Math.random()*(max-min+1)+min);
                    price = String.valueOf(b);

                }else{
                    price = n[i].innerText(productPricexp);
                }



                String productTitle = n[i].innerText(productNamexp);
                System.out.println(productTitle);

                System.out.println(price);
                n[i].locator("(//span[@class='tab-inner-text'])[7]").click();
                String productDescription = n[i].innerHTML(productDescriptionxp);
                System.out.println(productDescription);
                Long productPrice = Long.parseLong(price.replaceAll("[^0-9]", ""));


                String SEName = productTitle.replaceAll("[^a-zA-Z0-9]", "-");
                String currLink = n[i].url();
                String skuInLink = currLink.substring(currLink.lastIndexOf("/") + 1,currLink.lastIndexOf("/") + 11 );
                long SKU = Long.parseLong(skuInLink);
                String productShortDescription = productTitle;
//                  String img1 = "//div[@class='images-view-item']";
//                String img1 = "(//div[@class='images-view-item']/img)[2]";
//                String img2 = "(//div[@class='images-view-item']/img)[3]";
//                String img3 = "(//div[@class='images-view-item']/img)[4]";
//                String imgURL = "//img[@class='magnifier-image']";

                String img1 = "(//div[@class='images-view-item']/img)[2]";
                String img2 = "(//div[@class='images-view-item']/img)[3]";
                String img3 = "(//div[@class='images-view-item']/img)[4]";
                String imgURL = "//img[@class='magnifier-image']";
                String img1URL,img2URL,img3URL;

                if (!n[i].isVisible(img1)){
                    img1 = "(//div[@class='images-view-item']/img)[1]";
                    n[i].locator(img1).click();
                    img1URL = n[i].getAttribute(imgURL, "src");
                    img2URL = "";
                    img3URL = "";
                }
                else {
                    n[i].locator(img1).click();
                    img1URL = n[i].getAttribute(imgURL, "src");
                    n[i].locator(img2).click();
                    img2URL = n[i].getAttribute(imgURL, "src");
                    n[i].locator(img3).click();
                    img3URL = n[i].getAttribute(imgURL, "src");
                }

                System.out.println(img1URL);
                System.out.println(img2URL);
                System.out.println(img3URL);


                System.out.println(SKU);
                System.out.println(SEName);
                System.out.println(productShortDescription);

                Object[][] pro = {
                        { "Simple Product",0, "TRUE" ,productTitle, productShortDescription, productDescription,"", "Simple product", "FALSE", 0,"","","",SEName, "TRUE", "TRUE", SKU, productPrice, img1URL, img2URL, img3URL}
                };
//                Object[][] pro = {
//                        { "Simple Product",0, "TRUE" ,productTitle, productShortDescription, productDescription,"", "Simple product", "FALSE", 0,"","","",SEName, "TRUE", "TRUE", SKU, productPrice, img1URL}
//                };
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

                n[i].close();
            }

            page.close();
        }
    }
}