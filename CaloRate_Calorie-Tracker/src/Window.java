public abstract class Window {

    String windowTitle;
    boolean quitWindow = false;

    void windowInterface() {
        Global.printHeaderPart(windowTitle);
    }
    void windowLogic() {
        windowInterface();
    }

}
