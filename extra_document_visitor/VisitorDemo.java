public class VisitorDemo {
 
    public static void main(String[] args) {
 
        Visitor v = new ElementVisitor();
 
        Document d = new Document(generateUuid());
        d.elements.add(new JsonElement(generateUuid()));
        d.elements.add(new JsonElement(generateUuid()));
        d.elements.add(new XmlElement(generateUuid()));
 
        d.accept(v);
    }
 
    // ...
}