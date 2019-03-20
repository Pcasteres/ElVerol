package es.hotmail.pcasteres.elverol.NewUser;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class NewUserScreen {

    public static void configure(NewUserContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        NewUserState state = mediator.getNewUserState();

        NewUserContract.Router router = new NewUserRouter(mediator);
        NewUserContract.Presenter presenter = new NewUserPresenter(state);
        NewUserContract.Model model = new NewUserModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
