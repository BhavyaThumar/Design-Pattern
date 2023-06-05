import java.util.ArrayList;
import java.util.List;

class Originartor_Obj {
    private String content;
    private int fontSize;
    private String fontType;

    public Originartor_Obj(String content, int fontSize, String fontType) {
        this.content = content;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontType() {
        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

    // Originator creating snapshot
    public MementoObject saveObjectstate() {
        // obj of memento
        return new MementoObject(content, fontSize, fontType);
    }

    // trying to restore state of obj
    public void restoreObjectState(MementoObject m) {
        content = m.getContent();
        fontSize = m.getFontSize();
        fontType = m.getFontType();
    }

    public void printArticle() {
        System.out.println("Article [content=" + content + ", fontSize=" + fontSize + ", fontType=" + fontType + "]");
    }
}

// Memento never Come up with Setter methods
class MementoObject {
    private String content;
    private int fontSize;
    private String fontType;

    public MementoObject(String content, int fontSize, String fontType) {
        this.content = content;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }

    public String getContent() {
        return content;
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getFontType() {
        return fontType;
    }
}

class CareTakerObject {
    List<MementoObject> lm = new ArrayList<MementoObject>();

    public void addMementoObject(MementoObject m) {
        lm.add(m);
    }

    public MementoObject getMementoObject(int i) {
        return lm.get(i);
    }
}

public class Memento2 {
    public static void main(String[] args) {

        Originartor_Obj article = new Originartor_Obj("Sample article content", 12, "Times New Roman");
        CareTakerObject c = new CareTakerObject();

        article.printArticle();
        c.addMementoObject(article.saveObjectstate());

        article.setContent("Modified article content");
        article.setFontSize(16);
        article.setFontType("Arial");
        article.printArticle();
        c.addMementoObject(article.saveObjectstate());

        article.setContent("Latest article content");
        article.setFontSize(18);
        article.setFontType("Calibri");
        article.printArticle();
        c.addMementoObject(article.saveObjectstate());

    }
}