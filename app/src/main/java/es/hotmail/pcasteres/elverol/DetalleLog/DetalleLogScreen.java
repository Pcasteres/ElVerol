package es.hotmail.pcasteres.elverol.DetalleLog;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CatalogRepository;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class DetalleLogScreen {

    public static void configure(DetalleLogContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        DetalleLogState state = mediator.getDetalleLogState();
        RepositoryContract repository = CatalogRepository.getInstance(context.get());

        DetalleLogContract.Router router = new DetalleLogRouter(mediator);
        DetalleLogContract.Presenter presenter = new DetalleLogPresenter(state);
        DetalleLogContract.Model model = new DetalleLogModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
