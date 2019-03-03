public class JsonElement extends Element {
 
    // ...
 
    public void accept(Visitor v) {
        v.visit(this);
    }
}