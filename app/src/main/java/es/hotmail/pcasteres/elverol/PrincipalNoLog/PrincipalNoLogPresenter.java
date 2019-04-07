package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import java.lang.ref.WeakReference;
import java.util.List;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class PrincipalNoLogPresenter implements PrincipalNoLogContract.Presenter {

    public static String TAG = PrincipalNoLogPresenter.class.getSimpleName();

    private WeakReference<PrincipalNoLogContract.View> view;
    private PrincipalNoLogViewModel viewModel;
    private PrincipalNoLogContract.Model model;
    private PrincipalNoLogContract.Router router;

    public PrincipalNoLogPresenter(PrincipalNoLogState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PrincipalNoLogContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PrincipalNoLogContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PrincipalNoLogContract.Router router) {
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
    public void selectProductListData(int item) {

    }



    @Override
    public void selectProductListData(CategoryItem item) {

        router.passDataToListaProductosNoLogScreen(item);
        router.navigateToListaProductosNoLogScreen();
    }



}
