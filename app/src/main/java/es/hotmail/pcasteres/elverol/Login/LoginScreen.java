package es.hotmail.pcasteres.elverol.Login;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CatalogRepository;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class LoginScreen {

    public static void configure(LoginContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        LoginState state = mediator.getLoginState();
        RepositoryContract repository = CatalogRepository.getInstance(context.get());

        LoginContract.Router router = new LoginRouter(mediator);
        LoginContract.Presenter presenter = new LoginPresenter(state);
        LoginContract.Model model = new LoginModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
