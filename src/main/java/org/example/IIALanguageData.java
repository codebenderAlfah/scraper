package org.example;

public class IIALanguageData {
    public static void main(String[] args) {
        String[] chineseValue = {
              "账单信息：", "运输信息：", "笔记", "引用", "发票号码：", "日期：", "订单号：", "发货人编号：", "订单类型：", "帐户ID：", "凭身份证购买：",
                "客户邮政信箱：", "条款：净 30 天", "#", "产品名称", "顾客姓名", "客户ID", "开始日期", "结束日期", "价格", "数量", "项目总计", "商品折扣", "全部的", "返回一份并付款并汇款至：", "净销售额总计", "运输/处理", "税:", "全部的",
                "少付金额", "余额到期", "付款方式：", "支付状态：", "付款方式添加。 费用"

        };
        String[] CzechValue = {
                "Fakturační údaje:", "Přepravní informace:", "Poznámky", "Citát", "Číslo faktury:", "Datum:",
                "Číslo objednávky:", "ID odesílatele:", "Typ objednávky:", "Číslo účtu:", "Zakoupeno podle ID:", "Zákazník P.O:", "Podmínky: NET 30 dní", "#", "jméno výrobku",
                "Jméno zákazníka", "zákaznické identifikační číslo", "Počáteční datum", "Datum ukončení", "Cena", "Množství", "Položka celkem", "Sleva na položku", "Celkový", "Vraťte jednu kopii s platbou a zašlete na:", "Čistý prodej celkem", "Poštovné a balné",
                "Daň:", "Celkový", "Méně placená částka", "Nedoplatek", "Způsob platby:", "Status platby:", "Způsob platby Přidat. Poplatek"
        };
        String[] KoreanValue = {
                "결제 정보:", "배송 정보:", "메모", "인용하다", "송장 번호:", "날짜:", "주문 번호:", "발송인 ID:", "주문 유형:", "계정 ID:", "ID로 구매:", "고객 PO:", "조건: NET 30일条款：净 30 天", "#",
                "상품명", "고객 이름", "고객 ID", "시작일", "종료일", "가격", "수량", "항목 합계", "아이템 할인", "총", "지불한 사본 1부를 반환하고 다음 주소로 송금하십시오.", "순매출액", "배송 및 취급",
                 "세:", "총", "적은 금액", "차감 부족액", "지불 방법:", "지불 상태:", "결제수단 추가 요금"
        };

        String[] japanesValue = {
               "課金情報：", "出荷情報：", "ノート", "見積もり", "請求書番号：", "日にち：", "注文番号：", "荷送人 ID:", "注文タイプ:", "アカウントID：", "IDで購入：", "お客様の私書箱:", "条件: NET 30 日", "#", "商品名",
                "顧客名", "顧客ID", "開始日", "終了日", "価格", "量", "アイテム合計", "アイテム割引", "合計", "代金を添えて 1 部を返送し、次の宛先に送金してください。", "売上高 合計", "出荷処理", "税:", "合計",
                "少ない支払額", "未払い残高", "支払方法：", "支払い状況：", "お支払い方法の追加。 費用"
        };

        String[] TurkishValue = {
               "Fatura bilgileri:", "Nakliye Bilgisi:", "Notlar", "Alıntı", "Fatura numarası:", "Tarih:", "Sipariş numarası:", "Gönderici Kimliği:", "Sipariş türü:", "Hesap Kimliği:", "Kimlikle satın alındı:", "Müşteri Postası:",
                "Şartlar: NET 30 Gün条件: NET 30 日", "#", "Ürün adı", "müşteri adı", "Müşteri Kimliği", "Başlangıç ​​tarihi", "Bitiş tarihi", "Fiyat",
                "Miktar", "Öğe Toplamı", "Ürün İndirimi", "Toplam", "Ödemeyle birlikte bir kopyayı iade edin ve şu adrese havale edin:", "Net Satış Toplamı", "Nakliye/Taşıma", "Vergi:", "Toplam", "Daha Az Ödenen Tutar", "Bakiye Vadesi",
                 "Ödeme şekli:", "Ödeme Durumu:", "Ödeme Yöntemi Ekle. Ücret"
        };

        String[] SpanishValue = {
                "Datos de facturación:", "Información de envío:", "notas",
                "Cotizar","Número de factura:", "Fecha:", "Número de orden:", "Identificación del remitente:", "Tipo de orden:", "ID de la cuenta:", "Comprado por DNI:", "Apartado de correos del cliente:", "Términos: NETO 30 Días",
                "#", "nombre del producto", "Nombre del cliente", "Identificación del cliente", "Fecha de inicio", "Fecha final", "Precio",
                "Cantidad", "Total", "Descuento del artículo", "Total", "Devuelva una copia con el pago y remita a:", "Total de ventas netas", "Envío/Manejo", "Impuesto:", "Total",
                "Cantidad menos pagada", "Saldo adeudado", "Método de pago:", "Estado de pago:", "Método de pago Agregar. Tarifa"
        };

        String[] Russian = {
                "Платежная информация:", "Информация о доставке:", "Заметки", "Цитировать", "Номер счета:", "Свидание:", "Порядковый номер:", "Идентификатор отправителя:", "Тип заказа:",
                  "Идентификатор учетной записи:", "Куплено по ИД:", "Заказ клиента:", "Условия: НЕТТО 30 дней", "#", "наименование товара", "Имя Клиента", "Пользовательский ИД", "Дата начала",
                   "Дата окончания", "Цена", "Количество", "Сумма товара", "Скидка на товар", "Общий", "Верните одну копию с оплатой и отправьте по адресу:", "Всего чистых продаж", "Доставка и обработка",
                     "налог:", "Общий", "Меньше оплаченной суммы", "Задолжность", "Метод оплаты:", "Статус платежа:", "Способ оплаты Доп. Платеж"
        };

        String[] portugal={
                "Informações de pagamento:",
        "Informação de envio:",
        "Notas",
                "Citar",
        "Número da fatura:",
        "Encontro:",
        "Número do pedido:",
                "Identificação do remetente:",
                "Tipo de pedido:",
        "Código da conta:",
        "Comprado por ID:",
        "PO Cliente:",
        "Termos: NET 30 dias",
"#",
        "Nome do Produto",
        "nome do cliente",
        "Identificação do Cliente",
        "Data de início",
        "Data final",
        "Preço",
                "Quantidade",
        "Total de itens",
        "Desconto de itens",
                "Total",
        "Devolva uma cópia com o pagamento e envie para:",
        "Total de vendas líquidas",
        "Envio/Manuseio",
        "Imposto:",
        "Total",
        "Valor menos pago",
        "Saldo devedor",
        "Zahlungsmethode:",
        "Status do pagamento:",
                "Método de pagamento Adicionar. Taxa"
        } ;

        String[] German = {
                "Abrechnungsdaten:",
        "Versandinformationen:",
        "Anmerkungen",
                "Zitieren",
        "Rechnungsnummer:",
        "Datum:",
        "Bestellnummer:",
        "Versender-ID:",
        "Auftragsart:",
        "Konto-ID:",
        "Gekauft nach ID:",
        "Kunden-Postfach:",
        "Bedingungen: 30 Tage netto",
"#",
        "Produktname",
                "Kundenname",
        "Kundennummer",
                "Anfangsdatum",
        "Endtermin",
                "Preis",
        "Menge",
        "Artikel Gesamt",
        "Artikelrabatt",
                "Gesamt",
        "Ein Exemplar gegen Bezahlung zurücksenden und an folgende Adresse senden:",
        "Nettoumsatz insgesamt",
        "Versand & Bearbeitung",
        "Steuer:",
        "Gesamt",
        "Weniger bezahlter Betrag",
        "Restbetrag fällig",
        "Zahlungsmethode:",
        "Zahlungsstatus:",
        "Zahlungsmethode Hinzufügen. Gebühr"
        };

        System.out.println(japanesValue.length);
    }

}
