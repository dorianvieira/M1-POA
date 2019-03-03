public class Document extends Element {
 
    List<Element> elements = new ArrayList<>();
 
    // ...
 
    @Override
    public void accept(Visitor v) {
        for (Element e : this.elements) {
            e.accept(v);
        }
    }
}