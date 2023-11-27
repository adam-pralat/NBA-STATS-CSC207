package interface_adapter.home_page;

import use_case.home_page.HomePageInputBoundary;
import use_case.home_page.HomePageInputData;

public class HomePageController {
    final HomePageInputBoundary homePageInputBoundary;

    public HomePageController(HomePageInputBoundary homePageInputBoundary) {
        this.homePageInputBoundary = homePageInputBoundary;
    }

    public void execute() {
        HomePageInputData homePageInputData = new HomePageInputData();
        homePageInputBoundary.execute(homePageInputData);
    }
}
