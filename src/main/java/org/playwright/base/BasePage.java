package org.playwright.base;

import com.microsoft.playwright.*;

public class BasePage {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    public void createPageInstance() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    public void closePageInstance() {
        page.close();
    }

    public Page getPage() {
        return page;
    }

    public static void clearAndType(String locator, String input) {
        page.fill(locator, "");
        page.type(locator, input);
    }
}