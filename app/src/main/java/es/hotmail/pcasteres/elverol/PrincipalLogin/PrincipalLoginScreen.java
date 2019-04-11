package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CatalogRepository;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class PrincipalLoginScreen {

    public static void configure(PrincipalLoginContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        PrincipalLoginState state = mediator.getPrincipalLoginState();
        RepositoryContract repository = CatalogRepository.getInstance(context.get());

        PrincipalLoginContract.Router router = new PrincipalLoginRouter(mediator);
        PrincipalLoginContract.Presenter presenter = new PrincipalLoginPresenter(state);
        PrincipalLoginContract.Model model = new PrincipalLoginModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));
        view.injectPresenter(presenter);

    }
}
