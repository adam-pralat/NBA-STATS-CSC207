package use_case.home_page;


public interface HomePageOutputBoundary {
    void prepareSuccessView(HomePageOutputData response);

    void prepareFailView(String error);
}
