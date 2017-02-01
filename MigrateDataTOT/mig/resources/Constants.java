package mig.resources;

import java.nio.charset.Charset;

public class Constants {
	
	
	public static final Charset UTF_8 = Charset.forName("UTF-8");
	public static final String ExteactCyclePath = System.getenv("HOME")+"/var/tea/MigData/ListAccount/";
	
	public static final String nameAddressInfoXLS = System.getenv("HOME")+"/var/tea/MigData/NAME_ADDRESS_INFO/configNameAddressInfo.xlsx";	
	public static final String nameAddressInfoPid = System.getenv("HOME")+"/var/tea/MigData/NAME_ADDRESS_INFO/";
	public static final String nameAddressInfoOutput = System.getenv("HOME")+"/var/tea/MigData/NAME_ADDRESS_INFO/output/";
	public static final String nameAddressInfoBackUp = System.getenv("HOME")+"/var/tea/MigData/NAME_ADDRESS_INFO/BackUp/";
	
	public static final String customerAccountXLS = System.getenv("HOME")+"/var/tea/MigData/COSTOMER_ACCOUNT/configBillingAcount.xlsx";	
	public static final String customerAccountPid = System.getenv("HOME")+"/var/tea/MigData/COSTOMER_ACCOUNT/";
	public static final String customerAccountOutput = System.getenv("HOME")+"/var/tea/MigData/COSTOMER_ACCOUNT/output/";
	public static final String customerAccountBackUp = System.getenv("HOME")+"/var/tea/MigData/COSTOMER_ACCOUNT/BackUp/";
	
	public static final String serviceFeaturePid = System.getenv("HOME")+"/var/tea/MigData/SERVICE_FEATURE/";
	public static final String serviceFeatureBackUp = System.getenv("HOME")+"/var/tea/MigData/SERVICE_FEATURE/BackUp/";
	
	public static final String accountPymMtdXLS = System.getenv("HOME")+"/var/tea/MigData/ACCOUNT_PYM_MTD/configBanPymMtd.xlsx";
	public static final String accountPymMtdPid = System.getenv("HOME")+"/var/tea/MigData/ACCOUNT_PYM_MTD/";
	public static final String accountPymMtdBackUp = System.getenv("HOME")+"/var/tea/MigData/ACCOUNT_PYM_MTD/BackUp/";

	public static final String productXLS = System.getenv("HOME")+"/var/tea/MigData/PRODUCT/configProduct.xlsx";
	public static final String productPid = System.getenv("HOME")+"/var/tea/MigData/PRODUCT/";
	public static final String productBackUp = System.getenv("HOME")+"/var/tea/MigData/PRODUCT/BackUp/";
	
	public static final String productHistoryXLS = System.getenv("HOME")+"/var/tea/MigData/PRODUCT_HISTORY/configProductHistory.xlsx";
	public static final String productHistoryPid = System.getenv("HOME")+"/var/tea/MigData/PRODUCT_HISTORY/";
	public static final String productHistoryBackUp = System.getenv("HOME")+"/var/tea/MigData/PRODUCT_HISTORY/BackUp/";
	
	public static final String productTypeXLS = System.getenv("HOME")+"/var/tea/MigData/PRODUCT_TYPE/configProductType.xlsx";
	public static final String productTypePid = System.getenv("HOME")+"/var/tea/MigData/PRODUCT_TYPE/";
	public static final String productTypeBackUp = System.getenv("HOME")+"/var/tea/MigData/PRODUCT_TYPE/BackUp/";
	
	public static final String paymentMethodXLS = System.getenv("HOME")+"/var/tea/MigData/PAYMENT_METHOD/configPaymentMethod.xlsx";
	public static final String paymentMethodPid = System.getenv("HOME")+"/var/tea/MigData/PAYMENT_METHOD/";
	public static final String paymentMethodBackUp = System.getenv("HOME")+"/var/tea/MigData/PAYMENT_METHOD/BackUp/";
	
	public static final String pricePlanXLS = System.getenv("HOME")+"/var/tea/MigData/PRICE_PLAN/configPricePlan.xlsx";
	public static final String pricePlanPid = System.getenv("HOME")+"/var/tea/MigData/PRICE_PLAN/";
	public static final String pricePlanBackUp = System.getenv("HOME")+"/var/tea/MigData/PRICE_PLAN/BackUp/";
	
	public static final String holidaysXLS = System.getenv("HOME")+"/var/tea/MigData/HOLIDAYS/configHolidays.xlsx";
	public static final String holidaysPid = System.getenv("HOME")+"/var/tea/MigData/HOLIDAYS/";
	public static final String holidaysBackUp = System.getenv("HOME")+"/var/tea/MigData/HOLIDAYS/BackUp/";
	
	public static final String serviceAgreementXLS = System.getenv("HOME")+"/var/tea/MigData/SERVICE_AGREEMENT/configServiceAgreement.xlsx";
	public static final String serviceAgreementPid = System.getenv("HOME")+"/var/tea/MigData/SERVICE_AGREEMENT/";
	public static final String serviceAgreementBackUp = System.getenv("HOME")+"/var/tea/MigData/SERVICE_AGREEMENT/BackUp/";
	
	public static final String serviceDiscountXLS = System.getenv("HOME")+"/var/tea/MigData/SERVICE_DISCOUNT/configServiceDiscount.xlsx";
	public static final String serviceDiscountPid = System.getenv("HOME")+"/var/tea/MigData/SERVICE_DISCOUNT/";
	public static final String serviceDiscountBackUp = System.getenv("HOME")+"/var/tea/MigData/SERVICE_DISCOUNT/BackUp/";
	
	public static final String cycleControlXLS = System.getenv("HOME")+"/var/tea/MigData/CYCLE_CONTROL/configCycleControl.xlsx";
	public static final String cycleControlPid = System.getenv("HOME")+"/var/tea/MigData/CYCLE_CONTROL/";
	public static final String cycleControlBackUp = System.getenv("HOME")+"/var/tea/MigData/CYCLE_CONTROL/BackUp/";
	
	public static final String bankXLS = System.getenv("HOME")+"/var/tea/MigData/BANK/configBank.xlsx";
	public static final String bankPid = System.getenv("HOME")+"/var/tea/MigData/BANK/";
	public static final String bankBackUp = System.getenv("HOME")+"/var/tea/MigData/BANK/BackUp/";

	public static final String printCategoryXLS = System.getenv("HOME")+"/var/tea/MigData/PRINT_CATEGORY/configPrintCategory.xlsx";
	public static final String printCategoryPid = System.getenv("HOME")+"/var/tea/MigData/PRINT_CATEGORY/";
	public static final String printCategoryBackUp = System.getenv("HOME")+"/var/tea/MigData/PRINT_CATEGORY/BackUp/";

	public static final String rcRateXLS = System.getenv("HOME")+"/var/tea/MigData/RC_RATE/configRcRate.xlsx";
	public static final String rcRatePid = System.getenv("HOME")+"/var/tea/MigData/RC_RATE/";
	public static final String rcRateBackUp = System.getenv("HOME")+"/var/tea/MigData/RC_RATE/BackUp/";

	public static final String accountTypeXLS = System.getenv("HOME")+"/var/tea/MigData/ACCOUNT_TYPE/configAccountType.xlsx";
	public static final String accountTypePid = System.getenv("HOME")+"/var/tea/MigData/ACCOUNT_TYPE/";
	public static final String accountTypeBackUp = System.getenv("HOME")+"/var/tea/MigData/ACCOUNT_TYPE/BackUp/";
	
	public static final String featureXLS = System.getenv("HOME")+"/var/tea/MigData/FEATURE/Feature.xlsx";
	public static final String featurePid = System.getenv("HOME")+"/var/tea/MigData/FEATURE/";
	public static final String featureBackUp = System.getenv("HOME")+"/var/tea/MigData/FEATURE/BackUp/";
	
	public static final String generatePath = System.getenv("HOME")+"/var/tea/MigData/Generate/";
	public static final String pathFileCreate = System.getenv("HOME")+"/var/tea/MigData/Generate/create.txt";
	public static final String pathFileDrop = System.getenv("HOME")+"/var/tea/MigData/Generate/drop.txt";
	public static final String pathFileCreateIndex = System.getenv("HOME")+"/var/tea/MigData/Generate/createIndex.txt";
	public static final String pathFileDropIndex = System.getenv("HOME")+"/var/tea/MigData/Generate/dropIndex.txt";

}
