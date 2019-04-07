package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CatalogRepository;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class ListaProductosNoLogScreen {

    public static void configure(ListaProductosNoLogContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ListaProductosNoLogState state = mediator.getListaProductosNoLogState();
        RepositoryContract repository = CatalogRepository.getInstance(context.get());

        ListaProductosNoLogContract.Router router = new ListaProductosNoLogRouter(mediator);
        ListaProductosNoLogContract.Presenter presenter = new ListaProductosNoLogPresenter(state);
        ListaProductosNoLogContract.Model model = new ListaProductosNoLogModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
