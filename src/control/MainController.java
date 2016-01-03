package control;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {

    private final Map<Class<? extends IController>, IController> controller = new HashMap<>();

    private final Map<Class<? extends IControllerSubject>, List<IControllerSubject>> subject = new HashMap<>();

    void addController(IController ctrl) {
        controller.put(ctrl.getClass(), ctrl);
    }

    void addSubject(Class<? extends IController> type, IControllerSubject subject) {
        if (sub)



        controller.get(type).addSubject(subject);
    }


    void switchController(Class<? extends IController> type) {
        // stop current controller
        //
    }

    public static void main(String[] args) {

        MainController c = new MainController();
        //c.addController(MenuController.class);

    }

}




interface IController {

    void start();

    void stop();

}

interface IControllerSubject {

    void onStart();

    void onStop();

}

final class MenuController implements IController {

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

final class GameController implements IController {

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

final class TuiMenuController implements IControllerSubject {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}

final class GuiMenuController implements IControllerSubject {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}

final class TuiGameController implements IControllerSubject {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}

final class GuiGameController implements IControllerSubject {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}

