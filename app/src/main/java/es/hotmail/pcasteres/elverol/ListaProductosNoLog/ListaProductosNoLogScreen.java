package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class ListaProductosNoLogScreen {

    public static void configure(ListaProductosNoLogContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ListaProductosNoLogState state = mediator.getListaProductosNoLogState();

        ListaProductosNoLogContract.Router router = new ListaProductosNoLogRouter(mediator);
        ListaProductosNoLogContract.Presenter presenter = new ListaProductosNoLogPresenter(state);
        ListaProductosNoLogContract.Model model = new ListaProductosNoLogModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
