package es.hotmail.pcasteres.elverol.DetalleLog;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class DetalleLogScreen {

    public static void configure(DetalleLogContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        DetalleLogState state = mediator.getDetalleLogState();

        DetalleLogContract.Router router = new DetalleLogRouter(mediator);
        DetalleLogContract.Presenter presenter = new DetalleLogPresenter(state);
        DetalleLogContract.Model model = new DetalleLogModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
