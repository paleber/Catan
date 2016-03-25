package engine.control.imp;

import engine.control.IControlSubject;
import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


final class MainControl implements IMainControl {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final class Element {

        private final IControlObserver observer;
        private final List<IControlSubject> subjects = new LinkedList<>();

        private Element(final IControlObserver observer) {
            this.observer = observer;
        }

    }

    private final Map<Class<? extends IControlObserver>, Element> controls = new HashMap<>();

    private final List<IView> views = new LinkedList<>();
    private final Map<Class<?>, Object> sharedData = new HashMap<>();

    private Element active = null;

    @Override
    public void registerView(IView view) {
        assert (!views.contains(view));
        views.add(view);
        view.onInitialize(this);
    }

    @Override
    public void registerObserver(IControlObserver ctrl) {
        assert (!controls.containsKey(ctrl.getClass()));
        controls.put(ctrl.getClass(), new Element(ctrl));
        ctrl.onInitialize(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S extends IControlSubject<O, V>, O extends IControlObserver, V extends IView> void registerSubject(S subject, Class <? extends O> observer, V view) {
        assert (!controls.containsKey(observer));
        Element e = controls.get(observer);
        e.subjects.add(subject);
        e.observer.onSubjectAdded(subject);
        subject.onInitialize((O)e.observer, view);
    }

    @Override
    public void switchControl(Class<? extends IControlObserver> ctrl) {
        assert (controls.containsKey(ctrl));
        stopActiveControl();
        active = controls.get(ctrl);
        active.subjects.forEach(IControlSubject::onStart);
        active.observer.onStart();
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
        stopActiveControl();
        views.forEach(IView::onShutdown);
    }

    private void stopActiveControl() {
        if (active != null) {
            active.observer.onStop();
            active.subjects.forEach(IControlSubject::onStop);
        }
    }

    @Override
    public void addSharedData(Object data) {
        assert (!sharedData.containsKey(data.getClass()));
        sharedData.put(data.getClass(), data);
    }

    @Override
    public <D> D getSharedData(Class<D> type) {
        assert (sharedData.containsKey(type));
        return type.cast(sharedData.get(type));
    }

}
