package framework.Context;

import framework.PageObjects.ItemPage;
import framework.PageObjects.MainPage;

public class MainContext {
    private MainContext(){}
    private static MainPage filterPrice(MainPage mainpage , int minimal, int maximal) throws InterruptedException {
        mainpage = mainpage.setMinPrice(minimal);
        mainpage = mainpage.setMaxPrice(maximal);
        Thread.sleep(2000);
        return mainpage.adjustPriceFilter();
    }
    private static MainPage filterCountry(MainPage mainPage,String country) throws InterruptedException{
        mainPage = mainPage.setCountry(country);
        Thread.sleep(2000);
        return mainPage;
    }
    public static ItemPage ChooseItem(MainPage mainPage, String name, String country, int min, int max) throws InterruptedException {
        mainPage = filterPrice(filterCountry(mainPage, country), min, max);
        Thread.sleep(2000);
        return mainPage.selectGoodFromGoods(name);
    }
}
