package annotations;

@Deprecated
public class HeyPrinter {

    @Deprecated (since = "1.0")
    public void hey() {
        System.out.println("Hey");
    }
}
