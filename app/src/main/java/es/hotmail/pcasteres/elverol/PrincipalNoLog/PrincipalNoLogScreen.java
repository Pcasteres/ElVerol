package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import java.lang.ref.WeakReference;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import android.support.v4.app.FragmentActivity;

public class PrincipalNoLogScreen {

    public static void configure(PrincipalNoLogContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        PrincipalNoLogState state = mediator.getPrincipalNoLogState();

        PrincipalNoLogContract.Router router = new PrincipalNoLogRouter(mediator);
        PrincipalNoLogContract.Presenter presenter = new PrincipalNoLogPresenter(state);
        PrincipalNoLogContract.Model model = new PrincipalNoLogModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
