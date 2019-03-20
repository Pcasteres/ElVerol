package es.hotmail.pcasteres.elverol.PrincipalLogin;

import java.lang.ref.WeakReference;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import android.support.v4.app.FragmentActivity;

public class PrincipalLoginScreen {

    public static void configure(PrincipalLoginContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        PrincipalLoginState state = mediator.getPrincipalLoginState();

        PrincipalLoginContract.Router router = new PrincipalLoginRouter(mediator);
        PrincipalLoginContract.Presenter presenter = new PrincipalLoginPresenter(state);
        PrincipalLoginContract.Model model = new PrincipalLoginModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
