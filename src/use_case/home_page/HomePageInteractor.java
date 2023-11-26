package use_case.home_page;

public class HomePageInteractor implements HomePageInputBoundary {
    final HomePageDataAccessInterface homePageDataAccessInterface;
    final HomePageOutputBoundary homePageOutputBoundary;

    public HomePageInteractor(HomePageDataAccessInterface homePageDataAccessInterface, HomePageOutputBoundary homePageOutputBoundary) {
        this.homePageDataAccessInterface = homePageDataAccessInterface;
        this.homePageOutputBoundary = homePageOutputBoundary;
    }
}
