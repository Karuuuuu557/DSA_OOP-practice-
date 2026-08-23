/*
 * TOPIC: LSP (Liskov Substitution Principle)
 * Analogy: If a rental car promises "car behavior", any brand should still drive safely the same way.
 */
public class LiskovSubstitutionDemo {
    static class Rectangle {
        protected int w, h;
        void setWidth(int w) { this.w = w; }
        void setHeight(int h) { this.h = h; }
        int area() { return w * h; }
    }
    static class Square extends Rectangle {
        @Override void setWidth(int w) { this.w = this.h = w; }
        @Override void setHeight(int h) { this.w = this.h = h; }
    }

    static int computeAreaAfterResize(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        return r.area();
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        System.out.println("Beginner rectangle area: " + computeAreaAfterResize(rect));

        Rectangle sqAsRect = new Square();
        System.out.println("Intermediate square-as-rectangle area: " + computeAreaAfterResize(sqAsRect));

        System.out.println("Pro: this mismatch shows Square should not inherit mutable Rectangle here.");
    }
}

/*
 * Pitfalls: overriding with stronger preconditions, changing expected behavior, throwing unsupported operation in subtype.
 * Practice: redesign shape hierarchy with immutable dimensions.
 */
