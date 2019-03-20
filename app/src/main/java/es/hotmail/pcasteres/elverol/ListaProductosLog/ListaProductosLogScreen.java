package es.hotmail.pcasteres.elverol.ListaProductosLog;

import java.lang.ref.WeakReference;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import android.support.v4.app.FragmentActivity;

public class ListaProductosLogScreen {

    public static void configure(ListaProductosLogContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ListaProductosLogState state = mediator.getListaProductosLogState();

        ListaProductosLogContract.Router router = new ListaProductosLogRouter(mediator);
        ListaProductosLogContract.Presenter presenter = new ListaProductosLogPresenter(state);
        ListaProductosLogContract.Model model = new ListaProductosLogModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
