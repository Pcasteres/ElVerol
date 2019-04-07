package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;
import es.hotmail.pcasteres.elverol.data.CatalogRepository;

public class PrincipalNoLogScreen {

    public static void configure(PrincipalNoLogContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        PrincipalNoLogState state = mediator.getPrincipalNoLogState();
        RepositoryContract repository = CatalogRepository.getInstance(context.get());

        PrincipalNoLogContract.Router router = new PrincipalNoLogRouter(mediator);
        PrincipalNoLogContract.Presenter presenter = new PrincipalNoLogPresenter(state);
        PrincipalNoLogContract.Model model = new PrincipalNoLogModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));
        view.injectPresenter(presenter);

    }
}
