package es.hotmail.pcasteres.elverol.Carrito;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CatalogRepository;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class CarritoScreen {

    public static void configure(CarritoContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        CarritoState state = mediator.getCarritoState();
        RepositoryContract repository = CatalogRepository.getInstance(context.get());

        CarritoContract.Router router = new CarritoRouter(mediator);
        CarritoContract.Presenter presenter = new CarritoPresenter(state);
        CarritoContract.Model model = new CarritoModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
