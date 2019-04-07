package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

interface PrincipalNoLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PrincipalNoLogViewModel viewModel);

        void displayCategoryListData(PrincipalNoLogViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchCategoryListData();

        void selectProductListData(int item);

        void selectProductListData(CategoryItem item);
    }

    interface Model {

        void fetchCategoryListData(
                RepositoryContract.GetCategoryListCallback callback);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(PrincipalNoLogState state);

        void navigateToListaProductosNoLogScreen();

        void passDataToListaProductosNoLogScreen(int item);

        void passDataToListaProductosNoLogScreen(CategoryItem item);

        PrincipalNoLogState getDataFromPreviousScreen();
    }
}
