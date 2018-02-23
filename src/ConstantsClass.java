import org.openqa.selenium.support.ui.WebDriverWait;

class ConstantsClass {

    // General constants
    static final String PATHWAY_TO_AUXILIARY_FILES = "C:/Users/efratbaruch/IdeaProjects/Mobile_Project_BuyMe_Efrat_Baruch/Auxiliary Test Files";
    static WebDriverWait WAIT;

    // Intro and registration screen constants
    static final String TO_REGISTER_BUTTON_ID = "il.co.mintapp.buyme:id/skipButton";
    static final String REGISTER_WITH_GOOGLE_BUTTON_ID = "il.co.mintapp.buyme:id/googleButton";
    static final String GOOGLE_PROFILE_VISIBLE_ID = "com.google.android.gms:id/account_profile_picture";
    static final String GOOGLE_ACCOUNT_UI_SELECTOR = "new UiSelector().className(android.widget.LinearLayout).clickable(true).index(0)";

    // Home screen constants
    static final String HOME_TAB_ID = "il.co.mintapp.buyme:id/homeTab";
    static final String CATEGORY_TO_PICK_UI_SELECTOR = "new UiSelector().className(android.widget.RelativeLayout).index(0).fromParent(new UiSelector().className(android.widget.RelativeLayout).index(1))";
    static final String CATEGORY_SCREEN_VISIBLE_ID = "il.co.mintapp.buyme:id/categoryName";
    static final String BUSINESS_TO_PICK_UI_SELECTOR = "new UiSelector().className(android.widget.RelativeLayout).clickable(true).index(2)";
    static final String GIFT_AMOUNT_FIELD_ID = "il.co.mintapp.buyme:id/priceEditText";
    static final String PURCHASE_BUTTON_ID = "il.co.mintapp.buyme:id/purchaseButton";

    // Sender and receiver information screen
    static final String RECEIVER_NAME_FIELD_ID = "il.co.mintapp.buyme:id/toEditText";
    static final String BLESS_FIELD_ID = "il.co.mintapp.buyme:id/blessEditText";
    static final String SENDER_FIELD_ID = "il.co.mintapp.buyme:id/userFrom";
    static final String NEXT_BUTTON_ID = "il.co.mintapp.buyme:id/goNextButton";

    // How to send screen
    static final String SEND_NOW_RADIO_BUTTON_ID = "il.co.mintapp.buyme:id/nowRadioButton";
    static final String CHECKBOX_OPTIONS_ID = "il.co.mintapp.buyme:id/optionCheckBox";
    static final String RECEIVER_EMAIL_FIELD_ID = "il.co.mintapp.buyme:id/description";

    // AfterClass constant
    static final String PAYMENT_TITLE_ID = "il.co.mintapp.buyme:id/paymentTitle";

    // Extra Classes constants
    static final String SETTINGS_ICON_ID = "il.co.mintapp.buyme:id/profileTab";
    static final String SETTING_SCREEN_VISIBLE_ID = "il.co.mintapp.buyme:id/profileImage";
    static final String SETTING_OPTIONS_ID = "il.co.mintapp.buyme:id/title";
    static final String ABOUT_TITLE_ID = "il.co.mintapp.buyme:id/titleText";
    static final String ABOUT_BODY_ID = "il.co.mintapp.buyme:id/contentText";
    static final String BACK_BUTTON_UI_SELECTOR = "new UiSelector().className(android.widget.ImageButton).index(0)";
    static final String PRICE_ELEMENTS_ID = "il.co.mintapp.buyme:id/giftPrice";
}
