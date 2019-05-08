package es.hotmail.pcasteres.elverol.PrincipalLogin;

import java.lang.ref.WeakReference;
import java.util.List;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class PrincipalLoginPresenter implements PrincipalLoginContract.Presenter {

    public static String TAG = PrincipalLoginPresenter.class.getSimpleName();

    private WeakReference<PrincipalLoginContract.View> view;
    private PrincipalLoginViewModel viewModel;
    private PrincipalLoginContract.Model model;
    private PrincipalLoginContract.Router router;

    public PrincipalLoginPresenter(PrincipalLoginState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PrincipalLoginContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PrincipalLoginContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PrincipalLoginContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchCategoryListData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchCategoryListData(new RepositoryContract.GetCategoryListCallback() {

            @Override
            public void setCategoryList(List<CategoryItem> categories) {
                viewModel.categories = categories;

                view.get().displayCategoryListData(viewModel);
            }
        });

    }


    @Override
    public void selectProductListData(CategoryItem item) {

        router.passDataToListaProductosLoginScreen(item,1);
        router.navigateToListaProductosLoginScreen();
    }

    @Override
    public void selectCarritoListData(){

        router.passDataToCarritoScreen(1);
        router.navigateToCarritoScreen();

    }



}
