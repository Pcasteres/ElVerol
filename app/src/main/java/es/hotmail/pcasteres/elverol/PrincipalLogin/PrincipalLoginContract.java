package es.hotmail.pcasteres.elverol.PrincipalLogin;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;
import es.hotmail.pcasteres.elverol.data.UserItem;

interface PrincipalLoginContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PrincipalLoginViewModel viewModel);

        void displayCategoryListData(PrincipalLoginViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchCategoryListData();

        void selectProductListData(int item);

        void selectProductListData(CategoryItem item);

        void selectCarritoListData();
    }

    interface Model {

        void fetchCategoryListData(
                RepositoryContract.GetCategoryListCallback callback);
    }

    interface Router {
        void navigateToListaProductosLoginScreen();

        void navigateToCarritoScreen();

        void passDataToListaProductosLoginScreen(CategoryItem item, UserItem userItem);

        void passDataToCarritoScreen(int userItem);

        void passDataToListaProductosLoginScreen(CategoryItem item, int userItem);

        PrincipalLoginState getDataFromPreviousScreen();
    }
}
