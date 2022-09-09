package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PassStringResourceIIA {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            String url = "https://localhost:44347/Admin/Language/Edit/11";
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();

//            page.navigate("https://signin.theiiadev.org/adfs/oauth2/authorize/?client_id=36799138-f4b6-477b-b6c3-76e1d4b30eb0&redirect_uri=https%3A%2F%2Flocalhost%3A44347%2Fsignin&resource=https%3A%2F%2Flocalhost%3A44347%2F&response_type=id_token&scope=openid%20profile%20name%20emailaddress%20upn%20givenname%20surname%20role&response_mode=form_post&nonce=637981517909019354.ZDRjMmQzYjktY2QzOS00NTc4LWI0ODYtYTg2YmVkOThjNWE5YTAxYmM2YjUtNGMxNS00ZmFiLTkxYzgtMzA2OTk2YTNlZDFh&state=CfDJ8Gfqy3dgqJlCqS48G_AwxgSmkx1fOhO3yUb4ELYa32qnA1Gk9grHxJ48nDjvi7AYSOg0mEgYqEfY3mxH_NXmSy9qDVsm7eVxSdT9BvcHfODI-OKGLfE51eMTb3dCvqUxgOowJL3yEVmK57nUPhULoKOOAqsDUaqAX4xDweznTyU64zVPdGEZ1Cgb2moHVQH_VeR9jGCRnm7FNDiBcax9rDACgKozmwB8Zm_LYQ7qyPkhk8glxGBWaQmZJdNOg0CyW6tl3p7pnRnWW6Ed7s_oIUJKeiO49Nfgw8peYayasZCB-orMLfx7WuWnPkRm6786nA&x-client-SKU=ID_NETSTANDARD2_0&x-client-ver=6.8.0.0");
//            page.fill("#userNameInput", "brainstationtest@iiadev.org");
//            page.fill("#passwordInput", "Testing123456789");
//            page.click("#submitButton");

            String[] stringResource = {"pdfinvoice.billinginformation", "pdfinvoice.shippinginformation",
                    "pdfinvoice.notes", "pdfinvoice.quote", "pdfinvoice.invoicenumber", "pdfinvoice.invoicedate", "pdfinvoice.ordernumber",
                    "pdfinvoice.shipperid", "pdfinvoice.ordertype", "pdfinvoice.account", "pdfinvoice.purchasedby", "pdfinvoice.customerpo", "pdfinvoice.termsdays", "pdfinvoice.Sl",
                    "pdfinvoice.productname", "pdfinvoice.customername", "pdfinvoice.Customergan", "pdfinvoice.startdate", "pdfinvoice.enddate", "pdfinvoice.productprice", "pdfinvoice.productquantity",
                    "pdfinvoice.Productitemtotal", "pdfinvoice.productdiscount", "pdfinvoice.producttotal", "pdfinvoice.returncopyto", "pdfinvoice.netsalestotal", "pdfinvoice.shippinghandling", "pdfinvoice.tax",
                    "pdfinvoice.total", "pdfinvoice.lesspaidamount", "pdfinvoice.balancedue", "pdfinvoice.paymentmethod", "pdfinvoice.paymentstatus", "pdfinvoice.paymenthandling"
            };

            String[] value = {
                    "Fakturační údaje:", "Přepravní informace:", "Poznámky", "Citát", "Číslo faktury:", "Datum:",
                    "Číslo objednávky:", "ID odesílatele:", "Typ objednávky:", "Číslo účtu:", "Zakoupeno podle ID:", "Zákazník P.O:", "Podmínky: NET 30 dní", "#", "jméno výrobku",
                    "Jméno zákazníka", "zákaznické identifikační číslo", "Počáteční datum", "Datum ukončení", "Cena", "Množství", "Položka celkem", "Sleva na položku", "Celkový", "Vraťte jednu kopii s platbou a zašlete na:", "Čistý prodej celkem", "Poštovné a balné",
                    "Daň:", "Celkový", "Méně placená částka", "Nedoplatek", "Způsob platby:", "Status platby:", "Způsob platby Přidat. Poplatek"
            };

            System.out.println(value.length + " " +stringResource.length);
            page.navigate(url);
            page.waitForLoadState();
                page.fill("#userNameInput", "brainstationtest@iiadev.org");
                page.fill("#passwordInput", "Testing123456789");
                page.click("#submitButton");

                if (stringResource.length == value.length){
                    for (int i = 0; i < 34; i++) {
                        page.fill("//input[@id='LocaleResourceSearchModel_AddResourceString_ResourceName']", stringResource[i]);
                        page.fill("//input[@id='LocaleResourceSearchModel_AddResourceString_ResourceValue']", value[i]);
                        page.click("//*[@id='addResourceString']");
                        page.waitForLoadState();
                    }
                }

                page.close();



        }
    }
}
