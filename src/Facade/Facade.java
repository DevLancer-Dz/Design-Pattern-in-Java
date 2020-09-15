package Facade;

import java.sql.Driver;

public class Facade {
    public static void main(String[] args) {
        String test = "CheckElementPresent";
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);

    }
}

class FireFox {
    public static Driver getFireFoxDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generate Html Report for fireFox driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generate JUnit Report for fireFox driver");
    }
}

class Chrome {
    public static Driver getChromeDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generate Html Report for Chrome driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generate JUnit Report for Chrome driver");
    }
}

class WebExplorerHelperFacade {
    public static void generateReports(String explorer, String report, String test) {
        Driver driver = null;
        switch (explorer) {
            case "firefox":
                driver = FireFox.getFireFoxDriver();
                switch (report) {
                    case "html":
                        FireFox.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        FireFox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch (report) {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
                break;
        }
    }
}
