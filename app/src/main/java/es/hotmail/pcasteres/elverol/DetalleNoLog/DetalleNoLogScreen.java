package es.hotmail.pcasteres.elverol.DetalleNoLog;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class DetalleNoLogScreen {

    public static void configure(DetalleNoLogContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        DetalleNoLogState state = mediator.getDetalleNoLogState();

        DetalleNoLogContract.Router router = new DetalleNoLogRouter(mediator);
        DetalleNoLogContract.Presenter presenter = new DetalleNoLogPresenter(state);
        DetalleNoLogContract.Model model = new DetalleNoLogModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
