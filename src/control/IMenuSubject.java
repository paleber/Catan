package control;


import engine.control.IControlSubject;

public interface IMenuSubject extends IControlSubject {

    void updatePlayerNames(String names);

}
